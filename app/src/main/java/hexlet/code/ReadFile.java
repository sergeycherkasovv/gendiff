package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
    private static Path filePath(String fileName) throws Exception {
        Path path;

        if (fileName.contains("/")) {
            path = Paths.get(fileName)
                    .toAbsolutePath().normalize();
        } else {
            path = Paths.get("src", "main", "resources", fileName)
                    .toAbsolutePath().normalize();
        }

        return path;
    }

    public static String readFilePath(String fileName) throws Exception {
        var path = filePath(fileName);
        return Files.readString(path).trim();
    }

}
