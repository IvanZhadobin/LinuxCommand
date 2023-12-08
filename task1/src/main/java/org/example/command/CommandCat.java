package org.example.command;

import org.example.parser.ParserArgs;
import org.example.strategy.AbstractCommand;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommandCat extends AbstractCommand {
    ParserArgs parser = new ParserArgs();

    @Override
    protected void executeCommand(String filePath) {

        parser.paddingBooleanCat();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            for (int lineNumber = 1; (line = reader.readLine()) != null; lineNumber++) {
                StringBuilder output = new StringBuilder();

                if (parser.isShowLineNumbers()) output.append(lineNumber).append(" ");

                output.append(line);

                if (parser.isShowDollarSign()) output.append("$");

                System.out.println(output);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

