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
		//�����ҷ�����
		File sourceimage = new File("C:\\Users\\hiseo\\Desktop\\anipung_project\\mainImg.jpg");
		File image1 = new File("��������1");
		File image2 = new File("��������2");
		File image3 = new File("��������3");
		File image4 = new File("��������4");
		File image5 = new File("��������5");
		
		try {
			img = ImageIO.read(sourceimage);
		
			
		} catch (IOException e) {
			System.out.println("No Image Found.");
		}
		
		//���α׷� ȣ��
		init();
		
		//���α׷� Ʋ����
		setTitle("�ִ���");
		pack(); 	//������ �°� ����� �ڵ� ����
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
	
	public static void main(String[] args) {
		
		fmain f = new fmain();
	
	}

	void init(){
		//�̹����� ��ó���ϱ�
		JLabel label = new JLabel(new ImageIcon(img));
	
		
		//�󺧿�(label) ��ŸƮ��ư(startB) �ְ� �� ���� ���������ӿ�(mainP) ���������� �ִ´�.
		mainP.setLayout(new FlowLayout());
		label.setLayout(new FlowLayout());
		label.add(startB);
		mainP.add(label);
				
		//anipung��Ű���� �ε����� �����ϴ�  ��� ��������
		//(������ �ε����� 3������ ����ص� ������� �������ִµ� �� �׷��� ���� ��ã�Ҿ��
		//�ð������ؼ� �ϴ� �Ѿ��� �Ф�
		imsi.rand();
		
	 flag = true;

	 	while(flag) {
	 		
			rl=new rule(imsi.sc);

			imsi.fill(imsi.sc);

			flag = imsi.check(imsi.sc);

		}

	 	//�ʱ�ȭ��������(mainP)���� ��ŸƮ��ư(startB) ������ ��Ÿ�� ����ȭ��(input_P)
	 	input_P.setLayout(new FlowLayout());
	 	
	 	input_P.setLayout(new BorderLayout());
	 	scoreP_down.setLayout(new GridLayout(5, 5)); //��ư������ ����(5X5)
	 	
	 	//imsi.sc�� �ߺ����� �Էµ� ���� �ε���(���Ϳ� ���ڰ� �ִ� / �׷��� ������ ���۵�) 
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++){
				
				index_L.add(imsi.sc[i][j]);
				//���� game[i][j]�� �ְ� ���µ� ���α׷��󿡼� ������ ��ư�� �ε��� ��ȣ�� ���ڷ� �������� �����
				//List�Լ����� �ִ�����(���ݱ��� ã�ƺ����...��������...)
		
				scoreP_down.add(new JButton(index_L.getItem(i+j)));
				
				//scoreP_down.add(index_L); 
				//add��ȣ �ȿ� index_L�� ������ ��ư�� �ȵǵ� ������ �ε����� �����Ϳ� 
				
				scoreP_down.setBackground(Color.GRAY);
			}
			System.out.println();
		}
		//�̰͵� ��������ϴµ� �ϴ� �ִ��� ���� �Ŀ� �����ؿ�~�׳� ���ڹ�ư�� ���������
		JButton scoreB = new JButton("������");
		scoreP.add(scoreB);
		input_P.add(scoreP,"North");
		input_P.add(scoreP_down,"Center");
		
		add(mainP);
		startB.addActionListener(this);//�ʱ�ȭ�鿡�� ������ ���۹�ư
	   index_L.addItemListener(this);//������ �ε��� ��ȣ�� ���������ϴµ�...
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
		int selNum = index_L.getSelectedIndex();//��� �ȵǿ�...
		//�̰Ŵ� ����Ʈ���� �޾ƿ��°� �����ϴٸ� �ٽ� ������ ��ķ� ������ ���� ���� anipung �޼��尡 ����Ǽ�..
		int i=selNum/5;//��
		int j=selNum%5;//��
		
		System.out.print("a["+i+"]"+"["+j+"]"); //���ڰ� ������ �׽�Ʈ
	}
	
	
}
  