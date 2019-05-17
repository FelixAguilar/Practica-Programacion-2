/**
 * @author Felix Lluis Aguilar Ferrer.
 * @author Adrián Bennasar Polzin.
 */

package practicafinal;

import exceptions.DivisionByZero;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Programa principal.
 * 
 */
public class Window extends JFrame{
    
    //Atributos de la ventana.
    private CirclePanel circlePanel;
    private JTextField textField;
    
    /*Tamaño de la ventana. Obtenemos herramientas necesarias para comunicarnos 
    con el sistema donde se ejecuta la ventana. Creamos un objeto Dimension con 
    el tamaño de nuestra pantalla.*/
    Toolkit myScreen = Toolkit.getDefaultToolkit(); 
    Dimension screenSize = myScreen.getScreenSize(); 
        
    //Guardamos las constantes que se han registrado en el objeto Dimension.
    int screenHeight = screenSize.height; 
    int screenWidth = screenSize.width;
    
    //Constantes del menú.
    private final String TITLE = "Balls Simulation";
    private final String LABEL = "# Balls";
    private final String TEXT = "2";
    private final String WALLS = "With Walls";
    private final String FOLLOW = "Follow";
    private final Font FONT = new Font("serif", Font.BOLD, 20);
    
    /**
     * Constructor de la ventana.
     */
    public Window(){
        setTitle(TITLE);
        setSize(screenWidth/2,screenHeight/2);
        setLocation(screenWidth/4, screenHeight/4);
        setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        initContents();
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
        label.setText(LABEL);
        label.setFont(FONT);
        menu.add(label);
        
        //Creación del cuadro de texto.
        textField = new JTextField();
        textField.setText(TEXT); 
        textField.selectAll();
        textField.setFont(FONT);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        menu.add(textField);
        
        //Creación de las CheckBox.
        JCheckBox walls = new JCheckBox(WALLS);
        walls.setBackground(Color.LIGHT_GRAY);
        menu.add(walls);
        
        JCheckBox follow = new JCheckBox(FOLLOW);
        follow.setBackground(Color.LIGHT_GRAY);
        menu.add(follow);
        
        //Creación de la zona lateral.
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(Color.LIGHT_GRAY);
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        sidePanel.add(menu, BorderLayout.CENTER);
        
        //Adición de componentes a la pantalla.
        circlePanel = new CirclePanel();
        window.add(circlePanel, BorderLayout.CENTER);
        window.add(sidePanel, BorderLayout.LINE_END);
        
        //Escuchadores de eventos.
        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                int n = Integer.parseInt((textField.getText()));
                circlePanel.resizeBallsCollection(n);
            }
        });
        
        follow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
               circlePanel.setFollow(follow.isSelected());
            }
        });
        
        walls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                circlePanel.setWalls(walls.isSelected());
            }
        });
        
    }
    
    /**
     * Método de Inicio no static.
     * 
     * @throws InterruptedException
     * @throws DivisionByZero 
     */
    public void start() throws InterruptedException, DivisionByZero{
        int n = Integer.parseInt((textField.getText()));
        circlePanel.resizeBallsCollection(n);
         
        //Inicio movimiento círculos.
        circlePanel.infiniteLoop();
    }
    
    public static void main(String[] args)  {
        
        Window w = new Window();
        try {
           w.setVisible(true);
           w.start();
        } catch (InterruptedException | DivisionByZero ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
