import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class AddWin extends JFrame implements ActionListener{
  JTextField  E,C;
  JButton  addbtn,canbtn;
  Connection   Con =null;
  Statement Stmt=null;
 public AddWin() {


super("添加单词");
this.setBounds(250,250,250,200);
this.setVisible(true);
JPanel p1=new JPanel();
p1.add(new Label("请输入要添加的单词:"));
E=new JTextField(20);
p1.add(E);
p1.add(new Label("请输入添加的单词的解释:"));
C=new JTextField(20);
p1.add(C);
addbtn=new JButton("确定");
canbtn=new JButton("取消");
p1.add(addbtn);
p1.add(canbtn);
getContentPane().add(p1);
addbtn.addActionListener(this);
canbtn.addActionListener(this);
this.validate();
}
public void actionPerformed(ActionEvent e)
{
  if (e.getSource() ==addbtn) 
   {
            if (E.getText().equals("") || C.getText().equals(""))
               {
                JOptionPane.showMessageDialog(this, "添加的单词或解释不能为空!", "警告",JOptionPane.WARNING_MESSAGE);
               }  //判断输入框不能为空
            else {
                try { add(); }
                catch (SQLException ee) {}
            }
   }
 else if (e.getSource() ==canbtn)
          {
            dispose();
        } 
}
 public static void main(String[] args) {
        AddWin addwin = new AddWin();
    }
   //实现添加新单词的功能
  public void add()throws SQLException
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
            JOptionPane.showMessageDialog(this,"此词汇已存在!","警告",JOptionPane.WARNING_MESSAGE);
                break;
            } 
        }
        if(boo==false)
        {
        String s1=""+E.getText().trim()+"",s2=""+C.getText().trim()+"";
        String temp="INSERT INTO student VALUES('"+s1+"','"+s2+"')";
        Stmt.executeUpdate(temp);
        JOptionPane.showMessageDialog(this,"添加成功!","恭喜", JOptionPane.WARNING_MESSAGE );
        dispose();
        }
        Con.close();
}
catch (SQLException e)
    		  { System.out.println("SQLException:1 "+e.getMessage()); }
}
}
      
