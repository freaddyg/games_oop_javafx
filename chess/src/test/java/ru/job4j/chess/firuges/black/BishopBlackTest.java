package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void positionTest() {
        Figure bishopBlack = new BishopBlack(Cell.A3);
        assertThat(bishopBlack.position(), is(Cell.A3));
    }

    @Test
    public void copyTest() {
        Figure bishopBlack = new BishopBlack(Cell.H6);
        Figure newBishopBlack = bishopBlack.copy(Cell.A6);
        assertThat(newBishopBlack.position(), is(Cell.A6));
    }

    @Test
    public void wayTest() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.H5);
        Cell[] move = bishopBlack.way(Cell.D1);
        assertThat(move, is(new Cell[] {Cell.G4, Cell.F3, Cell.E2, Cell.D1}));
    }

    @Test(expected = IllegalStateException.class)
    public void wayExcTest() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.H5);
        Cell[] move = bishopBlack.way(Cell.D3);
    }
}