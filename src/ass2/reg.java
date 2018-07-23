package ass2;
import java.awt.BorderLayout;  
import java.awt.EventQueue;  
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;  
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;  
 public class reg extends JFrame implements ComponentListener , WindowListener, WindowStateListener  {  
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton login = new JButton("Submit");
	 private JPanel contentPane;  
	 private JTextField textField;
	 private JTextField textField_1;
	 JPanel c = new JPanel(){  
         public void paintComponent(Graphics g) {  
             Image img = Toolkit.getDefaultToolkit().getImage(  
                       reg.class.getResource("/logo.png")); 
             img = null;
              g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
              
         }  
    };
	 private JPasswordField textField_2;
	 private JPasswordField textField_3;
	 private JTextField textField_4;
       /**  
        * Launch the application.  
        */  
       public static void main(String[] args) {  
            EventQueue.invokeLater(new Runnable() {  
                 public void run() {  
                     try {  
                          reg frame = new reg();  
                           frame.setVisible(true);  
                     } catch (Exception e) {  
                          e.printStackTrace();  
                      }  
                }  
            });  
       }  
       /**  
        * Create the frame.  
        */  
      public reg() {  
    	  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,screenSize.width, screenSize.height);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
          // setBounds(100, 100, 614, 422);  
            contentPane = new JPanel() {  
                 public void paintComponent(Graphics g) {  
                     Image img = Toolkit.getDefaultToolkit().getImage(  
                               reg.class.getResource("/hhh.jpg"));  
                      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
                 }  
            };
            contentPane.setLayout(null);
          //  c.setBounds(10, 18, 549, 354);
            c.setBounds((screenSize.width / 2 ) - 307 , ((screenSize.height / 2) - 177), 614 , 354  );
            contentPane.add(c);
            login.setBounds(96, 282, 80, 33);
            login.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent arg0) {
            		 String message = "  Successfully registered ";
            			   // JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
            			    char[] input = textField_2.getPassword();
            			    char[] input2 = textField_3.getPassword();
            			    String Pass = new String(input);
            			    String pass2 = new String(input2);
            			    int i;
            			    int n = Pass.length();
            			    int flag = 0;
            			    for(i=0;i<n;i++)
            			    {
            			    	if(input[i] != input2[i])
            			    	{
            			    		flag = 1;
            			    		
            			    	}
            			    }
            			    if(flag == 1)
            			    {
            			    	JOptionPane.showMessageDialog(new JFrame(), "Password not matched", "Dialog", JOptionPane.ERROR_MESSAGE);
            			    	flag =0;
            			    	textField.setText("");
        			    		textField_1.setText("");
            			    	
            			    }
            			    else {
            			    	String name = textField.getText();
            			    	String username = textField_1.getText();
            			    	String phno = (textField_4.getText());
            			    	Dbconnect connect = new Dbconnect();
            			    	
            			    	if (connect.checkData(username  ) == true) {
            			    		JOptionPane.showMessageDialog(new JFrame(), "Username Already  Exits ", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                    			
            			    	}
            			    	else {
            			    		connect.addData(name,username,Pass,phno);
            			    		JOptionPane.showMessageDialog(new JFrame(), "Successfully registered ", "Dialog", JOptionPane.INFORMATION_MESSAGE);
            			    		
            			    	}
                    		
            			    }
            	}
            });
            c.setLayout(null);
            c.add(login);
            JButton btnNew = new JButton("Clear");
            btnNew.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent arg0) {
            		textField.setText("");
            		textField_1.setText("");
            		textField_2.setText("");
            		textField_3.setText("");
            		textField_4.setText("");
            	}
            });
            btnNew.setBounds(249, 282, 80, 33);
            c.add(btnNew);
            textField = new JTextField();
            textField.setBounds(230, 36, 197, 20);
            c.add(textField);
            textField.setColumns(30);
            textField_1 = new JTextField();
            textField_1.setBounds(230, 72, 197, 20);
            c.add(textField_1);
            textField_1.setColumns(30);
            JLabel lblUsern = new JLabel("Name");
            lblUsern.setBounds(52, 37, 70, 14);
            lblUsern.setFont(new Font("Tahoma", Font.BOLD, 14));
            c.add(lblUsern);
            JLabel lblPasswrd = new JLabel("Username");
            lblPasswrd.setBounds(52, 73, 70, 14);
            lblPasswrd.setFont(new Font("Tahoma", Font.BOLD, 14));
            c.add(lblPasswrd);
            
            JLabel lblCreatePassword = new JLabel("Create Password:");
            lblCreatePassword.setBounds(50, 116, 122, 14);
            lblCreatePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
            c.add(lblCreatePassword);
            
            JLabel lblConfirmPassword = new JLabel("Confirm Password:");
            lblConfirmPassword.setBounds(50, 160, 141, 14);
            lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
            c.add(lblConfirmPassword);
            
            textField_2 = new JPasswordField();
            textField_2.setBounds(230, 115, 197, 20);
            textField_2.setColumns(30);
            c.add(textField_2);
            
            textField_3 = new JPasswordField();
            textField_3.setBackground(Color.WHITE);
            textField_3.setForeground(Color.BLACK);
            textField_3.setBounds(230, 159, 197, 20);
            textField_3.setColumns(30);
            c.add(textField_3);
            
            JLabel lblPhoneNo = new JLabel("Phone No:");
            lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 14));
            lblPhoneNo.setBounds(50, 207, 141, 14);
            c.add(lblPhoneNo);
            
            textField_4 = new JTextField();
            textField_4.setColumns(30);
            textField_4.setBounds(230, 206, 197, 20);
            c.add(textField_4);
            
            JButton btnLogin = new JButton("Login");
            btnLogin.setBounds(416, 282, 80, 33);
            c.add(btnLogin);
            btnLogin.addActionListener(new ActionListener () {
        		public void actionPerformed(ActionEvent e ) {
        			dispose();
        			String s = null;
        			call();
        		}
        });
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);  
           
            this.addComponentListener(this);
            this.addWindowListener(this);
            this.addWindowStateListener( this);
       }  
      public void componentHidden(ComponentEvent ce) {
  		
  	};
      public void componentShown(ComponentEvent ce) {};
	  public void componentMoved(ComponentEvent ce) { };
	 
	  public void componentResized(ComponentEvent ce) {
	    int height = this.getHeight();
	    int width = this.getWidth();
	    c.setBounds((width / 2) - 307 , (height / 2 ) - 177 , 549 , 354  );
       
	  };
	  public void windowClosed(WindowEvent e) {
	        //This will only be seen on standard output.
	        
	    }

	    public void windowOpened(WindowEvent e) {
	      
	    }

	    public void windowIconified(WindowEvent e) {
	    	
		
	    }

	    public void windowDeiconified(WindowEvent e) {
	    	
		
	        
	    }

	    public void windowActivated(WindowEvent e) {
	    
		
	    }

	    public void windowDeactivated(WindowEvent e) {
	
		
	    }

	    public void windowGainedFocus(WindowEvent e) {
	    	
		
	    }

	    public void windowLostFocus(WindowEvent e) {
	    	
	    }

	    public void windowStateChanged(WindowEvent e) {
	    	if (e.getNewState() == JFrame.MAXIMIZED_BOTH) {
	    		int height = this.getHeight();
			    int width = this.getWidth();
			    int iniw = 450;
			    int inih = 300;
			    c.setBounds( (width  / 2 ) - (c.getWidth() / 2) , ((height / 2) - (c.getHeight() /  2) ), c.getWidth() , c.getHeight()  );
			  
			//    c.setBounds(width /c.getBounds().x, height  /c.getBounds().y, c.getWidth() , c.getHeight()  );
			   
	    	}
	
	    }
	    public void windowClosingEvent() {
		  	
	  }
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		public static void call() {
        	String s[] = new String[10];
        	hlo.main(s);
        }
  }  