package Clothes;

import java.util.ArrayList;
import java.util.List;

public class Outfit {
    List<Clothing> clothingList;

    public Outfit() {
        clothingList = new ArrayList<>();
    }
    public Outfit(int size) {
        clothingList = new ArrayList<>();
        Clothing pant1 = new Pants(size, Color.WHITE, Season.SPRING);
        Clothing shirt1 = new Shirt(size, Color.BLACK, Season.FALL);
        clothingList.add(pant1);
        clothingList.add(shirt1);
    }

    public Outfit merge(Outfit other) {
        Outfit newOutfit = new Outfit();
        newOutfit.clothingList.addAll(this.clothingList);
        newOutfit.clothingList.addAll(other.clothingList);
        return newOutfit;
    }
}
