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
						    JFrame sframe = new JFrame("Secretary Dentistry View"); 
						    sframe.setSize(700,500);
						    sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						    sframe.setVisible(true);
			            }
			        });
	    	    }
	    	}
	    });
	    
	    buttonD.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    	    if (buttonD.getModel().isPressed()){
	    	  	    SwingUtilities.invokeLater(new Runnable() {
					    public void run() {
						    JFrame dframe = new JFrame("Dentist View"); 
						    dframe.setSize(300,500);
						    dframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						    dframe.setVisible(true);
			            }
			        });
	    	    }
	    	}
	    });
	    
	    buttonH.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    	    if (buttonH.getModel().isPressed()){
	    	  	    SwingUtilities.invokeLater(new Runnable() {
					    public void run() {
						    JFrame hframe = new JFrame("Hygienist View"); 
						    hframe.setSize(300,500);
						    hframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						    hframe.setVisible(true);
			            }
			        });
	    	    }
	    	}
	    });
    }
}
