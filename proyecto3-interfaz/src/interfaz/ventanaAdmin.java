package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaAdmin extends JFrame {
    private JPanel mainPanel;
    private JPanel buttonPanel;

    public ventanaAdmin() {
        setTitle("Ventana Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        add(mainPanel, BorderLayout.CENTER);

        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("MENU", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        buttonPanel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(7, 1)); 
        buttonPanel.add(gridPanel, BorderLayout.CENTER);;
        
        
        JButton button1 = new JButton("Consultar Historial Pieza");
        button1.setPreferredSize(new Dimension(200, 100));
        button1.addActionListener(new ButtonClickListener(1));
        gridPanel.add(button1);
        
        JButton button2 = new JButton("Consultar Historial Compra");
        button2.setPreferredSize(new Dimension(200, 100));
        button2.addActionListener(new ButtonClickListener(2));
        gridPanel.add(button2);
        
        JButton button3 = new JButton("Consultar Pieza");
        button3.setPreferredSize(new Dimension(200, 100));
        button3.addActionListener(new ButtonClickListener(3));
        gridPanel.add(button3);
        
        JButton button4 = new JButton("Consultar Ofertar Pieza");
        button4.setPreferredSize(new Dimension(200, 100));
        button4.addActionListener(new ButtonClickListener(4));
        gridPanel.add(button4);
        
        JButton button5 = new JButton("Registrar Usuario");
        button5.setPreferredSize(new Dimension(200, 100));
        button5.addActionListener(new ButtonClickListener(5));
        gridPanel.add(button5);
        
        JButton button6 = new JButton("Verificar Ofertas");
        button6.setPreferredSize(new Dimension(200, 100));
        button6.addActionListener(new ButtonClickListener(6));
        gridPanel.add(button6);

        JButton button7 = new JButton("Registrar Pieza");
        button7.setPreferredSize(new Dimension(200, 100));
        button7.addActionListener(new ButtonClickListener(7));
        gridPanel.add(button7);
        

        add(buttonPanel, BorderLayout.WEST);
    }
    
    private class ButtonClickListener implements ActionListener {
        private int buttonIndex;

        public ButtonClickListener(int buttonIndex) {
            this.buttonIndex = buttonIndex;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (buttonIndex) {
                case 1:
                    panelHistorialPieza.updatePanel(mainPanel);
                    break;
                case 2:
                	panelHistorialCompra.updatePanel(mainPanel);
                    break;
                case 3:
                	panelConsultarPieza.updatePanel(mainPanel);
                    break;
                case 4:
                	panelOfertaPieza.updatePanel(mainPanel);
                    break;
                case 5:
                	panelRegistrarUsuarios.updatePanel(mainPanel);
                    break;
                case 6:
                	panelVerificarOfertas.updatePanel(mainPanel);
                    break;
                case 7:
                	panelHistorialPieza.updatePanel(mainPanel);
                    break;    
                default:
                    break;
            }
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ventanaAdmin().setVisible(true);
            }
        });
    }
}