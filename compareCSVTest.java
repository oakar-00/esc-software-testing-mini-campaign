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
        this.expectedCsv = readCSVIn(expectedCsv);
    }

    public static ArrayList<String> readCSVIn(String filename) {
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
        return Arrays.asList(new Object[][] { { "test1a.csv", "test1b.csv", "test1c.csv" },
                { "test2a.csv", "test2b.csv", "test2c.csv" }, { "test3a.csv", "test3b.csv", "test3c.csv" } });
    }

    @Test
    public void testCompareCSVTest() {
        new compareCSV();
        // System.out.println();
        assertEquals(expectedCsv, compareCSV.compare(csv1Name, csv2Name));
        System.out.println("compareCSV test ran successfully");

    }
}