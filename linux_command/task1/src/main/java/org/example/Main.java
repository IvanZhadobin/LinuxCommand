package org.example;

import org.example.key.CommandParser;

public class Main {
    public static void main(String[] args) {
        CommandParser commandParser = new CommandParser();
        commandParser.parseArgs(args);
    }
}