package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPiezasSubastadas {

    public static void updatePanel(JPanel panel) {
        panel.removeAll();

        panel.setLayout(new GridBagLayout());
        
        JLabel label = new JLabel("Ingrese el Código de Registro de la Pieza:");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Buscar");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.anchor = GridBagConstraints.CENTER;


        panel.add(label, gbc);
        panel.add(textField, gbc);
        panel.add(button, gbc);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textField.getText();
            }
        });
        panel.revalidate();
        panel.repaint();
    }
}
