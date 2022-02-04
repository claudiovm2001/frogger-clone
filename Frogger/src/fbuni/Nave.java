package fbuni;

//ESTA CLASSE FOI CRIADA AQUI APENAS COMO EXEMPLO. O ALUNO DEVE SUBSTITUI-LA POR OUTRA CLASSE CONFORME O PROJETO.
public class Nave extends DesenhoMovel implements Runnable {

	private Thread t = new Thread (this);
	
	
	
	public Nave() {}
	
	public Nave(int x, int y, String path) {
		super(x, y, path);
		t.start();
	}
	
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
	
	public void run() {
		while (true) {
			Principal.t.colisao();	
			if (this.getY() < 50) {
				Principal.t.sucesso();
			}
		}
	}
}
