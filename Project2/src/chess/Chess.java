package chess;

public abstract class Chess implements ChessPiece{

    private final int row;
    private final int column;
    private final Color color;


    /**
     * Constructs a chess object and initializes it to the given row, column number and color.
     *
     * @param row the initial row number of this chess
     * @param column the initial column number of this chess
     * @param color the color of this chess
     */

    public Chess(int row, int column, Color color) {
        if (row < 0 || row > 7 || column < 0 || column > 7) {
            throw new IllegalArgumentException();
        }
        this.row = row;
        this.column = column;
        this.color = color;
    }

    /**
     * Constructs a default chess object
     */
    public Chess() {
        this (0, 0, Color.BLACK);
    }

    /**
     * Return the current row of the chess piece.
     *
     * @return the row of the current piece.
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Return the current column of the chess piece.
     *
     * @return the column of the current chess piece.
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Get the color of the chess piece.
     *
     * @return the color of the chess piece (black or white).
     */
    @Override
    public Color getColor() {
        return color;
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
        if (row < 0 || row > 7 || col < 0 || col > 7) {
            throw new IllegalArgumentException();
        }
        return !(row == this.row && col == this.column);
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
        if (color != piece.getColor()) {
            return canMove(piece.getRow(), piece.getColumn());
        }
        return false;
    }
}
