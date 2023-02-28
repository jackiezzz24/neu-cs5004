package chess;

public class Pawn extends Chess{

    /**
     * Constructs a Bishop object and initializes it to the given row, column number and color.
     *
     * @param row the initial row number of this chess
     * @param col the initial column number of this chess
     * @param color the color of this chess
     */
    public Pawn(int row, int col, Color color) {
        super(row, col, color);
        if (color == Color.WHITE && row < 1) {
            throw new IllegalArgumentException();
        }
        if (color == Color.BLACK && row > 6) {
            throw  new IllegalArgumentException();
        }
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
            if (super.getColor() == Color.WHITE) {
                if (super.getRow() == 1) {
                    return (row - super.getRow() == 1 || row - super.getRow() == 2)
                            && col - super.getColumn() == 0;
                } else {
                    return row - super.getRow() == 1 && col - super.getColumn() == 0;
                }
            }

            if (super.getColor() == Color.BLACK) {
                if (super.getRow() == 6) {
                    return (super.getRow() - row == 1 || super.getRow() - row == 2)
                            && col - super.getColumn() == 0;
                } else {
                    return super.getRow() - row == 1 && col - super.getColumn() == 0;
                }
            }
        }
        return false;
    }

    /**
     * Determine of the piece can kill another piece starting from its current
     * location.
     *
     * @param piece the piece that might be killed.
     * @return True if the new piece can be killed.
     */
    @Override
    public boolean canKill(ChessPiece piece) {
        if (super.getColor() == Color.WHITE && super.getColor() != piece.getColor()) {
            return (piece.getRow() - super.getRow() == 1)
                    && (Math.abs(piece.getColumn() - super.getColumn()) == 1);
        }
        if (super.getColor() == Color.BLACK && super.getColor() != piece.getColor()) {
            return (super.getRow() - piece.getRow() == 1)
                    && (Math.abs(piece.getColumn() - super.getColumn()) == 1);
        }
        return false;
    }
}
