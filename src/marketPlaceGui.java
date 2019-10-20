import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class marketPlaceGui extends JFrame {
	private JButton myLoan;
	private JButton myBuyer;
	private JPanel myNorthPanel;
	private JPanel myCenterPanel;
	private JPanel mySouthPanel;
	private JButton myMarketView;
	ArrayList<Listing> myMarket;
	public marketPlaceGui() {
		super("I put that crack in my crack");
		initializeFields();
	}

	private void initializeFields() {
		myMarket = new ArrayList<Listing>();
		myLoan = new JButton("Loaner");
		myBuyer = new JButton("Buyer");
		myMarketView = new JButton("View Market");
		myNorthPanel = new JPanel(new FlowLayout());
		myCenterPanel = new JPanel(new FlowLayout());
		mySouthPanel = new JPanel(new FlowLayout());
	}

	private JPanel makeNorth() {
		JPanel useless = new JPanel();
		useless.setLayout(new BorderLayout());
		myMarketView.setEnabled(false);
		myMarketView.setPreferredSize(new Dimension(300, 125));
		myMarketView.setFont(new Font("Arial", Font.PLAIN, 40));
		myMarketView.addActionListener(event -> {
			JButton closeButton = new JButton("Close");
			
			JFrame marketFrame = new JFrame();
			JPanel panel1 = new JPanel();
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
			JTextArea textArea = new JTextArea(5,20);
			
			for(Listing l: myMarket) {
				textArea.append(l.toString());
			}
			closeButton.addActionListener(event2 -> {
				marketFrame.dispose();
			});
			
			panel1.add(textArea);
			panel1.add(closeButton);
			marketFrame.setContentPane(panel1);
			marketFrame.pack();
			marketFrame.setMinimumSize(getSize());
			marketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			marketFrame.setLocationRelativeTo(null);
			marketFrame.setVisible(true);
		});
		
		myLoan.setPreferredSize(new Dimension(300, 125));
		myLoan.setFont(new Font("Arial", Font.PLAIN, 40));

		myLoan.addActionListener(event -> {
			loanAction();
		});
		useless.add(myLoan, BorderLayout.NORTH);
		useless.add(myMarketView, BorderLayout.SOUTH);
		myNorthPanel.add(useless);

		return myNorthPanel;
	}

	private JPanel makeCenter() {

		myCenterPanel.setPreferredSize(new Dimension(1100, 700));
		ImageIcon imageIcon = new ImageIcon("pic.jpg");
		JLabel label = new JLabel(imageIcon);
		myCenterPanel.setPreferredSize(new Dimension(1100, 700));
		myCenterPanel.add(label);
		return myCenterPanel;
	}

	private JPanel makeSouth() {
		myBuyer.setPreferredSize(new Dimension(300, 125));
		myBuyer.setFont(new Font("Arial", Font.PLAIN, 40));
		myBuyer.addActionListener(event -> {
			buyerAction();
		});
		mySouthPanel.add(myBuyer);
		return mySouthPanel;
	}

	private void loanAct() {
		JFrame frame1 = new JFrame();
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel name = new JLabel("Name: ");
		JLabel address = new JLabel("Address: ");
		JLabel email = new JLabel("Email: ");
		JLabel card = new JLabel("Credit Card Number: ");

		JTextField nameF = new JTextField(15);
		JTextField addF = new JTextField(35);
		JTextField emailF = new JTextField(20);
		JTextField cardF = new JTextField(16);

		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout());
		namePanel.add(name);
		namePanel.add(nameF);

		JPanel addPanel = new JPanel();
		addPanel.setLayout(new FlowLayout());
		addPanel.add(address);
		addPanel.add(addF);

		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout());
		emailPanel.add(email);
		emailPanel.add(emailF);

		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(new FlowLayout());
		cardPanel.add(card);
		cardPanel.add(cardF);
		
		JButton button = new JButton("Submit");
		button.addActionListener(event -> {
			
			myMarketView.setEnabled(true);
			User tempUser = new User(nameF.getText(), addF.getText(), emailF.getText(), Integer.parseInt(cardF.getText()), myMarket);
			
			frame1.dispose();
			JFrame frame2 = new JFrame();
			JPanel panel1 = new JPanel();

			panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
			
			JLabel amount = new JLabel("Amount Giving: ");
			JTextField amountB = new JTextField(15);
			JPanel amountPanel = new JPanel();
			
			JLabel days = new JLabel("Days to pay off: ");
			JTextField daysB = new JTextField(15);
			JPanel daysPanel = new JPanel();
			
			JLabel interest = new JLabel("Interest Rate: ");
			JTextField interestB = new JTextField(15);
			JPanel interestPanel = new JPanel();
			
			
			amountPanel.setLayout(new FlowLayout());
			amountPanel.add(amount);
			amountPanel.add(amountB);
			
			daysPanel.setLayout(new FlowLayout());
			daysPanel.add(days);
			daysPanel.add(daysB);
			
			interestPanel.setLayout(new FlowLayout());
			interestPanel.add(interest);
			interestPanel.add(interestB);
			
			
			
			
			
			
			
			JButton go1 = new JButton("GO!");
			
			go1.addActionListener(event2 ->{
				Listing tempList = new Listing(Integer.parseInt(amountB.getText()), Integer.parseInt(daysB.getText()), Double.parseDouble(interestB.getText()), tempUser);
				tempUser.post(tempList);
				frame2.dispose();
			});
			
			panel1.add(amountPanel);
			panel1.add(daysPanel);
			panel1.add(interestPanel);
			panel1.add(go1);
			frame2.setContentPane(panel1);
			frame2.pack();
			frame2.setMinimumSize(getSize());
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame2.setLocationRelativeTo(null);
			frame2.setVisible(true);
			
			
		});
		
		
		panel.add(namePanel);
		panel.add(addPanel);
		panel.add(emailPanel);
		panel.add(cardPanel);
		panel.add(button);

		frame1.setContentPane(panel);
		frame1.pack();
		frame1.setMinimumSize(getSize());
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);

	}

	private void buyAct() {
		JFrame frame1 = new JFrame();
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel name = new JLabel("Name: ");
		JLabel address = new JLabel("Address: ");
		JLabel email = new JLabel("Email: ");
		JLabel card = new JLabel("Credit Card Number: ");

		JTextField nameF = new JTextField(15);
		JTextField addF = new JTextField(35);
		JTextField emailF = new JTextField(20);
		JTextField cardF = new JTextField(16);

		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout());
		namePanel.add(name);
		namePanel.add(nameF);

		JPanel addPanel = new JPanel();
		addPanel.setLayout(new FlowLayout());
		addPanel.add(address);
		addPanel.add(addF);

		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout());
		emailPanel.add(email);
		emailPanel.add(emailF);

		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(new FlowLayout());
		cardPanel.add(card);
		cardPanel.add(cardF);
		
		JButton button = new JButton("Submit");
		button.addActionListener(event -> {
			User tempUser = new User(nameF.getText(), addF.getText(), emailF.getText(), Integer.parseInt(cardF.getText()), myMarket);
			frame1.dispose();
			JFrame frame2 = new JFrame();
			JPanel panel1 = new JPanel();

			panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
			JLabel amount = new JLabel("Amount Request: ");
			JTextField amountB = new JTextField(15);
			JPanel amountPanel = new JPanel();
			amountPanel.setLayout(new FlowLayout());
			amountPanel.add(amount);
			amountPanel.add(amountB);
			JButton go = new JButton("GO!");
			go.addActionListener(event1 ->{
				Listing L = tempUser.find(Integer.parseInt(amountB.getText()));
				JOptionPane.showMessageDialog(null, "The best option on the market for you is: "+
					    L);
				frame2.dispose();
			});
			
			panel1.add(amountPanel);
			panel1.add(go);
			frame2.setContentPane(panel1);
			frame2.pack();
			frame2.setMinimumSize(getSize());
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame2.setLocationRelativeTo(null);
			frame2.setVisible(true);
			
		});
		
		
		panel.add(namePanel);
		panel.add(addPanel);
		panel.add(emailPanel);
		panel.add(cardPanel);
		panel.add(button);

		frame1.setContentPane(panel);
		frame1.pack();
		frame1.setMinimumSize(getSize());
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}

	private void loanAction() {
		loanAct();
	}

	private void buyerAction() {
		buyAct();
	}

	public void start() {
		setLayout(new BorderLayout());
		add(makeNorth(), BorderLayout.CENTER);
		add(makeCenter(), BorderLayout.NORTH);
		add(makeSouth(), BorderLayout.SOUTH);
		pack();
		setMinimumSize(getSize());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
