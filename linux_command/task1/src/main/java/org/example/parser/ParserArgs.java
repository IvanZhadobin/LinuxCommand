package org.example.parser;

import java.util.ArrayList;
import java.util.List;

public class ParserArgs {
    public static String name;
    public static List<String> keys = new ArrayList<>();
    public static String path;

    private static boolean listAll;
    private static boolean listDetailed;

    private static boolean listRecursive;

    private static boolean showLineNumbers;
    private static boolean showDollarSign;

    public void parseCommand(String[] args) {
        name = args[0];

        for (int i = 1; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                for (int j = 1; j < args[i].length(); j++) {
                    keys.add(String.valueOf(args[i].charAt(j)));
                }
            } else {
                path = args[i];
            }
        }
    }

    public void paddingBooleanLS() {
        for (String key : keys) {
            switch (key) {
                case "a":
                    listAll = true;
                    break;
                case "l":
                    listDetailed = true;
                    break;
                case "r":
                    listRecursive = true;
                    break;
            }
        }
    }

    public void paddingBooleanCat() {
        for (String key : keys) {
            switch (key) {
                case "n":
                    showLineNumbers = true;
                    break;
                case "e":
                    showDollarSign = true;
                    break;
            }
        }
    }

    public boolean getListAll() {
        return listAll;
    }

    public boolean getListDetailed() {
        return listDetailed;
    }

    public boolean getListRecursive() {
        return listRecursive;
    }

    public static boolean isShowLineNumbers() {
        return showLineNumbers;
    }

    public static boolean isShowDollarSign() {
        return showDollarSign;
    }
}
