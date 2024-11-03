package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
    private static Path filePath(String fileName) throws Exception {
        Path path = Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        return path;
    }

    public static String readFilePath(String fileName) throws Exception {
        var path = filePath(fileName);
        return Files.readString(path).trim();
    }

}
