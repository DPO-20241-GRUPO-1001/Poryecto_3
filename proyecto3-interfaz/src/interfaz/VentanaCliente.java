package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class VentanaCliente extends JFrame {
    private JPanel mainPanel;
    private JPanel buttonPanel;

    public VentanaCliente() 
    {
        setTitle("Ventana Cliente");
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
        gridPanel.setLayout(new GridLayout(5, 1)); 
        buttonPanel.add(gridPanel, BorderLayout.CENTER);;
        
        
        JButton button1 = new JButton("Consultar Historial Pieza");
        button1.setPreferredSize(new Dimension(200, 100));
        button1.addActionListener(new ButtonClickListener(1));
        gridPanel.add(button1);
        
        JButton button2 = new JButton("Consultar Historial Compra");
        button2.setPreferredSize(new Dimension(200, 100));
        button2.addActionListener(new ButtonClickListener(2));
        gridPanel.add(button2);
        
        JButton button3 = new JButton("Consultar Historial Propiedad");
        button3.setPreferredSize(new Dimension(200, 100));
        button3.addActionListener(new ButtonClickListener(3));
        gridPanel.add(button3);
        
        JButton button4 = new JButton("Consultar Pieza");
        button4.setPreferredSize(new Dimension(200, 100));
        button4.addActionListener(new ButtonClickListener(4));
        gridPanel.add(button4);
        
        JButton button5 = new JButton("Consultar Ofertar Pieza");
        button5.setPreferredSize(new Dimension(200, 100));
        button5.addActionListener(new ButtonClickListener(5));
        gridPanel.add(button5);
                

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
                    PanelHistorialPieza.updatePanel(mainPanel);
                    break;
                case 2:
                	PanelHistorialCompra.updatePanel(mainPanel);
                    break;
                case 3:
                	PanelConsultarPieza.updatePanel(mainPanel);
                    break;
                case 4:
                	PanelPiezasSubastadas.updatePanel(mainPanel);
                    break;
                case 5:
                	PanelRegistrarUsuarios.updatePanel(mainPanel);
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
                new VentanaCliente().setVisible(true);
            }
        });
    }
}
