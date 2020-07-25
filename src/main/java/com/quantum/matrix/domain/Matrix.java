package com.quantum.matrix.domain;

/**
 * The type Matrix.
 */
public class Matrix {

    private final int n;
    private final int m;

    /**
     * Instantiates a new Matrix.
     *
     * @param n the n
     * @param m the m
     */
    public Matrix(Integer n, Integer m) {
        this.n = n;
        this.m = m;
    }

    /**
     * Gets n.
     *
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * Gets m.
     *
     * @return the m
     */
    public int getM() {
        return m;
    }

}
