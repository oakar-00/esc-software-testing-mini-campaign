import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;
import java.io.*;

import static org.junit.Assert.*;

import java.util.*;

@RunWith(Parameterized.class)

public class getDataTest {
    private String filename;
    private ArrayList<String> expectedData;

    public getDataTest(String filename, String expectedDataCSV) {
        this.filename = filename;
        this.expectedData = readCsvIn(expectedDataCSV);
    }

    public static ArrayList<String> readCsvIn(String filename) {
        ArrayList<String> asList = new ArrayList<>();
        try {
            File csv = new File(filename);
            FileReader fr = new FileReader(csv);
            BufferedReader br = new BufferedReader(fr);

            String inp = " ";

            while ((inp = br.readLine()) != null) {
                asList.add(inp);
            }
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return asList;
    }

    @Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][] { { "sample_file_1.csv", "sample_file_1.csv" },
                { "test1a.csv", "test1a.csv" }, { "test1b.csv", "test1b.csv" },
                { "test2a.csv", "test2a.csv" }, { "test2b.csv", "test2b.csv" },
                { "test3a.csv", "test3a.csv" }, { "test3b.csv", "test3b.csv" } });
    }

    @Test
    public void testGetDataTest() {
        new compareCSV();
        assertEquals(expectedData, compareCSV.getData(filename));
        System.out.println("getData test ran successfully");

    }
}
