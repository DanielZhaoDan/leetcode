package robot.handler;

import robot.enums.Direction;
import robot.model.Robot;

public class MovingRightHandler extends AbstractHandler{

    @Override
    public void handle(Robot robot) {
        if (robot == null) {
            return;
        }
        Direction current = robot.getFacingDirection();

        String nextDirection = current.getRight();

        robot.setFacingDirection(Direction.getByName(nextDirection));
    }
}
