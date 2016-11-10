import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class DelWin extends JFrame implements ActionListener{
  JTextField  D;
  JButton  delbtn,canbtn;
  Connection   Con =null;
  Statement Stmt=null;
 public DelWin() 
{

super("删除单词");
this.setBounds(250,250,250,200);
this.setVisible(true);
JPanel p1=new JPanel();
p1.add(new Label("请输入要删除的单词:"));
D=new JTextField(20);
p1.add(D);
delbtn=new JButton("确定");
canbtn=new JButton("取消");
p1.add(delbtn);
p1.add(canbtn);
getContentPane().add(p1);
delbtn.addActionListener(this);
canbtn.addActionListener(this);
this.validate();
}
public void actionPerformed(ActionEvent e)
{
  if (e.getSource() ==delbtn) 
   {
            if (D.getText().equals(""))
               {
                JOptionPane.showMessageDialog(this, "删除的单词不能为空!", "警告",JOptionPane.WARNING_MESSAGE);
               }  //判断输入框不能为空
            else {
                try { delete(); }
                catch (SQLException ee) {}
            }
   }
 else if (e.getSource() ==canbtn)
          {
            dispose();
        } 
}//实现删除功能
 public static void main(String[] args) {
        DelWin delwin = new DelWin();
    }
   
  public void delete()throws SQLException
        {
	   String sql;
            try
            { Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); }
           catch (ClassNotFoundException ce){System.out.println("SQLException:"+ce.getMessage()); }
            try
	   { 
		String ename,cname;
     	        Con = DriverManager.getConnection("jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=student.mdb");
       	        Stmt = Con.createStatement(); 
                ResultSet rs =Stmt.executeQuery("SELECT * FROM student");
           boolean boo=false;
           while((boo=rs.next())==true)
            {
            ename=rs.getString("单词");
            cname=rs.getString("解释");
            if(ename.equals(D.getText()))
              {
       		 String temp="DELETE FROM student WHERE 单词='"+D.getText().trim()+"'";
       		 Stmt.executeUpdate(temp);
       		 JOptionPane.showMessageDialog(this,"成功删除记录!","恭喜", JOptionPane.WARNING_MESSAGE );
		 dispose();
                 break;
              } 
          }
        if(boo==false)
        {
            JOptionPane.showMessageDialog(this,"不存在此单词!","警告",JOptionPane.WARNING_MESSAGE);
        }
        Con.close();
}

catch (SQLException e)
    		  { System.out.println("SQLException:1 "+e.getMessage()); }
}
}
      
