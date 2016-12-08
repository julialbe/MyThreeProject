/**
 * Created by juli on 11/29/16.
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import java.lang.*;
import java.lang.String;


public class LoginFrame extends JFrame implements ActionListener, FocusListener{

    JButton btnLogIn, btnRegistrat, btnExit;
    JTextField myTextLogin, myTextPassword;
    Choice user;
    JLabel labLogin, labPassword;

    String defLoginText="Login";
    String defPasswordText="Password";

    String tLogin = null;
    String tPassword = null;


    public LoginFrame (String str) {
        super(str);
        
        setVisible(true);
        setSize(500,300);
        setMinimumSize(new Dimension(400,200));
        //setDefaultCloseOperation(LoginFrame.EXIT_ON_CLOSE);

        // Buttons
        btnLogIn = new JButton("Log in");
        btnLogIn.setFocusable(false);
        btnLogIn.addActionListener(this);
        btnLogIn.setToolTipText("Введите логин и пароль для входа в систему");

        btnRegistrat = new JButton("Registration");
        btnRegistrat.setToolTipText("Нажмите, если хотите зарегестрироваться");
        btnRegistrat.addActionListener(this);

        btnExit = new JButton("Exit");
        btnExit.setToolTipText("Нажмите на кнопку, если хотите выйти из программы");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        //Text fields
        myTextLogin = new JTextField(defLoginText);
        myTextLogin.addFocusListener(this);
        myTextLogin.setForeground(Color.gray);

        myTextLogin.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                JTextField item = (JTextField)e.getSource();
                if(item.getText().equals(defLoginText)){
                    item.setForeground(Color.black);
                    item.setText("");
                }
            }
        });


        myTextPassword = new JTextField(defPasswordText);
        myTextPassword.addFocusListener(this);
        myTextPassword.setForeground(Color.gray);

        myTextPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                JTextField item = (JTextField)e.getSource();
                if(item.getText().equals(defPasswordText)) {
                    item.setForeground(Color.black);
                    item.setText("");
                }
            }
        });

        labLogin = new JLabel("Логин:");
        labPassword = new JLabel("Пароль:");

        user = new Choice();
        user.add("Администратор");
        user.add("Ветеринар");



        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(10,4));
        loginPanel.add(labLogin);
        loginPanel.add(myTextLogin);
        loginPanel.add(labPassword);
        loginPanel.add(myTextPassword);
        loginPanel.add(user);
        loginPanel.add(btnLogIn);
        loginPanel.add(btnRegistrat);
        loginPanel.add(btnExit);
        this.setContentPane(loginPanel);
        this.setResizable(false);
        this.setSize(500,400);

//        this.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowActivated(WindowEvent e) {
//                super.windowActivated(e);
//                btnLogIn.requestFocusInWindow();//После открытия передать фокус кнопке ОК
//            }});

        this.getContentPane().revalidate();
    }

    //возвращает последний введённый логин
    public String getLogin () {
        return tLogin;
    }

    //возвращает последний введённый пароль
    public String getPassword () {
        return tPassword;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnLogIn) {
            if(!(myTextLogin.getText().equals("") || myTextPassword.getText().equals("") ||
                    myTextLogin.getText().equals("Login") || myTextPassword.getText().equals("Password"))) {

                tLogin = myTextLogin.getText();
                tPassword = myTextPassword.getText();

                //if(user.equals("Администратор")) {
                if(user.getSelectedItem() == "Администратор") {
                    FrameForAdmin frameA = new FrameForAdmin("Admin");
                    dispose();
                }
                //else if (user.equals("Ветеринар")) {
                else if(user.getSelectedItem() == "Ветеринар") {
                    FrameForVeterinar frameV = new FrameForVeterinar("Veterinar");
                    dispose();
                }
            }

            else {
                DMassage dialog = new DMassage("Вы не ввели логин или пароль.");
                dialog.jDialog.setLocationRelativeTo(getContentPane());
            }


        }

        if(e.getSource() == btnRegistrat) {
            FrameForReg fr = new FrameForReg("Registration");
        }

    }




    @Override
    public void focusGained(FocusEvent e) {
        btnLogIn.setEnabled(true);
    }

    @Override
    public void focusLost(FocusEvent e) {
        String st1 = myTextLogin.getText();
        String st2 = myTextPassword.getText();
        if(st1.equals("") || st2.equals(""))
            btnLogIn.setEnabled(false);
    }
}
