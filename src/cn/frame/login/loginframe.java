package cn.frame.login;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InvocationEvent;
import java.awt.event.MouseAdapter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.EventListenerList;

public class loginframe extends JFrame{
	    private static final long serialVersionUID = 5882409605868365475L;
	    private JPanel contentPane;
		private JPanel imageJPanel;
		private ImageIcon background;
	    
	    public static void main(String[] args) {
	        try {
	            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch (Throwable e) {

	        }
	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                try {
	                    loginframe frame = new loginframe();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

				 JMenuBar menu=new JMenuBar();
				 JMenu jibenxinxi=new JMenu();
				 JMenu xiaogongju=new JMenu();
				 
				 JMenuItem jishiben=new JMenuItem();
				 JMenuItem jisuanqi=new JMenuItem();
				 JMenuItem zengjiakecheng=new JMenuItem();
				 JMenuItem shanchukecheng=new JMenuItem();
				 JMenuItem xiugaikecheng=new JMenuItem();
				 JMenuItem chaxunkecheng=new JMenuItem();
				
				 public loginframe(){
					try {
						this.setSize(450,350);
						this.setLocationRelativeTo(null);
						this.setResizable(false);
						teacherframeInit();
						this.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				 }
				 
				private void teacherframeInit() throws Exception{
					jibenxinxi.setFont(new java.awt.Font("微软雅黑",1,15));
					jibenxinxi.setForeground(Color.green);
					jibenxinxi.setText("基本信息");
					
					zengjiakecheng.setFont(new java.awt.Font("微软雅黑",1,15));
					zengjiakecheng.setText("增加成绩单");
					zengjiakecheng.setForeground(Color.cyan);
					 zengjiakecheng.addActionListener(new ActionListener() {
				         @Override
				         public void actionPerformed(ActionEvent e) {
				            new add().setVisible(true);
				         }
				     });
					
					shanchukecheng.setFont(new java.awt.Font("微软雅黑",1,15));
					shanchukecheng.setText("删除成绩单");
					shanchukecheng.setForeground(Color.blue);
					shanchukecheng.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				            new delete().setVisible(true);
				        }
				    });
					
					xiugaikecheng.setFont(new java.awt.Font("微软雅黑",1,15));
					xiugaikecheng.setText("查询成绩单");
					xiugaikecheng.setForeground(Color.orange);
					xiugaikecheng.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				             new inquire().setVisible(true);
				        }
				    });
					
					chaxunkecheng.setFont(new java.awt.Font("微软雅黑",1,15));
					chaxunkecheng.setText("修改成绩单");
					chaxunkecheng.setForeground(Color.pink);
					chaxunkecheng.addActionListener(new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				        	new modify().setVisible(true);
				        }
				    });
					
					xiaogongju.setFont(new java.awt.Font("微软雅黑",1,15));
					xiaogongju.setForeground(Color.magenta);
					xiaogongju.setText("小工具");
					
					jishiben.setFont(new java.awt.Font("微软雅黑",1,15));
					jishiben.setText("记事本");
					jishiben.setForeground(Color.green);
					jishiben.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							do_notepadMenuItem_actionPerformed(e);
							
						}
					});
				    
				    jisuanqi.setFont(new java.awt.Font("微软雅黑",1,15));
					jisuanqi.setText("计算器");
					jisuanqi.setForeground(Color.MAGENTA);
					jisuanqi.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							do_calculatorMenuItem_actionPerformed(e);
							
						}
					});
					
						JLabel jlable=new JLabel();
						jlable.setFont(new java.awt.Font("华文斜体",1,30));
						jlable.setText("老师成绩管理模块");
						jlable.setForeground(new Color(30,250,254));
						jlable.setBounds(90, 40, 280, 40);
						
						Image i=new ImageIcon("phtot.jpg").getImage();
						JLabel j=new JLabel(new ImageIcon(i));
						j.setBounds(0,0,450,350);
						getContentPane().add(jlable);
						getContentPane().add(j);

					jibenxinxi.add(zengjiakecheng);
					jibenxinxi.add(xiugaikecheng);
					jibenxinxi.add(shanchukecheng);
					jibenxinxi.add(chaxunkecheng);
					
				    xiaogongju.add(jisuanqi);
				    xiaogongju.add(jishiben);
				    
					menu.add(jibenxinxi);
					menu.add(xiaogongju);

					 JLabel jl=new JLabel();
					 JPanel jp=new JPanel();
					 CardLayout c=new CardLayout();
					 BorderLayout b=new BorderLayout();
					 JPanel jp1=new JPanel();
					 BorderLayout b1=new BorderLayout();
					
					 jp.setLayout(c);
					 jp1.setLayout(b1);
					 jp1.setBackground(SystemColor.cyan);
					
					menu.setDoubleBuffered(false);
					menu.setVerifyInputWhenFocusTarget(true);
					this.getContentPane().setBackground(SystemColor.info);
					this.setJMenuBar(menu);
					this.getContentPane().setLayout(b);
					this.getContentPane().add(jp,BorderLayout.CENTER);
					this.getContentPane().add(jl);
					jp.add(jp1,"jp1");
					jp1.add(jl,BorderLayout.CENTER);	
				}
				
				protected void do_addGradeMenuItem_actionPerformed(ActionEvent e) {
				    EventQueue.invokeLater(new Runnable() {
				        public void run() {
				            try {
				              loginframe addframe = new loginframe();
				               addframe.setVisible(true);
				         } catch (Exception e) {
				              e.printStackTrace();
				            }
				      }
				    });
				}
				
				protected void do_deleteGradeMenuItem_actionPerformed(ActionEvent e) {
					
					 EventQueue.invokeLater(new Runnable() {
				         @Override
				         public void run() {
				             try {
				                 loginframe deleteframe = new loginframe();
				                 deleteframe.setVisible(true);
				             } catch (Exception e) {
				                 e.printStackTrace();
				             }
				         }
				     });
				}
				
				protected void do_queryGradeMenuItem_actionPerformed(ActionEvent e) {
				    EventQueue.invokeLater(new Runnable() {
				        @Override
				        public void run() {
				            try {
				                loginframe queryframe = new loginframe();
				                queryframe.setVisible(true);
				            } catch (Exception e) {
				                e.printStackTrace();
				            }
				        }
				    });
				}
				
				protected void do_modifyGradeMenuItem_actionPerformed(ActionEvent e) {
				       EventQueue.invokeLater(new Runnable() {
				        @Override
				        public void run() {
				            try {
				               loginframe modifyframe = new loginframe();
				                modifyframe.setVisible(true);
				            } catch (Exception e) {
				                e.printStackTrace();
				            }
				        }
				    });
				}
				
				 protected void do_notepadMenuItem_actionPerformed(ActionEvent e) {
				     Runtime runTime = Runtime.getRuntime();
				     try {
				         runTime.exec("notepad");
				     } catch (IOException e1) {
				         e1.printStackTrace();
				     }
				 }
				 
				 protected void do_calculatorMenuItem_actionPerformed(ActionEvent e) {
				     Runtime runTime = Runtime.getRuntime();
				     try {
				         runTime.exec("calc");
				     } catch (IOException e1) {
				         e1.printStackTrace();
				     }
				 }
				}