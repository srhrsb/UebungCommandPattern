package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private  JButton driveBtn, stopBtn, backBtn, leftBtn, rightBtn, replayBtn, clearBtn;

    private JList<String> actionList;

    private DefaultListModel<String> model;


    public MainView( int width, int height ){

        setSize( width, height );
        setFont( new Font("Arial", Font.PLAIN, 20));
        setTitle("Command Pattern Beispiel");
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        addUIComponents();
        setVisible(true);
    }

    /**
     * Hinzufuegen von UI-Elementen
     */
    private void addUIComponents( ){
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        JLabel topLabel = new JLabel("Aktionen des Autos  ");

        driveBtn = new JButton("Drive");
        stopBtn = new JButton("Stop");
        backBtn = new JButton("Back");
        leftBtn = new JButton("Left");
        rightBtn = new JButton("Right");

        replayBtn = new JButton("Alle Wiederholen");
        clearBtn = new JButton("Ausgabe löschen");

        model = new DefaultListModel<>();
        actionList= new JList<>( model );

        topPanel.add(topLabel);
        topPanel.add(replayBtn);
        topPanel.add(clearBtn);

        centerPanel.add(actionList);

        bottomPanel.add(driveBtn);
        bottomPanel.add(stopBtn);
        bottomPanel.add(backBtn);
        bottomPanel.add(leftBtn);
        bottomPanel.add(rightBtn);


        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void addCmdButtonHandler(ActionListener listener){
        driveBtn.addActionListener(listener);
        stopBtn.addActionListener(listener);
        backBtn.addActionListener(listener);
        leftBtn.addActionListener(listener);
        rightBtn.addActionListener(listener);
    }

    public void addReplayButtonHandler(ActionListener listener){
         replayBtn.addActionListener(listener);
    }

    public void addClearButtonHandler(ActionListener listener){
        clearBtn.addActionListener(listener);
    }

    public void addActionToList(String newCommand){
        System.out.println(newCommand);
        model.addElement(newCommand);
    }

    public void clearActionList(){
        model.clear();
    }
}
