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
super("�޸�");
this.setBounds(250,250,250,200);
this.setVisible(true);
JPanel p1=new JPanel();
p1.add(new Label("������Ҫ�޸ĵĵ���:"));
E=new JTextField(20);
p1.add(E);
p1.add(new Label("������õ��ʵĺ������:"));
C=new JTextField(20);
p1.add(C);
modifybtn=new JButton("ȷ��");
canbtn=new JButton("ȡ��");
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
                JOptionPane.showMessageDialog(this, "�޸ĵĵ��ʻ���Ͳ���Ϊ��!", "����",JOptionPane.WARNING_MESSAGE);
               }  //�ж��������Ϊ��
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
   //ʵ���޸ĵ��ʵĹ���
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
            ename=rs.getString("����");
            cname=rs.getString("����");
            if(ename.equals(E.getText()))
            {
                   // String s1=""+E.getText().trim()+"",s2=""+C.getText().trim()+"";
                    String temp="UPDATE student  SET ����='"+E.getText().trim()+"',����='"+C.getText().trim()+"' WHERE ����='"+E.getText().trim()+"'	";
        	    Stmt.executeUpdate(temp);
        	   JOptionPane.showMessageDialog(this,"��¼�޸ĳɹ�!","��ϲ", JOptionPane.WARNING_MESSAGE );
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
      
