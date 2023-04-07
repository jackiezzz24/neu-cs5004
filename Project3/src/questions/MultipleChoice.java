package questions;

import java.util.Objects;

public class MultipleChoice implements Question{
    private String question;
    private String correct;
    private String[] options;

    /**
     * Constructs a MultipleChoice object and initializes it to the given question, options and correct answer.
     * MultipleChoice question offers several options, only one of which is correct.
     * A question must have at least 3 options, but no more than 8.
     * An answer can be entered as one of the option numbers in a string. For example, "1", "3", etc.
     * Option numbers start at 1.
     * @param question question for this MultipleChoice object
     * @param correct correct answer for this MultipleChoice object
     * @param options possible options for this MultipleChoice object
     */
    public MultipleChoice(String question, String correct, String  ...options) {
        this.question = question;
        if (options.length < 3 || options.length > 8) {
            throw new IllegalArgumentException();
        }
        this.options = new String[options.length];
        int i = 0;
        for (String s : options) {
            this.options[i++] = s;
        }
        this.correct = correct;
    }

    /**
     * Determines if the answer is correct for a given question. If the answer is
     * correct, this method returns "Correct"; and "Incorrect" otherwise.
     *
     * @param answer the answer given
     * @return "Correct" or "Incorrect"
     */
    @Override
    public String answer(String answer) {
        if (Objects.equals(answer, correct)) {
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
        if (o instanceof MultipleChoice) {
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
        if (o instanceof TrueFalse) {
            return 1;
        }
        return -1;
    }
}
