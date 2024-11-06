package hexlet.code;

public class Differ {

    public static String generate(String filepath1,
                                  String filepath2,
                                  String formatName) throws Exception {
        var fileParse1 = Parser.getParser(filepath1);
        var fileParse2 = Parser.getParser(filepath2);

        if (fileParse1.isEmpty()) {
            throw new Exception("The file " + "'" + filepath1 + "'" + " is empty");
        } else if (fileParse2.isEmpty()) {
            throw new Exception("The file " + "'" + filepath2 + "'" + " is empty");
        }

        var result = DifferFilter.getDifferFilter(fileParse1, fileParse2);
        return Formatter.getFormatter(result, formatName);
    }

    public static String generate(String filepath1,
                                  String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
