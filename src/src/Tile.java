
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.util.*;


public class Tile extends StackPane {

    static Othello game;
    private Circle circle = new Circle();
    private static int tileSize = 60;
    static int i = 0;
    static boolean run = false;

    private static class InnerTimer extends TimerTask {

        @Override
        public void run() {

                long t = System.currentTimeMillis();

                //System.out.println("ITERATION" + ++i);
                if(game.current.getTimer()){
                Platform.runLater(() -> {
                    game.run();
                    run = true;//}
                    long e = System.currentTimeMillis();
                    //System.out.println(e-t);
                    if(game.gameOver){game.gameOverScreen(); /*System.exit(0);*/ }
                });}
        }
    }
    public static void gotimer (){
        System.out.println("NOTICE ME");
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new InnerTimer(),1000l, 70l);
        //run = false;

        if(game.board.gameOver() ){
            System.out.println("i quit the timer!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            timer.cancel();
            System.exit(0);
        }
    }
    public Tile(){
        Rectangle border = new Rectangle(tileSize, tileSize);
        border.setFill(Color.GREEN);
        border.setStroke(Color.BLACK);

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, circle);



        setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY){
                if(game.board.gameOver()) game.gameOverScreen();
                else if(game.current.numberOfpossibleMoves(game.board, game.current.getColour()) == 0)
                    game.gameOverScreen();
                else if(game.current.getTimer()) game.run();
                else {
                    int x = (int) getTranslateY() / tileSize;
                    int y = (int) getTranslateX() / tileSize;
                    game.current.play(x, y);
                    Othello.hbox.getChildren().clear();
                    game.updateScore();
                }
            }
        });
    }

    public void drawWhite(){
        circle.setRadius(20.00);
        circle.setFill(Color.WHITE);
    }

    public void drawBlack(){
        circle.setRadius(20.00);
        circle.setFill(Color.BLACK);
    }
    public void drawYellow(){
        circle.setRadius(10.00);
        circle.setFill(Color.YELLOW);
    }
    public void removeCircle(){
        circle.setFill(Color.TRANSPARENT);
    }
    public static void setGame(Othello g){
        game = g;
    }
}