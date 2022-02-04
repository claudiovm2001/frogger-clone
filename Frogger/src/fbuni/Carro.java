//CÓDIGO AUTORAL ABAIXO:

package fbuni;

//ESTA CLASSE FOI CRIADA AQUI APENAS COMO EXEMPLO. O ALUNO DEVE SUBSTITUI-LA POR OUTRA CLASSE CONFORME O PROJETO.
public class Carro extends DesenhoAnimado {
	
	private Thread t = new Thread(this);
	
	//public int modelo = 0;
	
	private int intervalo;
	
	private int direcao;
	
	private int loopStatus = 0;

	public Carro() {}
	
	public Carro(int x, int y, String path, int modelo) {
		super(x, y, path);
		
		//diferentes atributos para diferentes tipos de carro:
		switch (modelo) {
			case 0:
				this.setImg("carro_vermelho.png");
				intervalo = 1;
				direcao = 1;
				break;
				
			case 1:
				this.setImg("carro_verde.png");
				intervalo = 3;
				direcao = -1;
				break;
				
			case 2:
				this.setImg("carro_azul.png");
				intervalo = 9;
				direcao = 1;
		}
		
		t.start();
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while(true) {
			
			//Carros devem se mover na direção que seu parachoque aponta:
			if (direcao == 1) {
				if (this.getX()>800) {
					this.setX(-102);
				}
				
				this.setX(this.getX() + 1);
				
				try {
					t.sleep(intervalo);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (direcao == -1) {
				if (this.getX()<(-102)) {
					this.setX(800);
				}
				
				this.setX(this.getX() - 1);
				
				try {
					t.sleep(intervalo);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			switch(loopStatus) {
			case 0:
				this.setY(this.getY() + 1);
				break;
			case 1:
				this.setY(this.getY() + 1);
				break;
			case 2:
				this.setY(this.getY() - 1);
				break;
			case 3:
				this.setY(this.getY() - 1);
				break;
			case 4:
				this.setY(this.getY() - 1);
				break;
			case 5:
				this.setY(this.getY() - 1);
				break;
			case 6:
				this.setY(this.getY() + 1);
				break;
			case 7:
				this.setY(this.getY() + 1);
				break;
		}
		
		try {
			t.sleep(intervalo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		loopStatus++;
		if(loopStatus == 8) loopStatus = 0;
			
		}
			
			
	}
}
