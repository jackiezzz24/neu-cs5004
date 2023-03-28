package polynomial;

import java.util.ArrayList;
import java.util.List;

public class PolynomialImpl implements Polynomial{

    private List<Term> terms;

    /**
     * Create static class for Term. Each term has a coefficient and power
     */
    private static class Term {
        private int coefficient;
        private final int power;

        /**
         * Constructs a term object and initializes it to the given coefficient and power
         * @param coefficient the coefficient of this term
         * @param power the power of this term
         */
        public Term(int coefficient, int power) {
            this.coefficient = coefficient;
            this.power = power;
        }

        /**
         * Return the coefficient of this term
         * @return the coefficient of this term
         */
        public int getCoefficient() {
            return coefficient;
        }

        /**
         * Return the power of this term
         * @return the power of this term
         */
        public int getPower() {
            return power;
        }

        /**
         * Set the coefficient of this term
         * @param coefficient set the coefficient to this term
         */
        public void setCoefficient(int coefficient) {
            this.coefficient = coefficient;
        }

    }

    /**
     * Constructs a PolynomialImpl object and initializes it with no term
     */
    public PolynomialImpl () {
        terms = new ArrayList<>();
    }

    /**
     * Constructs a PolynomialImpl object and initializes it with a string of a given polynomial function
     * Creates a polynomial by parsing a string representation of the polynomial. The string must contain
     * each term separated by a space. The terms should be in the format of "a x^b" or "a" where "a" is the
     * coefficient and "b" is the power. If "b" is not present, it is assumed to be zero. The polynomial
     * terms will be added to the current polynomial in decreasing order of power.
     * @param polynomial string of a given polynomial function
     */
    public PolynomialImpl(String polynomial) {
        this();
        if (polynomial.isEmpty()) {
            return;
        }
        String[] polyTerms = polynomial.split(" ");
        int coefficient = 0;
        int power = 0;
        for (String polyTerm : polyTerms) {
            if (polyTerm.contains("^")) {
                coefficient = Integer.parseInt(polyTerm.substring(0, polyTerm.indexOf("^") - 1));
                power = Integer.parseInt(polyTerm.substring(polyTerm.indexOf("^") + 1));
                if (coefficient != 0) {
                    addTerm(coefficient, power);
                }
            }
            else {
                coefficient = Integer.parseInt(polyTerm);
                addTerm(coefficient, 0);
            }
        }
    }

    /**
     * Return the string of the given polynomial function
     * @return the string of the given polynomial function
     */
    @Override
    public String toString() {
        if (terms.size() == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < terms.size(); i++) {
            if (terms.get(i).getCoefficient() != 0) {
                if (terms.get(i).getPower() != 0) {
                    if (terms.get(i).getCoefficient() > 0 && i != 0) {
                        sb.append("+")
                                .append(terms.get(i).getCoefficient())
                                .append("x^")
                                .append(terms.get(i).getPower());
                    } else {
                        sb.append(terms.get(i).getCoefficient())
                                .append("x^")
                                .append(terms.get(i).getPower());
                    }
                    if (i != terms.size() - 1) {
                        sb.append(" ");
                    }
                } else {
                    if (terms.get(i).getCoefficient() > 0) {
                        sb.append("+").append(terms.get(i).getCoefficient());
                    } else {
                        sb.append(terms.get(i).getCoefficient());
                    }
                }
            }
        }
        return sb.toString();
    }


    /**
     * Add this polynomial to another and return the result as another polynomial.
     *
     * @param other the other polynomial to be added
     * @return the resulting polynomial
     * @throws IllegalArgumentException if parameter is not the same concrete type
     *                                  as the current object.
     */
    @Override
    public Polynomial add(Polynomial other) throws IllegalArgumentException {
        if (!(other instanceof PolynomialImpl)) {
            throw new IllegalArgumentException("Polynomials are not the same concrete type.");
        }
        int i = 0, j = 0;
        PolynomialImpl result = new PolynomialImpl();
        PolynomialImpl o = (PolynomialImpl) other;
        while (i < this.terms.size() && j < o.terms.size()) {
            Term thisTerm = this.terms.get(i);
            Term otherTerm = o.terms.get(j);
            if (thisTerm.getPower() == otherTerm.getPower()) {
                int sum = thisTerm.getCoefficient() + otherTerm.getCoefficient();
                if (sum != 0) {
                    result.addTerm(sum, thisTerm.getPower());
                }
                i++;
                j++;
            } else if (thisTerm.getPower() > otherTerm.getPower()) {
                result.addTerm(thisTerm.getCoefficient(), thisTerm.getPower());
                i++;
            } else {
                result.addTerm(otherTerm.getCoefficient(), otherTerm.getPower());
                j++;
            }
        }
        while (i < this.terms.size()) {
            result.addTerm(terms.get(i).getCoefficient(), terms.get(i).getPower());
            i++;
        }
        while (j < o.terms.size()) {
            result.addTerm(o.terms.get(j).getCoefficient(), o.terms.get(j).getPower());
            j++;
        }

        return result;
    }

    /**
     * Add a term to this polynomial with the specified coefficient and power.
     *
     * @param coefficient the coefficient of the term to be added
     * @param power       the power of the term to be added
     * @throws IllegalArgumentException if the power is negative
     */
    @Override
    public void addTerm(int coefficient, int power) throws IllegalArgumentException {
        if (power < 0) {
            throw new IllegalArgumentException("Power cannot be negative.");
        }
        if (coefficient == 0) {
            return;
        }
        for (int i = 0; i < terms.size(); i++) {
            Term term = terms.get(i);
            if (term.getPower() == power) {
                term.setCoefficient(term.getCoefficient() + coefficient);
                if (term.getCoefficient() == 0) {
                    terms.remove(i);
                }
                return;
            } else if (term.getPower() < power) {
                terms.add(i, new Term(coefficient, power));
                return;
            }
        }
        terms.add(new Term(coefficient, power));
    }

    /**
     * Determines if this polynomial is the same as the parameter polynomial.
     *
     * @param poly the polynomial to use
     * @return true if this polynomial is of the same concrete type and has the same
     * terms as the parameter, false otherwise
     */
    @Override
    public boolean isSame(Polynomial poly) {
        if (!(poly instanceof PolynomialImpl)) {
            return false;
        }

        PolynomialImpl other = (PolynomialImpl) poly;
        if (other.terms.size() != this.terms.size()) {
            return false;
        }

        for (int i = 0; i < other.terms.size(); i++) {
            if (other.terms.get(i).getPower() != this.terms.get(i).getPower()) {
                return false;
            }
            if (other.terms.get(i).getCoefficient() != this.terms.get(i).getCoefficient()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Evaluate the value of this polynomial at the given value of the variable.
     *
     * @param x the value at which the polynomial is to be evaluated.
     * @return the value of the polynomial at x
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        for (Term term : terms) {
            result += term.getCoefficient() * Math.pow(x, term.getPower());
        }
        return result;
    }

    /**
     * Return the coefficient of the term with the given power.
     *
     * @param power the power whose coefficient is sought
     * @return the coefficient at the given power
     */
    @Override
    public int getCoefficient(int power) {
        for (Term term : terms) {
            if (term.getPower() == power) {
                return term.getCoefficient();
            }
        }
        return 0;
    }

    /**
     * Get the degree of this polynomial.
     *
     * @return the degree of this polynomial as a whole number
     */
    @Override
    public int getDegree() {
        if (terms.size() == 0) {
            return 0;
        }
        return terms.get(0).getPower();
    }
}
