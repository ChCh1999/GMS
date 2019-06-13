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
	public static void main(String[] args) {
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
		setTitle("代表队报名");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 387);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//代表队名称
		JLabel label = new JLabel("代表队名称");//代表队名称
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(10, 10, 97, 29);
		contentPane.add(label);
		
		//获取代表队名称
		
		tnameText = new JTextField();
		tnameText.setBounds(129, 10, 182, 27);
		//tnameText.setEditable(false);
		contentPane.add(tnameText);
		tnameText.setColumns(10);
		
		JLabel leader = new JLabel("领队");//领队
		leader.setFont(new Font("宋体", Font.PLAIN, 18));
		leader.setBounds(10, 78, 97, 29);
		contentPane.add(leader);
		
		JLabel doctor = new JLabel("队医");//队医
		doctor.setFont(new Font("宋体", Font.PLAIN, 18));
		doctor.setBounds(10, 117, 97, 29);
		contentPane.add(doctor);
		
		JLabel trainer = new JLabel("教练员");//教练员
		trainer.setFont(new Font("宋体", Font.PLAIN, 18));
		trainer.setBounds(10, 156, 97, 29);
		contentPane.add(trainer);
		
		JLabel referee = new JLabel("裁判员");//裁判员
		referee.setFont(new Font("宋体", Font.PLAIN, 18));
		referee.setBounds(10, 195, 97, 29);
		contentPane.add(referee);
		
		JLabel name = new JLabel("姓名");//姓名
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("宋体", Font.PLAIN, 18));
		name.setBounds(129, 47, 66, 29);
		contentPane.add(name);
		
		JLabel IDnumber = new JLabel("身份证号");//身份证号
		IDnumber.setHorizontalAlignment(SwingConstants.CENTER);
		IDnumber.setFont(new Font("宋体", Font.PLAIN, 18));
		IDnumber.setBounds(216, 47, 137, 29);
		contentPane.add(IDnumber);
		
		leadername = new JTextField();//领队姓名
		leadername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
			}
		});
		
		JLabel phonenumber = new JLabel("电话号码");//电话号码
		phonenumber.setHorizontalAlignment(SwingConstants.CENTER);
		phonenumber.setFont(new Font("宋体", Font.PLAIN, 18));
		phonenumber.setBounds(388, 47, 137, 29);
		contentPane.add(phonenumber);
		
		JLabel sex = new JLabel("性别");
		sex.setHorizontalAlignment(SwingConstants.CENTER);
		sex.setFont(new Font("宋体", Font.PLAIN, 18));
		sex.setBounds(569, 47, 66, 29);
		contentPane.add(sex);
		leadername.setBounds(129, 83, 66, 23);
		contentPane.add(leadername);
		leadername.setColumns(10);
		
		leaderID = new JTextField();//领队身份证号
		leaderID.setColumns(10);
		leaderID.setBounds(210, 84, 168, 23);
		contentPane.add(leaderID);
		
		leaderPhNum = new JTextField();//领队电话号码
		leaderPhNum.setColumns(10);
		leaderPhNum.setBounds(388, 83, 168, 23);
		contentPane.add(leaderPhNum);
		
		Dname = new JTextField();//队医姓名
		Dname.setColumns(10);
		Dname.setBounds(129, 123, 66, 23);
		contentPane.add(Dname);
		
		DID = new JTextField();//队医身份证号
		DID.setColumns(10);
		DID.setBounds(210, 122, 168, 23);
		contentPane.add(DID);
		
		DPhNum = new JTextField();
		DPhNum.setColumns(10);
		DPhNum.setBounds(388, 123, 168, 23);
		contentPane.add(DPhNum);
		
		trainername = new JTextField();//教练员姓名
		trainername.setColumns(10);
		trainername.setBounds(129, 162, 66, 23);
		contentPane.add(trainername);
		
		trainerID = new JTextField();//教练员身份证号
		trainerID.setColumns(10);
		trainerID.setBounds(210, 162, 168, 23);
		contentPane.add(trainerID);
		
		trainerPhNum = new JTextField();//教练员电话号码
		trainerPhNum.setColumns(10);
		trainerPhNum.setBounds(388, 161, 168, 23);
		contentPane.add(trainerPhNum);
		
		refename = new JTextField();//裁判员姓名
		refename.setColumns(10);
		refename.setBounds(129, 201, 66, 23);
		contentPane.add(refename);
		
		refeID = new JTextField();//裁判员身份证号
		refeID.setColumns(10);
		refeID.setBounds(210, 201, 168, 23);
		contentPane.add(refeID);
		
		refePhNum = new JTextField();//裁判员电话号码
		refePhNum.setColumns(10);
		refePhNum.setBounds(388, 201, 168, 23);
		contentPane.add(refePhNum);
		
		ButtonGroup buttonGroup = new ButtonGroup();//实现单选
		JPanel panel = new JPanel();
		panel.setBounds(560, 156, 109, 29);
		contentPane.add(panel);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		panel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 18));
		buttonGroup.add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("女");
		panel.add(radioButton);
		radioButton.setFont(new Font("宋体", Font.PLAIN, 18));
		buttonGroup.add(radioButton);
		
		JButton btnNewButton = new JButton("录入队员信息");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//点击跳转录入队员信息页面
				//同时提交已录入数据
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
		
		readyNum = new JLabel("已录入人员数");
		readyNum.setFont(new Font("宋体", Font.PLAIN, 18));
		readyNum.setBounds(10, 244, 131, 29);
		contentPane.add(readyNum);
		
		readytext = new JTextField();
		readytext.setBounds(147, 247, 78, 27);
		readytext.setEditable(false);
		contentPane.add(readytext);
		readytext.setColumns(10);
		
		JButton messageup = new JButton("上传文件");//上传文件
		messageup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//点击事件
			}
		});
		messageup.setBounds(524, 246, 111, 28);
		contentPane.add(messageup);

		JButton backbutton = new JButton("返回");
		backbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		backbutton.setBounds(560, 15, 93, 23);
		contentPane.add(backbutton);
		
		this.setVisible(true);
	}
}
