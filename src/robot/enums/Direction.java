package robot.enums;


public enum Direction {

    NORTH("NORTH", "SOUTH", "WEST"),
    SOUTH("SOUTH", "WEST", "EAST"),
    EAST("EAST", "SOUTH", "NORTH"),
    WEST("WEST", "NORTH", "SOUTH"),
    ;

    // name of direction
    private String name;

    // after using L command
    private String left;

    // after using R command
    private String right;

    private Direction(String name, String left, String right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public static Direction getByName(String name) {
        for (Direction d : Direction.values()) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }
}
