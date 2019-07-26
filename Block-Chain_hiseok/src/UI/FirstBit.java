package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Label;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Button;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.TextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FirstBit extends JFrame implements ActionListener {

	private JPanel contentPane;

	public FirstBit() {
		this.setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 425);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Button button_1 = new Button("Sign-In");
		button_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_1.setBackground(new Color(255, 153, 0));
		button_1.setBounds(127, 347, 76, 23);
		contentPane.add(button_1);
		button_1.addActionListener(this);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(5, 5, 542, 1);
		contentPane.add(panel);
		panel.setLayout(null);

		Label label = new Label("D2BC");
		label.setBackground(new Color(0, 128, 128));
		label.setForeground(Color.RED);
		label.setBounds(513, 364, 39, 23);
		contentPane.add(label);

		Label label_1 = new Label("BitCoin");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 42));
		label_1.setBounds(194, 39, 150, 77);
		contentPane.add(label_1);
		ImageIcon bitcoin = new ImageIcon("C:/Users/HU-203-07/Desktop/비트코인.png");
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(127, 143, 291, 198);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		TextField textField = new TextField();
		textField.setBounds(51, 59, 177, 23);
		panel_1.add(textField);

		TextField textField_1 = new TextField();
		textField_1.setBounds(51, 122, 177, 23);
		panel_1.add(textField_1);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("����", Font.BOLD, 14));
		lblId.setBounds(51, 39, 32, 15);
		panel_1.add(lblId);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("����", Font.BOLD, 14));
		lblPassword.setBounds(51, 99, 87, 15);
		panel_1.add(lblPassword);
		JLabel lblNewLabel = new JLabel(bitcoin);
		lblNewLabel.setBounds(0, 0, 291, 198);
		panel_1.add(lblNewLabel);

		Button button = new Button("Log-In");
		button.setBackground(new Color(255, 153, 0));
		button.setFont(new Font("Arial Black", Font.BOLD, 15));
		button.addActionListener(this);

		button.setBounds(342, 347, 76, 23);
		contentPane.add(button);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Log-In")) {
			this.setVisible(false);
			new SecondBit();
		} else if (e.getActionCommand().equals("Sign-In")) {
			this.setVisible(false);
			new Sign();
		}

	}

}
