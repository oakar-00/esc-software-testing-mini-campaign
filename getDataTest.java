import java.io.File;
import java.io.*;
import java.util.stream.*;
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
    static String path = "C:/Documents/SUTD Stuff/Studies/Term5/Elements of Software Construction/esc-software-testing-mini-campaign/";
    private String filename;
    private ArrayList<String> expectedData;

    public getDataTest(String filename, String expectedDataCSV) {
        this.filename = filename;
        this.expectedData = readCsvIn(expectedDataCSV);
    }

    public static ArrayList<String> readCsvIn(String filename) {
        ArrayList asList = new ArrayList();
        try {
            File Obj = new File(filename);
            Scanner Reader = new Scanner(Obj);
            String line1 = Reader.nextLine();
            List<String> keys = Arrays.asList(line1.split(","));

            while (Reader.hasNextLine()) {
                HashMap<String, String> data_tem = new HashMap<>();
                String data = Reader.nextLine();
                List<String> key_value = Arrays.asList(data.split(","));

                for (int i = 0; i < keys.size(); i++) {
                    data_tem.put(keys.get(i), key_value.get(i));

                }
                asList.add(data_tem);
            }
            Reader.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return asList;
    }

    @Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][] { { (path + "sample_file_1.csv"), path + "sample_file_1.csv" },
                { path + "test1a.csv", path + "test1a.csv" }, { path + "test1b.csv", path + "test1b.csv" },
                { path + "test2a.csv", path + "test2a.csv" }, { path + "test2b.csv", path + "test2b.csv" },
                { path + "test3a.csv", path + "test3a.csv" }, { path + "test3b.csv", path + "test3b.csv" } });
    }

    @Test
    public void testGetDataTest() {
        new compareCSV();
        assertEquals(expectedData, compareCSV.getData(filename));
        System.out.println("getData test ran successfully");

    }
}
