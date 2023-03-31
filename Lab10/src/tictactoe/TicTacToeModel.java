package tictactoe;
import java.util.Arrays;
import java.util.stream.Collectors;
public class TicTacToeModel implements TicTacToe {
    private int moves;
    Player player;
    Player[][] board;

    public TicTacToeModel(){
        moves = 0;
        board = new Player[3][3];
    }
    // add your implementation here
    /**
     * Execute a move in the position specified by the given row and column.
     *
     * @param r the row of the intended move
     * @param c the column of the intended move
     * @throws IllegalArgumentException if the space is occupied or the position is
     *                                  otherwise invalid
     * @throws IllegalStateException    if the game is over
     */
    @Override
    public void move(int r, int c) {
        if (getMarkAt(r, c) != null) {
            throw new IllegalArgumentException("Invalid move should have thrown exception");
        }
        if (r < 0 || c < 0 || r > 2 || c > 2) {
            throw new IllegalArgumentException("Invalid move should have thrown exception");
        }
        if (isGameOver()) {
            throw new IllegalStateException("Invalid move should have thrown exception");
        }
        board[r][c] = getTurn();
        moves += 1;
    }

    /**
     * Get the current turn, i.e., the player who will mark on the next call to
     * move().
     *
     * @return the {@link Player} whose turn it is
     */
    @Override
    public Player getTurn() {
        if (moves % 2 == 0) {
            return Player.X;
        } else {
            return Player.O;
        }
    }

    /**
     * Return whether the game is over. The game is over when either the board is
     * full, or
     * one player has won.
     *
     * @return true if the game is over, false otherwise
     */
    @Override
    public boolean isGameOver() {
        return moves == 9 || getWinner() != null;
    }

    /**
     * Return the winner of the game, or {@code null} if there is no winner. If the
     * game is not
     * over, returns {@code null}.
     *
     * @return the winner, or null if there is no winner
     */
    @Override
    public Player getWinner() {
        for (int i = 0; i < board.length; i++) {
                if (getMarkAt(i, 0) == getMarkAt(i, 1) && getMarkAt(i, 1) == getMarkAt(i, 2)) {
                    return getMarkAt(i, 0);
                }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (getMarkAt(0, j) == getMarkAt(1, j) && getMarkAt(1, j) == getMarkAt(2, j)) {
                return getMarkAt(0, j);
            }
        }
        if (getMarkAt(0, 0) == getMarkAt(1, 1) && getMarkAt(1, 1) == getMarkAt(2, 2)) {
            return getMarkAt(1, 1);
        }
        if (getMarkAt(0, 2) == getMarkAt(1, 1) && getMarkAt(1, 1) == getMarkAt(2, 0)) {
            return getMarkAt(1, 1);
        }
        return null;
    }

    /**
     * Return the current game state, as a 2D array of Player. A {@code null} value
     * in the grid
     * indicates an empty position on the board.
     *
     * @return the current game board
     */
    @Override
    public Player[][] getBoard() {
        Player[][] result = new Player[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                result[i][j] = board[i][j];
            }
        }
        return result;
    }

    /**
     * Return the current {@link Player} mark at a given row and column, or {@code
     * null} if the
     * position is empty.
     *
     * @param r the row
     * @param c the column
     * @return the player at the given position, or null if it's empty
     */
    @Override
    public Player getMarkAt(int r, int c) {
        if (r < 0 || c < 0 || r > 2 || c > 2) {
            throw new IllegalArgumentException("Invalid move should have thrown exception");
        }
        return board[r][c];
    }

    @Override
    public String toString() {
        // Using Java stream API to save code:
        return Arrays.stream(getBoard()).map(
                        row -> " " + Arrays.stream(row).map(
                                p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
                .collect(Collectors.joining("\n-----------\n"));
        // This is the equivalent code as above, but using iteration, and still using
        // the helpful built-in String.join method.
        /**********
         List<String> rows = new ArrayList<>();
         for(Player[] row : getBoard()) {
            List<String> rowStrings = new ArrayList<>();
             for(Player p : row) {
                if(p == null) {
                    rowStrings.add(" ");
                } else {
                    rowStrings.add(p.toString());
                }
            }
            rows.add(" " + String.join(" | ", rowStrings));
         }
         return String.join("\n-----------\n", rows);
         ************/
    }


}