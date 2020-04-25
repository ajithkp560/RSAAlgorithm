package com.blogspot.terminalcoders.RSA;
// (c) Coded By AJITH K P [ ajithkp560 ]
// http://www.terminalcoders.blogspot.com
// RSA Algorithm implementation in Java [with GUI]
import javax.swing.*;

public class MainWindow {
    public static void main(String[] args){
        WindowGUI gui = new WindowGUI("RSA Algorithm");
        gui.setSize(500, 400);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
    }
}
