package com.example.demotetris.elements;

import javafx.scene.control.Button;

import static com.example.demotetris.HelloApplication.*;

public class Tetrominos {
    public static boolean[][] getSElement() {
        return new boolean[][]{{false, false, false}, {true, true, false}, {false, true, true}};
    }

    public static boolean[][] getReverseSElement() {
        return new boolean[][]{{false, false, false}, {false, true, true}, {true, true, false}};
    }

    public static boolean[][] getLElement() {
        return new boolean[][]{{false, false, false}, {true, false, false}, {true, true, true}};
    }

    public static boolean[][] getPlaneElement() {
        return new boolean[][]{{false, false, false}, {false, true, false}, {true, true, true}};
    }

    public static boolean[][] getSquareElement() {
        return new boolean[][]{{false, false, false}, {false, true, true}, {false, true, true}};
    }
    public static boolean[][] getStickElement() {
        return new boolean[][]{{false, false, false, false}, {false, false, false, false}, {true, true, true, true}, {false, false, false, false}};
    }

    public static Button[][] getElementFullfillWithButtons(boolean[][] booleans) {
        Button[][] buttons = new Button[booleans.length][booleans.length];

        for (int i = 0; i < booleans.length; i++) {
            for (int j = 0; j < booleans[i].length; j++) {
                buttons[i][j] = new Button();
                buttons[i][j].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
                buttons[i][j].setLayoutX(BUTTON_START_AXIS + STEP * j);
                buttons[i][j].setLayoutY(BUTTON_START_AYIS + STEP * i);
                if (booleans[i][j]) {
                    buttons[i][j].setStyle(BUTTON_STYLE);
                } else {
                    buttons[i][j].setStyle(EMPTY_BUTTON_STYLE);
                }
            }
        }
        return buttons;
    }
}
