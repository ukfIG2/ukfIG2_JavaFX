package _11_Animacia_02;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Oblak extends Canvas {
    protected GraphicsContext gc;
    Timeline casovac;
    protected int obrazok = 0;
    int rychlost = 2;
    protected Group root; // získame ho zo scény


    public Oblak(Group rt) {
        super(30, 20); // nastavenie rozmerov Canvasu
        root = rt;
        this.setLayoutX(10);
        this.setLayoutY(100);
        gc = getGraphicsContext2D(); // ziskanie gr. kontextu
        vykresli(); // vykreslenie
        // novy casovac
        casovac = new Timeline(
                new KeyFrame(Duration.millis(100), e -> spracuj()));
        // pocet opakovani – nekonecno
        casovac.setCycleCount(Animation.INDEFINITE);
        setOnMousePressed(evt -> kvap(evt));
    }

        public void startuj() {
            casovac.play();
        }

        protected void vykresli() {
            gc.clearRect(0, 0, getWidth(), getHeight());
            gc.setFill(Color.BLUE);
            gc.fillOval(obrazok, obrazok, 30-obrazok, 20-obrazok);
        }

        protected void spracuj() {
            // v kazdom kromku zmeni obrazok = prida 1 a
            // zisti zvysok pri deleni 2, tak meni 0,1,0,1
            obrazok = (obrazok + 1) % 5; // zabezpeci zmenu obrazku
            posun();			    // zabezpeci zmenu suradnice x
            // kvoli prekresleniu obrazku
            vykresli();
        }

        protected void posun() {
            // ak sa presunul k okraju formulara, ukaze sa na druhom
            if (getLayoutX()<10)
                setLayoutX(300);
            else // inak sa posunie dolava o rychlost
                setLayoutX(getLayoutX()-rychlost);
        }

    private void kvap(MouseEvent evt) {
        Kvapka k = new Kvapka(root, getLayoutX(),getLayoutY(),10);
        k.startuj();
        root.getChildren().add(k);
    }

}
