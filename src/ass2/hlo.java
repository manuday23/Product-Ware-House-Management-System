package ass2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;  
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;  
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;  
public class hlo extends JFrame implements ComponentListener , WindowListener, WindowStateListener  {  
	/**
	 * 
	 */
	private static String n;
	public String getUsername () {
		return this.n;
	}
	private static final long serialVersionUID = 1L;
	JButton login = new JButton("Login");
	private JPanel contentPane;  
	private JTextField textField;
	private JPasswordField textField_1;
	JPanel c = new JPanel(){  
		public void paintComponent(Graphics g) {  
			Image img = Toolkit.getDefaultToolkit().getImage(  
					hlo.class.getResource("/logo.png"));  
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
		}  
	};
	/**  
	 * Launch the application.  
	 */  
	public static void main(String[] args) {  
		//Dbconnect connect = new Dbconnect();

		//connect.addData();
		// connect.getData();
		// connect.checkData();


		EventQueue.invokeLater(new Runnable() {  
				public void run() {  
				try {  
				hlo frame = new hlo();  
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
	public hlo() {  
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0,0,screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		// setBounds(100, 100, 450, 300);  
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(  
						hlo.class.getResource("/hhh.jpg"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		};
		contentPane.setLayout(null);
		//      JPanel c = new JPanel();
		c.setBounds((screenSize.width / 2)  - 225 , (screenSize.height / 2 ) - 150 , 450 ,  300);
		contentPane.add(c);
		c.setLayout(null);
		login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				Dbconnect connect = new Dbconnect();
				String username = textField.getText();
				char input[]  = textField_1.getPassword();
				String password = new String(input);
				if(connect.checkData(username, password) ) { 
				hlo.n = username;
				call();
				}
				else {
				textField.setText("");
				textField_1.setText("");
				}

				}
				});
		login.setBounds(98, 133, 80, 33);
		c.add(login);
		JButton btnNew = new JButton("New");
		btnNew.setBounds(208, 133, 80, 33);
		c.add(btnNew);
		btnNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) { 
				dispose();
				callreg();
				}
				});
		textField = new JTextField();
		textField.setBounds(138, 42, 150, 20);
		c.add(textField);
		textField.setColumns(30);
		textField_1 = new JPasswordField();
		textField_1.setBounds(138, 87, 150, 20);
		c.add(textField_1);
		textField_1.setColumns(30);
		JLabel lblUsern = new JLabel("Username");
		lblUsern.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsern.setBounds(42, 45, 70, 14);
		c.add(lblUsern);
		JLabel lblPasswrd = new JLabel("Password");
		lblPasswrd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPasswrd.setBounds(42, 90, 70, 14);
		c.add(lblPasswrd);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);  

		this.addComponentListener(this);
		this.addWindowListener(this);
		this.addWindowStateListener( this);
	}  
	public static void callreg(){
		String s[] = new String[10];
		reg.main(s);
	}
	public static void call() {
		String s[] = new String[10];

		frm.main(s);
	}
	public void componentHidden(ComponentEvent ce) {

	};
	public void componentShown(ComponentEvent ce) {};
	public void componentMoved(ComponentEvent ce) { };

	public void componentResized(ComponentEvent ce) {
		int height = this.getHeight();
		int width = this.getWidth();
		c.setBounds((width / 2) - 307, (height / 2 ) - 177 , 549, 354);
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

}  
