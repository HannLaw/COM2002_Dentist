package com2002;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class SqlTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	    Secretary sec = new Secretary();
        @SuppressWarnings("deprecation")
		ResultSet rs = sec.viewAppointments(new Date(2017,12,8));
        // It creates and displays the table
	    JTable table = new JTable(buildTableModel(rs)); 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SqlTest frame = new SqlTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	             ResultSetMetaData metaData = rs.getMetaData();
	             // names of columns
	             Vector<String> columnNames = new Vector<String>();
	             int columnCount = metaData.getColumnCount();
	             for (int column = 1; column <= columnCount; column++) {
	                 columnNames.add(metaData.getColumnName(column));
	             }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	    }

	/**
	 * Create the frame.
	 */
	public SqlTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
