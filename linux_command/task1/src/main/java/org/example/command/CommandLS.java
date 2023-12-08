package org.example.command;

import org.example.parser.ParserArgs;
import org.example.strategy.AbstractCommand;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandLS extends AbstractCommand {
    ParserArgs parser = new ParserArgs();

    @Override
    protected void executeCommand(String directoryPath) {
        parser.paddingBooleanLS();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The directory does not exist or is not a directory: " + directoryPath);
            return;
        }

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (parser.getListRecursive() && file.isDirectory()) {
                    System.out.println("directory: " + file.getAbsolutePath());
                    executeCommand(file.getAbsolutePath());
                } else {
                    if (parser.getListDetailed()) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedDate = sdf.format(new Date(file.lastModified()));
                        String fileInfo = String.format("%s\t%s\t%s\t%s", file.getName(), file.isDirectory() ? "DIR" : "FILE", formattedDate, file.length());
                        System.out.println(fileInfo);
                    } else {
                        if (parser.getListAll() || !file.getName().startsWith(".")) {
                            System.out.println(file.getName());
                        }
                    }
                }
            }
        }
    }
}
