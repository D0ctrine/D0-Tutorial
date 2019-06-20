package GUIEX1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameEX extends JFrame implements ActionListener{

	JButton j1,j2;
	JPanel jp1=new JPanel();
	JPanel centerP = new JPanel();
	JPanel centerP_up = new JPanel();
	JTextArea jt;
	JTextField t1,t2;
	JLabel l1,l2;
	
	
	FrameEX(){
	this.setSize(200,400);
	this.setLocation(200,400);
	this.setLayout(new BorderLayout());
	
	init();
	//this.setBackground(Color.CYAN);
	this.setVisible(true);
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}


	private void init() {
			j1=new JButton("사용자 추가");
			//this.add(j1,"North");
			j2=new JButton("사용자 삭제");
			//this.add(j2,"Center");
			//j3=new JButton("버튼");
			//this.add(j3,"West");
			jp1.add(j1);
			jp1.add(j2);
			this.add(jp1,"North");
			
			j1.addActionListener(this);
			centerP.setLayout(new BorderLayout());
			//tt = new JTextArea(20,20);
			
			
			l1 = new JLabel("검색어");
			centerP_up.add(l1);
			t1=new JTextField(20);
			centerP_up.add(t1);
			t1.addActionListener(this);
			jt=new JTextArea(10,30);
			
			centerP.add(centerP_up,"North");
			centerP.add(jt,"Center");
			this.add(centerP,"Center");
			l1 = new JLabel("단어장  v1.0",JLabel.CENTER);
			this.add(l1,"South");
			
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String text=t1.getText();
		l1.setText(text);
		t1.setText("");
		jt.append(text+"\n");
	}
}
