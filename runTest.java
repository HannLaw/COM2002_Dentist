package com2002;

import javax.swing.SwingUtilities;

public class runTest {
	
	public static void main(String[] args) {	
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SqlTest frame = new SqlTest(); // MainFrame Class doesn't currently work
	        }
	    });
    }
}