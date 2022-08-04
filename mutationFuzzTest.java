import org.junit.Test;

public class mutationFuzzTest {
    public static void main(String[] args) {
        System.out.println("Hello World");
        fuzzer fuzz = new fuzzer();
        System.out.println(fuzz.randomFuzz(30));
        System.out.println(fuzz.mutationFuzz("input"));
        System.out.println(fuzz.mutationFuzzN("Kanye West is the greatest god to exist.", 5));
        System.out.println(fuzz.mutationFuzzN("Kanye West is the greatest god to exist.", 100));

        compareCSV test1 = new compareCSV();
        // will return error and create an empty csv file with the name of the third
        // argument
        test1.compare(fuzz.randomFuzz(5) + ".csv", fuzz.randomFuzz(5) + ".csv", fuzz.randomFuzz(5) + ".csv");
    }

}
