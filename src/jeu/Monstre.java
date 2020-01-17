package jeu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Monstre extends Graphic{
	int score=20;

	public Monstre(Zone zone) {
		Image image=null;
		image = new Image("file:pics/helicopter.gif");
		corps =new ImageView(image);
		((ImageView) corps).setX(0);
		((ImageView) corps).setY(0);
		((ImageView) corps).setFitHeight(100);
		((ImageView) corps).setFitWidth(100);

		double x=zone.getX1()+(zone.getX2()-zone.getX1())*Math.random();
		double y=zone.getY1()+(zone.getY2()-zone.getY1())*Math.random();
		corps.setTranslateX(x);
		corps.setTranslateY(y);
	}
}
