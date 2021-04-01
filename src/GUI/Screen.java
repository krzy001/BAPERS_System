package GUI;

import Control.BAPERS;

import javax.swing.*;



public class Screen extends JFrame {
    private JPanel panelMain;

    protected String driver="com.mysql.cj.jdbc.Driver";
    protected String url="jdbc:mysql://localhost/risinggen";
    protected String user="root";
    protected String pass="";

    //The class all the interfaces are subclasses of. Sets visibility to true and to makes sure all GUI is BAPERS object
    Screen(BAPERS system){
        super("BAPERS System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
