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
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import anipung.falling;
import anipung.rule;
import anipung.screen;

public class fmain extends JFrame implements ActionListener,ItemListener {

	
	Image img=null;
	JPanel mainP = new JPanel();
	JPanel input_P = new JPanel();
	JPanel scoreP = new JPanel();
	JPanel scoreP_down = new JPanel();
	JButton startB = new JButton("Start");
	int count=0;


	JButton[][] gameB = new JButton[5][5];
	JButton[][] imsigameB = new JButton[5][5];
	screen imsi= new screen();
	boolean flag=true;
	List index_L = new List();
	
	File sourceimage = new File("C:\\Users\\HU-203-11\\Desktop\\�ִ���PROJECT\\�ִ���.jpg");
	ImageIcon image1 = new ImageIcon("C:\\Users\\HU-203-11\\Desktop\\�ִ���PROJECT\\��1.jpg");
	ImageIcon image2 = new ImageIcon("C:\\Users\\HU-203-11\\Desktop\\�ִ���PROJECT\\��2.jpg");
	ImageIcon image3 = new ImageIcon("C:\\Users\\HU-203-11\\Desktop\\�ִ���PROJECT\\��3.jpg");
	ImageIcon image4 = new ImageIcon("C:\\Users\\HU-203-11\\Desktop\\�ִ���PROJECT\\��4.jpg");
	ImageIcon image5 = new ImageIcon("C:\\Users\\HU-203-11\\Desktop\\�ִ���PROJECT\\��5.jpg");
	ImageIcon image6 = new ImageIcon("C:\\Users\\HU-203-11\\Desktop\\�ִ���PROJECT\\��6.jpg");
	
	fmain() {	
		//�����ҷ�����
		
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
	 		
	 		imsi.fill(imsi.sc);
	 		
	 		rule rl = new rule(imsi.sc);
	 		
	 		imsi.fill(imsi.sc);
	 		
	 		flag = imsi.check(imsi.sc);


		}

	 	//�ʱ�ȭ��������(mainP)���� ��ŸƮ��ư(startB) ������ ��Ÿ�� ����ȭ��(input_P)
	 	input_P.setLayout(new FlowLayout());
	 	
	 	input_P.setLayout(new BorderLayout());
	 	scoreP_down.setLayout(new GridLayout(5, 5)); //��ư������ ����(5X5)
	 	
	 	//imsi.sc�� �ߺ����� �Էµ� ���� �ε���(����ε����� ���ڰ� �ִ� / �׷��� ������ ���۵�) 
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++){
				//���������� gameB�� ��´�.
				gameB[i][j]=new JButton(imsi.sc[i][j]);
				if(gameB[i][j].getText().equals("1")) {
					
					gameB[i][j].setIcon(image1);;
					
				}else if(gameB[i][j].getText().equals("2")) {
					gameB[i][j].setIcon(image2);;
				}else if(gameB[i][j].getText().equals("3")) {
					gameB[i][j].setIcon(image3);;
				}else if(gameB[i][j].getText().equals("4")) {
						gameB[i][j].setIcon(image4);
				}else if(gameB[i][j].getText().equals("5")) {
					gameB[i][j].setIcon(image5);
				}
				scoreP_down.add(gameB[i][j]);
				
				scoreP_down.setBackground(Color.GRAY);
			}
		}
		//�̰͵� ��������ϴµ� �ϴ� �ִ��� ���� �Ŀ� �����ؿ�~�׳� ���ڹ�ư�� ���������
	//	JButton scoreB = new JButton("������");
	//	scoreP.add(scoreB);
	//	input_P.add(scoreP,"North");
		input_P.add(scoreP_down,"Center");
		
		add(mainP);
		startB.addActionListener(this);//�ʱ�ȭ�鿡�� ������ ���۹�ư
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++){
			
				gameB[i][j].addActionListener(this); 
			}
			}
		
		
		
	}

	public void convert_image(String[][] gameB) {
		ImageIcon i1,i2,i3,i4,i5;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(gameB[i][j]=="1") {
					i1=new ImageIcon(this.getClass().getResource(""));
				}else if(gameB[i][j]=="2") {
						i1=new ImageIcon(this.getClass().getResource(""));
			}else if(gameB[i][j]=="3") {
				i1=new ImageIcon(this.getClass().getResource(""));
			}else if(gameB[i][j]=="4") {
				i1=new ImageIcon(this.getClass().getResource(""));
			}else if(gameB[i][j]=="5") {
				i1=new ImageIcon(this.getClass().getResource(""));
			}
		}
		
	}
	}
	 private void findButton(Object c,String read_b) {
	
	        for (int x = 0; x < 5; x++) {
	            for (int y = 0; y < 5; y++) {
	                if (c.equals(gameB[x][y])) {
	                	gameB[x][y].setText(read_b);
	                	
	                	
	                }
	                
	            }
	        }
	    }

	 Object o1 = null;
	 String	read_b1 = null;
	 String	read_b2 = null;
	 Object o2 =null;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		falling fall=new falling(gameB);
		 imsi.fill(gameB); 
	
		if(count==0) {
		read_b1=e.getActionCommand();
		if(read_b1.equals("Start")) {
		this.remove(mainP);	
		this.add(input_P,"Center");
		this.setVisible(true);
		count++;
		}
		}
		else if(count==1) {
			read_b1=e.getActionCommand();
			o1=e.getSource();
			
			count++;
		}else {
			read_b2=e.getActionCommand();
			o2 = e.getSource();
			findButton(o1,read_b2);
			findButton(o2,read_b1);
			
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					if(gameB[i][j].getText().equals("1")) {
					
						gameB[i][j].setIcon(image1);
						
					}else if(gameB[i][j].getText().equals("2")) {
						gameB[i][j].setIcon(image2);
					}else if(gameB[i][j].getText().equals("3")) {
						gameB[i][j].setIcon(image3);
					}else if(gameB[i][j].getText().equals("4")) {
							gameB[i][j].setIcon(image4);
					}else if(gameB[i][j].getText().equals("5")) {
						
						gameB[i][j].setIcon(image5);
						
					}
				}
			}
			/*
			this.remove(input_P);
			input_P.add(scoreP_down);
			this.add(input_P,"Center");
			this.setVisible(true);
			this.add(scoreP_down,"Center");
			setVisible(true);
			*/
			count--;
		
			}//end else if
		
		rule rl = new rule(gameB);

		flag = imsi.check(gameB);
		
		
	
 		
 		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(gameB[i][j].getText().equals("1")) {
					gameB[i][j].setIcon(image1);
				}else if(gameB[i][j].getText().equals("2")) {
					gameB[i][j].setIcon(image2);
				}else if(gameB[i][j].getText().equals("3")) {
					gameB[i][j].setIcon(image3);
				}else if(gameB[i][j].getText().equals("4")) {
						gameB[i][j].setIcon(image4);
				}else if(gameB[i][j].getText().equals("5")) {
					gameB[i][j].setIcon(image5);
				}else if(gameB[i][j].getText().equals("0")) {
					gameB[i][j].setIcon(image6);
				}
			}
		}
 		 
		}
		
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		//���� ��ư�� �ε��� ��ȣ �޾ƿ���
	}
	
	
}
  