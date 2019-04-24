package practicafinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Felix
 */
public class Window extends JFrame{
    
    //Tamaño de la venta.
    public static int sizex = 600;
    public static int sizey = 400;
    
    //Titulo de la ventana.
    public String title = "Balls Simulation";
    
    //Fuentes a utilizar.
    public Font f = new Font("serif", Font.BOLD, 20);
    
    //Constructor de la ventana.
    public Window(){
        this.setSize(sizex, sizey);
        this.setTitle(title);
        this.setLocationByPlatform(rootPaneCheckingEnabled);
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
        num.setFont(f);
        num.setHorizontalAlignment(SwingConstants.RIGHT);
        menu.add(num);
        
        //Los checkbox para modificar el programa.
        JCheckBox walls = new JCheckBox("With Walls");
        menu.add(walls);
        JCheckBox follow = new JCheckBox("Follow Mouse");
        menu.add(follow);
                
        //Layout principal.
        JPanel screen = (JPanel) getContentPane();
        JPanel zone1 = new JPanel();
        zone1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        zone1.add(menu, BorderLayout.CENTER);
        menu.setBackground(Color.red);
        screen.add(zone1, BorderLayout.LINE_END);
    }
    
    public static void main(String[] args) {
        new Window().setVisible(true);
    }
    
}
