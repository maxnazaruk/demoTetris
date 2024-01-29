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

    /**
     * Returns true if game is over.
     */
    boolean hasLost() {

    }

    /**
     * Returns score - how many squares were eliminated.
     */
    int getScore() {

    }

    /**
     * Returns current active tetrimono
     */
    Tetrimono getCurrentTetrimono() {

    }

    /**
     * Returns next tetrimonos in the queue.
     */
    Tetrimono[] getNextTetrimonos(int size) {

    }

    /**
     * Returns full tetris board
     */
    TetrisState getCurrentState() {

    }
}
