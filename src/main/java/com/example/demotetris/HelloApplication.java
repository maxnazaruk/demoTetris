package com.example.demotetris;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    public static final int BUTTON_START_AXIS = 100;
    public static final int BUTTON_START_AYIS = 100;
    public static final String BUTTON_STYLE = "";
    public static final int LOWER_LINE = 390;
    public static final int STEP = 25;
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 800;
    private static final int BUTTON_WIDTH = 30;
    private static final int BUTTON_HEIGHT = 30;
    public static boolean release = false;
    private static final List<Button> bottomLine = new ArrayList<>();
    double position = 0;
    Button buttonLower = new Button();
    private final int count = 0;
    private Pane root;
    private Label timeLabel;
    private final boolean bottom = false;
    private final List<Button[]> buttons = new ArrayList<>();

    private static void rotateElement(Button[] buttons) {
    }

    private static void moveToTheRight(Button[] buttons) {
        for (Button button : buttons) {
            button.setLayoutX(button.getLayoutX() + STEP);
        }
    }

    private static void moveToTheLeft(Button[] buttons) {
        for (Button button : buttons) {
            button.setLayoutX(button.getLayoutX() - STEP);
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

    public static void getLowerElements(Button[] buttons) {
        double maxY = 0;
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
            if(!exist){
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
        }
    }

    public static void getTopLine(Button[] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i].getLayoutY() < buttons[j].getLayoutY()) {
                    buttons[i].setText("2");
                    buttons[j].setText("");
                }
            }
        }

        for (Button button : buttons) {
            if (button.getText().equalsIgnoreCase("2")) {
                bottomLine.add(button);
            }
        }
    }

    public static boolean isButtonPlaced(Button[] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            for (Button button : bottomLine) {
                if (button.getLayoutY() == buttons[i].getLayoutY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isButtonOnTheBottom(Button button) {
        return button.getLayoutY() == LOWER_LINE;
    }

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);


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
        buttons.add(sElement);

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
        primaryStage.show();
    }

    private void updateContent(Pane root) {
        getLowerElements(buttons.get(buttons.size() - 1));
        Button[] currentElement = buttons.get(buttons.size() - 1);
        /*for (Button button : currentElement) {
            if(isButtonPlaced(currentElement)){
                getTopLine(currentElement);
                buttons.add(getSElemenet());
                root.getChildren().addAll(buttons.get(buttons.size() - 1));
                break;
            }
            if (button.getText().equalsIgnoreCase("1")) {
                position = button.getLayoutY();
                buttonLower = button;
            }

            if (button.getText().equalsIgnoreCase("1") && button.getLayoutY() <= LOWER_LINE) {
                button.setLayoutY(button.getLayoutY() + STEP);
            }

            if (button.getText().equalsIgnoreCase("") && position != buttonLower.getLayoutY()) {
                button.setLayoutY(button.getLayoutY() + STEP);
            } else if (position == buttonLower.getLayoutY() && button.getText().equalsIgnoreCase("1")) {
                getTopLine(currentElement);
                buttons.add(getSElemenet());
                root.getChildren().addAll(buttons.get(buttons.size() - 1));
                break;
            }
        }*/

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
            buttons.add(getSElemenet());
            root.getChildren().addAll(buttons.get(buttons.size() - 1));
            release = false;
        } else {
            moveOneStep(currentElement);
        }
    }
}