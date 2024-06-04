package interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelHistorialPieza {

    public static void updatePanel(JPanel panel) {
        panel.removeAll();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Este es el Panel de Historial Piezas", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        panel.revalidate();
        panel.repaint();
    }
}
