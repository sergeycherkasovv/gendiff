package hexlet.code;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DifferTest {
    private static String directory;

    @BeforeAll
    public static void beforeAll() {
        directory = "src/test/resources/fixtures/";
    }

    @Test
    void testGenerateStylish() throws Exception {
        var expected = ReadFileForTest.readFilePath("DifferStylish.txt");
        var format = "stylish";

        var output1 = Differ.generate(directory + "file1.yml", directory + "file2.yml", format);
        assertEquals(output1, expected);

        var output2 = Differ.generate(directory + "file1.json", directory + "file2.json", format);
        assertEquals(output2, expected);

        var output3 = Differ.generate(directory + "file1.yml", directory + "file2.yml");
        assertEquals(output3, expected);

        var output4 = Differ.generate(directory + "file1.json", directory + "file2.json");
        assertEquals(output4, expected);

        var output5 = Differ.generate(directory + "file1.yml", directory + "file2.json");
        assertEquals(output5, expected);
    }

    @Test
    void testGeneratePlain() throws Exception {
        var expected = ReadFileForTest.readFilePath("DifferPlain.txt");
        var format = "plain";

        var output1 = Differ.generate(directory + "file3.yml", directory + "file4.yml", format);
        assertEquals(output1, expected);

        var output2 = Differ.generate(directory + "file3.json", directory + "file4.json", format);
        assertEquals(output2, expected);

        var output3 = Differ.generate(directory + "file3.yml", directory + "file4.json", format);
        assertEquals(output3, expected);
    }

    @Test
    void testGenerateJson() throws Exception {
        var expected = ReadFileForTest.readFilePath("DifferJson.txt");
        var format = "json";

        var output1 = Differ.generate(directory + "file3.yml", directory + "file4.yml", format);
        assertEquals(output1, expected);

        var output2 = Differ.generate(directory + "file3.json", directory + "file4.json", format);
        assertEquals(output2, expected);
    }

    @Test
    void testGenerateThrows() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            Differ.generate(directory + "empty.json", directory + "file2.json");
        }, "The file " + "'empty.json'" + " is empty");

        Exception exception1 = assertThrows(Exception.class, () -> {
            Differ.generate(directory + "file1.json", directory + "empty.yml");
        }, "The file " + "'empty.yml'" + " is empty");

        Exception exception2 = assertThrows(Exception.class, () -> {
            Differ.generate(directory + "file.json", directory + "file2.yml");
        }, "File 'file.json' does not exist");

        Exception exception3 = assertThrows(Exception.class, () -> {
            Differ.generate(directory + "file1.json", directory + "file2.yml", "incorrect");
        }, "Unexpected value: " + "incorrect");
    }
}
