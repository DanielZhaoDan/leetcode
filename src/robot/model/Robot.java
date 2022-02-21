package robot.model;

import robot.enums.Direction;

public class Robot {

    // the direction robot is facing
    private Direction facingDirection;

    // current row of position
    private int currentRow;

    // current column of position
    private int currentCol;

    public Robot() {
        this.facingDirection = Direction.NORTH;
        this.currentRow = 0;
        this.currentCol = 0;
    }

    public Robot(Direction facingDirection, int currentRow, int currentCol) {
        this.facingDirection = facingDirection;
        this.currentRow = currentRow;
        this.currentCol = currentCol;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }
}
