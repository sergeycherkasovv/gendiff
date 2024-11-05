package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DifferTest {
    private static String fileExpectedsStylish;
    private static String getFileExpectedsPlain;
    private static String getFileExpectedsJson;

    @BeforeEach
    public void beforeEachstylish() {
        List<String> result = new ArrayList<>();
        result.addAll(List.of("{",
                "-  follow: false",
                "   host: hexlet.io",
                "-  proxy: 123.234.53.22",
                "-  timeout: 50",
                "+  timeout: 20",
                "+  verbose: true",
                "}"));
        fileExpectedsStylish = String.join("\n", result);
    }
    @BeforeEach
    public void beforeEachPlain() {
        List<String> result = new ArrayList<>();
        result.addAll(List.of("{",
                "Property 'follow' was removed",
                "Property 'proxy' was removed",
                "Property 'timeout' was updated. From '50' to '20'",
                "Property 'verbose' was added with value: true",
                "}"));
        getFileExpectedsPlain = String.join("\n", result);
    }
    @BeforeEach
    public void beforeEachJson() {
        List<String> result = new ArrayList<>();
        result.addAll(List.of("{\"follow\":{\"old\":false}," +
                "\"host\":{\"intact\":\"hexlet.io\"}," +
                "\"proxy\":{\"old\":\"123.234.53.22\"}," +
                "\"timeout\":{\"new\":20,\"old\":50}," +
                "\"verbose\":{\"new\":true}}"));
        getFileExpectedsJson = String.join("\n", result);
    }


    @Test
    void testGenerateStylish() throws Exception {
        var output1 = Differ.generate("file1.yml", "file2.yml", "stylish");
        assertEquals(output1, fileExpectedsStylish);

        var output2 = Differ.generate("file1.json", "file2.json", "stylish");
        assertEquals(output2, fileExpectedsStylish);

        var output3 = Differ.generate("file1.yml", "file2.yml");
        assertEquals(output3, fileExpectedsStylish);

        var output4 = Differ.generate("file1.json", "file2.json");
        assertEquals(output4, fileExpectedsStylish);
    }

    @Test
    void testGeneratePlain() throws Exception {
        var output1 = Differ.generate("file1.yml", "file2.yml", "plain");
        assertEquals(output1, getFileExpectedsPlain);

        var output2 = Differ.generate("file1.json", "file2.json", "plain");
        assertEquals(output2, getFileExpectedsPlain);
    }

    @Test
    void testGenerateJson() throws Exception {
        var output1 = Differ.generate("file1.yml", "file2.yml", "json");
        assertEquals(output1, getFileExpectedsJson);

        var output2 = Differ.generate("file1.json", "file2.json", "json");
        assertEquals(output2, getFileExpectedsJson);
    }
}