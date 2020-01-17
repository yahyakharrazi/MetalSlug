package jeu;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Balle extends Graphic{
	private Point2D direction = new Point2D(0, 0);

	public Balle(Arme arme) {
		corps=new ImageView(new Image("file:pics/weapon.png"));
		corps.setTranslateX(arme.getSortie().getTranslateX());
		corps.setTranslateY(arme.getSortie().getTranslateY());
		updateDirection(arme.getRotate());
	}

	private void updateDirection(double rotation) {
			Point2D p;
			double x=Math.cos(Math.toRadians(rotation));
			double y=Math.sin(Math.toRadians(rotation));
			p=new Point2D(x,y);
			direction=p.normalize().multiply(7);
	}

	public void update() {
		corps.setTranslateY(corps.getTranslateY()+direction.getY());
		corps.setTranslateX(corps.getTranslateX()+direction.getX());
	}
	public void rotateRight() {
		corps.setRotate(corps.getRotate()-5);
	}

	public void rotateLeftt() {
		corps.setRotate(corps.getRotate()+5);
	}
}