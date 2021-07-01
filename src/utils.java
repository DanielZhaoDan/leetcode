import models.Node;

import java.util.ArrayList;
import java.util.List;

public class utils {

    public static int[][] gererateArray(String s) {
        String temp[] = s.split("\\],\\[");
        int jSize = temp[0].split(",").length;
        int[][] res = new int[temp.length][jSize];
        for (int i = 0; i < temp.length; i++) {
            String[] t = temp[i].split(",");
            for (int j = 0; j < jSize; j++)
                res[i][j] = Integer.parseInt(t[j]);
        }
        return res;
    }

    public static List<List<Integer>> gererate2List(String s) {
        String temp[] = s.split("\\],\\[");
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            List<Integer> tempList = new ArrayList<>();
            String[] t = temp[i].split(",");
            for (int j = 0; j < t.length; j++) {
                tempList.add(Integer.parseInt(t[j]));
            }
            res.add(tempList);
        }
        return res;
    }

    public static void printObject(Object o) {
        if (o instanceof Node) {
            printLinkedList((Node) o);
        } else if (o instanceof List) {
            printList((List) o);
        } else {
            System.out.println(o);
        }
    }

    public static void printList(List list) {
        System.out.print("[");
        for (Object o : list) {
            System.out.print(o);
            System.out.print(" ");
        }
        System.out.print("]");
    }

    public static void printLinkedList(Node head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
            if (head != null)
                System.out.print(" ");
        }
        System.out.print("]");
    }

    public static Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

}
