import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import java.awt.*;
import javax.swing.JLabel;
public class Help extends JFrame {

    public Help() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {

        getContentPane().setLayout(null);
	this.setBounds(250,250,350,250);
        this.setTitle("������Ϣ");
        jLabel1.setFont(new java.awt.Font("����", Font.PLAIN, 18));
	jLabel1.setForeground(Color.black);
        jLabel1.setText("���ţ�0901����");
        jLabel1.setBounds(new Rectangle(65, 51, 131, 29));
        this.getContentPane().add(jLabel1);
        jLabel4.setFont(new java.awt.Font("����", Font.PLAIN, 18));
	jLabel4.setForeground(Color.black);
        jLabel4.setText("�ӷ���");
        jLabel4.setBounds(new Rectangle(117, 116, 55, 22));
        jLabel3.setFont(new java.awt.Font("����", Font.PLAIN, 18));
	jLabel3.setForeground(Color.black);
        jLabel3.setText("��С��");
        jLabel3.setBounds(new Rectangle(39, 116, 55, 22));
        jLabel2.setFont(new java.awt.Font("����", Font.PLAIN, 18));
	jLabel2.setForeground(Color.black);
        jLabel2.setText("������");
        jLabel2.setBounds(new Rectangle(196, 116, 55, 22));
	this.getContentPane().add(jLabel4);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(jLabel2);
	show();
    }
	public static void main(String [] args)
	{
		Help help=new Help();

   	 }


    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();

}
