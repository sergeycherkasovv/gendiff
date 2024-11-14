package hexlet.code;

import java.util.Map;

public class Differ {

    public static String generate(String filepath1,
                                  String filepath2,
                                  String formatName) throws Exception {

        var fileParse1 = readAndParse(filepath1);
        var fileParse2 = readAndParse(filepath2);

        var result = DifferFilter.getDifferFilter(fileParse1, fileParse2);
        return Formatter.getFormatter(result, formatName);
    }

    public static String generate(String filepath1,
                                  String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }


    public static Map<String, Object> readAndParse(String file) throws Exception {
        var read = ReadFile.readFilePath(file);
        var fileFormat = file.substring(file.lastIndexOf("."));
        return Parser.getParser(read, fileFormat);
    }
}
