package com.example.demotetris;

import com.example.demotetris.elements.Tetrominos;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloApplication extends Application {


    public static final int BUTTON_START_AXIS = 140;
    public static final int BUTTON_START_AYIS = 50;
    public static final String BUTTON_STYLE = "-fx-text-fill: transparent;";
    public static final String REMOVE_BUTTON_STYLE = "-fx-background-color: red";
    public static final String EMPTY_BUTTON_STYLE = "-fx-background-color:transparent";
    public static final String SCORE = "-fx-font-size: 20;";
    public static final int LOWER_LINE = 500;
    public static final int STEP = 30;
    public static final int LEFT_EDGE = 60;
    public static final int RIGHT_EDGE = 290;

    public static int scorePoints = 0;
    public static double speed = 1;
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 800;
    public static final int BUTTON_WIDTH = 30;
    public static final int BUTTON_HEIGHT = 30;
    private static final List<Button> bottomLine = new ArrayList<>();
    private static final List<Button> removeLine = new ArrayList<>();
    private static int[][] matrix = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 2, 3, 4},
            {0, 0, 0, 0}};

    public static final Random random = new Random();

    //private static List<Button[][]> elements = Arrays.asList(getSElemenet(), getLElement(), getFiveElement(), getPlaneElement(), getSquareElement(), getStickElemenet());
    public static boolean release = false;
    private final int count = 0;
    private final boolean bottom = false;
    private final List<Button[][]> buttons = new ArrayList<>();
    double position = 0;
    Button buttonLower = new Button();
    private Pane root;
    private Label timeLabel;
    Label points = new Label();

    private static void rotateElement(Button[][] buttons) {
        boolean left = false;
        boolean right = false;

        for (int i = 0; i < matrix.length; i++) {
            int tmp0 = matrix[i][matrix.length - 1];
            int tmp1 = matrix[matrix.length - 1][matrix.length - 1 - i];
            int tmp2 = matrix[matrix.length - 1 - i][0];

            matrix[i][matrix.length - 1] = matrix[0][i];
            matrix[matrix.length - 1][matrix.length - 1 - i] = tmp0;
            matrix[matrix.length - 1 - i][0] = tmp1;
            matrix[0][i] = tmp2;
        }

        for (int i = 1; i < 2; i++) {
            int tmp0 = matrix[i][matrix.length - 1 - i];
            int tmp1 = matrix[matrix.length - 1 - i][matrix.length - 1 - i];
            int tmp2 = matrix[matrix.length - 1 - i][i];

            matrix[i][matrix.length - 1 - i] = matrix[i][i];
            matrix[matrix.length - 1 - i][matrix.length - 1 - i] = tmp0;
            matrix[matrix.length - 1 - i][i] = tmp1;
            matrix[i][i] = tmp2;
        }

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j].getLayoutX() < LEFT_EDGE) {
                    moveToTheRight(buttons);
                    left = true;
                }
            }
        }

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j].getLayoutX() > RIGHT_EDGE) {
                    moveToTheLeft(buttons);
                    right = true;
                }
            }
        }

        if (buttons.length == 3) {
            for (int i = 0; i < 2; i++) {
                double tmp0X = buttons[i][buttons.length - 1].getLayoutX();
                double tmp0Y = buttons[i][buttons.length - 1].getLayoutY();

                double tmp1X = buttons[buttons.length - 1][buttons.length - 1 - i].getLayoutX();
                double tmp1Y = buttons[buttons.length - 1][buttons.length - 1 - i].getLayoutY();

                double tmp2X = buttons[buttons.length - 1 - i][0].getLayoutX();
                double tmp2Y = buttons[buttons.length - 1 - i][0].getLayoutY();

                buttons[i][buttons.length - 1].setLayoutX(buttons[0][i].getLayoutX());
                buttons[i][buttons.length - 1].setLayoutY(buttons[0][i].getLayoutY());

                buttons[buttons.length - 1][buttons.length - 1 - i].setLayoutX(tmp0X);
                buttons[buttons.length - 1][buttons.length - 1 - i].setLayoutY(tmp0Y);


                buttons[buttons.length - 1 - i][0].setLayoutX(tmp1X);
                buttons[buttons.length - 1 - i][0].setLayoutY(tmp1Y);

                buttons[0][i].setLayoutX(tmp2X);
                buttons[0][i].setLayoutY(tmp2Y);
            }
        } else if (buttons.length == 4) {
            for (int i = 0; i < matrix.length; i++) {
                double tmp0X = buttons[i][buttons.length - 1].getLayoutX();
                double tmp0Y = buttons[i][buttons.length - 1].getLayoutY();

                double tmp1X = buttons[buttons.length - 1][buttons.length - 1 - i].getLayoutX();
                double tmp1Y = buttons[buttons.length - 1][buttons.length - 1 - i].getLayoutY();

                double tmp2X = buttons[buttons.length - 1 - i][0].getLayoutX();
                double tmp2Y = buttons[buttons.length - 1 - i][0].getLayoutY();

                buttons[i][buttons.length - 1].setLayoutX(buttons[0][i].getLayoutX());
                buttons[i][buttons.length - 1].setLayoutY(buttons[0][i].getLayoutY());

                buttons[buttons.length - 1][buttons.length - 1 - i].setLayoutX(tmp0X);
                buttons[buttons.length - 1][buttons.length - 1 - i].setLayoutY(tmp0Y);


                buttons[buttons.length - 1 - i][0].setLayoutX(tmp1X);
                buttons[buttons.length - 1 - i][0].setLayoutY(tmp1Y);

                buttons[0][i].setLayoutX(tmp2X);
                buttons[0][i].setLayoutY(tmp2Y);
            }

            for (int i = 1; i < 2; i++) {
                int tmp0 = matrix[i][matrix.length - 1 - i];
                int tmp1 = matrix[matrix.length - 1 - i][matrix.length - 1 - i];
                int tmp2 = matrix[matrix.length - 1 - i][i];

                matrix[i][matrix.length - 1 - i] = matrix[i][i];
                matrix[matrix.length - 1 - i][matrix.length - 1 - i] = tmp0;
                matrix[matrix.length - 1 - i][i] = tmp1;
                matrix[i][i] = tmp2;

                double tmp0X = buttons[i][buttons.length - 1 - i].getLayoutX();
                double tmp0Y = buttons[i][buttons.length - 1 - i].getLayoutY();

                double tmp1X = buttons[buttons.length - 1 - i][buttons.length - 1 - i].getLayoutX();
                double tmp1Y = buttons[buttons.length - 1 - i][buttons.length - 1 - i].getLayoutY();

                double tmp2X = buttons[buttons.length - 1 - i][i].getLayoutX();
                double tmp2Y = buttons[buttons.length - 1 - i][i].getLayoutY();

                buttons[i][buttons.length - 1 - i].setLayoutX(buttons[i][i].getLayoutX());
                buttons[i][buttons.length - 1 - i].setLayoutY(buttons[i][i].getLayoutY());

                buttons[buttons.length - 1 - i][buttons.length - 1 - i].setLayoutX(tmp0X);
                buttons[buttons.length - 1 - i][buttons.length - 1 - i].setLayoutY(tmp0Y);


                buttons[buttons.length - 1 - i][i].setLayoutX(tmp1X);
                buttons[buttons.length - 1 - i][i].setLayoutY(tmp1Y);

                buttons[i][i].setLayoutX(tmp2X);
                buttons[i][i].setLayoutY(tmp2Y);
            }
        }


        if (left) {
            moveToTheLeft(buttons);
        }

        if (right) {
            moveToTheRight(buttons);
        }
    }

    private static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void moveToTheRight(Button[][] buttons) {
        if (getMostRightButton(buttons).getLayoutX() < RIGHT_EDGE) {
            for (Button button[] : buttons) {
                for (Button button1 : button) {
                    button1.setLayoutX(button1.getLayoutX() + STEP);
                }
            }
        }
    }

    private static void moveToTheLeft(Button[][] buttons) {
        if (getMostLeftButton(buttons).getLayoutX() > LEFT_EDGE) {
            for (Button button[] : buttons) {
                for (Button button1 : button) {
                    button1.setLayoutX(button1.getLayoutX() - STEP);
                }
            }
        }
    }

    private boolean getNode(Pane pane, Button button) {
        for (Node child : pane.getChildren()) {
            if (child.getBoundsInParent().contains(button.getLayoutX(), button.getLayoutY())) {
                if (child instanceof Button && ((Button) child).getText().equals("2")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void moveOneStep(Button[][] currentElement) {
        for (Button button[] : currentElement) {
            for (Button button1 : button) {
                button1.setLayoutY(button1.getLayoutY() + STEP);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void getLowerElements(Button[][] buttons) {
        for (Button button[] : buttons) {
            for (Button button1 : button) {
                if (button1.getStyle().equalsIgnoreCase(BUTTON_STYLE)) {
                    button1.setText("1");
                }
            }
        }
    }

    public static Button getMostRightButton(Button[][] buttons) {
        Button button = buttons[0][0];
        for (Button[] btn : buttons) {
            for (Button button1 : btn) {
                if (button1.getStyle().equalsIgnoreCase(BUTTON_STYLE)) {
                    button = button1;
                    break;
                }
            }
        }

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j].getLayoutX() > button.getLayoutX() && buttons[i][j].getStyle().equalsIgnoreCase(BUTTON_STYLE) && button.getStyle().equalsIgnoreCase(BUTTON_STYLE)) {
                    button = buttons[i][j];
                }
            }
        }
        return button;
    }

    public static Button getMostLeftButton(Button[][] buttons) {
        Button button = buttons[0][0];
        for (Button[] btn : buttons) {
            for (Button button1 : btn) {
                if (button1.getStyle().equalsIgnoreCase(BUTTON_STYLE)) {
                    button = button1;
                    break;
                }
            }
        }

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j].getLayoutX() < button.getLayoutX() && buttons[i][j].getStyle().equalsIgnoreCase(BUTTON_STYLE) && button.getStyle().equalsIgnoreCase(BUTTON_STYLE)) {
                    button = buttons[i][j];
                }
            }
        }
        return button;
    }

    public static void getTopLine(Button[][] buttons) {
        for (Button button[] : buttons) {
            for (Button button1 : button) {
                if (button1.getStyle().equalsIgnoreCase(BUTTON_STYLE)) {
                    button1.setText("2");
                }
            }
        }

        for (Button button[] : buttons) {
            for (Button button1 : button) {
                if (button1.getText().equalsIgnoreCase("2")) {
                    bottomLine.add(button1);
                }
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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

        Button cheats = new Button();
        cheats.setPrefWidth(300);
        cheats.setStyle(EMPTY_BUTTON_STYLE);
        cheats.setLayoutX(350);
        cheats.setLayoutY(BUTTON_START_AYIS + STEP);
        this.renderingGameFlow(cheats);

        for (Button[] button : buttons.get(buttons.size() - 1)) {
            root.getChildren().addAll(button);
        }

        Label score = new Label();
        score.setText("Score: ");
        score.setStyle(SCORE);
        score.setLayoutX(350);
        score.setLayoutY(BUTTON_START_AYIS);

        points.setText(scorePoints + "");
        points.setLayoutX(420);
        points.setLayoutY(BUTTON_START_AYIS);
        points.setStyle(SCORE);
        root.getChildren().addAll(leftLine, rightLine, bottomLine, topLine, score, points, cheats);
        primaryStage.show();
    }

    private void renderingGameFlow(Button cheats) {
        Timeline timeline = new Timeline();

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.3), event -> {
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

            cheats.setOnAction(eventCheater -> {
                root.getChildren().removeAll(HelloApplication.bottomLine);
                HelloApplication.bottomLine.clear();
                scorePoints += 1000;
                points.setText(scorePoints + "");
                root.getChildren().remove(points);
                root.getChildren().add(points);
            });
            getLowerElements(buttons.get(buttons.size() - 1));
            try {
                updateContent(root);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateContent(Pane root) throws InvocationTargetException, IllegalAccessException {
        getLowerElements(buttons.get(buttons.size() - 1));
        Button[][] currentElement = buttons.get(buttons.size() - 1);


        for (Button button1[] : currentElement) {
            for (Button button : button1) {
                if (button.getLayoutY() + STEP >= LOWER_LINE && button.getStyle().equalsIgnoreCase(BUTTON_STYLE)) {
                    release = true;
                    break;
                }
                for (Button bottomLine : bottomLine) {
                    if (button.getLayoutY() + STEP == bottomLine.getLayoutY() && button.getLayoutX() == bottomLine.getLayoutX() && button.getStyle().equalsIgnoreCase(BUTTON_STYLE)) {
                        release = true;
                        break;
                    }
                }
            }
        }
        if (release) {
            getTopLine(currentElement);
            buttons.add(getNewElement());

            for (Button[] button : buttons.get(buttons.size() - 1)) {
                root.getChildren().addAll(button);
            }
            removeFullLine(root);
            bottomLine.removeAll(removeLine);
            removeLine.clear();
            release = false;
        } else {
            moveOneStep(currentElement);
        }
    }


    private void removeFullLine(Pane pane) {

        int count = 0;
        for (double i = 50; i <= 470; i += 30) {
            for (double j = 50; j <= 290; j += 30) {
                for (Button button : bottomLine) {
                    if (button.getLayoutX() == j && button.getLayoutY() == i && button.getStyle().equalsIgnoreCase(BUTTON_STYLE)) {
                        count++;
                    }
                }
            }
            if (count == 9) {
                scorePoints += 100;
                for (int j = 50; j <= 290; j += STEP) {
                    for (Button button : bottomLine) {
                        if (button.getLayoutY() == i && button.getStyle().equalsIgnoreCase(BUTTON_STYLE)) {
                            removeLine.add(button);
                            button.setStyle(REMOVE_BUTTON_STYLE);
                            pane.getChildren().remove(button);
                        }
                    }

                }

                shiftAllButtons(i, pane);
                root.getChildren().remove(points);
                points.setText(scorePoints + "");
                root.getChildren().add(points);
                count = 0;
            } else {
                count = 0;
            }
        }

    }

    private void shiftAllButtons(double line, Pane pane) {
        for (Node node : pane.getChildren()) {
            if (node instanceof Button && node.getLayoutY() < line) {
                node.setLayoutY(node.getLayoutY() + STEP);
            }
        }

    }

    public static Button[][] getNewElement() throws InvocationTargetException, IllegalAccessException {
        //System.out.println(Tetrominos.class.getDeclaredMethods().length - 2);
        //return Tetrominos.getElementFullfillWithButtons(Tetrominos.getStickElement());
        //Method method = Tetrominos.class.getDeclaredMethods()[random.nextInt(Tetrominos.class.getDeclaredMethods().length - 2)];
        for (int i = 0; i < 100; i++) {
            int meth = random.nextInt(Tetrominos.class.getDeclaredMethods().length - 2);
            System.out.println(meth);
            System.out.println(Tetrominos.class.getDeclaredMethods()[meth].getName());
        }

        return Tetrominos.getElementFullfillWithButtons((boolean[][]) Tetrominos.class.getDeclaredMethods()[random.nextInt(Tetrominos.class.getDeclaredMethods().length - 1) + 1].invoke(new Tetrominos()));
    }
}