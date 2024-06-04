package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class VentanaAdmin extends JFrame {
    private JPanel mainPanel;
    private JPanel btnPanel;

    public VentanaAdmin() {
        setTitle("Ventana Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        add(mainPanel, BorderLayout.CENTER);

        
        btnPanel = new JPanel();
        btnPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("MENU", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        btnPanel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(7, 1)); 
        btnPanel.add(gridPanel, BorderLayout.CENTER);;
        
        
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
        

        add(btnPanel, BorderLayout.WEST);
    }
    
    private class ButtonClickListener implements ActionListener {
        private int indexBtn;

        public ButtonClickListener(int buttonIndex) {
            this.indexBtn = buttonIndex;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (indexBtn) {
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
                case 6:
                	PanelAprobarOfertas.updatePanel(mainPanel);
                    break;
                case 7:
                	PanelHistorialPieza.updatePanel(mainPanel);
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
                new VentanaAdmin().setVisible(true);
            }
        });
    }
}