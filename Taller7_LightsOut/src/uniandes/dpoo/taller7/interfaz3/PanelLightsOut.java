package uniandes.dpoo.taller7.interfaz3;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.Tablero;

@SuppressWarnings("serial")
public class PanelLightsOut extends JPanel
{
	public static ButtonLights[][] botones;
    private Tablero tablero;

    public PanelLightsOut(int tama�o, int dificultad) {
        tablero = new Tablero(tama�o);
        tablero.desordenar(dificultad); // Desordenar con la dificultad especificada
        setLayout(new GridLayout(tama�o, tama�o));
        botones = new ButtonLights[tama�o][tama�o];

        for (int i = 0; i < tama�o; i++) {
            for (int j = 0; j < tama�o; j++) {
                botones[i][j] = new ButtonLights(i, j, tablero);
                add(botones[i][j]);
            }
        }
    }

    public static ButtonLights[][] getBotones() {
        return botones;
    }

    public void actualizarTablero() {
        for (int i = 0; i < PanelLightsOut.getBotones().length; i++) {
            for (int j = 0; j < PanelLightsOut.getBotones()[i].length; j++) {
                PanelLightsOut.getBotones()[i][j].repaint();
            }
        }
        if (tablero.tableroIluminado()) {
            JOptionPane.showMessageDialog(null, "�Felicidades! Has iluminado todas las luces.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
