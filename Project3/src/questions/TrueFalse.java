package questions;

import java.util.Objects;

public class TrueFalse implements Question{
    private String question;
    private String correct;

    /**
     * Constructs a TrueFalse object and initializes it to the given question and correct answer.
     * TrueFalse question can be answered in one of two ways: true or false.
     * The only valid answer to this type of question is a "True" or "False".
     * @param question question for this TrueFalse object
     * @param correct correct answer for this TrueFalse object
     */
    public TrueFalse(String question, String correct) {
        this.question = question;
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
        if (o instanceof TrueFalse) {
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
        return -1;
    }
}
