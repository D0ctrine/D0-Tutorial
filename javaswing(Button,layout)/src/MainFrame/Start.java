package MainFrame;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import MenuFrame.MenuFrame;

public class Start extends JFrame implements ActionListener{


	JLabel pwdLabel;
	JTextField pwdTF;
	JButton loginBTN;
	JLabel programInfo;
	JPanel mainP=new JPanel();
	JPanel northP=new JPanel();
	JPanel centerP=new JPanel();
	JPanel southP=new JPanel();
	Start(){
		this.setSize(300, 200);
		this.setLocation(300, 100);
		init();		
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public void init() {
		mainP.setLayout(new BorderLayout());
		pwdLabel = new JLabel("비밀번호");
		pwdLabel.setBackground(Color.GRAY);
		northP.add(pwdLabel);		
		mainP.add(northP,"North");
				pwdTF = new JTextField(20);
				centerP.add(pwdTF);
				pwdTF.setBackground(Color.blue);
				mainP.add(centerP,"Center");
				loginBTN = new JButton("관리자 로그인");
				southP.add(loginBTN);
				mainP.add(southP,"South");
				
				loginBTN.addActionListener(this);
				programInfo = new JLabel("단어장 프로그램 v1.0",JLabel.CENTER);
				
				this.add(mainP,"Center");
				this.add(programInfo,"South");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String pwd=pwdTF.getText();
		if(pwd.equals("1111")) {
			this.setVisible(false);
			new MenuFrame();
		}
		
	}
}
