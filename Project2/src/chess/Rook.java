package chess;

public class Rook extends Chess{

    /**
     * Constructs a Rook object and initializes it to the given row, column number and color.
     *
     * @param row the initial row number of this chess
     * @param col the initial column number of this chess
     * @param color the color of this chess
     */
    public Rook(int row, int col, Color color) {
        super(row, col, color);
    }

    /**
     * Determine if the chess piece can move to a given cell.
     *
     * @param row the row where the piece might be moved to.
     * @param col the column where the piece might be moved to.
     * @return True if the piece can move to that location. False otherwise.
     */
    @Override
    public boolean canMove(int row, int col) {
        if (super.canMove(row, col)) {
            return row == super.getRow() ||
                    col == super.getColumn();
        }
        return false;
    }
}
