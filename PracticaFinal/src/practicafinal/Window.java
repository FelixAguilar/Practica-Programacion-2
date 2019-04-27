package practicafinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Felix
 */
public class Window extends JFrame{
    
    static CirclePanel cp;
    
    //Tamaño de la venta.
    
        Toolkit miPantalla = Toolkit.getDefaultToolkit(); // Obtenemos herramientas necesarias para comunicarnos con el sistema donde se ejecuta la ventana
        Dimension tamanoPantalla = miPantalla.getScreenSize(); // Creamos un objeto Dimension con el tamaño de nuestra pantalla
        
        int alturaPantalla = tamanoPantalla.height; // Guardamos las constantes que se han registrado en el objeto Dimension
        int anchoPantalla = tamanoPantalla.width;
    
    //Titulo de la ventana.
    public String title = "Balls Simulation";
    
    //Fuentes a utilizar.
    public Font f = new Font("serif", Font.BOLD, 20);
    
    //Constructor de la ventana.
    public Window(){
        
        this.setTitle(title);
        this.setSize(anchoPantalla/2,alturaPantalla/2);
        this.setLocation(anchoPantalla/4, alturaPantalla/4);
        this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        this.initContents();
    }
    
    private void initContents(){
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        
        
        //Cuadro de texto.
        JLabel info = new JLabel();
        info.setText("# Balls");
        info.setFont(f);
        menu.add(info);
        JTextField num = new JTextField();
        num.setText("2"); 
        num.selectAll();
        num.setFont(f);
        num.setHorizontalAlignment(SwingConstants.RIGHT);
        menu.add(num);
        menu.setBackground(Color.LIGHT_GRAY);
       
        
        //Los checkbox para modificar el programa.
        JCheckBox walls = new JCheckBox("With Walls");
        menu.add(walls);
        walls.setBackground(Color.LIGHT_GRAY);
        JCheckBox follow = new JCheckBox("Follow Mouse");
        menu.add(follow);
        follow.setBackground(Color.LIGHT_GRAY);        
        //Layout principal.
        JPanel screen = (JPanel) getContentPane();
        JPanel zone1 = new JPanel();
        zone1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        zone1.add(menu, BorderLayout.CENTER);
        zone1.setBackground(Color.LIGHT_GRAY);
        screen.add(zone1, BorderLayout.LINE_END);
        
        //Revisar nombres variables esto funciona gg.
       
        screen.add(cp, BorderLayout.CENTER);
        
        
        num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                cp.setsize(cp.getSize());
                cp.setBallscollection(cp.resize(num.getText()));
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
        cp = new CirclePanel();
        new Window().setVisible(true);
        try {
            cp.infiniteLoop();
        } catch (InterruptedException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
