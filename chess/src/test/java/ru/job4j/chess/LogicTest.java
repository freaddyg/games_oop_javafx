package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

public class LogicTest {

    @Ignore
    @Test(expected = OccupiedCellException.class)
    public void moveWhenOccup()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.H6));
        logic.add(new PawnBlack(Cell.D2));
        logic.move(Cell.H6, Cell.C1);
    }

    @Test
    public void moveWhenFree()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.H6));
        logic.move(Cell.H6, Cell.C1);
    }

}