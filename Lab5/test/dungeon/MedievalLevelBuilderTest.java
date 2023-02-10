package dungeon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.BatchUpdateException;

import static org.junit.jupiter.api.Assertions.*;

class MedievalLevelBuilderTest {

    private MedievalLevelBuilder builder;
    @BeforeEach
    void setUp() {
        builder = new MedievalLevelBuilder(1, 3, 10, 5);
        builder.addRoom("Room 0");
        builder.addRoom("Room 1");
        builder.addRoom("Room 2");
        builder.addGoblins(0, 5);
        builder.addPotion(0);
        builder.addGold(1, 5);
        builder.addWeapon(1, "Gun");
        builder.addSpecial(2, "Diamond", 50);

    }

    @Test
    void addRoom() {
        assertEquals(3, builder.getRoomCounter());
        assertThrows(IllegalStateException.class, () -> builder.addRoom("Room 4"));
    }

    @Test
    void addGoblins() {
        assertEquals(5, builder.getMonsterCounter());
        assertThrows(IllegalStateException.class, () -> builder.addGoblins(0, 8));
        assertThrows(IllegalArgumentException.class, () -> builder.addGoblins(6, 3));
    }

    @Test
    void addOrc() {
        assertThrows(IllegalArgumentException.class, () -> builder.addOrc(6));
        builder.addOrc(1);
        assertEquals(6, builder.getMonsterCounter());
        builder.addGoblins(2, 4);
        assertThrows(IllegalStateException.class, () -> builder.addOrc(1));

    }

    @Test
    void addOgre() {
        assertThrows(IllegalArgumentException.class, () -> builder.addOgre(6));
        builder.addOgre(1);
        assertEquals(6, builder.getMonsterCounter());
        builder.addGoblins(2, 4);
        assertThrows(IllegalStateException.class, () -> builder.addOgre(1));

    }

    @Test
    void addHuman() {
        assertThrows(IllegalArgumentException.class, () -> builder.addHuman(6));
        builder.addHuman(2);
        assertEquals(6, builder.getMonsterCounter());
        builder.addGoblins(2, 4);
        assertThrows(IllegalStateException.class, () -> builder.addHuman(2));

    }

    @Test
    void addPotion() {
        assertThrows(IllegalArgumentException.class, () -> builder.addPotion(6));
        builder.addPotion(1);
        assertEquals(5, builder.getTreasureCounter());
        assertThrows(IllegalStateException.class, () -> builder.addPotion(2));
    }

    @Test
    void addGold() {
        assertThrows(IllegalArgumentException.class, () -> builder.addGold(6, 2));
        builder.addGold(1, 5);
        assertEquals(5, builder.getTreasureCounter());
        assertThrows(IllegalStateException.class, () -> builder.addGold(2, 2));
    }

    @Test
    void addWeapon() {
        assertThrows(IllegalArgumentException.class, () -> builder.addWeapon(6, "Knife"));
        builder.addWeapon(1, "Knife");
        assertEquals(5, builder.getTreasureCounter());
        assertThrows(IllegalStateException.class, () -> builder.addWeapon(2, "Knife"));
    }

    @Test
    void addSpecial() {
        assertThrows(IllegalArgumentException.class, () -> builder.addSpecial(6, "Diamond", 50));
        builder.addSpecial(1, "Diamond", 50);
        assertEquals(5, builder.getTreasureCounter());
        assertThrows(IllegalStateException.class, () -> builder.addSpecial(2, "Diamond", 50));
    }

    @Test
    void build() {
        assertThrows(IllegalStateException.class, () -> builder.build());
        builder.addGoblins(1, 2);
        builder.addHuman(1);
        builder.addOrc(2);
        builder.addOgre(2);
        builder.addPotion(1);
        System.out.println(builder.build());

    }
}