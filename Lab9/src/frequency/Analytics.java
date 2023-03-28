package frequency;

import java.util.HashMap;
import java.util.Map;

public class Analytics {

    /**
     * Return the relative frequency of the occurrences of word in a given message.
     * @param message the given message
     * @return the relative frequency of the occurrences of word in a given message.
     */
    public static Map<String, Double> wordFrequency(String message){
        String[] words = message.replaceAll("[^a-zA-Z ]", "").split(" ");
        int sum = words.length;
        Map<String, Double> frequencies = new HashMap<>();
        for (String s : words) {
            String word = s.toUpperCase();
            if (frequencies.containsKey(word)) {
                frequencies.put(word, (frequencies.get(word) + 1));
            } else {
                frequencies.put(word, 1.0);
            }
        }
        frequencies.replaceAll((k, v) -> v / sum);
        return frequencies;
    }
}
