package doubledispatch;

import java.util.ArrayList;
import java.util.List;

public class SimulationBuilder {

    public static List<String> log = new ArrayList<>();

    /**
     * Return new instance of plants
     * @param name the name of the planet
     * @return the new instance of plants
     */

    public static IPlanet createPlanet(String name){
        if (name.equalsIgnoreCase("Mars")) {
            return new Mars();
        } else if (name.equalsIgnoreCase("Venus")) {
            return new Venus();
        } else if (name.equalsIgnoreCase("Mercury")) {
            return new Mercury();
        } else {
            return null;
        }
    }

    /**
     * Return the new instance of space
     * @param name the name of the explorer
     * @return the new instance of space
     */

    public static ISpaceExplorer createExplorer(String name) {
        if (name.equalsIgnoreCase("LifeExplorer")){
            return new LifeExplorer();
        } else if (name.equalsIgnoreCase("TerrainExplorer")) {
            return new TerrainExplorer();
        } else {
            return null;
        }
    }

    /**
     * Add a new log when the plant is visited
     * @param message the message for the log
     */
    public static void addToLog(String message) {
        log.add(message);
    }

    /**
     * Return the simulation log
     * @return the simulation log
     */
    public static List<String> getSimulationLog(){
        return new ArrayList<>(log);
    }
}
