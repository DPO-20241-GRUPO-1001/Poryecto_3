package interfaz;

import javax.swing.*;
import java.awt.*;

public class panelHistorialCompra {

    public static void updatePanel(JPanel panel) {
        panel.removeAll();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Este es el Panel de HistorialCompra", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        panel.revalidate();
        panel.repaint();
    }
}
