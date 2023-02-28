package Clothes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Outfit test1 = new Outfit(7);
        Outfit test2 = new Outfit(6);
        Outfit ans = test1.merge(test2);
        int n = ans.clothingList.size();
        System.out.println(n);

        Pants p1 = new Pants(7, Color.WHITE, Season.FALL);
        p1.rate(5);
        p1.rate(2);
        System.out.println(p1.getAverage());
        Pants p2 = new Pants(6, Color.WHITE, Season.SPRING);
        p2.rate(4);
        List<Clothing> list = new ArrayList<>();
        list.add(p2);
        list.add(p1);
        Collections.sort(list);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
