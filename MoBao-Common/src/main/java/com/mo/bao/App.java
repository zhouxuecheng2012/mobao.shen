package com.mo.bao;

import com.mo.bao.spi.Command;
import java.util.ServiceLoader;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ServiceLoader<Command> serviceLoader = ServiceLoader.load(Command.class);
        for (Command command : serviceLoader) {
            command.execute();
        }
    }
}
