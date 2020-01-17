package jeu;

import java.util.ArrayList;
import java.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.security.auth.Refreshable;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.glass.events.KeyEvent;
import com.sun.prism.paint.Color;
import com.sun.xml.internal.ws.api.server.Container;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class programme extends Application{
	
	//INTERFACE
	private double width=800;
	private double hight=600;
	private Pane cont=new Pane();
	private static int a = 0;
	
	Line line=new Line(0, 200, width, 200);
	Zone zone1 =new Zone(0, 20, line.getEndX()-20, line.getEndY());
	Zone zone2 =new Zone(line.getStartX(), line.getStartY(), line.getEndX()-50, hight-50);
	Label score= new Label("score: "+a+" !");
	HBox scoreBar = new HBox();

	 private Player player=new Player(zone2);
	 private List<Monstre> monstres=new ArrayList<>(); 
	 private List<Beggar> beggars=new ArrayList<>();
	 private Arme arme = new Arme(player);
	 private List<Balle> balles=new ArrayList<>(); 
	
	//animation
	AnimationTimer anim= new AnimationTimer() {
		
		@Override
		public void handle(long now) {
			// TODO Auto-generated method stub
			RefreshCentent();
			
		}
	};

	EventHandler<javafx.scene.input.KeyEvent> event = event -> {
		// TODO Auto-generated method stub
		if(event.getCode()==KeyCode.X) {
			arme.rotateLeftt();

		}
	if(event.getCode()==KeyCode.W) {
			arme.rotateRight();
		}
	if(event.getCode()==KeyCode.SPACE) {
		   Balle balle=new Balle(arme);
		   balle.getCorps().setRotate(arme.getRotate()+90);
		   cont.getChildren().add(balle.getCorps());
		   balles.add(balle);
	}
	if(event.getCode()==KeyCode.LEFT && player.getCorps().getTranslateX()>(line.getStartX()+20) ) {
		player.getCorps().setTranslateX(player.getCorps().getTranslateX()-5);
		arme.attachToPlayer(player);
	}

	if(event.getCode()==KeyCode.RIGHT && player.getCorps().getTranslateX()<(width-20)) {
		player.getCorps().setTranslateX(player.getCorps().getTranslateX() + 5);
		arme.attachToPlayer(player);
	}

	};
	
	
	private void createContain() {
		
//		cont.getChildren().add(line);
		cont.getChildren().add(player.getCorps());
		cont.getChildren().add(arme.getCorps());
		cont.getChildren().add(arme.getSortie());
//		cont.getChildren().add(score);

//		score.setTranslateX(0);
//		score.setTranslateY(510);
		score.setStyle("-fx-text-fill: white;-fx-font-family: Consolas;-fx-font-size: 16;-fx-font-weight: bold");
		player.getCorps().setTranslateY(420);
		player.getCorps().setTranslateX(300);
	
	}
		
	private void RefreshCentent() {
		for(Balle balle:balles) {
			for(Monstre monstre:monstres) {
				if(balle.touch(monstre)) {
					cont.getChildren().removeAll(balle.getCorps(),monstre.getCorps());
					balle.setAlive(false);
					monstre.setAlive(false);
					a+=monstre.score;

					score.setText("Score : "+a+"!");
				}
			}

			for(Beggar monster:beggars) {
				if(balle.touch(monster)) {
					cont.getChildren().removeAll(balle.getCorps(),monster.getCorps());
					balle.setAlive(false);
					monster.setAlive(false);
					a+=monster.score;

					score.setText("Score : "+a);
				}
			}
		}
		balles.removeIf(Graphic::isDead);
		monstres.removeIf(Graphic::isDead);
		beggars.removeIf(Graphic::isDead);
		for(Balle balle:balles) {
			balle.update();
		}
		if(Math.random()<0.01) {
		Monstre monstre =new Monstre(zone1);
		cont.getChildren().add(monstre.getCorps());
		monstres.add(monstre);
		}
		if(Math.random()<0.01){
			Beggar beggar = new Beggar(zone1);
			cont.getChildren().add(beggar.getCorps());
			beggars.add(beggar);
		}
	}
	
	
	
	@Override
	public void start(Stage window) throws Exception {
		window.setWidth(width);
		window.setHeight(hight);
		window.setTitle("Mon jeu de guerre");
		Image image = new Image("file:pics/bg.gif");
		
		ImageView mv = new ImageView(image);
		mv.setImage(image);
		mv.setFitHeight(hight);
		mv.setFitWidth(width);
		cont.getChildren().add(mv);

		scoreBar.setTranslateX(0);
		scoreBar.setTranslateY(0);
		scoreBar.setStyle("-fx-background-color: black");
		scoreBar.getStyleClass().add("scoreBar");
		scoreBar.getChildren().add(score);
		scoreBar.setPrefHeight(20);
		scoreBar.setPrefWidth(width);
		cont.getChildren().add(scoreBar);
		createContain();
		
		Scene scene=new Scene(cont);
		window.setScene(scene);
		scene.getStylesheets().add("MyCss.css");

		anim.start();

		scene.setOnKeyPressed(event);
		window.show();

	
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
