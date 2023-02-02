package chess;

public class Bishop extends Chess{
    /**
     * Constructs a chess object and initializes it to the given row, column number and color.
     *
     * @param row    the initial row number of this chess
     * @param column the initial column number of this chess
     * @param color  the color of this chess
     */
    public Bishop(int row, int column, Color color) {
        super(row, column, color);
    }

    @Override
    public boolean canMove(int row, int column) {
        if (Math.abs(row - super.getRow()) == Math.abs(column - super.getColumn())) {
            return true;
        }
        return false;
    }


}
