package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRead {
    private static Path normalizeFilePath(String fileName) {
        return Paths.get(fileName)
                .toAbsolutePath().normalize();
    }

    public static String readFile(String fileName) throws Exception {
        var path = normalizeFilePath(fileName);
        return Files.readString(path).trim();
    }
}
