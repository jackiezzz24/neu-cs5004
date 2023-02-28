package chess;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test case for chess class
 */
class ChessTest {

    ChessPiece bishop;
    ChessPiece knight;
    ChessPiece king;
    ChessPiece queen;
    ChessPiece rock;
    ChessPiece rock2;
    ChessPiece pawn1;
    ChessPiece pawn2;
    ChessPiece pawn3;
    ChessPiece pawn4;


    @BeforeEach
    void setUp() {
        bishop = new Bishop(4, 3, Color.WHITE);
        king = new King(4, 5, Color.BLACK);
        queen = new Queen(2, 2, Color.WHITE);
        rock = new Rook(1, 2, Color.BLACK);
        knight = new Knight(3, 3, Color.BLACK);
        pawn1 = new Pawn(1, 5, Color.WHITE);
        pawn2 = new Pawn(6, 4, Color.BLACK);
        pawn3 = new Pawn(2, 4, Color.WHITE);
        pawn4 = new Pawn(5, 2, Color.BLACK);
        rock2 = new Rook(5, 4, Color.WHITE);
    }

    @Test
    void testConstructor(){
        assertThrows(IllegalArgumentException.class, ()
                -> { new Bishop(0, -1, Color.BLACK);});
        assertThrows(IllegalArgumentException.class, ()
                -> { new King(9, 1, Color.BLACK);});
        assertThrows(IllegalArgumentException.class, ()
                -> { new Queen(-1, 4, Color.BLACK);});
        assertThrows(IllegalArgumentException.class, ()
                -> { new Rook(3, 9, Color.BLACK);});
        assertThrows(IllegalArgumentException.class, ()
                -> { new Knight(1, -1, Color.BLACK);});
        assertThrows(IllegalArgumentException.class, ()
                -> { new Pawn(7, 0, Color.BLACK);});
        assertThrows(IllegalArgumentException.class, ()
                -> { new Pawn(0, 0, Color.WHITE);});
    }

    @Test
    void getRow() {
        assertEquals(4, bishop.getRow());
        assertEquals(4, king.getRow());
        assertEquals(2, queen.getRow());
        assertEquals(1, rock.getRow());
        assertEquals(3, knight.getRow());
        assertEquals(1, pawn1.getRow());
        assertEquals(6, pawn2.getRow());
    }

    @Test
    void getColumn() {
        assertEquals(3, bishop.getColumn());
        assertEquals(5, king.getColumn());
        assertEquals(2, queen.getColumn());
        assertEquals(2, rock.getColumn());
        assertEquals(3, knight.getColumn());
        assertEquals(4, pawn3.getColumn());
        assertEquals(2, pawn4.getColumn());
    }

    @Test
    void getColor() {
        assertEquals(Color.WHITE, bishop.getColor());
        assertEquals(Color.BLACK, king.getColor());
        assertEquals(Color.WHITE, queen.getColor());
        assertEquals(Color.BLACK, rock.getColor());
        assertEquals(Color.BLACK, knight.getColor());
        assertEquals(Color.WHITE, pawn3.getColor());
    }

    @Test
    void canMove() {
        assertTrue(bishop.canMove(6, 5));
        assertFalse(bishop.canMove(3, 0));
        assertTrue(king.canMove(3, 4));
        assertFalse(king.canMove(2, 2));
        assertTrue(queen.canMove(7, 7));
        assertFalse(queen.canMove(5, 3));
        assertTrue(rock.canMove(6, 2));
        assertFalse(rock.canMove(3, 0));
        assertTrue(knight.canMove(5, 2));
        assertFalse(knight.canMove(4, 2));
        assertTrue(pawn1.canMove(2, 5));
        assertTrue(pawn1.canMove(3, 5));
        assertFalse(pawn1.canMove(4, 5));
        assertTrue(pawn2.canMove(5, 4));
        assertFalse(pawn2.canMove(7, 4));
        assertTrue(pawn3.canMove(3, 4));
        assertFalse(pawn3.canMove(0, 4));
        assertTrue(pawn4.canMove(4, 2));
        assertFalse(pawn4.canMove(3, 2));
        assertFalse(pawn4.canMove(5, 2));

        assertThrows(IllegalArgumentException.class, ()
                -> { bishop.canMove(-1, 1);});
        assertThrows(IllegalArgumentException.class, ()
                -> { king.canMove(9, 3);});
        assertThrows(IllegalArgumentException.class, ()
                -> { queen.canMove(-4, 7);});
        assertThrows(IllegalArgumentException.class, ()
                -> { rock.canMove(-4, 0);});
        assertThrows(IllegalArgumentException.class, ()
                -> { knight.canMove(8, 0);});
        assertThrows(IllegalArgumentException.class, ()
                -> { pawn1.canMove(1, 9);});
    }

    @Test
    void canKill() {
        assertTrue(bishop.canKill(pawn4));
        assertFalse(bishop.canKill(knight));
        assertTrue(king.canKill(rock2));
        assertFalse(king.canKill(bishop));
        assertTrue(queen.canKill(rock));
        assertFalse(queen.canKill(pawn3));
        assertTrue(rock.canKill(pawn1));
        assertFalse(rock.canKill(pawn3));
        assertTrue(knight.canKill(rock2));
        assertFalse(knight.canKill(bishop));
        assertTrue(pawn3.canKill(knight));
        assertFalse(pawn2.canKill(rock2));
    }
}