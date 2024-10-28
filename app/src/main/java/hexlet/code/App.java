package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<String> {
    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;
    @Parameters(index = "1", paramLabel = "filepath1", description = "path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, paramLabel = "format", defaultValue = "stylish",
            description = "output format [default: stylish]")
    private String format;

    @Override
    public String call() throws Exception {
        var fileRead1 = ReadFile.readFilePath(filepath1);
        var fileRead2 = ReadFile.readFilePath(filepath2);
        var fileInMap1 = FileInMap.objectMapper(fileRead1);
        var fileInMap2 = FileInMap.objectMapper(fileRead2);

        if (fileInMap1.isEmpty() || fileInMap2.isEmpty()) {
            throw new Exception();
        }

        var result = Differ.generate(fileInMap1, fileInMap2, format);
        System.out.println(result);
        return result;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
