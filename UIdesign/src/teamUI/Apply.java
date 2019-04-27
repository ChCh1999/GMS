package teamUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Apply extends JFrame {

	private JPanel contentPane;
	private JTextField tnameText;
	private JTextField leadername;
	private JTextField leaderID;
	private JTextField leaderPhNum;
	private JTextField Dname;
	private JTextField trainername;
	private JTextField refename;
	private JTextField DID;
	private JTextField trainerID;
	private JTextField refeID;
	private JTextField DPhNum;
	private JTextField trainerPhNum;
	private JTextField refePhNum;
	private JLabel readyNum;
	private JTextField readytext;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apply frame = new Apply();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Apply() {
		setTitle("����ӱ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//���������
		JLabel label = new JLabel("���������");//���������
		label.setFont(new Font("����", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(10, 10, 97, 29);
		contentPane.add(label);
		
		//��ȡ���������
		
		tnameText = new JTextField();
		tnameText.setBounds(129, 10, 182, 27);
		tnameText.setEditable(false);
		contentPane.add(tnameText);
		tnameText.setColumns(10);
		
		JLabel leader = new JLabel("���");//���
		leader.setFont(new Font("����", Font.PLAIN, 18));
		leader.setBounds(10, 78, 97, 29);
		contentPane.add(leader);
		
		JLabel doctor = new JLabel("��ҽ");//��ҽ
		doctor.setFont(new Font("����", Font.PLAIN, 18));
		doctor.setBounds(10, 117, 97, 29);
		contentPane.add(doctor);
		
		JLabel trainer = new JLabel("����Ա");//����Ա
		trainer.setFont(new Font("����", Font.PLAIN, 18));
		trainer.setBounds(10, 156, 97, 29);
		contentPane.add(trainer);
		
		JLabel referee = new JLabel("����Ա");//����Ա
		referee.setFont(new Font("����", Font.PLAIN, 18));
		referee.setBounds(10, 195, 97, 29);
		contentPane.add(referee);
		
		JLabel name = new JLabel("����");//����
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("����", Font.PLAIN, 18));
		name.setBounds(129, 47, 66, 29);
		contentPane.add(name);
		
		JLabel IDnumber = new JLabel("���֤��");//���֤��
		IDnumber.setHorizontalAlignment(SwingConstants.CENTER);
		IDnumber.setFont(new Font("����", Font.PLAIN, 18));
		IDnumber.setBounds(216, 47, 137, 29);
		contentPane.add(IDnumber);
		
		leadername = new JTextField();//�������
		leadername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
			}
		});
		
		JLabel phonenumber = new JLabel("�绰����");//�绰����
		phonenumber.setHorizontalAlignment(SwingConstants.CENTER);
		phonenumber.setFont(new Font("����", Font.PLAIN, 18));
		phonenumber.setBounds(388, 47, 137, 29);
		contentPane.add(phonenumber);
		
		JLabel sex = new JLabel("�Ա�");
		sex.setHorizontalAlignment(SwingConstants.CENTER);
		sex.setFont(new Font("����", Font.PLAIN, 18));
		sex.setBounds(569, 47, 66, 29);
		contentPane.add(sex);
		leadername.setBounds(129, 83, 66, 23);
		contentPane.add(leadername);
		leadername.setColumns(10);
		
		leaderID = new JTextField();//������֤��
		leaderID.setColumns(10);
		leaderID.setBounds(210, 84, 168, 23);
		contentPane.add(leaderID);
		
		leaderPhNum = new JTextField();//��ӵ绰����
		leaderPhNum.setColumns(10);
		leaderPhNum.setBounds(388, 83, 168, 23);
		contentPane.add(leaderPhNum);
		
		Dname = new JTextField();//��ҽ����
		Dname.setColumns(10);
		Dname.setBounds(129, 123, 66, 23);
		contentPane.add(Dname);
		
		DID = new JTextField();//��ҽ���֤��
		DID.setColumns(10);
		DID.setBounds(210, 122, 168, 23);
		contentPane.add(DID);
		
		DPhNum = new JTextField();
		DPhNum.setColumns(10);
		DPhNum.setBounds(388, 123, 168, 23);
		contentPane.add(DPhNum);
		
		trainername = new JTextField();//����Ա����
		trainername.setColumns(10);
		trainername.setBounds(129, 162, 66, 23);
		contentPane.add(trainername);
		
		trainerID = new JTextField();//����Ա���֤��
		trainerID.setColumns(10);
		trainerID.setBounds(210, 162, 168, 23);
		contentPane.add(trainerID);
		
		trainerPhNum = new JTextField();//����Ա�绰����
		trainerPhNum.setColumns(10);
		trainerPhNum.setBounds(388, 161, 168, 23);
		contentPane.add(trainerPhNum);
		
		refename = new JTextField();//����Ա����
		refename.setColumns(10);
		refename.setBounds(129, 201, 66, 23);
		contentPane.add(refename);
		
		refeID = new JTextField();//����Ա���֤��
		refeID.setColumns(10);
		refeID.setBounds(210, 201, 168, 23);
		contentPane.add(refeID);
		
		refePhNum = new JTextField();//����Ա�绰����
		refePhNum.setColumns(10);
		refePhNum.setBounds(388, 201, 168, 23);
		contentPane.add(refePhNum);
		
		ButtonGroup buttonGroup = new ButtonGroup();//ʵ�ֵ�ѡ
		JPanel panel = new JPanel();
		panel.setBounds(560, 156, 109, 29);
		contentPane.add(panel);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("��");
		panel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("����", Font.PLAIN, 18));
		buttonGroup.add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("Ů");
		panel.add(radioButton);
		radioButton.setFont(new Font("����", Font.PLAIN, 18));
		buttonGroup.add(radioButton);
		
		JButton btnNewButton = new JButton("¼���Ա��Ϣ");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//�����ת¼���Ա��Ϣҳ��
				//ͬʱ�ύ��¼������
				INathlete inathlete =new INathlete();
				//dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(198, 287, 220, 40);
		contentPane.add(btnNewButton);
		
		readyNum = new JLabel("��¼����Ա��");
		readyNum.setFont(new Font("����", Font.PLAIN, 18));
		readyNum.setBounds(10, 244, 131, 29);
		contentPane.add(readyNum);
		
		readytext = new JTextField();
		readytext.setBounds(147, 247, 78, 27);
		readytext.setEditable(false);
		contentPane.add(readytext);
		readytext.setColumns(10);
		
		JButton messageup = new JButton("�ϴ��ļ�");//�ϴ��ļ�
		messageup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//����¼�
			}
		});
		messageup.setBounds(524, 246, 111, 28);
		contentPane.add(messageup);
		
		this.setVisible(true);
	}
}
