package com.example.demotetris.viewmodel;

public class TetrisModel {

    /**
     * When game begins (or restarts), the application will create a new instance of this class. It will provide
     * desired width and depths (how many rows there are).
     */
    public TetrisModel(int width, int depth) {
    }

    /**
     * Move active tetrimono to the left
     */
    void moveLeft() {

    }

    /**
     * Move active tetrimono to the right
     */
    void moveRight() {

    }

    /**
     * Rotate active tetrimono
     */
    void rotate(boolean clockWise) {

    }

    /**
     * Calculate next step. This means we'd move the tetrimono by one step, if tetrimono hit the line this will also
     * calculate all the lines that must be eliminated, and in general will update internal state.
     */
    void nextStep(boolean accelarate) {

    }
}
