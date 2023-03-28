package doubledispatch;

public class Mars implements IPlanet{
    /**
     * @param explorer
     */
    @Override
    public void accept(ISpaceExplorer explorer) {
        explorer.visit(this);
    }
}
