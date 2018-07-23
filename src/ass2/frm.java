package ass2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class frm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm frame = new frm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void calljtable(String s){
		String str[] = new String[10];
		str[0] = s;
		JTableWithImage.main(str);
	}

	/**
	 * Create the frame.
	 */
	public frm() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 764);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(300, 200, 575, 26);
		contentPane.add(menuBar);
		/*user.addFocusListener(new FocusListener(){
            	public void focusGained(FocusEvent e ){
                	user.setText(null);
            	}

            	@Override
            	public void focusLost(FocusEvent e) {
               		user.setText("Enter Username");
            	}
        	});*/
		JMenu mnElectronics = new JMenu("   Electronics      ");
		mnElectronics.setForeground(Color.RED);
		mnElectronics.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		menuBar.add(mnElectronics);
		
		JMenuItem mntmSmartPhones = new JMenuItem("Smart Phones");
		
		mntmSmartPhones.addActionListener(new ActionListener () {
					public void actionPerformed(ActionEvent e ) {
					//	JTableWithImage j = new JTableWithImage();
							String s = "Smart Phone";
						calljtable(s);
					}
		});
		
		buttonGroup.add(mntmSmartPhones);
		mntmSmartPhones.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnElectronics.add(mntmSmartPhones);
		
		JMenuItem mntmLaptops = new JMenuItem("Laptops");
		mntmLaptops.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Laptop";
				calljtable(s);
			}
		});
		
		mntmLaptops.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnElectronics.add(mntmLaptops);
		
		JMenuItem mntmMemoryCards = new JMenuItem("Memory Cards");
		mntmMemoryCards.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Memory Cards";
				calljtable(s);
			}
		});
		mntmMemoryCards.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnElectronics.add(mntmMemoryCards);
		
		JMenuItem mntmComputrPeripherals = new JMenuItem("Computr Peripherals");
		mntmComputrPeripherals.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Computer Peripherals";
				calljtable(s);
			}
		});
		mntmComputrPeripherals.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnElectronics.add(mntmComputrPeripherals);
		
		JMenuItem mntmCamera = new JMenuItem("Camera");
		mntmCamera.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Camera";
				calljtable(s);
			}
		});
		mntmCamera.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnElectronics.add(mntmCamera);
		
		JMenu mnAccessories = new JMenu("Appliances      ");
		mnAccessories.setForeground(Color.RED);
		mnAccessories.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		menuBar.add(mnAccessories);
		
		JMenuItem mntmWashingMachine = new JMenuItem("Washing Machine");
		mntmWashingMachine.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Washing Machine";
				calljtable(s);
			}
		});
		
		mntmWashingMachine.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnAccessories.add(mntmWashingMachine);
		
		JMenuItem mntmKitchenAppliances = new JMenuItem("Kitchen Appliances");
		mntmKitchenAppliances.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Kitchen Appliances";
				calljtable(s);
			}
		});
		mntmKitchenAppliances.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnAccessories.add(mntmKitchenAppliances);
		
		JMenuItem mntmRefrigerators = new JMenuItem("Refrigerators");
		mntmRefrigerators.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Refrigerators";
				calljtable(s);
			}
		});
		mntmRefrigerators.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnAccessories.add(mntmRefrigerators);
		
		JMenuItem mntmAirConditioners = new JMenuItem("Air conditioners");
		mntmAirConditioners.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "AC";
				calljtable(s);
			}
});
		mntmAirConditioners.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnAccessories.add(mntmAirConditioners);
		
		JMenu mnMens = new JMenu("Men     ");
		mnMens.setForeground(Color.RED);
		mnMens.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		menuBar.add(mnMens);
		
		JMenuItem mntmClothing = new JMenuItem("Clothing");
		mntmClothing.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Men Clothing";
				calljtable(s);
			}
		});
		mntmClothing.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnMens.add(mntmClothing);
		
		JMenuItem mntmWatches = new JMenuItem("Watches");
		mntmWatches.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Watch";
				calljtable(s);
			}
		});
		mntmWatches.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnMens.add(mntmWatches);
		
		JMenuItem mntmPersonalCareApplaiences = new JMenuItem("Personal Care Applaiences");
		mntmPersonalCareApplaiences.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "MCA";
				calljtable(s);
			}
		});
		mntmPersonalCareApplaiences.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnMens.add(mntmPersonalCareApplaiences);
		
		JMenu mnWomens = new JMenu("Women     ");
		mnWomens.setForeground(Color.RED);
		mnWomens.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		menuBar.add(mnWomens);
		
		JMenuItem mntmFootwear = new JMenuItem("Footwear");
		mntmFootwear.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Footwear";
				calljtable(s);
			}
		});
		mntmFootwear.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnWomens.add(mntmFootwear);
		
		JMenuItem mntmBeautyGrooming = new JMenuItem("Beauty & Grooming");
		mntmBeautyGrooming.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "B & G";
				calljtable(s);
			}
		});
		mntmBeautyGrooming.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnWomens.add(mntmBeautyGrooming);
		
		JMenuItem mntmJwellery = new JMenuItem("Jwellery");
		mntmJwellery.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Jewellery";
				calljtable(s);
			}
		});
		mntmJwellery.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnWomens.add(mntmJwellery);
		
		JMenuItem mntmPersonalCareAppliances = new JMenuItem("Personal Care Appliances");
		mntmPersonalCareAppliances.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "PCA";
				calljtable(s);
			}
		});
		mntmPersonalCareAppliances.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnWomens.add(mntmPersonalCareAppliances);
		
		JMenu mnKids = new JMenu("Books & More     ");
		mnKids.setForeground(Color.RED);
		mnKids.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		menuBar.add(mnKids);
		
		JMenuItem mntmGaming = new JMenuItem("Gaming");
		mntmGaming.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Gaming";
				calljtable(s);
			}
		});
		mntmGaming.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnKids.add(mntmGaming);
		
		JMenuItem mntmMusic = new JMenuItem("Music");
		mntmMusic.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Music";
				calljtable(s);
			}
		});
		mntmMusic.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnKids.add(mntmMusic);
		
		JMenuItem mntmMoviesTv = new JMenuItem("Movies & TV Shows");
		mntmMoviesTv.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Movie & TV";
				calljtable(s);
			}
		});
		mntmMoviesTv.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnKids.add(mntmMoviesTv);
		
		JMenuItem mntmMusicalInstruments = new JMenuItem("Musical Instruments");
		mntmMusicalInstruments.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Music Instrument";
				calljtable(s);
			}
		});
		mntmMusicalInstruments.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnKids.add(mntmMusicalInstruments);
		
		JMenuItem mntmSports = new JMenuItem("Sports");
		mntmSports.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
			//	JTableWithImage j = new JTableWithImage();
					String s = "Sports";
				calljtable(s);
			}
		});
		mntmSports.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		mnKids.add(mntmSports);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
