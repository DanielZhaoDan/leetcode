package robot;

import robot.enums.Command;
import robot.handler.AbstractHandler;
import robot.handler.HandlerFactory;
import robot.handler.HandlerFactoryImpl;
import robot.model.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// nicholas.laroux@shopify.com
public class Main {
    // 0. init the robot globally
    // 1. while loop to accept input, quit when input is Q
    //     1.1 validate user input by using getCommandByName
    //     1.2


    public static void main(String[] args) {
        Robot robot = new Robot();

        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

         HandlerFactory handlerFactory = new HandlerFactoryImpl();

        while (true) {
            try {
                // Reading data using readLine
                String name = reader.readLine();

                Command command = Command.getByName(name);

                if (null == command) {
                    System.out.println("INVALID COMMAND");
                    command = Command.QUES; // to print instructions for invalid command
                }

                if (Command.Q == command) {
                    System.out.println("Robot shutting down.");
                    break;
                }

                AbstractHandler handler = handlerFactory.getHandlerByCommands(command);
                handler.handle(robot);

            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }

    }

}
