package dungeon;

public class MedievalLevelBuilder {

    private final int numRooms;
    private final int numMonsters;
    private final int numTreasures;
    private final Level level;
    private int roomCounter;
    private int monsterCounter;
    private int treasureCounter;

    public MedievalLevelBuilder(int levelNum, int numRooms, int numMonsters, int numTreasures) {
        if (levelNum < 0 || numRooms < 0 || numMonsters < 0 || numTreasures < 0) {
            throw new IllegalArgumentException();
        }
        this.numRooms = numRooms;
        this.numMonsters = numMonsters;
        this.numTreasures = numTreasures;
        this.level = new Level(levelNum);

    }

    public void addRoom(String description) throws IllegalStateException {
        if (roomCounter == numRooms) {
            throw new IllegalStateException();
        }
        level.addRoom(description);
        roomCounter++;
    }

    public void addGoblins (int roomId, int num){
        if (monsterCounter + num > numMonsters) {
            throw new IllegalStateException();
        }
        if (roomId > roomCounter) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < num; i++) {
            Monster goblin = new Monster("goblin",
                    "mischievous and very unpleasant, vengeful, and greedy creature whose " +
                            "primary purpose is to cause trouble to humankind", 7);
            level.addMonster(roomId, goblin);
            monsterCounter++;
        }
    }

    public void addOrc(int roomId) {
        if (monsterCounter == numMonsters) {
            throw new IllegalStateException();
        }
        if (roomId > roomCounter) {
            throw new IllegalArgumentException();
        }
        Monster orc = new Monster("orc",
                "brutish, aggressive, malevolent being serving evil", 20);
        level.addMonster(roomId, orc);
        monsterCounter++;

    }

    public void addOgre(int roomId) {
        if (monsterCounter == numMonsters) {
            throw new IllegalStateException();
        }
        if (roomId > roomCounter) {
            throw new IllegalArgumentException();
        }
        Monster ogre = new Monster("ogre",
                "large, hideous man-like being that likes to eat humans for lunch", 50);
        level.addMonster(roomId, ogre);
        monsterCounter++;
    }

    public void addHuman (int roomId) {
        if (monsterCounter == numMonsters) {
            throw new IllegalStateException();
        }
        if (roomId >= roomCounter) {
            throw new IllegalArgumentException();
        }
        Monster human = new Monster("human",
                "human", 0);
        level.addMonster(roomId, human);
        monsterCounter++;
    }

    public void addPotion (int roomId) {
        if (treasureCounter == numTreasures) {
            throw new IllegalStateException();
        }
        if (roomId >= roomCounter) {
            throw new IllegalArgumentException();
        }
        Treasure potion = new Treasure("a healing potion", 1);
        level.addTreasure(roomId, potion);
        treasureCounter++;
    }

    public void addGold (int roomId, int value) {
        if (treasureCounter == numTreasures) {
            throw new IllegalStateException();
        }
        if (roomId >= roomCounter) {
            throw new IllegalArgumentException();
        }
        Treasure gold = new Treasure("pieces of gold", value);
        level.addTreasure(roomId, gold);
        treasureCounter++;
    }

    public void addWeapon  (int roomId, String description) {
        if (treasureCounter == numTreasures) {
            throw new IllegalStateException();
        }
        if (roomId >= roomCounter) {
            throw new IllegalArgumentException();
        }
        Treasure weapon = new Treasure(description, 10);
        level.addTreasure(roomId, weapon);
        treasureCounter++;
    }

    public void addSpecial (int roomId, String description, int val) {
        if (treasureCounter == numTreasures) {
            throw new IllegalStateException();
        }
        if (roomId >= roomCounter) {
            throw new IllegalArgumentException();
        }
        Treasure special = new Treasure(description, val);
        level.addTreasure(roomId, special);
        treasureCounter++;
    }

    public Level build(){
        if (roomCounter != numRooms || monsterCounter != numMonsters || treasureCounter != numTreasures) {
            throw new IllegalStateException();
        }
        return level;
    }

    public int getRoomCounter() {
        return roomCounter;
    }

    public int getMonsterCounter() {
        return monsterCounter;
    }

    public int getTreasureCounter() {
        return treasureCounter;
    }
}
