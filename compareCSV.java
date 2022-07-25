
// Import the File class
import java.io.File;

// Import this class for handling errors

import java.io.*;

import java.util.stream.*;

// Import the Scanner class to read content from text files

import java.util.*;

public class compareCSV {
    public static ArrayList getData(String filename) {

        ArrayList data_final = new ArrayList();

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
                // System.out.println(data_tem);
                data_final.add(data_tem);
                // System.out.println(data);

            }
            // System.out.println(data_final);
            Reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        return data_final;

    }

    public static String putData(String filename, ArrayList Data) {
        try {
            FileWriter myWriter = new FileWriter(filename);

            for (int i = 0; i < Data.size(); i++) {
                HashMap<String, String> map = (HashMap<String, String>) Data.get(i);
                ArrayList<String> listOfValues = map.values().stream().collect(
                        Collectors.toCollection(ArrayList::new));
                String listString = listOfValues.stream().map(Object::toString)
                        .collect(Collectors.joining(", "));
                myWriter.write(listString + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return filename;
    }

    public static String compare(String file1, String file2, String file3) {
        ArrayList file_1 = new ArrayList();
        ArrayList file_2 = new ArrayList();
        ArrayList file_3 = new ArrayList();

        file_1 = getData(file1);

        file_2 = getData(file2);

        file_3 = getData(file3);

        if (file_1.size() == file_2.size()) {
            for (int i = 0; i < file_1.size(); i++) {
                HashMap<String, String> line_1 = (HashMap<String, String>) file_1.get(i);
                HashMap<String, String> line_2 = (HashMap<String, String>) file_2.get(i);
                if (line_1.equals(line_2) == false) {
                    file_3.add(line_1);
                    file_3.add(line_2);
                }

            }

        }
        System.out.println("Comparison is Successful!");
        return putData(file3, file_3);

    }
}