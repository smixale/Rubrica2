package src.view;

import javax.swing.JFrame;

import src.controller.Controller;
import src.controller.UserController;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

public class FramePrincipale extends JFrame{

    public Controller controller;
    public UserController userController;

    private TabellaRubrica tabellaRubrica;
    public StrumentiFinestraPrincipale strumenti;

    public Form form;;
    public StrumentiForm strumentiForm;

    public PaginaLogin paginaLogin;
    public StrumentiLogin strumentiLogin;

    public FramePrincipale (){

        super("Sistema rubrica");

        this.controller = new Controller(this);
        this.userController = new UserController(this);

        form = new Form();

        strumenti = new StrumentiFinestraPrincipale(controller);
        strumentiForm = new StrumentiForm(controller);
        strumentiLogin = new StrumentiLogin(userController);

        tabellaRubrica = new TabellaRubrica(controller);
        tabellaRubrica.setData(controller.getRubrica());
        paginaLogin = new PaginaLogin(userController);

        this.setListener();

        this.caricaDaFile();

        setLayout(new BorderLayout());
        
        controller.caricaPaginaLogin();

        AspettoFrame();
    }

    //strumenti controller----------------------------------------------
    public Form getForm() {
        return form;
    }

    public StrumentiForm getStrumentiForm() {
        return strumentiForm;
    }

    public StrumentiFinestraPrincipale getStrumenti() {
        return strumenti;
    }

    public TabellaRubrica getTabellaRubrica() {
        return tabellaRubrica;
    }

    public PaginaLogin getPaginaLogin() {
        return paginaLogin;
    }

    public StrumentiLogin getStrumentiLogin() {
        return strumentiLogin;
    }
    //----------------------------------------------------------------------

    //raggruppo l'aggiunta dei diversi listener alle componenti
    private void setListener(){

        //listener per gerstire la creazione di una nuova persona tramite form
        strumentiForm.setFormListener(new FormListener(){
            @Override
            public void formEventListener(EventoForm ef){

                String nome  = ef.getNome();
                String cognome = ef.getCognome();
                String indirizzo = ef.getIndirizzo();
                String telefono = ef.getTelefono();
                int eta = ef.getEta();

                try {
                    controller.addPersona(nome, cognome, indirizzo, telefono, eta);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                tabellaRubrica.aggiorna();
                
                CaricaFinestraPrincipale();
            }
        });

        //listener per gestire un tentativo di login
        strumentiLogin.setLoginListener(new LoginListener() {
            @Override
            public void loginEventListener(EventoLogin el){
                System.out.println("tentativo login");
            }
        });

        //listener per gestire la chiusura del frame
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                try {
                    controller.salvaDatiSuFile();
                    userController.salvaSuFile();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            };
        });
    }

    public void CaricaPaginaLogin(){
        add(paginaLogin, BorderLayout.CENTER);
        add(strumentiLogin, BorderLayout.PAGE_END);
    }

    //caricamento componenti pagina principale rubrica
    public void CaricaFinestraPrincipale(){        
        remove(strumentiForm);
        remove(form);

        add(tabellaRubrica,BorderLayout.CENTER);
        add(strumenti,BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    //caricamento componenti form aggiunta persona in rubrica
    public void CaricaFinestraForm(){
        remove(strumenti);
        remove(tabellaRubrica);

        add(form,BorderLayout.CENTER);
        add(strumentiForm,BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    //metodo che assegna le dimensioni e l'aspetto di default al frame
    private void AspettoFrame(){
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void caricaDaFile(){
        controller.caricaDaFile();
        userController.caricaDaFile();
        tabellaRubrica.aggiorna();
    }
}
