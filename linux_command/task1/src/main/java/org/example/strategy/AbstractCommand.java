package org.example.strategy;

import org.example.parser.ParserArgs;

public abstract class AbstractCommand {
    protected ParserArgs parser;

    public void execute(String path, ParserArgs parser) {
        this.parser = parser;
        executeCommand(path);
    }

    protected abstract void executeCommand(String path);
}
