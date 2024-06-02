package uniandes.dpoo.taller7.interfaz3;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import uniandes.dpoo.taller7.modelo.Tablero;

@SuppressWarnings("serial")
public class InterfazLightsOut extends JFrame 
{
    private PanelSuperior panelSuperior;
    private PanelDerecho panelDerecho;
    private PanelInferior panelInferior;

    private PanelLightsOut panelTablero;
    private int tama�oActual;
    private int dificultadActual;

    public InterfazLightsOut() {
        setTitle("Juego Lights Out");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 700);
        setVisible(true);
        setResizable(true);

        setLayout(new BorderLayout());
        
        tama�oActual = 4; // Tama�o por defecto
        dificultadActual = 10;
        inicializarTablero(tama�oActual,dificultadActual);

        panelSuperior = new PanelSuperior(e -> {
            String tama�oSeleccionado = panelSuperior.getTama�oSeleccionado();
            int tama�o = Integer.parseInt(tama�oSeleccionado.split("x")[0]);
            int dificultad = panelSuperior.getDificultad();
            inicializarTablero(tama�o,dificultad);
        });

        panelSuperior.setVisible(true);
        add(panelSuperior, BorderLayout.NORTH);

        panelDerecho = new PanelDerecho();
        panelDerecho.setVisible(true);
        add(panelDerecho, BorderLayout.EAST);

        panelInferior = new PanelInferior();
        panelInferior.setVisible(true);
        add(panelInferior, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializarTablero(int tama�o, int dificultad) {
        if (panelTablero != null) {
            remove(panelTablero);
        }
        Tablero tablero = new Tablero(tama�o);
        tablero.desordenar(dificultad); // Dificultad seleccionada
        panelTablero = new PanelLightsOut(tama�o, dificultad);
        add(panelTablero, BorderLayout.CENTER);
        pack();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazLightsOut());
    }
}



