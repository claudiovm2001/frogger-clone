package fbuni;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;


//ESTA CLASSE DEVE SE OBRIGATORIAMENTE MANTIDA NO PROJETO. QUALQUER ALTERA��O REALIZADA DEVE OBEDECER A HIERARQUIA
public class Principal extends JFrame implements KeyListener {
	
	static Principal t = new Principal();
	//public static Principal p = new Principal();

	private fbuni.Desenho espaco;
	private Nave nave;
	
	private FPSLimiter fpsCounterLimiter = new FPSLimiter();
	private static final long serialVersionUID = 1L;
	
	private ContadorTempo contadorTempo;
	private Carro carro1, carro2, carro3, carro4, carro5, carro6;	
	
	private Arquivo arquivo;
	//private int c;
	
	private ContadorPontos contadorPontos;

	public Principal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Desenhando a tela e seus elementos
		espaco = new Desenho(0,0,"fundo.jpg");
		nave = new Nave(400,525,"sapo.png");
		
		
		carro1 = new Carro (-100, 125, "carro.png", 0);
		
		carro2 = new Carro (800, 275, "carro.png", 1);
		carro4 = new Carro (400, 275, "carro.png", 1);
		
		carro3 = new Carro (80, 425, "carro.png", 2);
		carro5 = new Carro (350, 425, "carro.png", 2);
		carro6 = new Carro (620, 425, "carro.png", 2);
		
		
		contadorTempo = new ContadorTempo();
		contadorPontos = new ContadorPontos();
		//Adicionando o evento de teclado
		this.addKeyListener(this);
		
		arquivo = new Arquivo();
		/*
		try {
			arquivo.gravarArquivo(9999);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		int i = 0;
		
		try {
			//arquivo.gravarArquivo(0);
			i = arquivo.lerArquivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		contadorPontos.setRecorde(i);
		//contadorPontos.recorde = i;
	}
	
	//EVITAR ALTERAR ESSE M�TODO
	public static void main(String[] args) {
		//Criando uma inst�ncia da classe principal
		//t = new Principal();
		
		
		t.setSize(800, 600);
		
		t.createBufferStrategy(1);		
		t.setVisible(true);
		t.createBufferStrategy(2);
		
	
	}

	//EVITAR ALTERAR ESSE M�TODO
	@Override
	public void paint(Graphics ignore) {
		BufferStrategy strategy = getBufferStrategy();
		do {
			do {
				Graphics graphics = strategy.getDrawGraphics();
				renderizarImagens(graphics);
				graphics.dispose();
			} while (strategy.contentsRestored());
			strategy.show();
		} while (strategy.contentsLost());
		repaint();
	}
	
	//ESSE � O M�TODO QUE DEVE SER ADAPTADO AO PROJETO
	public void renderizarImagens(Graphics g2) {
		//Desenhando as imagens
		espaco.desenhar(g2);
		nave.desenhar(g2);
		
		carro1.desenhar(g2);
		carro2.desenhar(g2);
		carro3.desenhar(g2);
		
		carro4.desenhar(g2);
		carro5.desenhar(g2);
		carro6.desenhar(g2);
		
		fpsCounterLimiter.draw(g2);
		
		contadorTempo.desenhar(g2);
		contadorPontos.desenhar(g2);
	}
	

	public void keyPressed(KeyEvent evt) {
		//Especificando o comportamento das teclas
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT){
        	try {
        		nave.moverDireita();
        	}catch (PosicaoException e) {
        		nave.setX(nave.getX()-10);
        	}
        	
        	repaint();
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT){
        	try {
        		nave.moverEsquerda();
        	}catch (PosicaoException e) {
        		nave.setX(nave.getX()+10);
        	}
      
        	repaint();
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_UP){
        	try {
        		nave.moverCima();
        	}catch (PosicaoException e) {
        		nave.setY(nave.getY()+10);
        	}
        	
        	repaint();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN){
        	try {
        		nave.moverBaixo();
        	}catch (PosicaoException e){
        		nave.setY(nave.getY()-10);
        	}
        	
        	repaint();
        }
    }

	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	
	public void timerZerado() {
		nave.setX(400);
		nave.setY(525);
		
		contadorPontos.setPontos(0);
		//contadorPontos.pontos = 0;
	}
	
	public void sucesso() {
		if (nave.getY() < 50) {
			
			nave.setX(400);
			nave.setY(525);
			
			contadorPontos.setPontos(contadorPontos.getPontos() + 1);
			//++contadorPontos.pontos;
			
			contadorTempo.setI(60);
			//contadorTempo.i = 60;
			
			int i, i2;
			
			i = contadorPontos.getPontos();
			i2 = contadorPontos.getRecorde();
			
			if (i > i2) {
				contadorPontos.setRecorde(i);
				//contadorPontos.recorde = contadorPontos.pontos;
				try {
					arquivo.gravarArquivo(i);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
		
	}
	
	/*
	public void metodo() {
		if (nave.getY() < 50) {
			
			nave.setX(400);
			nave.setY(525);
			
			++contadorPontos.cont;
			try {
				arquivo.gravarArquivo(contadorPontos.cont);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	*/
	
	
	public void colisao() {
		System.out.println();
		
		if (nave.getRectangle().intersects(carro1.getRectangle()) ||
			nave.getRectangle().intersects(carro2.getRectangle()) ||
			nave.getRectangle().intersects(carro3.getRectangle()) ||
			nave.getRectangle().intersects(carro4.getRectangle()) ||
			nave.getRectangle().intersects(carro5.getRectangle()) ||
			nave.getRectangle().intersects(carro6.getRectangle()) )  {
			
				nave.setX(400);
				nave.setY(525);
				
				contadorTempo.setI(60);
				contadorPontos.setPontos(0);
				
		}
	}
}
