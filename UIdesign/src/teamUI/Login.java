package teamUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frame;
	private JTextField nameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("登录");//登录
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel name = new JLabel("用户名：");//用户名
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("宋体", Font.PLAIN, 18));
		name.setBounds(45, 74, 80, 30);
		frame.getContentPane().add(name);
		
		JLabel password = new JLabel("密码：");//密码
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("宋体", Font.PLAIN, 18));
		password.setBounds(45, 140, 80, 30);
		frame.getContentPane().add(password);
		
		nameField = new JTextField();//用户名输入框
		nameField.setBounds(135, 74, 261, 30);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		passwordField = new JPasswordField();//密码输入框
		passwordField.setBounds(135, 140, 261, 30);
		frame.getContentPane().add(passwordField);
		
		JButton login_in = new JButton("登录");//登录
		login_in.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*switch() {
				case
				//登录函数
				
				}*/
				//Apply apply = new Apply();//临时调试用
				Referee referee = new Referee();
			}
		});
		login_in.setBounds(294, 210, 102, 30);
		frame.getContentPane().add(login_in);
		
		JButton reset = new JButton("清空信息");//重置账号密码
		reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nameField.setText("");
				passwordField.setText("");
			}
		});
		reset.setBounds(169, 210, 102, 30);
		frame.getContentPane().add(reset);
		
		JButton register = new JButton("录入信息");
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Apply apply = new Apply();
			}
		});
		register.setBounds(45, 210, 102, 30);
		frame.getContentPane().add(register);
		
		//插入图片背景
		/*JLayeredPane backpic = new JLayeredPane();
		backpic.setBounds(0, 0, 1, 1);
		ImageIcon img = new ImageIcon(getClass().getResource("/1.jpg"));
		img.setImage(img.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
		frame.getContentPane().add(backpic);
		backpic.setLayout(null);*/
		
	}
}
