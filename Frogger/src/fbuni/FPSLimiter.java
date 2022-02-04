//ESTE ARQUIVO CONTÉM CÓDIGO DE TERCEIROS, NESCESSÁRIO PARA PERMITIR EXECUÇÃO SUAVE DO JOGO
//(TAXA DE QUADROS ILIMITADA CAUSAVA PROBLEMAS DE DESEMPENHO)

package fbuni;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class FPSLimiter implements ActionListener {
	private final Timer resetTimer = new Timer(1000, this);
    private long previousFrameTime;
    private int current, last = -1;

    public FPSLimiter() {
        resetTimer.start();
    }

    public void draw(Graphics g) {
        ++current;
        //g.setColor(Color.GRAY);
        //g.drawString(String.format("FPS: %s", last), 25, 50);

        // limit fps to 60
        long limit = (long) 1e9 / 60;
        long delta = System.nanoTime() - previousFrameTime;

        if (delta < limit) {
            try {
                Thread.sleep((long) ((limit - delta) / 1e6));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        previousFrameTime = System.nanoTime();
    }

    @Override
    public synchronized void actionPerformed(final ActionEvent e) {
        last = current;
        current = 0;
    }

}
