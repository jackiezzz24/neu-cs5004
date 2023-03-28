package doubledispatch;

import static frequency.Analytics.wordFrequency;

public class Main {
    public static void main(String[] args) {
        IPlanet mars = SimulationBuilder.createPlanet("Mars");
        IPlanet venus = SimulationBuilder.createPlanet("Venus");
        IPlanet mercury = SimulationBuilder.createPlanet("Mercury");
        ISpaceExplorer life = SimulationBuilder.createExplorer("LifeExplorer");
        ISpaceExplorer terrain = SimulationBuilder.createExplorer("TerrainExplorer");
        mars.accept(life);
        venus.accept(terrain);
        mercury.accept(life);
        life.visit(venus);
        life.visit(venus);
        terrain.visit(mars);
        terrain.visit(mercury);
        System.out.println(SimulationBuilder.getSimulationLog());
    }

}
