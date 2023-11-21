package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Game extends Group{
	final int SPRITESIZE = 30;
	final int MAXDUCK = 30;

	private LinkedList<Sliepka> zoznamSliepok;
	private LinkedList<Naboj> zoznamNabojov;
	private LinkedList<Kacka> zoznamKaciek;
	private LinkedList<Papagaj> zoznamPapagajov;
	private PauseTransition pause;
	private AnimaciaVystrelu vystrel;
	private AnimaciaVystrelu zasah;
	
	
	private Random rand;
	private MediaPlayer strelaZvuk;
	private MediaPlayer prebitieZvuk;
	
	private double maxWidth, maxHeight = 450;
	private int skore = 0;
	private double stage = 0;
	private boolean canShoot = true;
	private boolean isPlaying = false;
	private boolean prebijanie = false;
	private boolean isCalled = false;
	
	public Game(int w, int h, String pozadie) {
		
		zoznamPapagajov = new LinkedList<>();
		zoznamKaciek = new LinkedList<>();
		zoznamSliepok = new LinkedList<>();
		zoznamNabojov = new LinkedList<Naboj>();
		this.maxWidth= w;
		this.maxHeight = h;
		this.rand = new Random();
		Image bg= new Image(pozadie, w, h, false, false);
		ImageView background= new ImageView(bg);
		this.pause = new PauseTransition(Duration.millis(1500));
		this.vystrel =new AnimaciaVystrelu(235,430,"fireshot");
		this.zasah = new AnimaciaVystrelu(100, 100,"gunshot");
		
		
		Image zbran = new Image("zbranupravena.png", 150,150,false,false);
		ImageView zb = new ImageView(zbran);
		getChildren().addAll(background,zb,vystrel,zasah);
		zb.setY(450);
		zb.setX(250);
		setFocusTraversable(true);
		
		//String mediaSTR = "file:///C://Users//Marek//Eclipse//workspace//MoorHuhn//VanillaProject//resources//bgjunglesound.mp3";  // Replace with the actual path to your media file
		//String mediaSTR = "bgjunglesound.mp3";  // Replace with the actual path to your media file
		//Media mediaBG = new Media(mediaSTR);
		//Media mediaBG = new Media("muzika/bgjunglesound.mp3");
		
		
       // MediaPlayer mpBG = new MediaPlayer(mediaBG);
        //mpBG.setCycleCount(MediaPlayer.INDEFINITE);
        String soundFilePath = new File("resources/bgjunglesound.mp3").toURI().toString();
		MediaPlayer mpBG = new MediaPlayer(new Media(soundFilePath));
        mpBG.play();
        //String mediaFile = "C:\\Users\\Marek\\Eclipse\\workspace\\MoorHuhn\\VanillaProject\\resources\\vystrelzvuk.mp3";  // Replace with the actual path to your media file
		String mediaFile = "resources/vystrelzvuk.mp3";  // Replace with the actual path to your media file
        Media media = new Media(new File(mediaFile).toURI().toString());
        this.strelaZvuk = new MediaPlayer(media);

       // String mf = "C:\\Users\\Marek\\Eclipse\\workspace\\MoorHuhn\\VanillaProject\\resources\\shotgunreload.mp3";  // Replace with the actual path to your media file
        String mf = "resources/shotgunreload.mp3";  // Replace with the actual path to your media file
        Media m = new Media(new File(mf).toURI().toString());
        this.prebitieZvuk = new MediaPlayer(m);
        
        

        
		this.setOnMousePressed(e -> prekresliNaboje(e));
		
		this.setOnKeyPressed(e-> {
			requestFocus();
			if(e.getCode() == KeyCode.R) {
			this.canShoot = false;

			if (!prebijanie) {
				this.prebitieZvuk.play();
				prebijanie = true;
         } else {
        	 this.prebitieZvuk.stop();
        	 this.prebitieZvuk.play();
            }
			pause.setOnFinished(r -> this.nabiZbran(e));
			pause.play();
			mpBG.play();
			}
		});
		
		
		
		
		
		
		
	}
	
	
	public void update(double deltaTime) {
		vyrobZvierata();

		if(isCalled == false) {
			if (zoznamNabojov.size() < 1) {
				this.isCalled = true;
				if (!prebijanie) {
					this.prebitieZvuk.play();
					prebijanie = true;
				} else {
		    	 this.prebitieZvuk.stop();
		    	 this.prebitieZvuk.play();
		        }
				pause.setOnFinished(e -> this.nabiZbran());
				pause.play();
			}
		}
		zobrazNaboje();
		urobPohyb((deltaTime/1000000));

		stavHry();
		premazZvierata();

	}
	
	public boolean stavHry() {
		// TODO Auto-generated method stub
		if(this.getSkore() < 0) {
//			javafx.application.Platform.exit();
			return true;
			
			
		}
		
		return false;
	}


	private void vyrobKacku() {
		if (zoznamKaciek.size() < 1) {

				Kacka nova = new Kacka("kacka", 8, SPRITESIZE, SPRITESIZE, maxWidth, maxHeight,this.stage);
				zoznamKaciek.add(nova);
				getChildren().add(nova);

		}
	}



	private void vyrobZvierata() {
		if (zoznamSliepok.size() < 1 && zoznamPapagajov.size() < 1) {
			if(this.stage == 0) {
				nabiZbran();
			}
			this.stage+=10;
			vyrobKacku();//Kacka pridava az 100bodov navyse
			for(int i = 0; i < 3; i++) {
				int size = rand.nextInt(50)+30;
				Sliepka nova = new Sliepka("vtak", 10, size, size, maxWidth, maxHeight,this.stage);
				zoznamSliepok.add(nova);
				getChildren().add(nova);
			}	
			for(int i = 0; i < 3; i++) {
				int size = rand.nextInt(50)+30;
				Papagaj nova = new Papagaj("papagaj", 18, size, size, maxWidth, maxHeight,this.stage);
				
				zoznamPapagajov.add(nova);
				getChildren().add(nova);
			}
		}
	}
	
	//PRETAZENIE METODY automaticky pri vyprazdneni zasobnika mi prebije
	private void nabiZbran() {
		
		
		
		if (zoznamNabojov.size() < 1) {

			for (int i = 0; i < 6; i++) {
				Naboj nova = new Naboj("bullet", 1, SPRITESIZE, SPRITESIZE*2,i*30,450);
				zoznamNabojov.add(nova);
				getChildren().add(nova);
				
			}
		}
		this.canShoot = true;
		this.isCalled = false;
		
		
		
		

	
		
	}
	//PRETAZENIE METODY Pri stlaceni R mi prebije
	public void nabiZbran(KeyEvent e ) {

			ListIterator<Naboj> iterator = zoznamNabojov.listIterator(zoznamNabojov.size());
			
			while (iterator.hasPrevious()) {
					
			    Naboj prvok = iterator.previous();
			    prvok.setVystreleny();
			    getChildren().remove(prvok);
			    iterator.remove();
			}
			nabiZbran();
			this.canShoot = true;
			

		
	}
	
	private void zobrazNaboje() {

		int i = 0;
		Iterator<Naboj> iterator = zoznamNabojov.iterator();
		while(iterator.hasNext()) {
			
			Naboj prvok = iterator.next();
		     prvok.zmena(i*10);
		     i++;
		    }
	}


	private void urobPohyb(double delta) {
		Iterator<Sliepka> iterator = zoznamSliepok.iterator();
		while(iterator.hasNext()) {
		      Sliepka prvok = iterator.next();
		      
		      prvok.zmena(delta);

		    }
		
		
		Iterator<Kacka> iteratorKacky = zoznamKaciek.iterator();
		while(iteratorKacky.hasNext()) {
		      Kacka prvok = iteratorKacky.next();
		      prvok.zmena(delta);
		    }
		

		Iterator<Papagaj> iteratorPapagaja= zoznamPapagajov.iterator();
		while(iteratorPapagaja.hasNext()) {
		      Papagaj prvok = iteratorPapagaja.next();
		      prvok.zmena(delta);
		    }
	}
	

	private void prekresliNaboje(MouseEvent e) {
		if(canShoot) {
		ListIterator<Naboj> iterator = zoznamNabojov.listIterator(zoznamNabojov.size());
 
		 if (iterator.hasPrevious()) {
				 if (!isPlaying) {
		                strelaZvuk.play();
		                isPlaying = true;
	             } else {
		                strelaZvuk.stop();
		                strelaZvuk.play();
		            }
			 	skontrolujStrelu(e);
			 	this.zasah.nastavSuradnice(e.getSceneX(), e.getSceneY());
			 	this.zasah.toggleStav();
			 	this.vystrel.toggleStav();
			    Naboj prvok = iterator.previous();
			    prvok.setVystreleny();
			    iterator.remove();
		  }
		}
		 
        
        
	  
	}
	public void skontrolujStrelu(MouseEvent e) {
		double x = e.getX();
		 double y = e.getY();
		 Iterator<Sliepka> iteratorSliepka = zoznamSliepok.iterator();
			while(iteratorSliepka.hasNext()) {
			      Sliepka prvok = iteratorSliepka.next();
			      prvok.onClick(e.getSceneX(),e.getSceneY());
			      
			      
			    }
			
		Iterator<Kacka> iteratorKacky = zoznamKaciek.iterator();
		while(iteratorKacky.hasNext()) {
		      Kacka prvok = iteratorKacky.next();
		      prvok.onClick(e.getSceneX(),e.getSceneY());
		    }
		
		Iterator<Papagaj> iteratorPapagaja= zoznamPapagajov.iterator();
		while(iteratorPapagaja.hasNext()) {
		      Papagaj prvok = iteratorPapagaja.next();
		      prvok.onClick(e.getSceneX(),e.getSceneY());
		    }
	}

	private void premazZvierata() {


		Iterator<Sliepka> iterator = zoznamSliepok.iterator();
		while(iterator.hasNext()) {
		      Sliepka prvok = iterator.next();

		      if (prvok.getStav() == 2) {
		    	  if(prvok.getTrafena() == 1) {
		    		  this.skore +=10;
		    	  } else {
		    		  this.skore -= 10;
		    	  }
		    	  iterator.remove();
		    	  getChildren().remove(prvok);
		      } 
		      
		    }
		
		
		Iterator<Papagaj> iteratorPapagaja= zoznamPapagajov.iterator();
		while(iteratorPapagaja.hasNext()) {
		      Papagaj prvok = iteratorPapagaja.next();

		      if (prvok.getStav() == 2) {
		    	  if(prvok.getTrafena() == 1) {
		    		  this.skore +=20;
		    	  } else {
		    		  this.skore -= 20;
		    	  }
		    	  iteratorPapagaja.remove();
		    	  getChildren().remove(prvok);
		      } 
		      
		    }
		
		
		Iterator<Kacka> iteratorKacky = zoznamKaciek.iterator();
		while(iteratorKacky.hasNext()) {
		      Kacka prvok = iteratorKacky.next();
		      if (prvok.getStav() == 2) {
		    	  if(prvok.getTrafena() == 1) {
		    		  this.skore +=100;
		    	  } 
		    	  iteratorKacky.remove();
		    	  getChildren().remove(prvok);
		      } 
		      
		    }
	}
	
	
	
	public int getSkore() {
		return this.skore;
	}
	
	public double getStage() {
		return this.stage%500;
	}
	


}
