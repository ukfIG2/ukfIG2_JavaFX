package _15_Virtualny_svet_2;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class Dopravny_prostriedok extends Canvas {
	protected GraphicsContext gc;
	protected Color farba;
	protected int obrazok;
	private int rychlost;
	private Timeline casovac;
	
	public Dopravny_prostriedok(int x, int y, int rychlost, Color farba) {
		super(40, 40);
		this.rychlost = rychlost;	this.farba = farba;
		setLayoutX(x); setLayoutY(y);
		gc = getGraphicsContext2D();
		
		setFocusTraversable(true);
		setOnKeyPressed(evt -> spracujKB(evt));
		setOnMouseClicked(evt -> { requestFocus(); vykresli(); });
		
		casovac = new Timeline(
				new KeyFrame(Duration.seconds(0.1),e -> posun()));
		casovac.setCycleCount(Animation.INDEFINITE);
		casovac.play();
	}
	
	private void posun() {
		if(getLayoutX()>500 || (getLayoutX()<10))
			rychlost = -rychlost;
		setLayoutX(getLayoutX() + rychlost);
		obrazok = (obrazok +1) %2;
		vykresli();	//lebo robime animaciu
	}
	
	protected void vykresli() {
        gc.clearRect(0,0,getWidth(),getHeight());
        if (isFocused()) {
            gc.setFill(Color.RED);
            gc.fillRect(0,0, getWidth(), getHeight()); //cela sirka,dlzka
        }
	}
	
		private void spracujKB(javafx.scene.input.KeyEvent evt) { //zalei na tom, kke je to takto napisane???
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
	
    private void posunHore() {
        if (getLayoutY()>10) setLayoutY(getLayoutY()-10);
    }

    private void posunDole() {
        if (getLayoutY()<250) setLayoutY(getLayoutY()+10);
    }

    public void zvysRychlost() {
        rychlost = rychlost + (int)Math.signum(rychlost);//Math/signum prida prida oobere hodnotu podla totho ci e +/-.
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
