package robot.handler;

import robot.enums.Command;

import java.util.HashMap;
import java.util.Map;

public class HandlerFactoryImpl implements HandlerFactory{

    static Map<Command, AbstractHandler> map = new HashMap<>();

    static {
        map.put(Command.L, new MovingLeftHandler());
        map.put(Command.R, new MovingRightHandler());
        map.put(Command.M, new MovingForwardHandler());
        map.put(Command.QUES, new InstructionHandler());
    }

    @Override
    public AbstractHandler getHandlerByCommands(Command command) {
        return map.get(command);
    }
}
