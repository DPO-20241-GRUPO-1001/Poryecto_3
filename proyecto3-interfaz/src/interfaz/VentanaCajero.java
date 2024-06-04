package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCajero extends JFrame 
{
    private JPanel mainPanel;
    private JPanel buttonPanel;

    public VentanaCajero() {
        setTitle("Ventana Cajero");
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
        gridPanel.setLayout(new GridLayout(6, 1)); 
        buttonPanel.add(gridPanel, BorderLayout.CENTER);;
        
        
        JButton button1 = new JButton("Registrar Pieza");
        button1.setPreferredSize(new Dimension(200, 100));
        button1.addActionListener(new ButtonClickListener(1));
        gridPanel.add(button1);
        
   

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
                    PanelRegistrarPieza.updatePanel(mainPanel);
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
                new VentanaCajero().setVisible(true);
            }
        });
    }
}
