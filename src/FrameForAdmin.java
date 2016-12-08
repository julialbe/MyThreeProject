import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 * Created by juli on 12/8/16.
 */
public class FrameForAdmin extends JFrame implements ActionListener {

    final JTabbedPane basePaneA = new JTabbedPane();

    JPanel baseAdminPanel;
    JPanel infoClient, infoVeterin, schedulePanel, medicinePanel;

    JButton addClient, delClient, changeClient, btnLogOutClient;
    JButton addVeter, delVeter, changeVeter, btnLogOutVeter;
    JButton changeSched, btnLogOutSched;
    JButton addMedic, delMedic, changeMedic, btnLogOutMed;


    JTable tabClient, tabVeter, tabSched, tabMedic;
    JScrollPane scrollClient, scrollVeter, scrollSched, scrollMedic;


    String[] columnNames = {
            "Date",
            "Doctor name",
            "Owner name",
            "Pet's name",
            "Breed",
            "Age",
    };

    String[][] data = {
            {"20.11.2016", "Victor", "Mikl Horn", "Jesy", "Dog",
                    "5"},
            {"21.11.2016", "Mark","John Doran", "Doly", "Cat",
                    "1"},
            {"21.11.2016", "Ron","Susy Molter", "Grom",
                    "Dog", "3"},
            {"24.11.2016", "Victor","Jane White", "Holes",
                    "Rabbit", "2"},
            {"03.12.2016", "Mark","Lora Caile", "Jack",
                    "Mouse", "1,5"}
    };

