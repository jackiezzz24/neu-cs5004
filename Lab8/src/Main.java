import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    /**
     * Converts a String into pig latin
     * @param input the String to convert into pig latin
     * @return the input, converted to pig latin
     */

    public static String pigLatin(String input) {
        return Arrays.stream(input.split(" "))
                .map(word -> {
                    char c = word.charAt(0);
                    if ("AEIOU".indexOf(c) != -1) {
                        return word + "WAY";
                    } else {
                        return word.substring(1) + c + "AY";
                    }
                })
                .collect(Collectors.joining(" "));
    }
}
