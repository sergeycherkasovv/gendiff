package hexlet.code;

import java.util.Map;

public class Differ {

    public static String generate(String filepath1,
                                  String filepath2,
                                  String formatName) throws Exception {

        var fileParse1 = getPreparedFile(filepath1);
        var fileParse2 = getPreparedFile(filepath2);

        var result = FileDifferences.getDifferences(fileParse1, fileParse2);
        return Formatter.getFormatter(result, formatName);
    }

    public static String generate(String filepath1,
                                  String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static Map<String, Object> getPreparedFile(String file) throws Exception {
        var read = FileRead.readFile(file);
        var fileFormat = file.substring(file.lastIndexOf("."));
        return Parser.getParser(read, fileFormat);
    }
}
