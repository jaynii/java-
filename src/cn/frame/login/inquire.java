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

public class inquire extends JFrame {
	private JTextField jte;
	private JTextField jt;
	private JTextField jt1;
	private JTextField jt2;
	private JTextField jt3;
	private JTextField jt4;
	private JTextField jt5;

	public inquire() {

		getContentPane().setLayout(null);
		setTitle("查询成绩单");
		setBounds(0, 0, 500, 320);

		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.green);


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

		JButton jb = new JButton("查询");
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
	
	public static void main(String[] args) {
		inquire i = new inquire();
		i.setLocationRelativeTo(null);
		i.setVisible(true);
	}

	private ActionListener action = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			String text = ((JButton) src).getText();
			if (text.equals("查询")) {
				do_inquireButton_actionPerformed(e);
			} else if (text.equals("重置")) {
				do_clearButton_actionPerformed(e);
			} else if (text.equals("返回")) {
				setVisible(false);
			}
		}
		};
	
	
		private void do_inquireButton_actionPerformed(ActionEvent e) {
				String jtStr = jt.getText();
				String jt1Str = jt1.getText();
				String jt2Str = jt2.getText();
				String jt3Str = jt3.getText();
				String jt4Str = jt4.getText();
				String jt5Str = jt5.getText();
				do_clearButton_actionPerformed(e);
				GradeBean gradeBean = new GradeBean();
				gradeBean.setStudentName(jtStr);
				gradeBean.setStudentClass(jt1Str);
				gradeBean.setTestSubject(jt2Str);
				gradeBean.setScore(jt3Str);
				gradeBean.setTestTime(jt4Str);
				gradeBean.setRemark(jt5Str);
				List<GradeBean> datas = JdbcHelper.query(gradeBean);
				if(datas.size() <= 0){
					JOptionPane.showMessageDialog(this, "查无此人!", "", JOptionPane.WARNING_MESSAGE);
					return;
				}
				StringBuffer sb = new StringBuffer();
				for(GradeBean grade : datas){
					String studentName = grade.getStudentName();
			        String studentClass = grade.getStudentClass();
			        String testSubject = grade.getTestSubject();
			        String score = grade.getScore();
			        String testTime = grade.getTestTime();
			        String remark = grade.getRemark();
					sb.append("studentName : " + studentName + ",");
					sb.append("studentClass : " + studentClass + ",");
					sb.append("testSubject : " + testSubject + ",");
					sb.append("score : " + score + ",");
					sb.append("testTime : " + testTime + ",");
					sb.append("remark : " + remark + "\n");
				}
				JOptionPane.showMessageDialog(this, "查询结果:\n" + sb.toString(), "", JOptionPane.WARNING_MESSAGE);
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
