package Clothes;


import java.util.ArrayList;
import java.util.List;

public abstract class Clothing implements Comparable<Clothing>{
    private final List<Integer> rating;

    public Clothing() {
        this.rating = new ArrayList<>();
    }

    public void rate(int rate) {
        if (rate < 1 || rate > 5) {
            throw new IllegalArgumentException("Rate can only be 1, 2, 3, 4, or 5");
        }
        rating.add(rate);
    }

    public double getAverage() {
        double total = 0;
        if (rating.size() == 0) {
            return 0;
        }
        for (int i = 0; i < rating.size(); i++) {
            total += rating.get(i);
        }
        return total / rating.size();
    }

    @Override
    public int compareTo(Clothing o) {
        return (int) Math.signum(this.getAverage() - o.getAverage());
    }
}
