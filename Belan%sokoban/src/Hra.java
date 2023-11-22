

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Hra extends Group {
	private ImageView pozadie;
	private LinkedList<Kocka> kocky;
	private Hrac h;
	private Text vyhraText;
	private int velkostKociek, pocetKrabic, level, sirkaSceny, vyskaSceny;
	
	public Hra(int sirkaSceny, int vyskaSceny) {
		this.sirkaSceny = sirkaSceny;
		this.vyskaSceny = vyskaSceny;
		this.pocetKrabic = 0;
		this.level = 1;
		this.velkostKociek = 50;
		kocky = new LinkedList<Kocka>();
		
		Image bg = new Image("pozadie.png", sirkaSceny, vyskaSceny, false, false);
		pozadie = new ImageView(bg);
		
		Button buttonRestart = new Button("Reštart");
		buttonRestart.setOnAction(e -> restart());
		buttonRestart.setLayoutX(sirkaSceny*0.7);
		buttonRestart.setLayoutY(vyskaSceny*0.1);
		buttonRestart.setPrefSize(200, 100);
		buttonRestart.setFont(new Font(30));
		getChildren().add(buttonRestart);
		
		setOnKeyPressed(e -> pohyb(e.getCode().toString()));
		setFocusTraversable(true);
    	setFocused(true);
    	nacitajLevel(1);
	}
	private void nacitajLevel(int level) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("level"+level+".txt"));
			String riadok = br.readLine();
			int poziciaY = 0;
			while(riadok != null) {
				for(int i = 0; i < riadok.length(); i++) {
					String znak = riadok.substring(i, i+1);
					if(znak.equals("x")) {
						Kocka s = new Stena("stena.png", i, poziciaY, velkostKociek);
						kocky.add(s);
						getChildren().add(s);
					}
					if((znak.equals("o")) || (znak.equals("c"))) {
						pocetKrabic++;
						Kocka k = new Krabica("krabica.png", i, poziciaY, velkostKociek);
						kocky.add(k);
						getChildren().add(k);
					}
					if((znak.equals("q")) || (znak.equals("c"))) {
						Kocka b = new Bod("bod.png", i, poziciaY, velkostKociek);
						kocky.add(b);
						//getChildren().addFirst(b);
						getChildren().add(0, b);
					}
					if(znak.equals("i")) {
						h = new Hrac("hrac1.png", i, poziciaY, velkostKociek);
						kocky.add(h);
						getChildren().add(h);
					}
				}
				poziciaY++;
				riadok = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		getChildren().add(0, pozadie);
		pridajButton(level);
	}
	private void pohyb(String klavesa) {
		if(klavesa.equals("LEFT") && h.moznoDolava(kocky, true)) {
			h.dolava();
		}
		if(klavesa.equals("RIGHT") && h.moznoDoprava(kocky, true)) {
			h.doprava();
		}
		if(klavesa.equals("UP") && h.moznoHore(kocky, true)) {
			h.hore();
		}
		if(klavesa.equals("DOWN") && h.moznoDole(kocky, true)) {
			h.dole();
		}
		aktualizujScenu();
	}
	private void aktualizujScenu() {
		int pocet = 0;
		for(int i = 0; i < kocky.size(); i++) {
			Kocka k = kocky.get(i);
			if(k instanceof Krabica) {
				if(((Krabica) k).jeNaBode(kocky)) {
					pocet++;
				}
			}
		}
		if(pocet == pocetKrabic) {
			pocetKrabic = 0;
			level++;
			System.out.println(level);
			if(level <= 3) {
				for(int i = 0; i < kocky.size(); i++) {
					getChildren().remove(kocky.get(i));
				}
				kocky.clear();
				getChildren().remove(pozadie);
				nacitajLevel(level);
				aktualizujScenu();
			} else {
				vyhraText = new Text("GG");
				vyhraText.setLayoutX(sirkaSceny/2.5);
				vyhraText.setLayoutY(vyskaSceny*0.92);
				vyhraText.setFont(new Font(50));
				getChildren().add(vyhraText);
			}
		}
		requestFocus();
	}
	private void pridajButton(int level) {
			Button buttonLevel = new Button("Level "+level);
			buttonLevel.setOnAction(e -> {
				this.level = level;
				for(int i = 0; i < kocky.size(); i++) {
					getChildren().remove(kocky.get(i));
				}
				if(getChildren().contains(vyhraText)) {
					getChildren().remove(vyhraText);
				}
				kocky.clear();
				pocetKrabic = 0;
				getChildren().remove(pozadie);
				nacitajLevel(level);
				aktualizujScenu();
			});
			buttonLevel.setLayoutX(sirkaSceny*0.7);
			buttonLevel.setLayoutY(vyskaSceny*(0.1*(1+2*level)));
			buttonLevel.setPrefSize(200, 100);
			buttonLevel.setFont(new Font(30));
			getChildren().add(buttonLevel);
	}
	private void restart() {
		for(int i = 0; i < kocky.size(); i++) {
			Kocka k = kocky.get(i);
			k.setLayoutX(velkostKociek*(2+k.getStartX()));
			k.setLayoutY(velkostKociek*(2+k.getStartY()));
		}
		h.resetSmerHraca();
		aktualizujScenu();
	}
}
