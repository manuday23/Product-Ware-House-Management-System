package ass2;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JTableWithImage extends javax.swing.JFrame implements ListSelectionListener  {
    ArrayList<Product2> list ;
    Dbconnect ob = new Dbconnect();

    public JTableWithImage(String s) {
        initComponents();
        populateJTable(s);
    }
    
    public void populateJTable(String s){
        MyQuery mq = new MyQuery();
       
        //ArrayList<Product2> list = mq.BindTable( s);
        list = mq.BindTable(s);
        String[] columnName = {"Id","Name","Qte","Price","Image","Categorie"};
        Object[][] rows = new Object[list.size()][6];
        for(int i = 0; i < list.size(); i++){
            rows[i][0] = list.get(i).getID();
            rows[i][1] = list.get(i).getName();
            rows[i][2] = list.get(i).getQte();
            rows[i][3] = list.get(i).getPrice();
            
            if(list.get(i).getMyImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
                
            rows[i][4] = image;
            }
            else{
                rows[i][4] = null;
            }
            rows[i][5] = list.get(i).getCatID();
        }
        
        TheModel model = new TheModel(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
        
    }
    
    public void jtable1(String si) {
    	String s[] = new String[10];
    	s[0] = si;
    	JTableWithImage.main(s);
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
            
            
            
        ));
        
        
       /* jTable1.addMouseListener(new MouseAdapter () {
            
            public void mouseClicked(MouseEvent e) {
                
                   int row = jTable1.rowAtPoint(e.getPoint);
                   int col = jTable1.columnAtPoint(e.getPoint());
                   
           				jtable1(str);
                   
           		
                  
                }
            
        });*/
       /* jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });*/
        
        
        
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           
            public void valueChanged(ListSelectionEvent event) {
            	
                if (jTable1.getSelectedRow() > -1) {
                	
                	String username = (new hlo()).getUsername();
                    // print first column value from selected row
                	int id = Integer.parseInt((jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
                    String pname = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                    int qte =	Integer.parseInt((jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()));
                    int price = Integer.parseInt((jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString()));
                   // byte[] Image = (byte[]) jTable1.getValueAt(jTable1.getSelectedRow(), 4);
                    String Cat =  jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
                    ob.addData(username,id,pname,qte,price,Cat);
                    //System.out.println(id+"  "+pname+"  "+qte+"  "+price+"  "+Cat);
		    		String input = JOptionPane.showInputDialog(new JFrame(), "Enter quantity ", "Dialog", JOptionPane.INFORMATION_MESSAGE);
		    		int inquan = Integer.parseInt(input);
		    		while(qte < inquan)
		    		{
			    		input = JOptionPane.showInputDialog(new JFrame(), "Not Sufficient quantity, Enter lesser Quantuty ", "Dialog", JOptionPane.INFORMATION_MESSAGE);
			    		inquan = Integer.parseInt(input);
		    		}
		    		ob.addData(username,id,pname,inquan,price,Cat);
		    		
                    
                }
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                                                            

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JTableWithImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JTableWithImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JTableWithImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JTableWithImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JTableWithImage(args[0]).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}


