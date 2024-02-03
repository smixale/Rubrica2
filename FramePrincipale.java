import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FramePrincipale extends JFrame{

    private JButton nuovo = new JButton("nuovo");;
    private JButton modifica = new JButton("modifica");;
    private JButton elimina = new JButton("elimina");;

    
    public FramePrincipale (){

        super("frame principale");

        setLayout(new BorderLayout());
        add(nuovo,BorderLayout.PAGE_END);
        add(modifica,BorderLayout.PAGE_END);
        add(elimina,BorderLayout.PAGE_END);
        Azioni();



        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void Azioni (){

        nuovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("pulsante nuovo");
            }
        });

        modifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("pulsante modifica");
            }
        });

        elimina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("pulsante elimina");
            }
        });

    }
}
