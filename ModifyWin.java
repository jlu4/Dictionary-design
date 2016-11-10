import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class ModifyWin extends JFrame implements ActionListener{
  JTextField  C,E;
  JButton  modifybtn,canbtn;
  Connection   Con =null;
  Statement Stmt=null;
 public ModifyWin() 
{
super("修改");
this.setBounds(250,250,250,200);
this.setVisible(true);
JPanel p1=new JPanel();
p1.add(new Label("请输入要修改的单词:"));
E=new JTextField(20);
p1.add(E);
p1.add(new Label("请输入该单词的汉语解释:"));
C=new JTextField(20);
p1.add(C);
modifybtn=new JButton("确定");
canbtn=new JButton("取消");
p1.add(modifybtn);
p1.add(canbtn);
getContentPane().add(p1);
modifybtn.addActionListener(this);
canbtn.addActionListener(this);
this.validate();
}
public void actionPerformed(ActionEvent e)
{
  if (e.getSource() ==modifybtn) 
   {
            if (E.getText().equals("") || C.getText().equals(""))
               {
                JOptionPane.showMessageDialog(this, "修改的单词或解释不能为空!", "警告",JOptionPane.WARNING_MESSAGE);
               }  //判断输入框不能为空
            else {
                try { modify(); }
                catch (SQLException ee) {}
            }
   }
 else if (e.getSource() ==canbtn)
          {
            dispose();
           //System.exit(0);
        } 
}
 public static void main(String[] args) {
        ModifyWin modifywin = new ModifyWin();
    }
   //实现修改单词的功能
  public void modify()throws SQLException
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
            if(ename.equals(E.getText()))
            {
                   // String s1=""+E.getText().trim()+"",s2=""+C.getText().trim()+"";
                    String temp="UPDATE student  SET 单词='"+E.getText().trim()+"',解释='"+C.getText().trim()+"' WHERE 单词='"+E.getText().trim()+"'	";
        	    Stmt.executeUpdate(temp);
        	   JOptionPane.showMessageDialog(this,"记录修改成功!","恭喜", JOptionPane.WARNING_MESSAGE );
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
      
