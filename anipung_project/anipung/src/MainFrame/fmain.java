package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import anipung.rule;
import anipung.screen;

public class fmain extends JFrame implements ActionListener,ItemListener {

	
	Image img=null;
	JPanel mainP = new JPanel();
	JPanel input_P = new JPanel();
	JPanel scoreP = new JPanel();
	JPanel scoreP_down = new JPanel();
	JButton startB = new JButton("Start");
	
	rule rl=null;
	JButton[][] gameB = new JButton[5][5];
	screen imsi= new screen();
	boolean flag=true;
	List index_L = new List();
	
	
	fmain() {	
		//사진불러오기
		File sourceimage = new File("C:\\Users\\hiseo\\Desktop\\anipung_project\\mainImg.jpg");
		File image1 = new File("동물사진1");
		File image2 = new File("동물사진2");
		File image3 = new File("동물사진3");
		File image4 = new File("동물사진4");
		File image5 = new File("동물사진5");
		
		try {
			img = ImageIO.read(sourceimage);
		
			
		} catch (IOException e) {
			System.out.println("No Image Found.");
		}
		
		//프로그램 호출
		init();
		
		//프로그램 틀제작
		setTitle("애니펑");
		pack(); 	//사진에 맞게 사이즈를 자동 맞춤
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
	
	public static void main(String[] args) {
		
		fmain f = new fmain();
	
	}

	void init(){
		//이미지를 라벨처리하기
		JLabel label = new JLabel(new ImageIcon(img));
	
		
		//라벨에(label) 스타트버튼(startB) 넣고 그 라벨을 메인프레임에(mainP) 최종적으로 넣는다.
		mainP.setLayout(new FlowLayout());
		label.setLayout(new FlowLayout());
		label.add(startB);
		mainP.add(label);
				
		//anipung패키지에 인덱스에 세팅하는  기능 가져오기
		//(가끔씩 인덱스가 3개연속 비슷해도 안지우는 현상이있는데 왜 그런지 아직 못찾았어요
		//시간부족해서 일단 넘어갔어요 ㅠㅠ
		imsi.rand();
		
	 flag = true;

	 	while(flag) {
	 		
			rl=new rule(imsi.sc);

			imsi.fill(imsi.sc);

			flag = imsi.check(imsi.sc);

		}

	 	//초기화면프레임(mainP)에서 스타트버튼(startB) 누르면 나타날 다음화면(input_P)
	 	input_P.setLayout(new FlowLayout());
	 	
	 	input_P.setLayout(new BorderLayout());
	 	scoreP_down.setLayout(new GridLayout(5, 5)); //버튼형식을 지정(5X5)
	 	
	 	//imsi.sc란 중복없이 입력된 최종 인덱스(모든것에 숫자가 있다 / 그래야 게임이 시작됨) 
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++){
				
				index_L.add(imsi.sc[i][j]);
				//원래 game[i][j]에 넣고 헀는데 프로그램상에서 선택한 버튼의 인덱스 번호를 숫자로 가져오는 기능이
				//List함수에만 있더라고요(지금까지 찾아본결과...있을수도...)
		
				scoreP_down.add(new JButton(index_L.getItem(i+j)));
				
				//scoreP_down.add(index_L); 
				//add괄호 안에 index_L만 있으면 버튼은 안되도 선택한 인덱스는 읽혀와요 
				
				scoreP_down.setBackground(Color.GRAY);
			}
			System.out.println();
		}
		//이것도 만들려고하는데 일단 애니펑 만든 후에 생각해요~그냥 글자버튼만 만들어놨어요
		JButton scoreB = new JButton("점수판");
		scoreP.add(scoreB);
		input_P.add(scoreP,"North");
		input_P.add(scoreP_down,"Center");
		
		add(mainP);
		startB.addActionListener(this);//초기화면에서 누르는 시작버튼
	   index_L.addItemListener(this);//눌러서 인덱스 번호를 받으려고하는데...
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String read_b=e.getActionCommand();
		if(read_b.equals("Start")) {
		this.remove(mainP);	
		this.add(input_P,"Center");
		this.setVisible(true);
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		int selNum = index_L.getSelectedIndex();//요게 안되요...
		//이거는 리스트에서 받아오는게 가능하다면 다시 이차원 행렬로 만들어야 제가 만든 anipung 메서드가 실행되서..
		int i=selNum/5;//행
		int j=selNum%5;//열
		
		System.out.print("a["+i+"]"+"["+j+"]"); //숫자가 나오나 테스트
	}
	
	
}
  