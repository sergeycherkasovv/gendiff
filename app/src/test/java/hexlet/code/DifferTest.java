package hexlet.code;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private static String directory;
    private static String expectedStylish;
    private static String expectedPlain;

    @BeforeAll
    public static void beforeAll() throws Exception {

        directory = "src/test/resources/fixtures/";
        expectedStylish = FileRead.readFile(directory + "resultStylish.txt");
        expectedPlain = FileRead.readFile(directory + "resultPlain.txt");
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yml"})
    void testGenerate(String format) throws Exception {
        var file1 = directory + "file1" + format;
        var file2 = directory + "file2" + format;

        var notFormatter = Differ.generate(file1, file2);
        assertEquals(notFormatter, expectedStylish);

        var stylishFormatter = Differ.generate(file1, file2, "stylish");
        assertEquals(stylishFormatter, expectedStylish);

        var plainFormatter = Differ.generate(file1, file2, "plain");
        assertEquals(plainFormatter, expectedPlain);
    }
}
