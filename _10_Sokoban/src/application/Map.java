package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class Map extends ImageView {
		private String level[][];
		int[][] coordinaty;
		private static Image BOXimage = new Image("box.png");
		private static Image BOXonTARGETimage = new Image("boxO.png");
		private static Image FLOORimage = new Image("floor.bmp");
		private static Image TARGETimage = new Image("goal.png");
		private static Image WALLimage = new Image("wall.bmp");
		private static Image PLAYERdole = new Image("player2D.png");
		private static Image PLAYERhore = new Image("player2U.png");
		private static Image PLAYERdolava = new Image("player2L.png");
		private static Image PLAYERdoprava = new Image("player2R.png");
		private static final double sirka_snimku = 50;
		private static final double vyska_snimku = 50;
		private double aktualna_pozicia_X;
		private double aktualna_pozicia_Y;
		private double nova_pozicia_X;
		private double nova_pozicia_Y;
		private ArrayList<ImageView> HRAC = new ArrayList<>(List.of(new ImageView(PLAYERhore), new ImageView(PLAYERdole), new ImageView(PLAYERdoprava), new ImageView(PLAYERdolava)));
		private double okrajX = 50;
		private double okrajY = 50;
		private double pocetRiadkov = 0;
		private double pocetstlpcov = 0;
		private double MAXpocetstlpcov = 0;
		private String nazov_suboru;
		private Group group;
		private ImageView hrac;
		private List<ImageView> walls = new ArrayList<>();

		
		
		public Map(Group group, String nazov_suboru) {
			this.group=group;
			this.nazov_suboru=nazov_suboru;
			nacitaj_Subor(nazov_suboru);
			nacitaj_mapu();
			pridaj_boxy();
			vytvor_hraca();
			
			setFocusTraversable(true);
			
			/*Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> update()));
			timeline.setCycleCount(Animation.INDEFINITE);
			timeline.play();*/
			
			setOnKeyPressed(e -> pohyb_hraca(e));

		}
		
		private void nacitaj_Subor(String nazov_subory) {
			try (BufferedReader reader = new BufferedReader(new FileReader(nazov_subory))) {
		        String line;

		        // Read the level layout
		        List<String> levelList = new ArrayList<>();
		        while ((line = reader.readLine()) != null && !line.matches("\\d+ \\d+")) {
		            levelList.add(line);
		        }
		        level = new String[levelList.size()][];
		        for (int i = 0; i < levelList.size(); i++) {
		            level[i] = levelList.get(i).split("");
		        }

		        // Read the coordinates
		        List<int[]> coordinatesList = new ArrayList<>();
		        do {
		            String[] coordinatesString = line.split(" ");
		            int x = Integer.parseInt(coordinatesString[0]);
		            int y = Integer.parseInt(coordinatesString[1]);
		            coordinatesList.add(new int[]{x, y});
		        } while ((line = reader.readLine()) != null);

		        // Convert the list to an array
		        coordinaty = coordinatesList.toArray(new int[0][0]);
		    } catch (IOException | NumberFormatException e) {
		        e.printStackTrace();
		    }
		}
		
		private void nacitaj_mapu() {
			for(int i=0; i<level.length; i++) {
				pocetRiadkov++;
				for(int j=0; j<level[i].length; j++) {
					switch(level[i][j]) {
					case "!":
						pocetstlpcov++;
						break;
					case "#":
						pridaj_snimok(WALLimage, i, j);
						pocetstlpcov++;
						break;
					case " ":
						pridaj_snimok(FLOORimage, i, j);
						pocetstlpcov++;
						break;
					case ".":
						pridaj_snimok(TARGETimage, i, j);
						pocetstlpcov++;
						break;
					}
				}
			}
		}
		
		private void pridaj_snimok(Image image, int i, int j) {
		    ImageView pridajsnimok = new ImageView(image);
		    pridajsnimok.setLayoutX(okrajX + sirka_snimku * j);
		    pridajsnimok.setLayoutY(okrajY + vyska_snimku * i);
		    if (image.equals(WALLimage)) {
		        walls.add(pridajsnimok); // Add wall to the list
		    }
		    group.getChildren().add(pridajsnimok);
		}

		
		private void vytvor_hraca() {
			hrac = new ImageView();
			hrac.setLayoutX(okrajX + coordinaty[0][0] * sirka_snimku);
			hrac.setLayoutY(okrajY + (pocetRiadkov-1 - coordinaty[0][1]) * vyska_snimku);
			hrac.setImage(PLAYERdole);
			aktualna_pozicia_X = hrac.getLayoutX();
			nova_pozicia_X = aktualna_pozicia_X;
			aktualna_pozicia_Y = hrac.getLayoutY();
			nova_pozicia_Y = aktualna_pozicia_Y;
			group.getChildren().add(hrac);
		}
		
		private void pridaj_boxy(){
			for(int i=1; i<coordinaty.length; i++) {
				ImageView box = new ImageView();
				box.setLayoutX(okrajX + coordinaty[i][0] * sirka_snimku);
				box.setLayoutY(okrajY + (pocetRiadkov-1 - coordinaty[i][1]) * vyska_snimku );
				box.setImage(BOXimage);
				group.getChildren().add(box);
			}
		}

		private void pohyb_hraca(KeyEvent evt) {
			KeyCode keycode = evt.getCode();
			switch(keycode) {
			case LEFT:
				hrac.setImage(PLAYERdolava);
				nova_pozicia_X = aktualna_pozicia_X - sirka_snimku;
				
				List<ImageView> wallPositions = getWallPositions();
		        for (ImageView wall : wallPositions) {
		            double wallX = wall.getLayoutX();
		            double wallY = wall.getLayoutY();
		            //System.out.println("Wall position - X: " + wallX + ", Y: " + wallY);
		            if((nova_pozicia_X == wallX) && (nova_pozicia_Y == wallY)) {
		            	hrac.setLayoutX(aktualna_pozicia_X);
		            	System.out.println("True");
				        System.out.println(aktualna_pozicia_X +"_"+ nova_pozicia_X);
				        System.out.println(aktualna_pozicia_Y +"_"+ nova_pozicia_Y);
				        nova_pozicia_X = aktualna_pozicia_X;
		            	break;
		            }
		        }
            	aktualna_pozicia_X = nova_pozicia_X;
            	hrac.setLayoutX(aktualna_pozicia_X);

				break;
			case RIGHT:
				hrac.setImage(PLAYERdoprava);
				nova_pozicia_X = aktualna_pozicia_X + sirka_snimku;
				
				List<ImageView> wallPositions1 = getWallPositions();
		        for (ImageView wall : wallPositions1) {
		            double wallX = wall.getLayoutX();
		            double wallY = wall.getLayoutY();
		            //System.out.println("Wall position - X: " + wallX + ", Y: " + wallY);
		            if((nova_pozicia_X == wallX) && (nova_pozicia_Y == wallY)) {
		            	hrac.setLayoutX(aktualna_pozicia_X);
		            	System.out.println("True");
				        System.out.println(aktualna_pozicia_X +"_"+ nova_pozicia_X);
				        System.out.println(aktualna_pozicia_Y +"_"+ nova_pozicia_Y);
				        nova_pozicia_X = aktualna_pozicia_X;
		            	break;
		            }
		        }
            	aktualna_pozicia_X = nova_pozicia_X;
            	hrac.setLayoutX(aktualna_pozicia_X);

				break;
				
			case UP:
				hrac.setImage(PLAYERhore);
				nova_pozicia_Y = aktualna_pozicia_Y - vyska_snimku;
				
				List<ImageView> wallPositions11 = getWallPositions();
		        for (ImageView wall : wallPositions11) {
		            double wallX = wall.getLayoutX();
		            double wallY = wall.getLayoutY();
		            //System.out.println("Wall position - X: " + wallX + ", Y: " + wallY);
		            if((nova_pozicia_X == wallX) && (nova_pozicia_Y == wallY)) {
		            	hrac.setLayoutY(aktualna_pozicia_Y);
		            	System.out.println("True");
				        System.out.println(aktualna_pozicia_X +"_"+ nova_pozicia_X);
				        System.out.println(aktualna_pozicia_Y +"_"+ nova_pozicia_Y);
				        nova_pozicia_Y = aktualna_pozicia_Y;
		            	break;
		            }
		        }
            	aktualna_pozicia_Y = nova_pozicia_Y;
            	hrac.setLayoutY(aktualna_pozicia_Y);

				break;
			case DOWN:
				hrac.setImage(PLAYERdole);
				nova_pozicia_Y = aktualna_pozicia_Y + sirka_snimku;
				
				List<ImageView> wallPositions111 = getWallPositions();
		        for (ImageView wall : wallPositions111) {
		            double wallX = wall.getLayoutX();
		            double wallY = wall.getLayoutY();
		            //System.out.println("Wall position - X: " + wallX + ", Y: " + wallY);
		            if((nova_pozicia_X == wallX) && (nova_pozicia_Y == wallY)) {
		            	hrac.setLayoutY(aktualna_pozicia_Y);
		            	System.out.println("True");
				        System.out.println(aktualna_pozicia_X +"_"+ nova_pozicia_X);
				        System.out.println(aktualna_pozicia_Y +"_"+ nova_pozicia_Y);
				        nova_pozicia_Y = aktualna_pozicia_Y;
		            	break;
		            }
		        }
            	aktualna_pozicia_Y = nova_pozicia_Y;
            	hrac.setLayoutY(aktualna_pozicia_Y);
//kkeb bolo casu
				break;
				
			}
		    }
		
		public List<ImageView> getWallPositions() {
		    return walls;
		}

		
		
		private void update() {
			
		}
		
		
		}



