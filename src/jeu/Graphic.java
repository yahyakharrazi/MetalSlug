package jeu;

import javafx.scene.Node;

public class Graphic {
	protected Node corps;
	private boolean alive=true;

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Node getCorps() {
		return corps;
	}

	public void setCorps(Node corps) {
		this.corps = corps;
	}
	public boolean touch(Graphic obj) {
		return corps.getBoundsInParent().intersects(obj.getCorps().getBoundsInParent());
	}
	public boolean isDead() {
		return !alive;
	}

}
