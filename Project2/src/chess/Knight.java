package chess;

public class Knight extends Chess {

    /**
     * Constructs a Bishop object and initializes it to the given row, column number and color.
     *
     * @param row the initial row number of this chess
     * @param col the initial column number of this chess
     * @param color the color of this chess
     */
    public Knight(int row, int col, Color color) {
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
            return Math.abs(row - super.getRow()) == 2 * Math.abs(col - super.getColumn()) ||
                    Math.abs(col - super.getColumn()) == 2 * Math.abs(row - super.getRow());
        }
        return false;
    }
}
