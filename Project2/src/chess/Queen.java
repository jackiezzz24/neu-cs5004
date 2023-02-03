package chess;

public class Queen extends Chess{

    public Queen(int row, int col, Color color) {
        super(row, col, color);
    }

    @Override
    public boolean canMove(int row, int col) {
        if (super.canMove(row, col)) {
            return (Math.abs(row - super.getRow()) == Math.abs(col - super.getColumn()))
                    || row == super.getRow()
                    || col == super.getColumn();
        }
        return false;
    }

}
