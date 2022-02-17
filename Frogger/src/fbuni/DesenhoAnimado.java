package fbuni;

public abstract class DesenhoAnimado extends Desenho implements Runnable {

	public DesenhoAnimado() {}
	
	public DesenhoAnimado(int x, int y, String path) {
		super(x, y, path);
	}

}
