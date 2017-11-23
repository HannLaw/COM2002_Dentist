package com2002;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.SwingUtilities;


public class MainFrame extends JFrame {
    public MainFrame(String title) {
	    super(title);
	 
	    setLayout(new BorderLayout());
	 
	    JButton buttonS = new JButton("Secretary");
	    JButton buttonD = new JButton("Dentist");
	    JButton buttonH = new JButton("Hygienist");
	    
	    Container c = getContentPane();

	    c.add(buttonS, BorderLayout.CENTER);
	    c.add(buttonD, BorderLayout.WEST);
	    c.add(buttonH, BorderLayout.EAST);
	    
	    buttonS.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    	    if (buttonS.getModel().isPressed()){
	    	  	    SwingUtilities.invokeLater(new Runnable() {
					    public void run() {
						    JFrame frame = new MainFrame("Secretary Dentistry View"); // MainFrame Class doesn't currently work
						    frame.setSize(700,500);
						    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						    frame.setVisible(true);
			            }
			        });
	    	    }
	    	}
	    });
	    
	    buttonD.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    	    if (buttonS.getModel().isPressed()){
	    	  	    SwingUtilities.invokeLater(new Runnable() {
					    public void run() {
						    JFrame frame = new MainFrame("Dentist View"); // MainFrame Class doesn't currently work
						    frame.setSize(300,500);
						    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						    frame.setVisible(true);
			            }
			        });
	    	    }
	    	}
	    });
	    
	    buttonH.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    	    if (buttonS.getModel().isPressed()){
	    	  	    SwingUtilities.invokeLater(new Runnable() {
					    public void run() {
						    JFrame frame = new MainFrame("Higienist View"); // MainFrame Class doesn't currently work
						    frame.setSize(300,500);
						    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						    frame.setVisible(true);
			            }
			        });
	    	    }
	    	}
	    });
    }
}
