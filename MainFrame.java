package com2002;

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
						   SecretaryFrame sFrame = new SecretaryFrame("Secretary Dentistry View"); 
			            }
			        });
	    	}
	    });
	    
	    buttonD.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    	  	    SwingUtilities.invokeLater(new Runnable() {
					    public void run() {
						    PartnerFrame dFrame = new PartnerFrame("Dentist View",'D'); 
			            }
			        }); 
	    	}
	    });
	    
	    buttonH.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    	  	    SwingUtilities.invokeLater(new Runnable() {
					    public void run() {
						    PartnerFrame hFrame = new PartnerFrame("Hygienist View", 'H'); 
			            }
			        }); 
	    	}
	    });
    }
}
