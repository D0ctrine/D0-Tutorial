package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import member.memberDAO;
import member.memberDTO;

public class Start extends JFrame implements ActionListener {
	JLabel title;
	JLabel id;
	JTextField idTF;
	JLabel pw;
	JTextField pwTF;
	JLabel programInfo;
	JLabel wid;
	JLabel wpw;
	JButton joinBTN;
	JButton loginBTN;
	JPanel BoxP = new JPanel();
	JPanel MainP = new JPanel();
	JPanel NorthP = new JPanel();
	JPanel CenterP = new JPanel();
	JPanel SouthP = new JPanel();
	JFrame frame = new JFrame("HU-Chat");
	ArrayList<memberDTO> membList = memberDAO.getInstance().getList();

	Start() {
		frame.setSize(400, 300);
		frame.setLocation(400, 200);
		frame.setResizable(false);
		init();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	private void init() {
		// TODO Auto-generated method stub
		CenterP.setBackground(Color.LIGHT_GRAY);
		SouthP.setBackground(Color.LIGHT_GRAY);
		NorthP.setBackground(Color.LIGHT_GRAY);
		BoxP.setBackground(Color.LIGHT_GRAY);
		MainP.setBackground(Color.LIGHT_GRAY);

		MainP.setLayout(new BorderLayout());
		BoxP.setLayout(new BoxLayout(BoxP, BoxLayout.Y_AXIS));

		title = new JLabel("< HU-Chat >");
		NorthP.add(title);
		MainP.add(NorthP, "North");
		id = new JLabel("ID");
		idTF = new JTextField(20);
		idTF.setBackground(Color.orange);
		BoxP.add(id);
		BoxP.add(idTF);
		pw = new JLabel("PW");
		pwTF = new JTextField(20);
		pwTF.setBackground(Color.orange);
		BoxP.add(pw);
		BoxP.add(pwTF);
		CenterP.add(BoxP);
		MainP.add(CenterP, "Center");

		joinBTN = new JButton("회원가입");
		loginBTN = new JButton("로그인");
		SouthP.add(joinBTN);
		SouthP.add(loginBTN);
		MainP.add(SouthP, "South");

		joinBTN.addActionListener(this);
		loginBTN.addActionListener(this);

		programInfo = new JLabel("HU-Chat v1.0", JLabel.CENTER);
		programInfo.setOpaque(true);
		programInfo.setBackground(Color.LIGHT_GRAY);
		frame.add(MainP, "Center");
		frame.add(programInfo, "South");

		wid = new JLabel("아이디를 확인해주세요.");
		wid.setForeground(Color.red);

		wpw = new JLabel("패스워드를 확인해주세요.");
		wpw.setForeground(Color.red);

	}

	public void actionGo() {
		Runnable runnable = new Runnable() {
			int result = 0;

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					for (int j = 0; j < 10000; j++) {
						result = i + j;
					}
				}
				membList = memberDAO.getInstance().getList();
			}
		};
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.SECONDS);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Start m = new Start();
		m.actionGo();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String login = e.getActionCommand();
		int imsi=0;
		if (login.equals("로그인")) {
			for (int i = 0; i < membList.size(); i++) {
				if (idTF.getText().equals(membList.get(i).getId())) {
					imsi = i;
				}
				
		}
			if (idTF.getText().equals(membList.get(imsi).getId())) {
				if (pwTF.getText().equals(membList.get(imsi).getPwd())) {
							frame.setVisible(false);
							memberDAO.getInstance().login(membList.get(imsi).getId(),1);
							new Messenger(membList.get(imsi).getId());
							
							
						} else {
							wid.setText("");
							BoxP.add(wpw);
							frame.setVisible(true);
						}
				}else{
					BoxP.add(wid);
					frame.setVisible(true);
				}
			

		} else if (login.equals("회원가입")) {
			boolean flag = true;
			for (int i = 0; i < membList.size(); i++) {
				if (idTF.getText().equals(membList.get(i).getId())) {
					flag = false;
				}

			} // end for
			if (flag) {
				memberDTO joinList = new memberDTO();
				System.out.println(idTF.getText() + "/" + pwTF.getText());
				joinList.setId(idTF.getText());
				joinList.setPwd(pwTF.getText());
				memberDAO.getInstance().join(joinList);
			} // end if
		} // end else if

	}// end actionperformed()

}
