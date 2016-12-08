/**
 * Created by juli on 12/7/16.
 */

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.sql.SQLException;

public class FrameForVeterinar extends JFrame implements ActionListener{

    final JTabbedPane basePaneV = new JTabbedPane();

    JButton btnAddReport;
    JButton btnLogOutInfo, btnLogOutSched, btnLogOutReport;
    JTable InfoTable, SchedTable, ReportTable;
    JScrollPane infoScrollPane, schedScrollPane, reportScrollPane;
    //JPanel temp;
    JPanel base;
    JPanel infoPanel, schedPanel, reportPanel;
    //JLabel labInfoP, labSchedP, labRepP;



    String[] columnNames = {
            "Date",
            "Doctor name",
            "Owner name",
            "Pet's name",
            "Breed",
            "Age",
            "Diagnosis/Cervice"
    };

    String[][] data = {
            {"20.11.2016", "Victor", "Mikl Horn", "Jesy", "Dog",
                    "5", "Fracture of the left front paw"},
            {"21.11.2016", "Mark","John Doran", "Doly", "Cat",
                    "1", "Haircut"},
            {"21.11.2016", "Ron","Susy Molter", "Grom",
                    "Dog", "3", "Surgery to remove the tick"},
            {"24.11.2016", "Victor","Jane White", "Holes",
                    "Rabbit", "2", "Haircut"},
            {"03.12.2016", "Mark","Lora Caile", "Jack",
                    "Mouse", "1,5", "Removal of warts"}
    };


    public FrameForVeterinar(String str) {

        super(str);

        setVisible(true);
        setSize(900,600);
        setMinimumSize(new Dimension(600,300));

        setDefaultCloseOperation(FrameForVeterinar.EXIT_ON_CLOSE);

        base = new JPanel();
        base.setLayout(new BorderLayout());

        infoPanel = new JPanel();
        schedPanel = new JPanel();
        reportPanel = new JPanel();


        //Button for info panel
        btnLogOutInfo = new JButton("Log Out");
        btnLogOutInfo.setToolTipText("Нажмите на кнопку, если хотите выйти");
        btnLogOutInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame logF = new LoginFrame("Authorization");
                dispose();
            }
        });

        //Button for sched panel
        btnLogOutSched = new JButton("Log Out");
        btnLogOutSched.setToolTipText("Нажмите на кнопку, если хотите выйти");
        btnLogOutSched.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame logF = new LoginFrame("Authorization");
                dispose();
            }
        });

        //Button for report panel
        btnAddReport = new JButton("Add new row");
        btnAddReport.setToolTipText("Нажмите на кнопку, если хотите создать новую строку для записи данных.");
        btnAddReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) ReportTable.getModel();
                model.addRow(new String[]{"New...", " ", " ", " ", " ", " ", " ", " "});
            }
        });

        btnLogOutReport = new JButton("Log Out");
        btnLogOutReport.setToolTipText("Нажмите на кнопку, если хотите выйти");
        btnLogOutReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame logF = new LoginFrame("Authorization");
                dispose();
            }
        });


        //Table for info panel
        InfoTable = new JTable(new DefaultTableModel(data, columnNames));
        InfoTable.setFillsViewportHeight(true);
        InfoTable.setPreferredScrollableViewportSize(new Dimension(800, 200));

        InfoTable.getColumnModel().getColumn(0).setMaxWidth(100);
        InfoTable.getColumnModel().getColumn(1).setMaxWidth(100);
        InfoTable.getColumnModel().getColumn(2).setMaxWidth(140);
        InfoTable.getColumnModel().getColumn(3).setMaxWidth(70);
        InfoTable.getColumnModel().getColumn(4).setMaxWidth(90);
        InfoTable.getColumnModel().getColumn(5).setMaxWidth(50);

        infoScrollPane = new JScrollPane(InfoTable);

        //Table for sched panel
        SchedTable = new JTable(new DefaultTableModel(data, columnNames));
        SchedTable.setFillsViewportHeight(true);
        SchedTable.setPreferredScrollableViewportSize(new Dimension(800, 200));

        SchedTable.getColumnModel().getColumn(0).setMaxWidth(100);
        SchedTable.getColumnModel().getColumn(1).setMaxWidth(100);
        SchedTable.getColumnModel().getColumn(2).setMaxWidth(140);
        SchedTable.getColumnModel().getColumn(3).setMaxWidth(70);
        SchedTable.getColumnModel().getColumn(4).setMaxWidth(90);
        SchedTable.getColumnModel().getColumn(5).setMaxWidth(50);

        schedScrollPane = new JScrollPane(SchedTable);

        //Table for report panel
        ReportTable = new JTable(new DefaultTableModel(data, columnNames));
        ReportTable.setFillsViewportHeight(true);
        ReportTable.setPreferredScrollableViewportSize(new Dimension(800, 200));

        ReportTable.getColumnModel().getColumn(0).setMaxWidth(100);
        ReportTable.getColumnModel().getColumn(1).setMaxWidth(100);
        ReportTable.getColumnModel().getColumn(2).setMaxWidth(140);
        ReportTable.getColumnModel().getColumn(3).setMaxWidth(70);
        ReportTable.getColumnModel().getColumn(4).setMaxWidth(90);
        ReportTable.getColumnModel().getColumn(5).setMaxWidth(50);

        reportScrollPane = new JScrollPane(ReportTable);



        //add to info panel
        infoPanel.add(infoScrollPane);
        infoPanel.add(btnLogOutInfo, BorderLayout.SOUTH);


        //add to sched panel
        schedPanel.add(schedScrollPane);
        schedPanel.add(btnLogOutSched, BorderLayout.SOUTH);


        //add to report panel
        reportPanel.add(reportScrollPane);
        reportPanel.add(btnAddReport, BorderLayout.SOUTH);
        reportPanel.add(btnLogOutReport, BorderLayout.SOUTH);



        basePaneV.addTab("Информация о клиентах", infoPanel);
        basePaneV.addTab("Посмотреть график", schedPanel);
        basePaneV.addTab("Отчёт о лечении или приёме", reportPanel);

//        labInfoP = new JLabel("This is information about client");
//        labSchedP = new JLabel("This is schedule");

//        infoPanel.add(labInfoP, BorderLayout.CENTER);
//        infoPanel.add(btnLogOut, BorderLayout.SOUTH);

//        schedPanel.add(labSchedP,BorderLayout.CENTER);
//        schedPanel.add(btnLogOut, BorderLayout.SOUTH);

//        scrollPane = new JScrollPane(table);
//        reportPanel.add(scrollPane);
//        reportPanel.add(btnAdd, BorderLayout.SOUTH);
//        reportPanel.add(btnLogOut, BorderLayout.SOUTH);
        //reportPanel.add();



        base.add(basePaneV, BorderLayout.CENTER);

        this.setContentPane(base);
        this.getContentPane().revalidate();



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getContentPane().equals(infoPanel)) {
//            то выводим таблицу из бд
        }
        if (getContentPane().equals(schedPanel)) {
//            то выводим график из бд
        }
//        if (getContentPane().equals(reportPanel)) {
//        if (e.getSource() == btnAdd) {
//            DefaultTableModel model = (DefaultTableModel) table.getModel();
//            model.addRow(new String[]{"New...", " ", " ", " ", " ", " ", " ", " "});
//        }
//
//        if(e.getSource() == btnLogOut) {
//            LoginFrame logF = new LoginFrame("Authorization");
//            dispose();
//        }

    }
}
