package com.example.demotetris;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HelloApplication extends Application {


    public static final int BUTTON_START_AXIS = 140;
    public static final int BUTTON_START_AYIS = 50;
    public static final String BUTTON_STYLE = "-fx-text-fill: transparent;";
    public static final int LOWER_LINE = 500;
    public static final int STEP = 30;
    public static final int LEFT_EDGE = 60;
    public static final int RIGHT_EDGE = 290;
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 800;
    private static final int BUTTON_WIDTH = 30;
    private static final int BUTTON_HEIGHT = 30;
    private static final List<Button> bottomLine = new ArrayList<>();

    public static final Random random = new Random();

    private static List<Button[]> elements = Arrays.asList(getSElemenet(), getLElement(), getFiveElement(), getPlaneElement(), getSquareElement());
    public static boolean release = false;
    private final int count = 0;
    private final boolean bottom = false;
    private final List<Button[]> buttons = new ArrayList<>();
    double position = 0;
    Button buttonLower = new Button();
    private Pane root;
    private Label timeLabel;

    private static void rotateElement(Button[] buttons) {
    }

    private static void moveToTheRight(Button[] buttons) {
        if (getMostRightButton(buttons).getLayoutX() < RIGHT_EDGE) {
            for (Button button : buttons) {
                button.setLayoutX(button.getLayoutX() + STEP);
            }
        }
    }

    private static void moveToTheLeft(Button[] buttons) {
        if (getMostLeftButton(buttons).getLayoutX() > LEFT_EDGE) {
            for (Button button : buttons) {
                button.setLayoutX(button.getLayoutX() - STEP);
            }
        }
    }

    private static void moveOneStep(Button[] currentElement) {
        for (Button button : currentElement) {
            button.setLayoutY(button.getLayoutY() + STEP);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Button[] getSElemenet() {
        Button[] sElement = new Button[4];
        sElement[0] = new Button();
        sElement[0].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        sElement[0].setLayoutX(BUTTON_START_AXIS);
        sElement[0].setLayoutY(BUTTON_START_AYIS);
        sElement[0].setStyle(BUTTON_STYLE);

        sElement[1] = new Button();
        sElement[1].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        sElement[1].setLayoutX(BUTTON_START_AXIS + STEP);
        sElement[1].setLayoutY(BUTTON_START_AYIS);
        sElement[1].setStyle(BUTTON_STYLE);

        sElement[2] = new Button();
        sElement[2].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        sElement[2].setLayoutX(BUTTON_START_AXIS + STEP);
        sElement[2].setLayoutY(BUTTON_START_AYIS + STEP);
        sElement[2].setStyle(BUTTON_STYLE);

        sElement[3] = new Button();
        sElement[3].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        sElement[3].setLayoutX(BUTTON_START_AXIS + STEP * 2);
        sElement[3].setLayoutY(BUTTON_START_AYIS + STEP);
        sElement[3].setStyle(BUTTON_STYLE);

        return sElement;
    }

    public static Button[] getLElement() {
        Button[] lElement = new Button[5];
        lElement[0] = new Button();
        lElement[0].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        lElement[0].setLayoutX(BUTTON_START_AXIS - STEP);
        lElement[0].setLayoutY(BUTTON_START_AYIS + STEP);
        lElement[0].setStyle(BUTTON_STYLE);

        lElement[1] = new Button();
        lElement[1].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        lElement[1].setLayoutX(BUTTON_START_AXIS);
        lElement[1].setLayoutY(BUTTON_START_AYIS + STEP);
        lElement[1].setStyle(BUTTON_STYLE);

        lElement[2] = new Button();
        lElement[2].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        lElement[2].setLayoutX(BUTTON_START_AXIS + STEP);
        lElement[2].setLayoutY(BUTTON_START_AYIS + STEP);
        lElement[2].setStyle(BUTTON_STYLE);

        lElement[3] = new Button();
        lElement[3].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        lElement[3].setLayoutX(BUTTON_START_AXIS + STEP * 2);
        lElement[3].setLayoutY(BUTTON_START_AYIS + STEP);
        lElement[3].setStyle(BUTTON_STYLE);

        lElement[4] = new Button();
        lElement[4].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        lElement[4].setLayoutX(BUTTON_START_AXIS + STEP * 2);
        lElement[4].setLayoutY(BUTTON_START_AYIS);
        lElement[4].setStyle(BUTTON_STYLE);

        return lElement;
    }

    public static Button[] getPlaneElement() {
        Button[] element = new Button[4];
        element[0] = new Button();
        element[0].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        element[0].setLayoutX(BUTTON_START_AXIS);
        element[0].setLayoutY(BUTTON_START_AYIS);
        element[0].setStyle(BUTTON_STYLE);

        element[1] = new Button();
        element[1].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        element[1].setLayoutX(BUTTON_START_AXIS);
        element[1].setLayoutY(BUTTON_START_AYIS + STEP);
        element[1].setStyle(BUTTON_STYLE);

        element[2] = new Button();
        element[2].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        element[2].setLayoutX(BUTTON_START_AXIS + STEP);
        element[2].setLayoutY(BUTTON_START_AYIS + STEP);
        element[2].setStyle(BUTTON_STYLE);

        element[3] = new Button();
        element[3].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        element[3].setLayoutX(BUTTON_START_AXIS - STEP);
        element[3].setLayoutY(BUTTON_START_AYIS + STEP);
        element[3].setStyle(BUTTON_STYLE);

        return element;
    }

    public static Button[] getFiveElement() {
        Button[] element = new Button[4];
        element[0] = new Button();
        element[0].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        element[0].setLayoutX(BUTTON_START_AXIS);
        element[0].setLayoutY(BUTTON_START_AYIS);
        element[0].setStyle(BUTTON_STYLE);

        element[1] = new Button();
        element[1].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        element[1].setLayoutX(BUTTON_START_AXIS + STEP);
        element[1].setLayoutY(BUTTON_START_AYIS);
        element[1].setStyle(BUTTON_STYLE);

        element[2] = new Button();
        element[2].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        element[2].setLayoutX(BUTTON_START_AXIS);
        element[2].setLayoutY(BUTTON_START_AYIS + STEP);
        element[2].setStyle(BUTTON_STYLE);

        element[3] = new Button();
        element[3].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        element[3].setLayoutX(BUTTON_START_AXIS - STEP);
        element[3].setLayoutY(BUTTON_START_AYIS + STEP);
        element[3].setStyle(BUTTON_STYLE);

        return element;
    }

    public static Button[] getSquareElement() {
        Button[] element = new Button[4];
        element[0] = new Button();
        element[0].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        element[0].setLayoutX(BUTTON_START_AXIS);
        element[0].setLayoutY(BUTTON_START_AYIS);
        element[0].setStyle(BUTTON_STYLE);

        element[1] = new Button();
        element[1].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        element[1].setLayoutX(BUTTON_START_AXIS + STEP);
        element[1].setLayoutY(BUTTON_START_AYIS);
        element[1].setStyle(BUTTON_STYLE);

        element[2] = new Button();
        element[2].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        element[2].setLayoutX(BUTTON_START_AXIS);
        element[2].setLayoutY(BUTTON_START_AYIS + STEP);
        element[2].setStyle(BUTTON_STYLE);

        element[3] = new Button();
        element[3].setPrefSize(BUTTON_HEIGHT, BUTTON_WIDTH);
        element[3].setLayoutX(BUTTON_START_AXIS + STEP);
        element[3].setLayoutY(BUTTON_START_AYIS + STEP);
        element[3].setStyle(BUTTON_STYLE);

        return element;
    }

    public static void getLowerElements(Button[] buttons) {
       /* double maxY = 0;
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i].getLayoutY() > buttons[j].getLayoutY()) {
                    maxY = buttons[i].getLayoutY();
                }
            }
        }
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getLayoutY() == maxY) {
                buttons[i].setText("1");
            } else {
                buttons[i].setText("");
            }
        }
        boolean exist = false;
        for (int i = 0; i < buttons.length; i++) {
            exist = false;
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i].getLayoutY() + STEP == buttons[j].getLayoutY() && buttons[i].getLayoutX() == buttons[j].getLayoutX()) {
                    exist = true;
                }
            }
            if (!exist) {
                buttons[i].setText("1");
            }
        }

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i].getText().equalsIgnoreCase("1") && buttons[j].getText().equalsIgnoreCase("")) {
                    Button button = buttons[j];
                    buttons[j] = buttons[i];
                    buttons[i] = button;
                }
            }
        }*/

        for (Button button : buttons) {
            button.setText("1");
        }
    }

    public static Button getMostRightButton(Button[] buttons) {
        Button button = buttons[0];
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getLayoutX() > button.getLayoutX()) {
                button = buttons[i];
            }
        }
        return button;
    }

    public static Button getMostLeftButton(Button[] buttons) {
        Button button = buttons[0];
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getLayoutX() < button.getLayoutX()) {
                button = buttons[i];
            }
        }
        return button;
    }

    public static void getTopLine(Button[] buttons) {
       /* for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i].getLayoutY() < buttons[j].getLayoutY()) {
                    buttons[i].setText("2");
                    buttons[j].setText("");
                }
            }
        }*/

            for (Button button : buttons) {
                button.setText("2");
            }

        for (Button button : buttons) {
            if (button.getText().equalsIgnoreCase("2")) {
                bottomLine.add(button);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);

        Line leftLine = new Line(50, 50, 50, 500);
        leftLine.setStroke(Color.GREY);

        Line rightLine = new Line(320, 50, 320, 500);
        rightLine.setStroke(Color.GREY);

        Line bottomLine = new Line(50, 500, 320, 500);
        bottomLine.setStroke(Color.GREY);

        Line topLine = new Line(50, 50, 320, 50);
        topLine.setStroke(Color.GREY);

        buttons.add(getNewElement());

        timeLabel = new Label();
        timeLabel.setLayoutX(20);
        timeLabel.setLayoutY(20);

        getLowerElements(buttons.get(buttons.size() - 1));
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.4), event -> {
            root.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.A) {
                    moveToTheLeft(buttons.get(buttons.size() - 1));
                }
                if (keyEvent.getCode() == KeyCode.D) {
                    moveToTheRight(buttons.get(buttons.size() - 1));
                }
                if (keyEvent.getCode() == KeyCode.W) {
                    rotateElement(buttons.get(buttons.size() - 1));
                }
            });
            getLowerElements(buttons.get(buttons.size() - 1));
            updateContent(root);

        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        root.getChildren().addAll(buttons.get(buttons.size() - 1));
        root.getChildren().addAll(leftLine, rightLine, bottomLine, topLine);
        primaryStage.show();
    }

    private void updateContent(Pane root) {
        getLowerElements(buttons.get(buttons.size() - 1));
        Button[] currentElement = buttons.get(buttons.size() - 1);


        for (Button button : currentElement) {
            if (button.getLayoutY() + STEP >= LOWER_LINE) {
                release = true;
                break;
            }
            for (Button bottomLine : bottomLine) {
                if (button.getLayoutY() + STEP == bottomLine.getLayoutY() && button.getLayoutX() == bottomLine.getLayoutX()) {
                    release = true;
                    break;
                }
            }
        }
        if (release) {
            getTopLine(currentElement);
            buttons.add(getNewElement());
            root.getChildren().addAll(buttons.get(buttons.size() - 1));
            release = false;
        } else {
            moveOneStep(currentElement);
        }
    }

    public static Button[] getNewElement(){
        switch (random.nextInt(elements.size())){
            case 0:
                return getSElemenet();
            case 1:
                return getLElement();
            case 2:
                return getFiveElement();
            case 3:
                return getPlaneElement();
            case 4:
                return getSquareElement();
            default:
                return getSElemenet();
        }
    }
}