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

super("ɾ������");
this.setBounds(250,250,250,200);
this.setVisible(true);
JPanel p1=new JPanel();
p1.add(new Label("������Ҫɾ���ĵ���:"));
D=new JTextField(20);
p1.add(D);
delbtn=new JButton("ȷ��");
canbtn=new JButton("ȡ��");
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
                JOptionPane.showMessageDialog(this, "ɾ���ĵ��ʲ���Ϊ��!", "����",JOptionPane.WARNING_MESSAGE);
               }  //�ж��������Ϊ��
            else {
                try { delete(); }
                catch (SQLException ee) {}
            }
   }
 else if (e.getSource() ==canbtn)
          {
            dispose();
        } 
}//ʵ��ɾ������
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
            ename=rs.getString("����");
            cname=rs.getString("����");
            if(ename.equals(D.getText()))
              {
       		 String temp="DELETE FROM student WHERE ����='"+D.getText().trim()+"'";
       		 Stmt.executeUpdate(temp);
       		 JOptionPane.showMessageDialog(this,"�ɹ�ɾ����¼!","��ϲ", JOptionPane.WARNING_MESSAGE );
		 dispose();
                 break;
              } 
          }
        if(boo==false)
        {
            JOptionPane.showMessageDialog(this,"�����ڴ˵���!","����",JOptionPane.WARNING_MESSAGE);
        }
        Con.close();
}

catch (SQLException e)
    		  { System.out.println("SQLException:1 "+e.getMessage()); }
}
}
      
