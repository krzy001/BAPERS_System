package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame {
    private JPanel panelMain;

    protected String driver="com.mysql.cj.jdbc.Driver";
    protected String url="jdbc:mysql://localhost/risinggen";
    protected String user="root";
    protected String pass="";

    Screen(BAPERS system){
        super("BAPERS System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setVisible(true);
    }
}
