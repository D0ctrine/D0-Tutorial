package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import MainFrame.Start;
import chatting.chatDAO;
import chatting.chatDTO;
import member.memberDAO;
import member.memberDTO;

public class Messenger extends JFrame implements ItemListener, ActionListener {
	JFrame frame = new JFrame("HU-Chat");
	List memberListin = new List();
	List memberListout = new List();
	List textList = new List();
	JLabel messageLabel = new JLabel("<HU-Chat>", JLabel.CENTER);
	JLabel memberLabel = new JLabel("<<Member>>", JLabel.CENTER);
	JLabel inmemberLabel = new JLabel("<접속On>");
	JLabel waitmemberLabel = new JLabel("<접속Off>");
	JLabel programInfo = new JLabel();
	JPanel MainP = new JPanel();
	JPanel CenterP = new JPanel();
	JPanel NorthP = new JPanel();
	JPanel SouthP = new JPanel();
	JPanel MWestP = new JPanel();
	
	
///////////////////////////////////////////////
	
	
	JPanel MNorthP = new JPanel();
	// MENUBAR
		JMenu menu = new JMenu("메뉴");
		JMenuBar menuB = new JMenuBar();
		JMenuItem menuI = new JMenuItem("로그아웃");
		JMenuItem menuG = new JMenuItem("그룹톡");
		JLabel groupL = new JLabel("<<그룹톡 실행>>", JLabel.CENTER);
		
//////////////////////////////////////////////	
	String userID = null;
	TextArea textTA = new TextArea(1, 35);
	JButton SendB = new JButton("Send");
	String imsi=null;
	public Messenger(String id) {
		userID = id;
		
		
		frame.setBounds(300, 300, 500, 700);
		frame.setResizable(false);
		init();
	
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	/*
	 * private void setDB() { // TODO Auto-generated method stub listupdate(); }
	 */

	private void init() {
		// TODO Auto-generated method stub
		// 메세지창 setting 값
	//new
		menuB.add(menu);
		menu.add(menuI);
		menu.add(menuG);
		frame.setJMenuBar(menuB);
		menuI.addActionListener(this);
		menuG.addActionListener(this);
	//
		
		
		MainP.setLayout(new BorderLayout());
		MainP.add(textList, "Center");
		MainP.add(messageLabel, "North");
		SouthP.add(textTA, "South");
		SouthP.add(SendB, "South");
		MainP.add(SouthP, "South");

		frame.add(MainP, "Center");
		checkmembList();
		// 멤버리스트 Setting값
		//MNorthP.add(memberLabel);
		MWestP.setLayout(new BoxLayout(MWestP, BoxLayout.Y_AXIS));
		//MWestP.add(memberLabel, "North");
		MWestP.add(memberLabel);
		MWestP.add(inmemberLabel);
		inmemberLabel.setForeground(Color.ORANGE);
		MWestP.add(memberListin);
		MWestP.add(waitmemberLabel);
		waitmemberLabel.setForeground(Color.RED);
		MWestP.add(memberListout);
		frame.add(MWestP, "West");

		programInfo = new JLabel("HU-Chat v1.0", JLabel.CENTER);
		frame.add(programInfo, "South");
		memberListin.addItemListener(this);
		textList.addItemListener(this);
		SendB.addActionListener(this);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	//멤버리스트에서 사람 받아와서 추가하기
		imsi = memberListin.getItem(memberListin.getSelectedIndex());
		checkchatting();

	}

	public void checkmembList() {

		Runnable runnable = new Runnable() {
			int result = 0;

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					for (int j = 0; j < 10000; j++) {
						result = i + j;
					}
				}
				// imsiList1 : 로그인중인 멤버 / imsiList2 : 접속종료한 멤버
				ArrayList<memberDTO> imsiList1 = memberDAO.getInstance().getFriends(userID, 1);
				ArrayList<memberDTO> imsiList2 = memberDAO.getInstance().getFriends(userID, 0);

				memberListin.removeAll();
				memberListout.removeAll();
				for (int i = 0; i < imsiList1.size(); i++) {
					memberListin.add(imsiList1.get(i).getId());
				}
				for (int i = 0; i < imsiList2.size(); i++) {
					memberListout.add(imsiList2.get(i).getId());
				}

			}
		};
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.SECONDS);

	}
	public void checkchatting() {

		boolean flag=true;
		Runnable runnable = new Runnable() {
			int result = 0;
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					for (int j = 0; j < 10000; j++) {
						result = i + j;
						
					}
				}
				textList.removeAll();
				ArrayList<chatDTO> imsiList1 = chatDAO.getInstance().chatting(userID, imsi);
				

					int count =0;
					int jungsu=imsiList1.size()/9;
					
						count=9*jungsu;
					
					
					
				for (int i = count-1; i < imsiList1.size(); i++) {
					if(imsiList1.get(i).getSend_id().equals(userID)) {
						
						
						textList.add("                                                               [송신자 :"+imsiList1.get(i).getSend_id()+"]");
						textList.add("                                                               "+imsiList1.get(i).getMessage());
						textList.add("                                                               "+imsiList1.get(i).getSenddate());

					}else {
						
						textList.add("[송신자 :"+imsiList1.get(i).getSend_id()+"]");
						textList.add(imsiList1.get(i).getMessage());
						textList.add(imsiList1.get(i).getSenddate());
					}
						
	
					
					
					textList.add("  ");
						
				
				}
				

			}
			};
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
		/*
		if(flag) {
			
		}
		*/

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String btnName = e.getActionCommand();
		if (btnName.equals("Send")) {
			
			if(textTA.getText()!=null) {
				chatDAO.getInstance().sendmail(userID, imsi,textTA.getText());
			}
			
			textTA.setText("");
		}else if (e.getSource() == menuI) {
			frame.setVisible(false);
			memberDAO.getInstance().login(userID,0);
			new Start();

		} else if (e.getSource() == menuG) {
		
			messageLabel.setVisible(false);
			MainP.add(groupL, "North");
			frame.setVisible(true);

		}
		
	}
}
