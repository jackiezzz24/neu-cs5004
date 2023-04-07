package questions;

public class Likert implements Question{
    private final String question;

    /**
     * Constructs a Likert object and initializes it to the given question.
     * Likert questions can be answered on a fixed, 5-point Likert scale
     * (Strongly Agree, Agree, Neither Agree nor Disagree, Disagree, Strongly Disagree).
     * Since this question asks an opinion, there is no "correct" answer.
     * An answer can be entered as one of the option numbers, numbered from 1 in the above order.
     * Any valid option number is a "correct" answer
     *
     * @param question question for this likert object
     */
    public Likert(String question) {
        this.question = question;
    }

    /**
     * Determines if the answer is correct for a given question. If the answer is
     * correct, this method returns "Correct"; and "Incorrect" otherwise.
     * Since this question asks an opinion, there is no "correct" answer.
     * An answer can be entered as one of the option numbers, numbered from 1 in the above order.
     * Any valid option number is a "correct" answer
     *
     * @param answer the answer given
     * @return "Correct" or "Incorrect"
     */
    @Override
    public String answer(String answer) {
        if (answer != null &&
                (answer.equals("1") || answer.equals("2") || answer.equals("3") ||
                        answer.equals("4") || answer.equals("5"))) {
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
        if (o instanceof Likert) {
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
        return 1;
    }
}
