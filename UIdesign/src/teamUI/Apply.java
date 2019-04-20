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
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

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
		setTitle("代表队报名");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//代表队名称
		JLabel label = new JLabel("\u4EE3\u8868\u961F\u540D\u79F0");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(10, 10, 97, 29);
		contentPane.add(label);
		
		//获取代表队名称
		
		tnameText = new JTextField();
		tnameText.setBounds(129, 16, 178, 21);
		contentPane.add(tnameText);
		tnameText.setColumns(10);
		
		JLabel leader = new JLabel("\u9886\u961F");
		leader.setFont(new Font("宋体", Font.PLAIN, 18));
		leader.setBounds(10, 78, 97, 29);
		contentPane.add(leader);
		
		JLabel doctor = new JLabel("\u961F\u533B");
		doctor.setFont(new Font("宋体", Font.PLAIN, 18));
		doctor.setBounds(10, 117, 97, 29);
		contentPane.add(doctor);
		
		JLabel trainer = new JLabel("\u6559\u7EC3\u5458");
		trainer.setFont(new Font("宋体", Font.PLAIN, 18));
		trainer.setBounds(10, 156, 97, 29);
		contentPane.add(trainer);
		
		JLabel referee = new JLabel("\u88C1\u5224\u5458");
		referee.setFont(new Font("宋体", Font.PLAIN, 18));
		referee.setBounds(10, 195, 97, 29);
		contentPane.add(referee);
		
		JLabel name = new JLabel("\u59D3\u540D");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("宋体", Font.PLAIN, 18));
		name.setBounds(129, 47, 66, 29);
		contentPane.add(name);
		
		JLabel IDnumber = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
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
		
		JLabel phonenumber = new JLabel("\u7535\u8BDD\u53F7\u7801");
		phonenumber.setHorizontalAlignment(SwingConstants.CENTER);
		phonenumber.setFont(new Font("宋体", Font.PLAIN, 18));
		phonenumber.setBounds(388, 47, 137, 29);
		contentPane.add(phonenumber);
		leadername.setBounds(129, 83, 66, 23);
		contentPane.add(leadername);
		leadername.setColumns(10);
		
		textField_2 = new JTextField();//领队身份证号
		textField_2.setColumns(10);
		textField_2.setBounds(210, 84, 168, 23);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();//领队电话号码
		textField_3.setColumns(10);
		textField_3.setBounds(388, 83, 168, 23);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();//队医姓名
		textField_4.setColumns(10);
		textField_4.setBounds(129, 123, 66, 23);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();//教练员姓名
		textField_5.setColumns(10);
		textField_5.setBounds(129, 162, 66, 23);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();//裁判员姓名
		textField_6.setColumns(10);
		textField_6.setBounds(129, 201, 66, 23);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();//队医身份证号
		textField_7.setColumns(10);
		textField_7.setBounds(210, 122, 168, 23);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();//教练员身份证号
		textField_8.setColumns(10);
		textField_8.setBounds(210, 162, 168, 23);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();//裁判员身份证号
		textField_9.setColumns(10);
		textField_9.setBounds(210, 201, 168, 23);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(388, 123, 168, 23);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();//教练员电话号码
		textField_11.setColumns(10);
		textField_11.setBounds(388, 161, 168, 23);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();//裁判员电话号码
		textField_12.setColumns(10);
		textField_12.setBounds(388, 201, 168, 23);
		contentPane.add(textField_12);
		
		JLabel sex = new JLabel("性别");
		sex.setHorizontalAlignment(SwingConstants.CENTER);
		sex.setFont(new Font("宋体", Font.PLAIN, 18));
		sex.setBounds(569, 47, 66, 29);
		contentPane.add(sex);
		
		JButton btnNewButton = new JButton("录入队员信息");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//点击跳转录入队员信息页面
				INathlete inathlete =new INathlete();
				dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(199, 266, 220, 40);
		contentPane.add(btnNewButton);
		
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
		
		this.setVisible(true);
	}
}
