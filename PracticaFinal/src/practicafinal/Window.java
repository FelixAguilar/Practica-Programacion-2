package practicafinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 *
 * @author Felix
 */
public class Window extends JFrame{
    
    static CirclePanel cp;
    
    //Tamaño de la venta.
        // Obtenemos herramientas necesarias para comunicarnos con el sistema donde se ejecuta la ventana.
        // Creamos un objeto Dimension con el tamaño de nuestra pantalla
        Toolkit myScreen = Toolkit.getDefaultToolkit(); 
        Dimension screenSize = myScreen.getScreenSize(); 
        
        // Guardamos las constantes que se han registrado en el objeto Dimension.
        int screenHeight = screenSize.height; 
        int screenWidth = screenSize.width;
    
    
    public String title = "Balls Simulation"; //Titulo de la ventana.
    public Font font = new Font("serif", Font.BOLD, 20); //Fuentes a utilizar.
    
    //Constructor de la ventana.
    public Window(){
        
        this.setTitle(title);
        this.setSize(screenWidth/2,screenHeight/2);
        this.setLocation(screenWidth/4, screenHeight/4);
        this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        this.initContents();
    }
    
    private void initContents(){
        
        //Creación del Layout principal.
        JPanel window = (JPanel) getContentPane();
        
        //Creación del menú.
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setBackground(Color.LIGHT_GRAY);
        
        //Creación de la etiqueta. 
        JLabel label = new JLabel();
        label.setText("# Balls");
        label.setFont(font);
        menu.add(label);
        
        //Creación del cuadro de texto.
        JTextField textField = new JTextField();
        textField.setText("2"); 
        textField.selectAll();
        textField.setFont(font);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        menu.add(textField);
        
        //Creación de las CheckBox.
        JCheckBox walls = new JCheckBox("With Walls");
        walls.setBackground(Color.LIGHT_GRAY);
        menu.add(walls);
        
        JCheckBox follow = new JCheckBox("Follow Mouse");
        follow.setBackground(Color.LIGHT_GRAY);
        menu.add(follow);
        
        //Creación de la zona lateral.
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(Color.LIGHT_GRAY);
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        sidePanel.add(menu, BorderLayout.CENTER);
        
        //Adición de componentes a la pantalla.
        cp = new CirclePanel(); //Instanciación del panel de círculos.
        window.add(cp, BorderLayout.CENTER);
        window.add(sidePanel, BorderLayout.LINE_END);
        
        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                cp.setBallscollection(cp.resize(textField.getText()));
            }
        });
        
        follow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                cp.checkFollow = follow.isSelected();
            }
        });
        
        walls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                cp.checkWalls = walls.isSelected();
            }
        });
        
    }
    
    public static void main(String[] args)  {
        
        new Window().setVisible(true);
        try {
            cp.infiniteLoop(); //Inicio movimiento círculos.
        } catch (InterruptedException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
