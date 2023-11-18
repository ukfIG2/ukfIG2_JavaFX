package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Game extends Group{
	private Pane pane;
	private Scene scene;
	//Nacirat pozadia
    private Image Pozadie_Oblaky = new Image("cloud.gif");
    private Image Pozadie_Dedinka = new Image("parallaxbackground.GIF");
    //Nastavit sirku hry
    public double Sirka_hry = Pozadie_Dedinka.getWidth()*2 ;	//sirka Snimky/parallaxbackground.GIF *2
    //Premenne pre pozadie
    private ImageView pozadie_oblaky;
    private ImageView pozadie_dedinka;
    //Lisr pre normalne Sliepky
    private List<Spriites_snimky> AI = new LinkedList<Spriites_snimky>();
    //Nejake cisla
    private int Max_pocet_normalnych_sliepok = 100;
    private int Aktulny_pocet_normalnych_sliepok;
    private int Vytvorit_sliepok_naraz= 4;
    private int pocetNabojov;
    private int maxNabojov;
    Timeline vznik_sliepok;
    private Timeline soundTimeline;
    //Myska
    private ImageView myska;
    //Media 
    private static Map<Integer, MediaPlayer> soundCache;
    private List<ImageView> ammoImages = new ArrayList<>();
    
    
    private double rychlost_sceny = 30;
    private int smer; 
    
    public Game(Pane pane, Scene scene) {
    	this.scene=scene;
    	this.pane=pane;
    	Nastav_Pozadie();
		vznik_sliepok = new Timeline(new KeyFrame(Duration.seconds(3+random(0, 3)), e -> VytvorSliepku()));
		vznik_sliepok.setCycleCount(Animation.INDEFINITE);
		vznik_sliepok.play();
		NastavMysku();
		initSoundCache();
        soundTimeline = new Timeline(new KeyFrame(Duration.seconds(13), e -> playSound(6))); // Adjust the duration as needed
        soundTimeline.setCycleCount(Animation.INDEFINITE);
        soundTimeline.play();
        maxNabojov = 5;
        createInitialAmmos();
		playSound(6);

		
		
    	
	}
    void update(double deltaTime) {
        this.Aktulny_pocet_normalnych_sliepok = AI.size();

        // Use an iterator to loop through the list
        Iterator<Spriites_snimky> iterator = AI.iterator();
        while (iterator.hasNext()) {
            Spriites_snimky ai = iterator.next();
            ai.pohyb(deltaTime / 1000000000 * ai.rychlost_sliepky);
            

            if (ai.prec) {
               pane.getChildren().remove(ai);
                iterator.remove(); // Use the iterator to safely remove the current element
            }
            
        }
        System.out.print(pocetNabojov);
    }
 
    private void Nastav_Pozadie() {
    	//Nastavenie pozadi
		pozadie_oblaky = new ImageView(Pozadie_Oblaky);
		pozadie_oblaky.setFitWidth(Sirka_hry);
		pozadie_oblaky.setFitHeight(Main.Vyska_obrazovky);
		pane.getChildren().add(pozadie_oblaky);
		
		pozadie_dedinka = new ImageView(Pozadie_Dedinka);
		pozadie_dedinka.setFitHeight(Main.Vyska_obrazovky);
		pozadie_dedinka.setFitWidth(Sirka_hry);
		pozadie_dedinka.setY(Main.Vyska_obrazovky-pozadie_dedinka.getFitHeight());
		pane.getChildren().add(pozadie_dedinka);

		
		//Nastavenie udalosti pohybu mysi
		scene.addEventHandler(MouseEvent.MOUSE_MOVED, event -> pohniKamerou(event.getX()));
    }
    
    private void  pohniKamerou(double mouseX) {
		//System.out.println(mouseX);
		//System.out.println(root.getTranslateX());
		double priestor_aktivity = 300;
		if (mouseX <= priestor_aktivity) {			
            // Pohyb dolava
            if (pane.getTranslateX() < 0) {
                pane.setTranslateX(pane.getTranslateX() + rychlost_sceny);
            }
        } else if (mouseX >= Main.Sirka_obrazovky - priestor_aktivity) {
            // Pohyb doprava
            if (pane.getTranslateX() > Main.Sirka_obrazovky - Sirka_hry) {
                pane.setTranslateX(pane.getTranslateX() - rychlost_sceny);
            }
        }
		//System.out.println(pane.getTranslateX());
	}
    
	public double random(double min, double max) {
		return min + (Math.random() * max);
	}
	
	private double smerSliepky() {
		double a = random(0,1);
		if(a<0.5) {smer=1; return 0;}
		else {smer=0; return Sirka_hry-152;}
	}
	
	private void VytvorSliepku() {
		//Ak je na ploche mene ako 100 sliepok da nove
		if(Aktulny_pocet_normalnych_sliepok<Max_pocet_normalnych_sliepok) {
		for(int i=0; i<=Vytvorit_sliepok_naraz; i++) {
		Spriites_snimky nieco = new Spriites_snimky(this, "Sliepka/Sliepka", 21, 
    			smerSliepky(), random(0, Main.Vyska_obrazovky-152), 
    			142, 152, smer, random(100, 150));
		AI.add(nieco);
		pane.getChildren().add(nieco);
		}
		}
	}
	
	private void NastavMysku() {
		myska = new ImageView("cursor.gif");
        myska.setFitWidth(37);
        myska.setFitHeight(37);
        pane.getChildren().add(myska);
        scene.setCursor(Cursor.NONE); 
		scene.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> handleMouseClick(event));
		scene.addEventHandler(MouseEvent.MOUSE_MOVED, event -> updateCursorImagePosition(event.getX(), event.getY()));
	}
	
	private void handleMouseClick(MouseEvent event) {
	    if (event.getButton() == MouseButton.PRIMARY) {
	        double clickX = event.getSceneX();
	        double clickY = event.getSceneY();
	        if(pocetNabojov>0) {playSound(0);}
	        else {playSound(4);}

	        // Convert scene coordinates to local coordinates
	        Point2D localClick = pane.sceneToLocal(new Point2D(clickX, clickY));

	        // Check if the adjusted click intersects with any AI object
	        boolean aiClicked = false;
	        for (Spriites_snimky ai : AI) {
	            if (ai.getBoundsInParent().contains(localClick)) {
	                if(pocetNabojov<=0) {}
	                else {ai.Zastrelena(); reduceAmmo();}
	                aiClicked = true;
	                //playSound((int) (1 + Math.random() * 3));
	                break; // Exit the loop after handling the click on the first intersected AI object
	            }
	        }

	        if (!aiClicked) {
	            reduceAmmo();
	        }
	        }
	    else if (event.getButton() == MouseButton.SECONDARY) {
	        createInitialAmmos();
	        updateAmmoPosition();
	        playSound(5);
	    	
	}
	}
	
	private void updateCursorImagePosition(double mouseX, double mouseY) {
	    // Adjust the position of the cursor image based on the translation of the pane
	    double adjustedX = mouseX - pane.getTranslateX();
	    double adjustedY = mouseY - pane.getTranslateY();

	    // Update the position of the cursor image
	    myska.relocate(adjustedX - myska.getFitWidth() / 2, adjustedY - myska.getFitHeight() / 2);
	}
	
	public void initSoundCache() {
	//caching medii
	soundCache = new LinkedHashMap<>();
	for(int i=0; i<=7; i++) {
		//Media media = new Media(getClass().getResource("s"+i+".wav").toExternalForm());
		String soundFilePath = new File("Zvuky/s"+i+".wav").toURI().toString();
		MediaPlayer mediaPlayer = new MediaPlayer(new Media(soundFilePath));
		soundCache.put(i, mediaPlayer);
	}
	}
	
	public static void playSound(int soundIndex) {
		MediaPlayer mediaPlayer = soundCache.get(soundIndex);
		if (mediaPlayer != null) {
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.play();
        }
	}
	
    private void reduceAmmo() {
        if (pocetNabojov > 0) {
            pocetNabojov--;
            removeAmmo(); // Add this line to remove the corresponding ammo image
            updateAmmoPosition();
        }
    }

    private void updateAmmoPosition() {
        for (int i = 0; i < ammoImages.size(); i++) {
            ImageView ammoImage = ammoImages.get(i);
            double newX = Main.Sirka_obrazovky - 90 * 6 + 44 * (i + 1) + i * 10; // Adjust positions
            ammoImage.setX(newX);
        }
    }
    
    private void createAmmoImages() {
        double initialX = Main.Sirka_obrazovky - 90 * 6; // Initial X position
        double yPosition = Main.Vyska_obrazovky - 79 * 2; // Y position for all images
        int numAmmoToCreate = Math.min(maxNabojov, 5); // Ensure that you create at most 5 images

        // Check the current number of ammo images in the pane
        int currentNumAmmo = ammoImages.size();

        // Calculate how many additional images can be created without exceeding the limit
        int remainingAmmoSlots = 5 - currentNumAmmo;
        int numAmmoToAdd = Math.min(numAmmoToCreate, remainingAmmoSlots);

        for (int i = 0; i < numAmmoToAdd; i++) {
            ImageView ammoImage = new ImageView("ammo.gif");

            ammoImage.setFitWidth(44);
            ammoImage.setFitHeight(79);
            ammoImage.setX(initialX + i * 10 + 44 * (i + 1) + i * 10); // 10p apart from each other
            ammoImage.setY(yPosition);
            ammoImages.add(ammoImage);
            pane.getChildren().add(ammoImage);
        }

        if (numAmmoToAdd > 0) {
            playSound(5);
        }
    }
    
    
    private void createInitialAmmos() {
        for (int i = 0; i < maxNabojov; i++) {
            createAmmo();
        }
        createAmmoImages(); // Create ammo images at the start
        updateAmmoPosition(); // Update ammo positions at the start
    }


    private void createAmmo() {
        if (pocetNabojov < maxNabojov) {
            pocetNabojov++;
        }
    }
    
    private void removeAmmo() {
        if (!ammoImages.isEmpty()) {
            ImageView removedAmmo = ammoImages.remove(ammoImages.size() - 1);
            pane.getChildren().remove(removedAmmo);
        }
    }


	
}	
	
	
	
	