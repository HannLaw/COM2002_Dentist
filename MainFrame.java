//package com2002;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.SwingUtilities;


public class MainFrame extends JFrame {
    public MainFrame(String title) {
	    super(title);
	 
	    setLayout(new BorderLayout());
	    setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	 
	    JButton buttonS = new JButton("Secretary");
	    JButton buttonD = new JButton("Dentist");
	    JButton buttonH = new JButton("Hygienist");
	    
	    Container c = getContentPane();

	    c.add(buttonS, BorderLayout.CENTER);
	    c.add(buttonD, BorderLayout.WEST);
	    c.add(buttonH, BorderLayout.EAST);
	    
	    buttonS.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    	  	    SwingUtilities.invokeLater(new Runnable() {
					    public void run() {
						    SecretaryPage sFrame = new SecretaryPage();
						    System.out.println("Pressed sec button");
			            }
			        });
	    	}
	    });
	    
	    buttonD.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    	  	    SwingUtilities.invokeLater(new Runnable() {
					    public void run() {
						    PartnerPage dFrame = new PartnerPage();
							System.out.println("Pressed dent button");
			            }
			        }); 
	    	}
	    });
	    
	    buttonH.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    	  	    SwingUtilities.invokeLater(new Runnable() {
					    public void run() {
						    PartnerPage hFrame = new PartnerPage();
							System.out.println("Pressed hyg button");
			            }
			        }); 
	    	}
	    });
    }
}
