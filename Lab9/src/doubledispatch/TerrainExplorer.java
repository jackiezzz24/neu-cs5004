package doubledispatch;

public class TerrainExplorer implements ISpaceExplorer {

    /**
     * @param mercury
     */
    @Override
    public void visit(Mercury mercury) {
        SimulationBuilder.addToLog("Landing on Mercury...exploring for terrain");
    }

    /**
     * @param mars
     */
    @Override
    public void visit(Mars mars) {
        SimulationBuilder.addToLog("Landing on Mars...exploring for terrain");
    }

    /**
     * @param venus
     */
    @Override
    public void visit(Venus venus) {
        SimulationBuilder.addToLog("Landing on Venus...exploring for terrain");
    }
}
