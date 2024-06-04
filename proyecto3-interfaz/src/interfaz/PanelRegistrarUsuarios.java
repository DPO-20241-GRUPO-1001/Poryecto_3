package interfaz;

import javax.swing.*;

import central.Galeria;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistrarUsuarios {

	private static Galeria mundoGaleria;
	
    public static void updatePanel(JPanel panel, Galeria munGaleria) {
        panel.removeAll();
        
        mundoGaleria = munGaleria;
        panel.setLayout(new GridBagLayout());
        JRadioButton option1 = new JRadioButton("Cliente");
        JRadioButton option2 = new JRadioButton("Empleado");
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);

        // Crear botón
        JButton button = new JButton("Siguiente");

        // Crear restricciones para centrar los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        // Añadir RadioButtons al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(option1, gbc);
        gbc.gridy = 1;
        panel.add(option2, gbc);

        // Añadir botón al panel
        gbc.gridy = 2;
        panel.add(button, gbc);

        // Añadir ActionListener al botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (option1.isSelected()) {
                	PanelRegistrarCliente.updatePanel(panel, mundoGaleria);
                } else if (option2.isSelected()) {
                	PanelRegistrarEmpleado.updatePanel(panel, mundoGaleria);
                } else {
                    JOptionPane.showMessageDialog(panel, "Please select an option.");
                }
            }
        });
        
        panel.revalidate();
        panel.repaint();
    }
}
