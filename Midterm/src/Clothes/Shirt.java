package Clothes;

public class Shirt extends Clothing{
    private int size;
    private Color color;
    private Season season;
    public Shirt(int size, Color color, Season season) {
        super();
        this.size = size;
        this.color = color;
        this.season = season;
    }

    @Override
    public String toString() {
        return "Shirt, size " + this.size;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Shirt o) {
            return this.size == o.size
                    && this.color == o.color
                    && this.season == o.season;
        }
        else {
            return false;
        }
    }
}
