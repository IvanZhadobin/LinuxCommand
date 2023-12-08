package org.example.key;

import org.example.command.CommandCat;
import org.example.command.CommandLS;
import org.example.parser.ParserArgs;
import org.example.strategy.AbstractCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {
    final ParserArgs parser = new ParserArgs();
    private static final Map<String, AbstractCommand> commandMapping = new HashMap<>();

    static {
        commandMapping.put("cat", new CommandCat());
        commandMapping.put("ls", new CommandLS());
    }

    public void parseArgs(String[] args) {
        parser.parseCommand(args);
        if (commandMapping.containsKey(parser.name)) {
            commandMapping.get(parser.name).execute(parser.path, parser);
        } else {
            System.out.println(parser.name);
        }
    }
}
