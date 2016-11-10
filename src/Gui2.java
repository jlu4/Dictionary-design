import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DropMode;
import java.awt.Color;
import java.io.IOException;
public class Gui2  extends javax.swing.JFrame  {
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JTextField jTextField1; //english
	Dict dict;
	public Gui2() {
		initComponents();
        dict=new Dict();
			dict.readDict();
			// TODO Auto-generated catch block

        

	}
	 private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
	        // TODO add your handling code here:
	    }//GEN-LAST:event_jTextField1ActionPerformed
        private void initComponents() {
        	jTextField1 = new javax.swing.JTextField();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jList2 = new javax.swing.JList();
            jLabel3 = new javax.swing.JLabel();
            setTitle("英汉词典");
          
            jTextField1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField1ActionPerformed(evt);
                }
            });
            jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    jTextField1KeyReleased(evt);
                }
            });
            this.jLabel1.setText("请输入查询的内容：");
            this.jLabel2.setText("查询结果：");
            jList1 = new javax.swing.JList();
            jList1.setBackground(Color.ORANGE);
            jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    jList1ValueChanged(evt);
                }
            });
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            layout.setHorizontalGroup(
            	layout.createParallelGroup(Alignment.LEADING)
            		.addGroup(layout.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
            				.addGroup(layout.createSequentialGroup()
            					.addComponent(jLabel1)
            					.addGap(18))
            				.addGroup(layout.createSequentialGroup()
            					.addComponent(jLabel2)
            					.addGap(30)))
            			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
            				.addComponent(jList1, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
            				.addGroup(layout.createSequentialGroup()
            					.addGap(229)
            					.addComponent(jLabel3))
            				.addComponent(jTextField1))
            			.addContainerGap(122, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
            	layout.createParallelGroup(Alignment.LEADING)
            		.addGroup(layout.createSequentialGroup()
            			.addGap(18)
            			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
            				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
            					.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            					.addComponent(jLabel1))
            				.addComponent(jLabel3))
            			.addPreferredGap(ComponentPlacement.UNRELATED)
            			.addGroup(layout.createParallelGroup(Alignment.LEADING)
            				.addComponent(jLabel2)
            				.addGroup(layout.createSequentialGroup()
            					.addGap(8)
            					.addComponent(jList1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
            			.addContainerGap())
            );
            getContentPane().setLayout(layout);

            pack();
        }
        private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
            // TODO add your handling code here:
            if(jList1.getSelectedValue()==null)
                return;
        }//GEN-LAST:event_jList1ValueChanged
        private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
            // TODO add your handling code here:
              String query=jTextField1.getText();
              if(!"".equals(query)){  //query是输入的单个字母
                 List<String> result = new LinkedList<String>();
                 if(Trie.hintSearch(dict.dic, query, result)){
                 jList1.removeAll();
                 DefaultListModel listModel=new DefaultListModel();
                 for(int i=0;i<result.size();i++){
                    listModel.addElement(result.get(i));
                }
                jList1.setModel(listModel);
                 }else
                 {
                	 DefaultListModel listModel=new DefaultListModel();
               	  listModel.addElement("您所查的单词不在词典中");
               	  jList1.setModel(listModel);
                 }
              }
              else
              {
            	  DefaultListModel listModel=new DefaultListModel();
            	  listModel.addElement("请输入要查询的单词");
            	  jList1.setModel(listModel);
              }
        }

        public static void main(String args[]) {
            java.awt.EventQueue.invokeLater(new Runnable() {
            
                public void run() {
                    new Gui2().setVisible(true);
                    
                }
            });
        }
}
