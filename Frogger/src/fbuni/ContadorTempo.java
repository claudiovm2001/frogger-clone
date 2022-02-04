//CÓDIGO AUTORAL ABAIXO:

package fbuni;

//import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Graphics;

public class ContadorTempo implements Runnable{
	
	private Thread t = new Thread(this);
	
	private String s;
	
	private int i;
	
	public ContadorTempo() {
		/*label_tempo.setSize(400, 300);
		label_tempo.setBounds(200, 150, 400, 300);*/
		i = 60;
		t.start();
	}
	
	/*public void metodo() throws TempoException{
		if (cont == 0) {
			throw new TempoException();
		}
	}*/
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		
		while (true) {
			
			//Passar o tempo e reduzir o tempo restante
			while (i>0) {
			s = ("TEMPO: "+i);
			//System.out.println("TEMPO: "+cont);
			try {
				t.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			--i;
			}
		
			//tempo = "TEMPO ESGOTADO!";
		
			try {
				throw new TempoException();
			}catch (TempoException e) {
				Principal.t.timerZerado();
				this.i = 60;
				//System.out.println("TempoException capturada!");
			}
		}
		
		
		
		//System.out.println("TEMPO ESGOTADO!");
	}
	
	public void desenhar(Graphics g) {
		g.setColor(Color.RED);
		g.drawString(String.format(s), 10, 590);
	}
	
	public void setI(int i) {
		this.i = i;
	}
}
