package jeu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Beggar extends Graphic{
	int score=-20;

	public Beggar(Zone zone) {
	Image image=null;
	image = new Image("file:pics/alien.png");
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
