import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

/**
 * Created by juli on 12/8/16.
 */
public class FrameForReg extends JFrame implements ActionListener, FocusListener{

    //JPanel regPanel;
    JButton btnReg, btnBack;
    JLabel labFio, labNumberPhone, labEmail, labPass;
    Choice users;
    JTextField textFio, textNumber, textEmail, textPass;

    String defFioText = "Ваше имя";
    String defNumberText = "Номер вашего телефона";
    String defEmailText = "Ваш E-mail";
    String defPassText = "Ваш будущий пароль";

    String tFio = null;
    String tNum = null;
    String tEmail = null;
    String tPass = null;

    public FrameForReg(String str) {
        super(str);

        setVisible(true);
        setSize(500,300);
        setMinimumSize(new Dimension(400,200));
        setDefaultCloseOperation(FrameForReg.EXIT_ON_CLOSE);


        btnReg = new JButton("Regictration");
        btnReg.setFocusable(false);
        btnReg.addActionListener(this);
        btnReg.setToolTipText("Нажмите для регестрации");


        btnBack = new JButton("Back");
        btnBack.addActionListener(this);
        btnBack.setToolTipText("Нажмите, если хотите вернуться назад");


        labFio = new JLabel("ФИО:");
        labNumberPhone = new JLabel("Номер телефона:");
        labEmail = new JLabel("E-mail:");
        labPass = new JLabel("Пароль:");


        users = new Choice();
        users.add("Администратор");
        users.add("Ветеринар");


        textFio = new JTextField(defFioText);
        //textFio.addFocusListener(this);
        textFio.setForeground(Color.gray);

        textFio.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                JTextField item = (JTextField)e.getSource();
                if(item.getText().equals(defFioText)){
                    item.setForeground(Color.black);
                    item.setText("");
                }
            }
        });

        textNumber = new JTextField(defNumberText);
        //textNumber.addFocusListener(this);
        textNumber.setForeground(Color.gray);

        textNumber.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                JTextField item = (JTextField)e.getSource();
                if(item.getText().equals(defNumberText)){
                    item.setForeground(Color.black);
                    item.setText("");
                }
            }
        });

        textEmail = new JTextField(defEmailText);
        //textEmail.addFocusListener(this);
        textEmail.setForeground(Color.gray);

        textEmail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                JTextField item = (JTextField)e.getSource();
                if(item.getText().equals(defEmailText)){
                    item.setForeground(Color.black);
                    item.setText("");
                }
            }
        });

        textPass = new JTextField(defPassText);
        //textPass.addFocusListener(this);
        textPass.setForeground(Color.gray);

        textPass.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                JTextField item = (JTextField)e.getSource();
                if(item.getText().equals(defPassText)){
                    item.setForeground(Color.black);
                    item.setText("");
                }
            }
        });


        JPanel regPanel = new JPanel();
        regPanel.setLayout(new GridLayout(15,4));
        regPanel.add(labFio);
        regPanel.add(textFio);

        regPanel.add(labNumberPhone);
        regPanel.add(textNumber);

        regPanel.add(labEmail);
        regPanel.add(textEmail);

        regPanel.add(labPass);
        regPanel.add(textPass);

        regPanel.add(users);
        regPanel.add(btnReg);
        regPanel.add(btnBack);

        this.setContentPane(regPanel);
        this.setResizable(false);
        this.setSize(500,400);

        this.getContentPane().revalidate();
    }

    //возвращает последнее введённое имя
    public String getFio () {
        return tFio;
    }

    //возвращает последний введённый номер телефона
    public String getNumber () {
        return tNum;
    }

    //возвращает последний введенный E-mail
    public String getEmail () { return tEmail; }

    //возвращает последний введённый пароль
    public String getPass () { return tPass; }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReg) {
            if (!(textFio.getText().equals("") || textNumber.getText().equals("") ||
                    textEmail.getText().equals("") || textPass.getText().equals("") ||
                    textFio.getText().equals("Ваше имя") ||
                    textNumber.getText().equals("Номер вашего телефона") ||
                    textEmail.getText().equals("Ваш E-mail") ||
                    textPass.getText().equals("Ваш будущий пароль"))) {

                tFio = textFio.getText();
                tNum = textNumber.getText();
                tEmail = textEmail.getText();
                tPass = textPass.getText();
            } else {
                DMassage dialog = new DMassage("Вы ввели не все поля.");
                dialog.jDialog.setLocationRelativeTo(getContentPane());
            }
        }
        if(e.getSource() == btnBack) {
            dispose();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        btnReg.setEnabled(true);
    }

    @Override
    public void focusLost(FocusEvent e) {
        String st1 = textFio.getText();
        String st2 = textNumber.getText();
        String st3 = textEmail.getText();
        String st4 = textPass.getText();
        if( st1.equals("") || st2.equals("") || st3.equals("") || st4.equals("") )
            btnReg.setEnabled(false);
    }
}
