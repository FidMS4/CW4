package Model;

public abstract class Shape {

	private int x, y;

	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
