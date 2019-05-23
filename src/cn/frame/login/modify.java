package cn.frame.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import cn.database.bao.JdbcHelper;

public class modify extends JFrame {
	private JTextField jt;
	private JTextField jt1;
	private JTextField jt2;
	private JTextField jt3;
	private JTextField jt4;
	private JTextField jt5;
	private JTable studentGradeTable;

	public modify() {

		getContentPane().setLayout(null);
		setTitle("ÐÞ¸Ä³É¼¨µ¥");
		setLocationRelativeTo(null);
		setBounds(0, 0, 500, 320);
		getContentPane().setBackground(Color.lightGray);

		JLabel jl1 = new JLabel();
		jl1.setText("Ñ§ÉúÐÕÃû");
		jl1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		jl1.setBounds(10, 5, 150, 150);

		jt = new JTextField();
		jt.setBounds(80, 70, 100, 25);

		JLabel jl2 = new JLabel();
		jl2.setText("Ñ§Éú°à¼¶");
		jl2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		jl2.setBounds(250, 5, 150, 150);

		jt1 = new JTextField();
		jt1.setBounds(320, 70, 100, 25);

		JLabel jl3 = new JLabel();
		jl3.setText("¿¼ÊÔ¿ÆÄ¿");
		jl3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		jl3.setBounds(10, 50, 150, 150);

		jt2 = new JTextField();
		jt2.setBounds(80, 110, 100, 25);

		JLabel jl4 = new JLabel();
		jl4.setText("¿¼ÊÔ³É¼¨");
		jl4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		jl4.setBounds(250, 50, 150, 150);

		jt3 = new JTextField();
		jt3.setBounds(320, 110, 100, 25);

		JLabel jl5 = new JLabel();
		jl5.setText("¿¼ÊÔÊ±¼ä");
		jl5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		jl5.setBounds(10, 90, 150, 150);

		jt4 = new JTextField();
		jt4.setBounds(80, 150, 100, 25);

		JLabel jl6 = new JLabel();
		jl6.setText("±¸×¢");
		jl6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		jl6.setBounds(10, 125, 150, 150);

		jt5 = new JTextField();
		jt5.setBounds(80, 190, 380, 25);

		JButton jb1 = new JButton("ÐÞ¸Ä");
		JButton jb3 = new JButton("·µ»Ø");

		jb1.setFont(new Font("ºÚÌå", Font.BOLD, 16));
		jb3.setFont(new Font("ºÚÌå", Font.BOLD, 16));

		jb1.setBounds(150, 250, 80, 22);
		jb3.setBounds(280, 250, 80, 22);
		// jb.addActionListener(action);
		jb1.addActionListener(action);
		jb3.addActionListener(action);

		getContentPane().add(jl1);
		getContentPane().add(jt);
		getContentPane().add(jl2);
		getContentPane().add(jt1);
		getContentPane().add(jl3);
		getContentPane().add(jt2);
		getContentPane().add(jl4);
		getContentPane().add(jt3);
		getContentPane().add(jl5);
		getContentPane().add(jt4);
		getContentPane().add(jl6);
		getContentPane().add(jt5);
		getContentPane().add(jb1);
		getContentPane().add(jb3);

	}
	
	public static void main(String[] args) {
		modify m = new modify();
		m.setLocationRelativeTo(null);
		m.setVisible(true);
	}

	private ActionListener action = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			String text = ((JButton) src).getText();
			if (text.equals("ÐÞ¸Ä")) {
				doModifyButtonActionPerformed(e);
			} else if (text.equals("·µ»Ø")) {
				setVisible(false);
			}
		}
	};

	protected void do_clearButton_actionPerformed(ActionEvent e) {

		jt.setText("");
		jt1.setText("");
		jt2.setText("");
		jt3.setText("");
		jt4.setText("");
		jt5.setText("");
	}

	private void doModifyButtonActionPerformed(ActionEvent e) {
			String jtStr = jt.getText();
			String jt1Str = jt1.getText();
			String jt2Str = jt2.getText();
			String jt3Str = jt3.getText();
			String jt4Str = jt4.getText();
			String jt5Str = jt5.getText();
			GradeBean gradeBean = new GradeBean();
			gradeBean.setStudentName(jtStr);
			gradeBean.setStudentClass(jt1Str);
			gradeBean.setTestSubject(jt2Str);
			gradeBean.setScore(jt3Str);
			gradeBean.setTestTime(jt4Str);
			gradeBean.setRemark(jt5Str);
			JdbcHelper.update(gradeBean);
			JOptionPane.showMessageDialog(this, "ÐÞ¸Ä³É¹¦!", "a good new",JOptionPane.WARNING_MESSAGE);
			do_clearButton_actionPerformed(e);
		}
	protected void do_returnButton_actionPerformed(ActionEvent e) {
		dispose();
	}
}
