package questions;

public class Likert implements Question{
    private final String question;

    /**
     * Constructs a Likert object and initializes it to the given question.
     *
     * @param question question for this likert object
     */
    public Likert(String question) {
        this.question = question;
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
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
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
