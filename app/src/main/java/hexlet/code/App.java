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
        var fileParse1 = Parser.run(filepath1);
        var fileParse2 = Parser.run(filepath2);

        if (fileParse1.isEmpty() || fileParse2.isEmpty()) {
            throw new Exception();
        }

        var result = Differ.generate(fileParse1, fileParse2, format);
        System.out.println(result);
        return result;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
