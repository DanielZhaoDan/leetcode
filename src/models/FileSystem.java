package models;

import java.util.*;

public class FileSystem {

    private FileNode root;

    class FileNode {
        boolean isFile;
        TreeMap<String, FileNode> children;
        String content;

        public FileNode(boolean isFile) {
            this.isFile = isFile;
            if (!this.isFile) {
                children = new TreeMap<>();
            }
        }
    }

    public FileSystem() {
        this.root = new FileNode(false);
    }

    /**
     * path if path not exist, or return in lexi order
     * O(M + N)
     * @param path "a/b/c/d" M
     * @return
     */
    private List<String> ls(String path) {
        FileNode node = findTarget(path);
        List<String> res = new ArrayList<>();

        if (node == null) {
            return res;
        }
        if (node.isFile) {
            String[] subPaths = path.split("/");
            res.add(subPaths[subPaths.length-1]);
            return res;
        }

        String pathPrefix = path + "/";
        if (node == this.root) {
            pathPrefix = "";
        }

        for (String child : node.children.keySet()) {
            res.add(pathPrefix + child);
        }
        return res;
    }

    /**
     * create folder for a,b,c if not existed, then create file for d
     * O(M*LogN)
     *
     * @param path "a/b/c/d" M
     */
    private void mkdir(String path) {
        createFolder(path);
    }

    /**
     * time: O(MLogN)
     * space: O(N+M)
     * @param path "/a/b/c/d" M
     * @param content N
     */
    private void addContentToFile(String path, String content) {
        int fileIdx = path.lastIndexOf("/");
        String folderPath = path.substring(0, fileIdx);
        FileNode node = createFolder(folderPath);

        FileNode file = new FileNode(true);
        file.content += content;
        node.children.put(path.substring(fileIdx), file);

    }

    // O(1)
    private String readContentFromFile(String path) {
        FileNode node = findTarget(path);

        if (node == null || !node.isFile) {
            return null;
        }
        return node.content;
    }

    /**
     * o(M)
     *
     * @param path "a/b/c/d" M
     * @return null if not found
     */
    private FileNode findTarget(String path) {
        String[] subPaths = path.split("/");
        FileNode node = this.root;

        for (int i=1; i<subPaths.length; i++) {
            if (!node.children.containsKey(subPaths[i])) {
                return null;
            }
            node = node.children.get(subPaths[i]);
        }
        return node;
    }

    //O(M*logN)
    private FileNode createFolder(String path) {
        String[] subPaths = path.split("/");
        FileNode node = this.root;

        for (int i=1; i<subPaths.length; i++) {
            if (!node.children.containsKey(subPaths[i])) {
                node.children.put(subPaths[i], new FileNode(false));
            }
            node = node.children.get(subPaths[i]);
        }

        return node;
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
    }

}
