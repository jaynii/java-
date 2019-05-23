package cn.frame.login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.database.bao.datbase;


public class Teacher_register extends JFrame{
	public Teacher_register(){
		setTitle("µÇÂ¼×¢²á");
		setSize(450,300);
		setResizable(false);
		setLocationRelativeTo(null);
		
		Container c=getContentPane();
		c.setLayout(null);
		Image i=new ImageIcon("timg (2).jpg").getImage();
		JLabel jla=new JLabel(new ImageIcon(i));
		jla.setBounds(0, 0, 450, 300);

		
		final JLabel j=new JLabel("ÓÃ»§×¢²á");
		j.setForeground(Color.cyan);
		j.setFont(new Font("ºÚÌå",Font.PLAIN,30));
		j.setBounds(160, 20, 150, 30);
        c.add(j);
		
		final JLabel jl=new JLabel("ÓÃ»§Ãû");
		jl.setForeground(Color.blue);
		jl.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,20));
		jl.setBounds(120, 70, 180, 30);
        c.add(jl);
        
        final JTextField jt=new JTextField();
        jt.setBounds(210,75,100,25);
        c.add(jt);
        
        final JLabel jl1=new JLabel("ÃÜÂë");
        jl1.setForeground(Color.BLUE);
		jl1.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,20));
		jl1.setBounds(120, 120, 180, 30);
        c.add(jl1);
        
        final JPasswordField jp=new JPasswordField();
		jp.setBounds(210, 120, 100, 25);
        c.add(jp);
        
        final JLabel jl2=new JLabel("ÓÃ»§ÀàÐÍ");
        jl2.setForeground(Color.blue);
		jl2.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,20));
		jl2.setBounds(100, 170, 180, 30);
        c.add(jl2);
        
        final JComboBox jc=new JComboBox();
        jc.setBounds(210, 170, 100, 25);
        jc.addItem("ÀÏÊ¦");
        c.add(jc);
		
        
        final JButton jb=new JButton("×¢²á");
        jb.setForeground(Color.BLUE);
        jb.setBackground(Color.cyan);
        jb.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        jb.setBounds(120,220,80,25);
        c.add(jb);
        
        jb.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			String username=jt.getText();
    			String password=jp.getText();
    			String type=(String)jc.getSelectedItem();
    			System.out.println(username+password+type);
    			datbase d=new datbase();
    			if("ÀÏÊ¦".equals(type)){
    				boolean flag=d.doRegistTeacher(username,password);
    				if(flag){
    					System.out.println("×¢²á³É¹¦£¡");
    				     new loginframe();
    				}else{
    					System.out.println("×¢²áÊ§°Ü");
    				}
    			
    			}
    			}
    	});

    	jb.addActionListener(new ActionListener(){

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			String type=(String) jc.getSelectedItem();
    			if("ÀÏÊ¦".equals(type)){
    				new Teacher_register();
    			}else{
    				new loginframe();
    			}
    		}
    		
    	});
	
        
        final JButton jb1=new JButton("·µ»Ø");
        jb1.setForeground(Color.BLUE);
        jb1.setBackground(Color.cyan);
        jb1.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        jb1.setBounds(250,220,80,25);
        jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				do_returnButton_actionPerformed(e);
				
			}
		});
        
        c.add(jb1);
        c.add(jla);
       
        this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Teacher_register t=new Teacher_register();
		t.setVisible(true);
		
	}


protected void do_returnButton_actionPerformed(ActionEvent e) {
	          dispose();
}
}