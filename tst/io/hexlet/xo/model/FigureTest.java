package io.hexlet.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FigureTest {

    @Test
    public void testGetFigureX() throws Exception {

        final Figure inputValue = Figure.X;

        final String actualValue = inputValue.getFigure();

        assertEquals(inputValue.toString(), actualValue);

    }

    @Test
    public void testGetFigureO() throws Exception {

        final Figure inputValue = Figure.O;

        final String actualValue = inputValue.getFigure();

        assertEquals(inputValue.toString(), actualValue);

    }

}