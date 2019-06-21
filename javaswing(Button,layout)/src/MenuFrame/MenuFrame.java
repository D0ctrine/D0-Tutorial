package MenuFrame;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.WordDAO;
import DTO.WordDTO;

public class MenuFrame extends JFrame implements ItemListener, ActionListener {

	List wordList = new List();
	JLabel wordListLabel = new JLabel("리스트", JLabel.CENTER);
	JPanel listP = new JPanel();

	JPanel menuP = new JPanel();
	JButton addB = new JButton("추가");
	JButton delB = new JButton("삭제");
	JButton modB = new JButton("수정");
	JButton listB = new JButton("보기");

	JPanel northMainP = new JPanel();
	JPanel northMainP_up = new JPanel();
	JPanel northMainP_center = new JPanel();

	Label endLabel = new Label("영어단어");
	TextArea endTA = new TextArea(2, 25);

	Label korLabel = new Label("한글단어");
	TextArea korTA = new TextArea(2, 25);
	JLabel programInfo = new JLabel("단어장 프로그램 v1.0", JLabel.CENTER);
	
	JPanel inputP = new JPanel();
	Label iendLabel = new Label("영어");
	TextArea iendTA = new TextArea(2, 20);

	Label ikorLabel = new Label("한글");
	TextArea ikorTA = new TextArea(2, 20);
	
	JButton saveB =  new JButton("저장");	
	JPanel inputP_n=new JPanel();
	JPanel inputP_c=new JPanel();

	WordDAO wdao = null;
	ArrayList<WordDTO> wlist = null;

	public MenuFrame() {
		// TODO Auto-generated constructor stub
		this.setBounds(100, 100, 300, 330);
		init();
		setDB();
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public void init() {
		listP.setLayout(new BorderLayout());
		listP.add(wordListLabel, "North");
		listP.add(wordList, "Center");
		this.add(listP, "Center");
		menuP.setLayout(new BoxLayout(menuP, BoxLayout.Y_AXIS));
		menuP.add(addB);
		menuP.add(delB);
		menuP.add(modB);
		menuP.add(listB);
		this.add(menuP, "West");

		endTA.setEditable(false);

		northMainP_up.add(endLabel);
		northMainP_up.add(endTA);
		northMainP_center.add(korLabel);
		northMainP_center.add(korTA);
		northMainP.setLayout(new BorderLayout());
		northMainP.add(northMainP_up, "North");
		northMainP.add(northMainP_center, "Center");
		northMainP.add(programInfo, "South");
		this.add(northMainP, "South");

		
		inputP_n.add(iendLabel);
		inputP_n.add(iendTA);
		
		inputP_c.add(ikorLabel);
		inputP_c.add(ikorTA);
		
		inputP.setLayout(new BorderLayout());
		inputP.add(inputP_n,"North");
		inputP.add(inputP_c,"Center");
		inputP.add(saveB,"South");
		
		wordList.addItemListener(this);
		addB.addActionListener(this);
		delB.addActionListener(this);
		modB.addActionListener(this);
		saveB.addActionListener(this);
		listB.addActionListener(this);
	}

	public void setDB() {
		wdao = WordDAO.getInstance();
		listUpdate();
	}

	public void listUpdate() {
		wlist = wdao.getList();
		wordList.removeAll();
		if (wlist != null) {
			WordDTO imsi = null;
			for (int i = 0; i < wlist.size(); i++) {
				imsi = wlist.get(i);
				wordList.add(imsi.getEng() + " : " + imsi.getKor());
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int selNum = wordList.getSelectedIndex();
		WordDTO imsi = wlist.get(selNum);

		endTA.setText("");
		korTA.setText("");
		endTA.append(imsi.getEng());
		korTA.append(imsi.getKor());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String btnName = e.getActionCommand();
		System.out.println(btnName);
		
		if(btnName.equals("삭제")) {
			int selNum = wordList.getSelectedIndex();
			WordDTO imsi = wlist.get(selNum);
			wdao.del(imsi.getEng());
			listUpdate();
		}else if(btnName.equals("수정")) {
			int selNum = wordList.getSelectedIndex();
			WordDTO imsi = wlist.get(selNum);
			imsi.setKor(korTA.getText());
			wdao.updata(imsi);
			listUpdate();
		}else if(btnName.equals("추가")) {
			this.remove(listP);
			this.add(inputP,"Center");
			this.setVisible(true);
		/*
			WordDTO imsi = new WordDTO();
			imsi.setEng(endTA.getText());
			imsi.setKor(korTA.getText());
			wdao.insert(imsi);
			listUpdate();
			*/
		}else if(btnName.equals("저장")) {
			WordDTO imsi = new WordDTO();
			imsi.setEng(iendTA.getText());
			imsi.setKor(ikorTA.getText());
			wdao.insert(imsi);
			//listUpdate();
		}else if(btnName.equals("보기")) {
			this.remove(inputP);
			this.add(listP,"Center");
			this.setVisible(true);
			listUpdate();
		}
	}

}
