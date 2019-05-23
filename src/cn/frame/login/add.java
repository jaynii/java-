package cn.frame.login;

import java.awt.Color;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import cn.database.bao.JdbcHelper;

public class add extends JFrame {
	private JTextField jt;
	private JTextField jt1;
	private JTextField jt2;
	private JTextField jt3;
	private JTextField jt4;
	private JTextField jt5;

	public add() {

		getContentPane().setLayout(null);
		setTitle("增加成绩单");
		setBounds(0, 0, 500, 320);
		getContentPane().setBackground(Color.pink);

		JLabel jl = new JLabel();
		jl.setText("学生成绩查询");
		jl.setFont(new Font("华文斜体", Font.BOLD, 20));
		jl.setBounds(180, -50, 150, 150);

		JLabel jl1 = new JLabel();
		jl1.setText("学生姓名");
		jl1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		jl1.setBounds(10, 5, 150, 150);

		jt = new JTextField();
		jt.setBounds(80, 70, 100, 25);

		JLabel jl2 = new JLabel();
		jl2.setText("学生班级");
		jl2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		jl2.setBounds(250, 5, 150, 150);

		jt1 = new JTextField();
		jt1.setBounds(320, 70, 100, 25);

		JLabel jl3 = new JLabel();
		jl3.setText("考试科目");
		jl3.setFont(new Font("微软雅黑", Font.BOLD, 15));
		jl3.setBounds(10, 50, 150, 150);

		jt2 = new JTextField();
		jt2.setBounds(80, 110, 100, 25);

		JLabel jl4 = new JLabel();
		jl4.setText("考试成绩");
		jl4.setFont(new Font("微软雅黑", Font.BOLD, 15));
		jl4.setBounds(250, 50, 150, 150);

		jt3 = new JTextField();
		jt3.setBounds(320, 110, 100, 25);

		JLabel jl5 = new JLabel();
		jl5.setText("考试时间");
		jl5.setFont(new Font("微软雅黑", Font.BOLD, 15));
		jl5.setBounds(10, 90, 150, 150);

		jt4 = new JTextField();
		jt4.setBounds(80, 150, 100, 25);

		JLabel jl6 = new JLabel();
		jl6.setText("备注");
		jl6.setFont(new Font("微软雅黑", Font.BOLD, 15));
		jl6.setBounds(10, 125, 150, 150);

		jt5 = new JTextField();
		jt5.setBounds(80, 190, 380, 25);

		JButton jb = new JButton("保存");
		JButton jb1 = new JButton("重置");
		JButton jb3 = new JButton("返回");

		jb.setFont(new Font("黑体", Font.BOLD, 16));
		jb1.setFont(new Font("黑体", Font.BOLD, 16));
		jb3.setFont(new Font("黑体", Font.BOLD, 16));

		jb.setBounds(120, 250, 80, 22);
		jb1.setBounds(220, 250, 80, 22);
		jb3.setBounds(320, 250, 80, 22);
		jb.addActionListener(action);
		jb1.addActionListener(action);
		jb3.addActionListener(action);
		

		getContentPane().add(jl);
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
		getContentPane().add(jb);
		getContentPane().add(jb1);
		getContentPane().add(jb3);

	}

	
	private ActionListener action = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			String text = ((JButton) src).getText();
			if (text.equals("保存")) {
				do_saveButton_actionPerformed(e);
			} else if (text.equals("重置")) {
				do_clearButton_actionPerformed(e);
			} else if (text.equals("返回")) {
				setVisible(false);
			}
		}
	};

	public static void main(String[] args) {
		add a = new add();
		a.setLocationRelativeTo(null);
		a.setVisible(true);
	}


	protected void do_saveButton_actionPerformed(ActionEvent e) {
		String studentName = jt.getText().trim();
		String studentClass = jt1.getText().trim();
		String testSubject = jt2.getText().trim();
		String score = jt3.getText().trim();
		String testTime = jt4.getText().trim();
		String remark = jt5.getText().trim();
		GradeBean grade = new GradeBean();
		grade.setStudentName(studentName);
		grade.setStudentClass(studentClass);
		grade.setTestSubject(testSubject);
		grade.setScore(score);
		grade.setTestTime(testTime);
		grade.setRemark(remark);
		int result = JdbcHelper.save(grade);
		if (result >= 0) {
			JOptionPane.showMessageDialog(this, "成绩单增加成功！");
			return;
		} else {
			JOptionPane.showMessageDialog(this, "成绩单增加失败！");
			return;
		}
	}

	protected void do_clearButton_actionPerformed(ActionEvent e) {
		jt.setText("");
		jt1.setText("");
		jt2.setText("");
		jt3.setText("");
		jt4.setText("");
		jt5.setText("");
	}

	protected void do_returnButton_actionPerformed(ActionEvent e) {
		dispose();
	}
}
