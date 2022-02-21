package robot.handler;

import robot.enums.Command;

public interface HandlerFactory {

    /**
     *
     * @param command get operations handler by command
     * @return
     */
    AbstractHandler getHandlerByCommands(Command command);

}
