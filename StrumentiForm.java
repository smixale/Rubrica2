import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class StrumentiForm extends JPanel{

    private JButton salva = new JButton("salva");
    private JButton annulla = new JButton("annulla");

    public StrumentiForm(AzioniPulsanti azioni){
        setLayout(new FlowLayout(FlowLayout.CENTER,20,10));

        salva.setAlignmentX(LEFT_ALIGNMENT);
        annulla.setAlignmentX(CENTER_ALIGNMENT);

        add(salva);
        add(annulla);

        salva.addActionListener(azioni);
        annulla.addActionListener(azioni);
    }
}
