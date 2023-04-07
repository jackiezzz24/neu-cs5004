package questions;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MultipleSelect implements Question{

    private String question;
    private String correct;
    private String[] options;

    /**
     * Constructs a MultipleSelect object and initializes it to the given question, options and correct answer.
     * MultipleSelect question offers several options, but there are multiple correct answers.
     * A question may have at least 3 options, but no more than 8.
     * Both the correct answer and the user's answer are entered as the option numbers in a string.
     * Option numbers start at 1.
     * An answer is correct if and only if it contains all the correct options and none of the incorrect ones.
     * @param question question for this MultipleSelect object
     * @param correct correct answer for this MultipleSelect object
     * @param options possible options for this MultipleSelect object
     */
    public MultipleSelect(String question, String correct, String  ...options) {
        this.question = question;
        if (options.length < 3 || options.length > 8) {
            throw new IllegalArgumentException();
        }
        this.options = new String[options.length];
        int i = 0;
        for (String s : options) {
            this.options[i++] = s;
        }
        char[] tempArray = correct.replaceAll("\\s", "").toCharArray();
        Arrays.sort(tempArray);
        this.correct = new String(tempArray);
    }

    /**
     * Determines if the answer is correct for a given question. If the answer is
     * correct, this method returns "Correct"; and "Incorrect" otherwise.
     *
     * @param answer the answer given
     * @return "Correct" or "Incorrect"
     */

    public String answer(String answer) {
        char[] tempArray = answer.replaceAll("\\s", "").toCharArray();
        Arrays.sort(tempArray);
        String ans = new String(tempArray);
        if (Objects.equals(ans, correct)) {
            return "Correct";
        }
        return "Incorrect";
    }


    /**
     * Returns the text of the question.
     *
     * @return the text
     */
    @Override
    public String getText() {
        return question;
    }

    /**
     * Compares the question objects and order them based on expected ordering.
     * All true/false questions should be before any multiple-choice questions.
     * All multiple-choice questions should be before any multiple-select questions.
     * All multiple-select questions should be before any Likert questions.
     * Within a question type, they should be ordered in the lexicographical (dictionary) order of their question text.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Question o) {
        if (o instanceof MultipleSelect) {
            String a = this.getText();
            String b = o.getText();
            for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
                if (a.charAt(i) < b.charAt(i)) {
                    return -1;
                }
                else if (a.charAt(i) > b.charAt(i)) {
                    return 1;
                }
            }
            return Integer.compare(a.length(), b.length());
        }
        if (o instanceof Likert) {
            return -1;
        }
        return 1;
    }
}
