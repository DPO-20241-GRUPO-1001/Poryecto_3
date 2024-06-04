package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import central.Galeria;

public class PanelRegistrarCliente {

	private static Galeria mundoGaleria;
	
    public static void updatePanel(JPanel panel, Galeria munGaleria) {
        panel.removeAll();
        
        mundoGaleria = munGaleria;
        panel.setLayout(new GridBagLayout());


        JLabel initialLabel = new JLabel("Registrar Cliente");
        
        JLabel label1= new JLabel("Nombre:");
        JTextField textField1 = new JTextField(20);
        
        JLabel label2= new JLabel("Identificación:");
        JTextField textField2 = new JTextField(20);
        
        JLabel label3= new JLabel("Teléfono:");
        JTextField textField3 = new JTextField(20);
        
        JLabel label4= new JLabel("Correo:");
        JTextField textField4 = new JTextField(20);
        
        JLabel label5= new JLabel("Login:");
        JTextField textField5 = new JTextField(20);
        
        JLabel label6= new JLabel("Contraseña:");
        JTextField textField6 = new JTextField(20);
        
        JLabel label7= new JLabel("Ingreso:");
        JTextField textField7 = new JTextField(20);
        
        JLabel label8= new JLabel("Limite de Compra:");
        JTextField textField8 = new JTextField(20);
        
      
        JButton button = new JButton("Registrar");
       
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 
        gbc.anchor = GridBagConstraints.CENTER;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(initialLabel, gbc);
        gbc.gridwidth = 1;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(label1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(textField1, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(label2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(textField2, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(label3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(textField3, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(label4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(textField4, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(label5, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(textField5, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(label6, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(textField6, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(label7, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(textField7, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(label8, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(textField8, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        panel.add(button, gbc);



        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            	String nombre = textField1.getText();
            	int identificacion = Integer.parseInt(textField2.getText());
            	int telefono = Integer.parseInt(textField3.getText());
            	String correo = textField4.getText();
            	String login = textField5.getText();
            	String contraseña = textField6.getText();
            	double ingreso = Double.parseDouble(textField7.getText());
            	double limite_compra = Double.parseDouble(textField8.getText());
            	
           
            	mundoGaleria.registrarCliente(nombre,identificacion,telefono,correo,login,contraseña,ingreso, limite_compra);
            	
            }
        });

        panel.revalidate();
        panel.repaint();
    }
}
