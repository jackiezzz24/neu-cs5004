package Clothes;

public class Pants extends Clothing{
    private final int size;
    private Color color;
    private Season season;
    public Pants(int size, Color color, Season season) {
        super();
        this.size = size;
        this.color = color;
        this.season = season;
    }

    @Override
    public String toString() {
        return "Pants, size " + this.size;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Pants o) {
            return this.size == o.size
                    && this.color == o.color
                    && this.season == o.season;
        }
        else {
            return false;
        }
    }
}
