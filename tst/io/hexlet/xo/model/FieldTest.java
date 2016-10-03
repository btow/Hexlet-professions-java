package io.hexlet.xo.model;

import io.hexlet.xo.model.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by btow on 03.10.2016.
 */
public class FieldTest {
    @Test
    public void testGetSize() throws Exception {

        final int inputValue = 3;
        final int expectedValue = inputValue;

        final Field field = new Field(inputValue);

        final int actualValue = field.getSize();

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testGetFigure() throws Exception {

        final int inputValue_FieldSize = 3;
        final Point inputValue_Point = new Point(0, 0);
        final Point expectedValue_Point = inputValue_Point;
        final Figure inputValue_Figure = Figure.O;
        final Figure expectedValue_Figure = inputValue_Figure;

        final Field field = new Field(inputValue_FieldSize);

        field.setFigure(inputValue_Point, inputValue_Figure);

        final Figure actualValue_Figure = field.getFigure(inputValue_Point);

        assertEquals(expectedValue_Figure, actualValue_Figure);

    }

    @Test
    public void testGetFigureWenFigureIsNotSet() throws Exception {

        final int inputValue_FieldSize = 3;
        final Point inputValue_Point = new Point(0, 0);
        final Point expectedValue_Point = inputValue_Point;

        final Field field = new Field(inputValue_FieldSize);

        final Figure actualValue_Figure = field.getFigure(inputValue_Point);

        assertNull(actualValue_Figure);

    }

    @Test
    public void testGetFigureWenXLessZero() throws Exception {

        final int inputValue_FieldSize = 3;
        final Point inputValue_Point = new Point(-1, 0);
        final Point expectedValue_Point = inputValue_Point;

        final Field field = new Field(inputValue_FieldSize);

        try {
            field.getFigure(inputValue_Point);
            fail();
        } catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWenYLessZero() throws Exception {

        final int inputValue_FieldSize = 3;
        final Point inputValue_Point = new Point(0, -1);
        final Point expectedValue_Point = inputValue_Point;

        final Field field = new Field(inputValue_FieldSize);

        try {
            field.getFigure(inputValue_Point);
            fail();
        } catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWenXMoreThenSize() throws Exception {

        final int inputValue_FieldSize = 3;
        final Field field = new Field(inputValue_FieldSize);

        final Point inputValue_Point = new Point(field.getSize() + 1, 0);
        final Point expectedValue_Point = inputValue_Point;

        try {
            field.getFigure(inputValue_Point);
            fail();
        } catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWenYMoreThenSize() throws Exception {

        final int inputValue_FieldSize = 3;
        final Field field = new Field(inputValue_FieldSize);

        final Point inputValue_Point = new Point(0, field.getSize() + 1);
        final Point expectedValue_Point = inputValue_Point;

        try {
            field.getFigure(inputValue_Point);
            fail();
        } catch (final InvalidPointException e) {}

    }

}