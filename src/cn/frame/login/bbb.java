package cn.frame.login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit.BoldAction;
import cn.database.bao.datbase;


public class bbb extends JFrame{
	public JButton jb;
	public JButton jb1;
    public bbb(){
	    setTitle("µ«¬ºΩÁ√Ê");
		setSize(400,500);
		setResizable(false);
		setLocationRelativeTo(null);
		
		Container c=getContentPane();
	    c.setLayout(null);
	    c.setBackground(new Color(250,250,250));
	    Image bjg=new ImageIcon("bj.png").getImage();
		JLabel bjl=new JLabel(new ImageIcon(bjg));
		bjl.setBounds(0, -100, 400, 350);
		
		Image bjg1=new ImageIcon("timg.jpg").getImage();
		JLabel bjl1=new JLabel(new ImageIcon(bjg1));
		bjl1.setBounds(0, 150, 400, 350);
		
		JLabel jl=new JLabel();
		jl.setText("View");
		jl.setForeground(new Color(230,230,230));
		jl.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.LAYOUT_LEFT_TO_RIGHT,28));
		jl.setBounds(50,-5,80,100);
		c.add(jl);
		
		Image i=new ImageIcon("tp1.jpg").getImage();
		JLabel jlable=new JLabel(new ImageIcon(i));
		jlable.setBounds(50, 80, 150, 60);
		c.add(jlable);
		
		Image i1=new ImageIcon("tp2.jpg").getImage();
		JLabel jlable1=new JLabel(new ImageIcon(i1));
		jlable1.setBounds(155, 80, 150, 60);
		c.add(jlable1);
		
		Image i2=new ImageIcon("tp3.jpg").getImage();
		JLabel jlable2=new JLabel(new ImageIcon(i2));
		jlable2.setBounds(260, 80, 150, 60);
		c.add(jlable2);
		
		Image i3=new ImageIcon("tp4.jpg").getImage();
		JLabel jlable3=new JLabel(new ImageIcon(i3));
		jlable3.setBounds(50, 150, 150, 60);
		c.add(jlable3);
		
		Image i4=new ImageIcon("tp5.jpg").getImage();
		JLabel jlable4=new JLabel(new ImageIcon(i4));
		jlable4.setBounds(155, 150, 150, 60);
		c.add(jlable4);
		
		Image i5=new ImageIcon("tp6.jpg").getImage();
		JLabel jlable5=new JLabel(new ImageIcon(i5));
		jlable5.setBounds(260, 150, 150, 60);
		c.add(jlable5);
		
		JLabel jl1=new JLabel();
		jl1.setText("±≥æ∞ ”Õº");
		jl1.setForeground(Color.WHITE);
		jl1.setBackground(new Color(200,200,200));
		jl1.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.LAYOUT_LEFT_TO_RIGHT,12));
		jl1.setBounds(120,0,80,100);
		c.add(jl1);
		
		c.add(bjl);
		
		JLabel jl2=new JLabel();
		jl2.setText("”√ªßµ«¬º");
		jl2.setForeground(Color.blue);
		jl2.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.LAYOUT_LEFT_TO_RIGHT,25));
		jl2.setBounds(70,200,150,100);
		c.add(jl2);
		
	    JLabel jl3=new JLabel();
		jl3.setText("Login");
	    jl3.setForeground(Color.blue);
		jl3.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.LAYOUT_LEFT_TO_RIGHT,15));
		jl3.setBounds(180,210,150,100);
		c.add(jl3);
		
		final JLabel jl4=new JLabel("”√ªß√˚");
		jl4.setForeground(Color.blue);
		jl4.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.LAYOUT_LEFT_TO_RIGHT,18));
		jl4.setBounds(70,280,100,25);
		c.add(jl4);
		
		final JTextField jt =new JTextField("«Î ‰»Îƒ˙µƒ”√ªß√˚");
		jt.setBounds(150, 280, 200, 30);
		c.add(jt);
		
		final JLabel jl6=new JLabel("√‹¬Î");
		jl6.setForeground(Color.blue);
		jl6.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.LAYOUT_LEFT_TO_RIGHT,18));
		jl6.setBounds(70,320,100,25);
		c.add(jl6);
			
		final JPasswordField jp=new JPasswordField();
		jp.setBounds(150, 320, 200, 30);
	    c.add(jp);
	    
	    final JLabel jl7=new JLabel("”√ªß¿‡–Õ");
		jl7.setForeground(Color.blue);
		jl7.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.LAYOUT_LEFT_TO_RIGHT,18));
		jl7.setBounds(60,362,100,25);
		c.add(jl7);
		
	    final JComboBox jc=new JComboBox();
	    jc.setEditable(true);
	    jc.setBackground(Color.blue);
	    jc.setForeground(Color.green);
	    jc.addItem("¿œ ¶");
		jc.setBounds(150, 360, 100, 30);
	    c.add(jc);
	   
	    JLabel jlba=new JLabel();
	    jlba.setBounds(200, 360, 120, 30);
	    c.add(jlba);
		jb=new JButton("µ«¬º");
		jb.setForeground(new Color(0,126,254));
	    jb.setBounds(70, 410, 100, 30);
	    jb.setBackground(Color.blue);
	    c.add(jb);
	    
	    jb1=new JButton("◊¢≤·");
		jb1.setForeground(new Color(0,126,254));
	    jb1.setBounds(200, 410, 100, 30);
	    jb1.setBackground(Color.blue);
	    c.add(jb1);
	    c.add(bjl1);
	    
	 
	   jb.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String username=jt.getText();
			String password=jp.getText();
			String type=(String)jc.getSelectedItem();
			System.out.println(username+password+type);
			datbase d=new datbase();
			if("¿œ ¶".equals(type)){
				boolean flag=d.doQueryTeacher(username,password);
				if(flag){
					System.out.println("µ«¬º≥…π¶£°");
				     new loginframe();
				}else{
					System.out.println("µ«¬º ß∞‹");
				}
			
			}
			}
	});

	jb1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			String type=(String) jc.getSelectedItem();
			if("¿œ ¶".equals(type)){
				new Teacher_register();
			}else{
				new loginframe();
			}
		}
		
	});
 }
  public static void main(String[] args) {
	 bbb b=new bbb();
     b.setVisible(true);
     b.setResizable(false);
  }
}