    public FrameForAdmin (String str) {
        super(str);

        setVisible(true);
        setSize(900,600);
        setMinimumSize(new Dimension(600,300));

        setDefaultCloseOperation(FrameForAdmin.EXIT_ON_CLOSE);

        baseAdminPanel = new JPanel();
        baseAdminPanel.setLayout(new BorderLayout());

        infoClient = new JPanel();
        infoVeterin = new JPanel();
        schedulePanel = new JPanel();
        medicinePanel = new JPanel();

        //Buttons for client panel
        addClient = new JButton("ADD new client");
        addClient.setToolTipText("Нажмите, если хотите добавить нового клиента");
        addClient.addActionListener(this);

        delClient = new JButton("DEL client");
        delClient.setToolTipText("Нажмите, если хотите удалить клиента");
        delClient.addActionListener(this);

        changeClient = new JButton("CHANGE");
        changeClient.setToolTipText("Нажмите, если хотите изменить информацию о клиенте");
        changeClient.addActionListener(this);

        btnLogOutClient = new JButton("Log Out");
        btnLogOutClient.setToolTipText("Нажмите на кнопку, если хотите выйти");
        btnLogOutClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame logF = new LoginFrame("Authorization");
                dispose();
            }
        });

        //Buttons for doctors panel
        addVeter = new JButton("ADD new veterinar");
        addVeter.setToolTipText("Нажмите, если хотите добавить нового ветеринара");
        addVeter.addActionListener(this);

        delVeter = new JButton("DISMISS veterinar");
        delVeter.setToolTipText("Нажмите,сли хотите удалить ветеринара");
        delVeter.addActionListener(this);

        changeVeter = new JButton("CHANGE");
        changeVeter.setToolTipText("Нажмите, если хотите изменить информация о ветеринаре");
        changeVeter.addActionListener(this);

        btnLogOutVeter = new JButton("Log Out");
        btnLogOutVeter.setToolTipText("Нажмите на кнопку, если хотите выйти");
        btnLogOutVeter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame logF = new LoginFrame("Authorization");
                dispose();
            }
        });

        //Buttons for schedule panel
        changeSched = new JButton("CHANGE");
        changeSched.setToolTipText("Нажмите, если хотите изменить график");
        changeSched.addActionListener(this);

        btnLogOutSched = new JButton("Log Out");
        btnLogOutSched.setToolTipText("Нажмите на кнопку, если хотите выйти");
        btnLogOutSched.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame logF = new LoginFrame("Authorization");
                dispose();
            }
        });

        //Buttons for medicine panel
        addMedic = new JButton("ADD new medicine");
        addMedic.setToolTipText("Нажмите, если хотите добавить новое лекарство");
        addMedic.addActionListener(this);

        delMedic = new JButton("DELETE medicine");
        delMedic.setToolTipText("Нажмите, если хотите удалить лекарство");
        delMedic.addActionListener(this);

        changeMedic = new JButton("CHANGE");
        changeMedic.setToolTipText("Нажмите, если хотите изменить информацию о лекарстве");
        changeMedic.addActionListener(this);

        btnLogOutMed = new JButton("Log Out");
        btnLogOutMed.setToolTipText("Нажмите на кнопку, если хотите выйти");
        btnLogOutMed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame logF = new LoginFrame("Authorization");
                dispose();
            }
        });


        //Table for client panel
        tabClient = new JTable(new DefaultTableModel(data, columnNames));
        tabClient.setFillsViewportHeight(true);
        tabClient.setPreferredScrollableViewportSize(new Dimension(800, 200));

        scrollClient = new JScrollPane(tabClient);
        infoClient.add(scrollClient);

        //Table for veterinar panel
        tabVeter = new JTable(new DefaultTableModel(data, columnNames));
        tabVeter.setFillsViewportHeight(true);
        tabVeter.setPreferredScrollableViewportSize(new Dimension(800, 200));

        scrollVeter = new JScrollPane(tabVeter);
        infoVeterin.add(scrollVeter);

        //Table for schedule pqnel
        tabSched = new JTable(new DefaultTableModel(data, columnNames));
        tabSched.setFillsViewportHeight(true);
        tabSched.setPreferredScrollableViewportSize(new Dimension(800, 200));

        scrollSched = new JScrollPane(tabSched);
        schedulePanel.add(scrollSched);

        //Table for medicine panel
        tabMedic = new JTable(new DefaultTableModel(data, columnNames));
        tabMedic.setFillsViewportHeight(true);
        tabMedic.setPreferredScrollableViewportSize(new Dimension(800, 200));

        scrollMedic = new JScrollPane(tabMedic);
        medicinePanel.add(scrollMedic);

        //add buttons to client panel
        infoClient.add(addClient, BorderLayout.SOUTH);
        infoClient.add(delClient, BorderLayout.SOUTH);
        infoClient.add(changeClient, BorderLayout.SOUTH);
        infoClient.add(btnLogOutClient, BorderLayout.SOUTH);

        //add buttons to veterinar panel
        infoVeterin.add(addVeter, BorderLayout.SOUTH);
        infoVeterin.add(delVeter, BorderLayout.SOUTH);
        infoVeterin.add(changeVeter, BorderLayout.SOUTH);
        infoVeterin.add(btnLogOutVeter, BorderLayout.SOUTH);

        //add buttons to schedule panel
        schedulePanel.add(changeSched, BorderLayout.SOUTH);
        schedulePanel.add(btnLogOutSched, BorderLayout.SOUTH);

        //add buttons to medicine panel
        medicinePanel.add(addMedic, BorderLayout.SOUTH);
        medicinePanel.add(delMedic, BorderLayout.SOUTH);
        medicinePanel.add(changeMedic, BorderLayout.SOUTH);
        medicinePanel.add(btnLogOutMed, BorderLayout.SOUTH);

        //add to base panel
        basePaneA.addTab("Работа с информацией о клиенте", infoClient);
        basePaneA.addTab("Работа с информацией о ветеринаре", infoVeterin);
        basePaneA.addTab("Работа с графиком", schedulePanel);
        basePaneA.addTab("Работа с лекарствами", medicinePanel);

        baseAdminPanel.add(basePaneA, BorderLayout.CENTER);

        this.setContentPane(baseAdminPanel);
        this.getContentPane().revalidate();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        //if(e.getSource() == (btnLogOutClient || btnLogOutVeter || btnLogOutSched || btnLogOutMed))
    }
}
