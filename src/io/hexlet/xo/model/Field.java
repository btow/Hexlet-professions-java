package io.hexlet.xo.model;

import io.hexlet.xo.model.exception.AlreadyOccupiedException;
import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.*;
import java.security.InvalidParameterException;

/**
 * Created by btow on 03.10.2016.
 */
public class Field {

    private final int FIELD_SIZE;
    private final int MAX_COORDINATE;
    private static final int MIN_COORDINATE = 0;

    private final Figure[][] field;

    Field(final int FIELD_SIZE) {
        this.FIELD_SIZE = FIELD_SIZE;
        this.MAX_COORDINATE = FIELD_SIZE;
        field = new Figure[FIELD_SIZE][FIELD_SIZE];
    }

    public int getSize() {
        return FIELD_SIZE;
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
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }
}
