package io.hexlet.xo.model;

import java.awt.*;

/**
 * Created by btow on 03.10.2016.
 */
public class Field {

    private final int FIELD_SIZE;
    private final Figure[][] field;

    Field(final int FIELD_SIZE) {
        this.FIELD_SIZE = FIELD_SIZE;
        field = new Figure[FIELD_SIZE][FIELD_SIZE];
    }

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) {
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) {
        field[point.x][point.y] = figure;
    }
}
