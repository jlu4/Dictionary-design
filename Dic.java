
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Dic extends JFrame implements ActionListener
{	
	JPanel panel1;
            Container c;
          JLabel titleLabel;
	 
 	    JMenuBar jMenuBar1 = new JMenuBar();
            JMenu file = new JMenu("文件");
            JMenu edit = new JMenu("编辑");
            JMenu about = new JMenu("关于");
            JMenuItem jMenuItem1 = new JMenuItem("作者信息");
            JMenuItem addword = new JMenuItem("添加词汇");
            JMenuItem modword = new JMenuItem("修改词汇");
            JMenuItem delword = new JMenuItem("删除词汇");
            JMenuItem edic = new JMenuItem("英汉词典");
            JMenuItem cdic = new JMenuItem("汉英词典");
            JMenuItem exit = new JMenuItem("退出");
            JLabel jL1 = new JLabel("请输入要查询的英语单词：");
            JTextField jTextField1 = new JTextField();
            JTextArea jTextArea1 = new JTextArea();
            JButton JB1 = new JButton("查询");
            JButton JB2 = new JButton("添加");
            JButton JB3 = new JButton("修改");
            JButton JB4 = new JButton("删除");

    public Dic() 
        {

                try 
                    { jbInit();} 
                catch (Exception exception) 
                    {exception.printStackTrace();}
        }

    private void jbInit() throws Exception 
        {
            getContentPane().setLayout(null);
            this.setJMenuBar(jMenuBar1);
            this.setTitle("汉英小词典");
            this.setBounds(250,250,500,380);
            jL1.setFont(new java.awt.Font("楷体_GB2312", Font.PLAIN, 20));
            jL1.setBounds(new Rectangle(18, 59, 249, 29));
            jTextField1.setBounds(new Rectangle(254, 60, 138, 24));
            JB1.setBounds(new Rectangle(405, 59, 71, 25));
            JB1.setFont(new java.awt.Font("楷体_GB2312", Font.PLAIN, 15));
            jTextArea1.setBounds(new Rectangle(25, 92, 445, 163));
            JB2.setBounds(new Rectangle(46, 272, 71, 25));
            JB3.setBounds(new Rectangle(164, 272, 71, 25));
            JB4.setBounds(new Rectangle(289, 273, 71, 25));
            JB4.setToolTipText("");
            jMenuBar1.add(file);
            jMenuBar1.add(edit);
            jMenuBar1.add(about);
            about.add(jMenuItem1);
            edit.add(addword);
            edit.add(modword);
            edit.add(delword);
            file.add(edic);
            file.add(cdic);
            file.add(exit);
            this.getContentPane().add(jL1);
            this.getContentPane().add(jTextField1);
            this.getContentPane().add(jTextArea1);
            this.getContentPane().add(JB1);
            this.getContentPane().add(JB2);
            this.getContentPane().add(JB3);
            this.getContentPane().add(JB4);
            show();	
	    edic.addActionListener(this);
  	    cdic.addActionListener(this);
	    exit.addActionListener(this);
	    addword.addActionListener(this);
  	    modword.addActionListener(this);
	    delword.addActionListener(this);
  	    jMenuItem1.addActionListener(this);
 	    JB1.addActionListener(this);
	    JB2.addActionListener(this);
  	    JB3.addActionListener(this);
	    JB4.addActionListener(this);
		titleLabel=new JLabel(new ImageIcon(".\\1.jpg"));
	        c = getContentPane();
		c.setLayout(new BorderLayout());
		panel1 = new JPanel();
          	panel1.setLayout(new BorderLayout());
 		panel1.add(titleLabel,BorderLayout.WEST);
	    	c.add(panel1,BorderLayout.WEST); 
                }



  public void actionPerformed(ActionEvent e)
{		
		if(e.getSource()==JB1||e.getSource()==jTextField1)		
		{
			jTextArea1.setText("");
			if(jTextField1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"查询对象不能为空!","警告",2);
			}
			else 
			{
				try{Listword();}
				catch(SQLException ee){ };
			}
		}

		else if(e.getSource()==edic)
		{	
			jTextArea1.setText("");
			jTextField1.setText("");
			jL1.setText("请输入要查询的英语单词：");
			JB1.setVisible(true);
		}
		else if(e.getSource()==cdic)
		{
			jTextArea1.setText("");
			jTextField1.setText("");
			jL1.setText("请输入要查询的汉语意思：");
			JB1.setVisible(true);
		}		
		else if(e.getSource()==addword||e.getSource()==JB2)
		{
			new AddWin();					//添加窗口的类
		}
		else if(e.getSource()==modword||e.getSource()==JB3)
		{
			new ModifyWin();				//添加窗口的类
		}
		else if(e.getSource()==delword||e.getSource()==JB4)
		{
			new DelWin();					//添加窗口的类
		}
		else if(e.getSource()==jMenuItem1)
		{
			new Help();					//添加窗口的类
		}
		else if(e.getSource()==exit)					//退出
               {
                       System.exit(0);
                } 
		


}	
			public void Listword() throws SQLException
			{
				String   sql;
				try
      				{ Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); }
    				catch (ClassNotFoundException ce)
    			  	{ System.out.println("SQLException:"+ce.getMessage()); }
 				try
     				 {
					String ename,cname;
     			  	    Connection con = DriverManager.getConnection("jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=student.mdb");
       				    Statement stmt = con.createStatement();
				    if(jL1.getText().equals("请输入要查询的英语单词："))									      {
						ResultSet rs=stmt.executeQuery("SELECT * FROM student");
						while(rs.next())
						{
							ename=rs.getString("单词");
							cname=rs.getString("解释");	
							if(ename.equals(jTextField1.getText()))
							{
							jTextArea1.append(cname+'\n');
							}
						}
						con.close();			//关闭数据库
						if(jTextArea1.getText().equals(""))
						{
							JOptionPane.showMessageDialog(this,"查无此单词!","警告",2);
						}
					}
				 	else if(jL1.getText().equals("请输入要查询的汉语意思："))
					{				
						ResultSet rs=stmt.executeQuery("SELECT * FROM student");
						while(rs.next())
						{
							ename=rs.getString("单词");
							cname=rs.getString("解释");
							if(cname.equals(jTextField1.getText()))
							{
							jTextArea1.append(ename+'\n');
							}
						}
						con.close();	
						if(jTextArea1.getText().equals(""))
						{
							JOptionPane.showMessageDialog(this,"查无此单词!","警告",2);
						}
					 }
				}
 				catch (SQLException e)
    				  { System.out.println("SQLException:1 "+e.getMessage()); }
			}

    public static void main(String[] args) 
        {
                 Dic frame1 = new Dic();
frame1.addWindowListener(new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {  System.exit( 0 );  }
         });
        }


}










