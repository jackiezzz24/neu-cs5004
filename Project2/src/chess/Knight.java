package chess;

public class Knight extends Chess {

    public Knight(int row, int col, Color color) {
        super(row, col, color);
    }

    @Override
    public boolean canMove(int row, int col) {
        if (super.canMove(row, col)) {
            return Math.abs(row - super.getRow()) == 2 * Math.abs(col - super.getColumn()) ||
                    Math.abs(col - super.getColumn()) == 2 * Math.abs(row - super.getRow());
        }
        return false;
    }
}
