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
    static String path = "C:/Documents/SUTD Stuff/Studies/Term5/Elements of Software Construction/esc-software-testing-mini-campaign/";
    private String csv1Name;
    private String csv2Name;
    private String csv3Name;
    private ArrayList<String> expectedCsv;

    public compareCSVTest(String csv1Name, String csv2Name, String csv3Name, String expectedCsv) {
        this.csv1Name = csv1Name;
        this.csv2Name = csv2Name;
        this.csv3Name = csv3Name;
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
        return Arrays.asList(
                new Object[][] {
                        { path + "test1a.csv", path + "test1b.csv", path + "test1output.csv", path + "test1c.csv" },
                        { path + "test2a.csv", path + "test2b.csv", path + "test2output.csv", path + "test2c.csv" } });
    }

    @Test
    public void testCompareCSVTest() {
        new compareCSV();
        // System.out.println(csv1Name + csv2Name);
        assertEquals(expectedCsv, readCSVIn(compareCSV.compare(csv1Name, csv2Name, csv3Name)));
        System.out.println("compareCSV test ran successfully");

    }
}