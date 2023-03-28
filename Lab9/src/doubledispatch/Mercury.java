package doubledispatch;

public class Mercury implements IPlanet{
    /**
     * @param explorer
     */
    @Override
    public void accept(ISpaceExplorer explorer) {
        explorer.visit(this);
    }
}
