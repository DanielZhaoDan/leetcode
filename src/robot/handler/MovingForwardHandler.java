package robot.handler;

import robot.enums.Direction;
import robot.model.Robot;

import java.util.HashMap;
import java.util.Map;

public class MovingForwardHandler extends AbstractHandler {

    private static Map<Direction, int[]> movingDelta = new HashMap<>();

    static {
        movingDelta.put(Direction.NORTH, new int[]{0,1});
        movingDelta.put(Direction.SOUTH, new int[]{0,-1});
        movingDelta.put(Direction.EAST, new int[]{1,0});
        movingDelta.put(Direction.WEST, new int[]{-1,0});
    }

    @Override
    public void handle(Robot robot) {
        if (robot == null) {
            return;
        }
        int[] delta = movingDelta.get(robot.getFacingDirection());
        robot.setCurrentRow(robot.getCurrentRow()+delta[0]);
        robot.setCurrentCol(robot.getCurrentCol()+delta[1]);
    }
}
