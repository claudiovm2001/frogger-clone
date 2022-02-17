package fbuni;

public class DesenhoMovel extends Desenho {
	
	public DesenhoMovel() {}
	
	public DesenhoMovel(int x, int y, String path) {
		super(x, y, path);
	}
	
	public void moverDireita() throws PosicaoException {
		
		this.setX(this.getX() + 2);
	}
	
	public void moverEsquerda() throws PosicaoException {
		this.setX(this.getX() - 2);
	}
}
