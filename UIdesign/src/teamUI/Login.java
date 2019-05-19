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
		frame.setTitle("��¼");//��¼
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel name = new JLabel("�û�����");//�û���
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("����", Font.PLAIN, 18));
		name.setBounds(45, 74, 80, 30);
		frame.getContentPane().add(name);
		
		JLabel password = new JLabel("���룺");//����
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("����", Font.PLAIN, 18));
		password.setBounds(45, 140, 80, 30);
		frame.getContentPane().add(password);
		
		nameField = new JTextField();//�û��������
		nameField.setBounds(135, 74, 261, 30);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		passwordField = new JPasswordField();//���������
		passwordField.setBounds(135, 140, 261, 30);
		frame.getContentPane().add(passwordField);
		
		JButton login_in = new JButton("��¼");//��¼
		login_in.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*switch() {
				case
				//��¼����
				
				}*/
				//Apply apply = new Apply();//��ʱ������
				Referee referee = new Referee();
			}
		});
		login_in.setBounds(294, 210, 102, 30);
		frame.getContentPane().add(login_in);
		
		JButton reset = new JButton("�����Ϣ");//�����˺�����
		reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nameField.setText("");
				passwordField.setText("");
			}
		});
		reset.setBounds(169, 210, 102, 30);
		frame.getContentPane().add(reset);
		
		JButton register = new JButton("¼����Ϣ");
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Apply apply = new Apply();
			}
		});
		register.setBounds(45, 210, 102, 30);
		frame.getContentPane().add(register);
		
		//����ͼƬ����
		/*JLayeredPane backpic = new JLayeredPane();
		backpic.setBounds(0, 0, 1, 1);
		ImageIcon img = new ImageIcon(getClass().getResource("/1.jpg"));
		img.setImage(img.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
		frame.getContentPane().add(backpic);
		backpic.setLayout(null);*/
		
	}
}
