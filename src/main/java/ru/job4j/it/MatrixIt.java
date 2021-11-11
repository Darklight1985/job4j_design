package ru.job4j.it;

import javax.lang.model.type.NullType;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int row = this.row;
        int column = this.column;
        while (true) {
            if (column >= data[row].length) {
                column = 0;
                row++;
                if (row >= data.length) {
                    return false;
                }
            }
            if (data[row].length > 0 && data[row][column] != ' ') {
                return (row < data.length && column < data[row].length);
            } else {
                column++;
            }
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (true) {
            if (column >= data[row].length) {
                column = 0;
                row++;
            }
            if (data[row].length > 0 && data[row][column] != ' ') {
                return (data[row][column++]);
            } else {
                column++;
            }
        }
    }
}