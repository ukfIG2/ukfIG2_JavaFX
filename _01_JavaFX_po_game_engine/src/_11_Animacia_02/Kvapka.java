package _11_Animacia_02;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Kvapka extends Oblak {
    private int zivot = 20;

    /*public Kvapka(Group gr, double x, double y, int r) {
        super(gr);
        setLayoutX(x);
        setLayoutY(y);
        rychlost = r;
    }*/ //nerozumiem

    public Kvapka(Group gr, double x, double y, int r) {
		// TODO Auto-generated constructor stub
    	super(gr);
        setLayoutX(x);
        setLayoutY(y);
        rychlost = r;
	}

	protected void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(Color.LIGHTBLUE);
        gc.fillOval(0, 0, 2*obrazok, 2*obrazok);
    }

    protected void posun() {
        if (getLayoutY()<220)
            setLayoutY(getLayoutY()+rychlost);
    }

    protected void spracuj() {
        obrazok = (obrazok + 1) % 5;
        posun();
        zivot--;
        if (zivot == 0) {
            casovac.stop();
            root.getChildren().remove(this);
        }
        vykresli();
    }

}
