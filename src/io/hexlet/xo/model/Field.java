package io.hexlet.xo.model;

import io.hexlet.xo.model.exception.AlreadyOccupiedException;
import io.hexlet.xo.model.exception.InvalidPointException;
import io.hexlet.xo.model.exception.InvalidSizeException;

import java.awt.*;

public class Field {

    private final int fieldSize;
    private final int maxCoordinate;
    private static final int MIN_COORDINATE = 0;
    private static final int MIN_SIZE = 1;

    private final Figure[][] field;

    Field(final int fieldSize) throws InvalidSizeException {

        boolean returnsMarker = (fieldSize < MIN_SIZE);
        if (returnsMarker){
            throw new InvalidSizeException();
        }

        this.fieldSize = fieldSize;
        this.maxCoordinate = fieldSize;
        field = new Figure[fieldSize][fieldSize];

    }

    public int getSize() {
        return fieldSize;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!chekPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (!chekPoint(point)) {
            throw new InvalidPointException();
        }
        if (field[point.x][point.y] != null) {
            throw new AlreadyOccupiedException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean chekPoint(final Point point) {
        return chekCoordinate(point.x) && chekCoordinate(point.y);
    }

    private boolean chekCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }
}
