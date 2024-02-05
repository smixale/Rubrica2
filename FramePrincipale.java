import javax.swing.JFrame;
import java.awt.BorderLayout;

public class FramePrincipale extends JFrame{


    
    public FramePrincipale (){

        super("frame principale");

        setLayout(new BorderLayout());
        
        BarraPulsanti pulsanti = new BarraPulsanti();
        add(pulsanti,BorderLayout.PAGE_END);


        AspettoFrame();
    }

    private void AspettoFrame(){
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
