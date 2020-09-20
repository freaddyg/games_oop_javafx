package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX() - position.getX());
        Cell[] steps = new Cell[size];
        int deltaX = position.getX();
        int deltaY = position.getY();


        for (int index = 0; index < size; index++) {
            if (deltaX < dest.getX() && deltaY > dest.getY()) {
                steps[index] = Cell.findBy(deltaX + index + 1, deltaY - index - 1);
            } else if (deltaX > dest.getX() && deltaY < dest.getY()) {
                steps[index] = Cell.findBy(deltaX - index - 1, deltaY + index + 1);
            } else if (deltaX < dest.getX() && deltaY < dest.getY()) {
                steps[index] = Cell.findBy(deltaX + index + 1, deltaY + index + 1);
            } else if (deltaX > dest.getX() && deltaY > dest.getY()){
                Cell.findBy(deltaX - index - 1, deltaY - index - 1) ;
            }

        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (source.getX() - dest.getX() == source.getY() - dest.getY()
                || source.getX() - dest.getX() == dest.getY() - source.getY()) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
