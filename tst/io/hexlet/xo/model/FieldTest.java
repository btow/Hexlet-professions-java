package io.hexlet.xo.model;

import io.hexlet.xo.model.exception.AlreadyOccupiedException;
import io.hexlet.xo.model.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void testGetSize() throws Exception {

        final int inputValue = 3;

        final Field field = new Field(inputValue);

        final int actualValue = field.getSize();

        /*метод принудительного падения приложения сработает
         если ожидаемое значение не эквивалентно актуальному
        */
        assertEquals(inputValue, actualValue);

    }

    @Test
    public void testGetFigure() throws Exception {

        final int inputValue_FieldSize = 3;
        final Point inputValue_Point = new Point(0, 0);
        final Figure inputValue_Figure = Figure.O;

        final Field field = new Field(inputValue_FieldSize);

        field.setFigure(inputValue_Point, inputValue_Figure);

        final Figure actualValue_Figure = field.getFigure(inputValue_Point);

        assertEquals(inputValue_Figure, actualValue_Figure);

    }

    @Test
    public void testSetFigureWenAlreadyOccupied() throws Exception {

        final int inputValue_FieldSize = 3;
        final Point inputValue_Point = new Point(0, 0);
        final Figure inputValue_Figure = Figure.O;

        final Field field = new Field(inputValue_FieldSize);

        field.setFigure(inputValue_Point, inputValue_Figure);

        try {
            field.setFigure(inputValue_Point, inputValue_Figure);
            /*метод принудительного падения приложения сработает
            если не произошло выбрасывания исключения
             */
            fail();
        } catch (final AlreadyOccupiedException e) {}

    }

    @Test
    public void testGetFigureWenFigureIsNotSet() throws Exception {

        final int inputValue_FieldSize = 3;
        final Point inputValue_Point = new Point(0, 0);

        final Field field = new Field(inputValue_FieldSize);

        final Figure actualValue_Figure = field.getFigure(inputValue_Point);

        /*метод принудительного падения приложения сработает
         если актуальное значение эквивалентно null
        */
        assertNull(actualValue_Figure);

    }

    @Test
    public void testGetFigureWenXLessZero() throws Exception {

        final int inputValue_FieldSize = 3;
        final Point inputValue_Point = new Point(-1, 0);

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

        try {
            field.getFigure(inputValue_Point);
            fail();
        } catch (final InvalidPointException e) {}

    }

}