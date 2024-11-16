package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
    private static Path filePath(String fileName) {
        return Paths.get(fileName)
                .toAbsolutePath().normalize();
    }

    public static String readFilePath(String fileName) throws Exception {
        var path = filePath(fileName);
        return Files.readString(path).trim();
    }

}
