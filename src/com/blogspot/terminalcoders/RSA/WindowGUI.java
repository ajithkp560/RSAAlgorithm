package com.blogspot.terminalcoders.RSA;
// (c) Coded By AJITH K P [ ajithkp560 ]
// http://www.terminalcoders.blogspot.com
// RSA Algorithm implementation in Java [with GUI]
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class WindowGUI extends JFrame {
    private JPanel gbl = new JPanel(new GridBagLayout());
    private GridBagConstraints gbc = new GridBagConstraints();
    private JLabel pLbl, qLbl, nLbl, phiLbl, publicLbl, privateLbl, msgLbl, encLbl, decLbl;
    private JTextField pTxt, qTxt, nTxt, phiTxt, publicTxt, privateTxt, msgTxt, encTxt, decTxt;
    private JButton genVal, encVal, decVal;
    int yourPublicKey, yourPrivateKey, yourN;
    public WindowGUI(String title){
        super(title);
        //GUI --> Java JFrame
        this.pLbl = new JLabel("Your Value of P: ", SwingConstants.RIGHT);
        this.qLbl = new JLabel("Your Value of Q: ", SwingConstants.RIGHT);
        this.nLbl = new JLabel("Your Value of N: ", SwingConstants.RIGHT);
        this.phiLbl = new JLabel("Your Value of PHI: ", SwingConstants.RIGHT);
        this.publicLbl = new JLabel("Your Public Key (e): ", SwingConstants.RIGHT);
        this.privateLbl = new JLabel("Your Private Key (d): ", SwingConstants.RIGHT);
        this.msgLbl = new JLabel("Your Message: ", SwingConstants.RIGHT);
        this.encLbl = new JLabel("Encrypted Message: ", SwingConstants.RIGHT);
        this.decLbl = new JLabel("Decrypted Message: ", SwingConstants.RIGHT);

        this.pTxt = new JTextField();
        this.qTxt = new JTextField();
        this.nTxt = new JTextField();
        this.phiTxt = new JTextField();
        this.publicTxt = new JTextField();
        this.privateTxt = new JTextField();
        this.msgTxt = new JTextField();
        this.encTxt = new JTextField();
        this.decTxt = new JTextField();

        this.genVal = new JButton("Gen. Values");
        this.encVal = new JButton("Enc. Msg");
        this.decVal = new JButton("Dec. Msg");

        gbc.insets = new Insets(3,2,3,2);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 5;
        gbl.add(pLbl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 200;
        pTxt.setEditable(false);
        gbl.add(pTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 5;
        gbl.add(qLbl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 200;
        qTxt.setEditable(false);
        gbl.add(qTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 5;
        gbl.add(nLbl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 200;
        nTxt.setEditable(false);
        gbl.add(nTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 5;
        gbl.add(phiLbl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipadx = 200;
        phiTxt.setEditable(false);
        gbl.add(phiTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 5;
        gbl.add(publicLbl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.ipadx = 200;
        publicTxt.setEditable(false);
        gbl.add(publicTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipadx = 5;
        gbl.add(privateLbl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.ipadx = 200;
        privateTxt.setEditable(false);
        gbl.add(privateTxt, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.ipadx = 5;
        gbl.add(genVal, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.ipadx = 5;
        gbl.add(msgLbl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.ipadx = 200;
        gbl.add(msgTxt, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.ipadx = 5;
        gbl.add(encVal, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.ipadx = 5;
        gbl.add(encLbl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.ipadx = 200;
        encTxt.setEditable(false);
        gbl.add(encTxt, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.ipadx = 5;
        gbl.add(decVal, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.ipadx = 5;
        gbl.add(decLbl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.ipadx = 200;
        decTxt.setEditable(false);
        gbl.add(decTxt, gbc);

        this.setLayout(new BorderLayout());
        this.add(gbl, BorderLayout.CENTER);

        //Trigger populate the form --> Generate Values
        genVal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePrivateAndPublicKeys();
            }
        });

        //Trigger the encryption of message
        encVal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long msg = Integer.parseInt(msgTxt.getText());
                BigInteger encMsg = encryptMessage(msg);
                encTxt.setText(encMsg+"");
            }
        });

        //Trigger the decryption of message
        decVal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long enc = Integer.parseInt(encTxt.getText());
                BigInteger msg = decryptMessage(enc);
                decTxt.setText(msg+"");
            }
        });
    }

    private BigInteger encryptMessage(long msg){
        BigInteger mBig = BigInteger.valueOf(msg);
        BigInteger pBig = BigInteger.valueOf(yourPublicKey);
        BigInteger nBig = BigInteger.valueOf(yourN);
        BigInteger enc = mBig.modPow(pBig, nBig);
        return enc;
    }

    private BigInteger decryptMessage(long enc){
        BigInteger eBig = BigInteger.valueOf(enc);
        BigInteger nBig = BigInteger.valueOf(yourN);
        BigInteger pBig = BigInteger.valueOf(yourPrivateKey);
        BigInteger dec = eBig.modPow(pBig, nBig);
        return dec;
    }

    private void generatePrivateAndPublicKeys() {
        RSAGen rsaGen = new RSAGen();
        pTxt.setText(rsaGen.getP()+"");
        qTxt.setText(rsaGen.getQ()+"");
        nTxt.setText(rsaGen.getN()+"");
        phiTxt.setText(rsaGen.getPhi()+"");
        publicTxt.setText(rsaGen.getPublicKey()+"");
        privateTxt.setText(rsaGen.getPrivateKey()+"");
        yourPublicKey = rsaGen.getPublicKey();
        yourPrivateKey = rsaGen.getPrivateKey();
        yourN = rsaGen.getN();
    }
}
