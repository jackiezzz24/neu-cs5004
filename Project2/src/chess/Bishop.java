package chess;

public class Bishop extends Chess{

    public Bishop(int row, int col, Color color) {
        super(row, col, color);
    }

    @Override
    public boolean canMove(int row, int col) {
        if (super.canMove(row, col)) {
            return Math.abs(row - super.getRow()) == Math.abs(col - super.getColumn());
        }
        return false;
    }


}
