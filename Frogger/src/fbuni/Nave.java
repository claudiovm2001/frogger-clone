//CÓDIGO AUTORAL ABAIXO:

package fbuni;

public class Nave extends DesenhoMovel implements Runnable {

	private Thread t = new Thread (this);
	
	
	
	public Nave() {}
	
	public Nave(int x, int y, String path) {
		super(x, y, path);
		t.start();
	}
	
	//MOVIMENTAR SAPO (e aplicar limites de borda de tela):
	public void moverDireita() throws PosicaoException {
		this.setX(this.getX() + 10);
		
		if (this.getX() > 740) {
			throw new PosicaoException();
		}
	}
	public void moverEsquerda() throws PosicaoException {
		this.setX(this.getX() - 10);
		
		if (this.getX() < 0) {
			throw new PosicaoException();
		}
	}
	public void moverCima() throws PosicaoException {
		this.setY(this.getY() - 10);
		
		if (this.getY() < 35) {
			throw new PosicaoException();
		}
	}
	public void moverBaixo() throws PosicaoException {
		this.setY(this.getY() + 10);
		
		if (this.getY() > 550) {
			throw new PosicaoException();
		}
	}
	
	//Este código esta sempre em execução e verifica ocorrência de 'colisão' ou 'sucesso'
	public void run() {
		while (true) {
			Principal.t.colisao();	
			if (this.getY() < 50) {
				Principal.t.sucesso();
			}
		}
	}
}
