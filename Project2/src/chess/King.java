package chess;

public class King extends Chess{

    public King(int row, int col, Color color) {
        super(row, col, color);
    }
    @Override
    public boolean canMove(int row, int col) {
        if (super.canMove(row, col)) {
            return (Math.abs(row - super.getRow()) == 1 && Math.abs(col - super.getColumn()) == 1)
                    || (Math.abs(row - super.getRow()) == 1 && Math.abs(col - super.getColumn()) == 0)
                    || (Math.abs(row - super.getRow()) == 0 && Math.abs(col - super.getColumn()) == 1);
        }
        return false;
    }

}
