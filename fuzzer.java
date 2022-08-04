import java.util.concurrent.ThreadLocalRandom;

public class fuzzer {
    final String alphaUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String alphaLower = alphaUpper.toLowerCase();
    final String digits = "0123456789";
    final String alnum = alphaLower + alphaUpper + digits;

    // return a random String of length n with characters from "alnum"
    String randomFuzz(int n) {
        String output = "";
        for (int i = 0; i < n; i++) {
            output += alnum.charAt(ThreadLocalRandom.current().nextInt(alnum.length()));
        }
        return output;
    }

    // return a String of input after n generations of mutations
    String mutationFuzzN(String input, int n) {
        String tem = mutationFuzz(input);
        for (int i = 0; i < n - 1; i++) {
            tem = mutationFuzz(tem);
        }
        return tem;
    }

    // return a String of input after ONE generation of mutation
    String mutationFuzz(String input) {
        int pos = ThreadLocalRandom.current().nextInt(input.length());
        int i = ThreadLocalRandom.current().nextInt(alnum.length());
        char randomChar = alnum.charAt(i);
        char[] inputArray = input.toCharArray();
        inputArray[pos] = randomChar;
        return String.valueOf(inputArray);
    }
}
