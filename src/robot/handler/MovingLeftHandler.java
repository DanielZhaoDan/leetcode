package robot.handler;

import robot.enums.Command;
import robot.enums.Direction;
import robot.model.Robot;

public class MovingLeftHandler extends AbstractHandler{

    @Override
    public void handle(Robot robot) {
        if (robot == null) {
            return;
        }
        Direction current = robot.getFacingDirection();

        String nextDirection = current.getLeft();

        robot.setFacingDirection(Direction.getByName(nextDirection));
    }
}
