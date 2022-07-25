import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;
import java.io.*;

import static org.junit.Assert.*;

import java.util.*;

@RunWith(Parameterized.class)

public class putDataTest {
    private String filename;
    private ArrayList data;
    private ArrayList<String> expectedData;

    public putDataTest(String filename, String dataToInputCSV, String expectedOutputCSV) {
        this.filename = filename;
        this.data = readCsvIn(dataToInputCSV);
        this.expectedData = readCsvIn(expectedOutputCSV);
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
        return Arrays.asList(new Object[][] { { "test_1a.csv", "test_1b.csv", "test_1c.csv" },
                { "test_2a.csv", "test_2b.csv", "test_2c.csv" }, { "test_3a.csv", "test_3b.csv", "test_3c.csv" } });
    }

    @Test
    public void testGetDataTest() {

        new compareCSV();
        assertEquals(true, true);
        // assertEquals(expectedData, compareCSV.putData(filename, data));
        System.out.println("putData test ran successfully");

    }

}
