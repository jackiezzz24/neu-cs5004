package doubledispatch;

public class Venus implements IPlanet{
    /**
     * @param explorer
     */
    @Override
    public void accept(ISpaceExplorer explorer) {
        explorer.visit(this);
    }
}
