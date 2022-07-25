import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;
import java.io.*;

import static org.junit.Assert.*;

import java.util.*;

@RunWith(Parameterized.class)

public class compareCSVTest {
    private String csv1Name;
    private String csv2Name;
    private ArrayList<String> expectedCsv;

    public compareCSVTest(String csv1Name, String csv2Name, String expectedCsv) {
        this.csv1Name = csv1Name;
        this.csv2Name = csv2Name;
        this.expectedCsv = readCsvIn(expectedCsv);
    }

    // @Before
    // public void initialize(){
    // compareRecords = new compareRecords();
    // }
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
        // return value to make sure the function reads all the input
        return asList;
    }

    @Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][] { { "test_1a.csv", "test_1b.csv", "test_1c.csv" },
                { "test_2a.csv", "test_2b.csv", "test_2c.csv" }, { "test_3a.csv", "test_3b.csv", "test_3c.csv" } });
    }

    @Test
    public void testCompareCSVTest() {
        new compareCSV();
        assertEquals(expectedCsv, compareCSV.compare(csv1Name, csv2Name));
        System.out.println("Tests ran successfully");

    }
}
