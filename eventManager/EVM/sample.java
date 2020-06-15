import java.awt.*;
import javax.swing.*;
public class myWindow
{
    public static void main(String args[] )
    {
        JFrame f= new JFrame();
        f.setTitle("myWindow");
        f.setVisible(true);
        f.setSize(300,200);
        Container c= f.getContentPane();
        c.setBackground(Color.green);
        f.setResizable(false);//restricting the user to resize the window
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
}