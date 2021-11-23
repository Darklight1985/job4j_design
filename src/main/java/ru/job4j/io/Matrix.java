package ru.job4j.io;

import java.io.FileOutputStream;

public class Matrix {
    public static int[][] multiple(int size) {
        int[][] data = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                data[row][cell] = (row + 1) * (cell + 1);
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int[][] data = multiple(5);

        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    out.write(Integer.bitCount(data[i][j]));
                    out.write(" ".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
