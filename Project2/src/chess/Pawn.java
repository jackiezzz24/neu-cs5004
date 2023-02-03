package chess;

public class Pawn extends Chess{

    public Pawn(int row, int col, Color color) {
        super(row, col, color);
        if (color == Color.WHITE && row < 1) {
            throw new IllegalArgumentException();
        }
        if (color == Color.BLACK && row > 6) {
            throw  new IllegalArgumentException();
        }
    }

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
