package fbuni;

import java.awt.Color;
import java.awt.Graphics;

public class ContadorPontos implements Runnable {
	
	private Thread t = new Thread(this);
	
	private String sPontos;
	private String sRecorde;
	private int pontos;
	private int recorde;// = 0;
	
	public ContadorPontos() {
		pontos = 0;
		recorde = 0;
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			sPontos = ("PONTOS: "+pontos);
			sRecorde = ("RECORDE :"+recorde);			
			
			Principal.t.sucesso();
		}
	}
	
	public void desenhar(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawString(String.format(sPontos), 10, 60);
		g.drawString(String.format(sRecorde), 10, 70);
	}
	
	public int getRecorde() {
		return recorde;
	}
	
	public void setRecorde(int i) {
		recorde = i;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public void setPontos(int i) {
		pontos = i;
	}
}
