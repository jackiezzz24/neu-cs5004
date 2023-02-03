package chess;

public class Rook extends Chess{

    public Rook(int row, int col, Color color) {
        super(row, col, color);
    }

    @Override
    public boolean canMove(int row, int col) {
        if (super.canMove(row, col)) {
            return row == super.getRow() ||
                    col == super.getColumn();
        }
        return false;
    }
}
