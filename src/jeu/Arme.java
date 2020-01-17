package jeu;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Arme {
	private Rectangle corps =new Rectangle(20,10,10,20);
	private Circle sortie =new Circle(20,10,5);
	
	public Rectangle getCorps() {
		return corps;
	}

	public void setCorps(Rectangle corps) {
		this.corps = corps;
	}

	public Circle getSortie() {
		return sortie;
	}

	public void setSortie(Circle sortie) {
		this.sortie = sortie;
	}

	public Arme(Graphic player) {
		corps.setTranslateX(player.getCorps().getTranslateX());
		corps.setTranslateY(player.getCorps().getTranslateY());
		
		corps.setFill(Color.TRANSPARENT);
		sortie.setFill(Color.TRANSPARENT);
		updateSortie();
	}
	
public void attachToPlayer(Player player) {
	corps.setTranslateX(player.getCorps().getTranslateX()+45);
	corps.setTranslateY(player.getCorps().getTranslateY()+5);
	updateSortie();

}

public void updateSortie() {
	sortie.setTranslateX(corps.getTranslateX());
	sortie.setTranslateY(corps.getTranslateY());
	
}
public void rotateRight() {
	corps.setRotate(corps.getRotate()-5);
}

public void rotateLeftt() {
	corps.setRotate(corps.getRotate()+5);
}

public double getRotate() {
	return corps.getRotate()-90;
}
}
