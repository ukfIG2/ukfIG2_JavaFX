package _16_Virtualny_svet_3_Prezentacia;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class DopravnyProstriedok extends Canvas {
    protected GraphicsContext gc;
    protected Color farba; // na kontext budeme kresliť farbou
    protected int obrazok = 1; // obrazok pouzijeme pri kresleni
    private int rychlost;
    private Timeline casovac;


    public DopravnyProstriedok(int x, int y, int r, Color f) {
        super(40,40); // rozmer obrazka
        rychlost = r; farba = f;
        setLayoutX(x); setLayoutY(y);
        gc = getGraphicsContext2D();

        setFocusTraversable(true);
        setOnKeyPressed(evt -> spracujKB(evt));
        setOnMouseClicked(evt-> { vypisInfo();
            requestFocus(); vykresli(); });

        casovac = new Timeline(
                new KeyFrame(Duration.millis(100), e -> posun()));
        casovac.setCycleCount(Animation.INDEFINITE);
        casovac.play();
    }

    private void vypisInfo() {
        System.out.println(getClass().getName());
        System.out.println(getClass().getSimpleName());
        System.out.println("rychlost: "+rychlost +
                ", x: " + getLayoutX() +
                ", y: " + getLayoutY());
    }

    public void zmenaFarby(Color f) {
        farba = f;
    }

    private void posun() {
        if ((getLayoutX() > 300) || (getLayoutX() < 10))
            rychlost = -rychlost;
        setLayoutX(getLayoutX() + rychlost);
        obrazok = (obrazok +1) % 2;
        vykresli();
    }

    protected void vykresli() {
        gc.clearRect(0,0,getWidth(),getHeight());
        if (isFocused()) {
            gc.setFill(Color.RED);
            gc.fillRect(0,0, getWidth(), getHeight());
        }
    }

    private void spracujKB(KeyEvent evt) {
        KeyCode k = evt.getCode();
        switch (k) {
            case W: posunHore();
                break;
            case S: posunDole();
                break;
            case X: otocka();
                break;
            case O: zvysRychlost();
                break;
            case P: znizRychlost();
                break;
            case DELETE: Zmaz();
                break;
        }
    }

    public void posunHore() {
        if (getLayoutY()>10) setLayoutY(getLayoutY()-10);
    }

    private void posunDole() {
        if (getLayoutY()<250) setLayoutY(getLayoutY()+10);
    }

    public void zvysRychlost() {
        rychlost = rychlost + (int)Math.signum(rychlost);
    }

    public void znizRychlost() {
        rychlost = rychlost - (int)Math.signum(rychlost);
    };

    public void otocka() {
        rychlost = -rychlost;
    }

    private void Zmaz() {
        ((Group)getParent()).getChildren().remove(this);
    }





}
