package teamUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import org.javatuples.Pair;
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

import SocketTools.ClientTool;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;


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
		frame.setResizable(false);
		
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
				String userID=nameField.getText();
				String password=String.valueOf(passwordField.getPassword());
				if (!password.isEmpty()&&
						!userID.isEmpty()){
					int state=0;
					Pair<Integer,Socket>res=ClientTool.login(userID,password);
					state=res.getValue0();
					switch (state){
						case-1:
							JFrame jf=new JFrame();
							jf.setTitle("重复登录!");
							jf.setBounds(250, 250, 300, 200);
							jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							jf.setResizable(false);
							jf.getContentPane().setLayout(null);

							JLabel rejl = new JLabel("该账号已处于登录状态");
							rejl.setFont(new Font("宋体", Font.PLAIN, 18));
							rejl.setBounds(50, 40, 250, 30);
							jf.getContentPane().add(rejl);

							JButton canceljb = new JButton("返回");
							canceljb.setFont(new Font("宋体",Font.PLAIN,18));
							canceljb.setBounds(110,100, 70, 30);
							jf.getContentPane().add(canceljb);
							canceljb.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent arg0) {
									jf.dispose();
								}
							});

							jf.setVisible(true);
							break;
						case 0:
							JFrame jf2=new JFrame();
							jf2.setTitle("登录失败");
							jf2.setBounds(250, 250, 300, 200);
							jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							jf2.setResizable(false);
							jf2.getContentPane().setLayout(null);

							JLabel jl2 = new JLabel("登录失败");
							jl2.setFont(new Font("宋体", Font.PLAIN, 18));
							jl2.setBounds(110, 40, 250, 30);
							jf2.getContentPane().add(jl2);

							JButton canceljb2 = new JButton("返回");
							canceljb2.setFont(new Font("宋体",Font.PLAIN,18));
							canceljb2.setBounds(110,100, 70, 30);
							jf2.getContentPane().add(canceljb2);
							canceljb2.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent arg0) {
									jf2.dispose();
								}
							});

							jf2.setVisible(true);
							break;
						case 1:
							frame.dispose();
							Referee referee = new Referee(userID,res.getValue1());
							break;
						case 2:
							ChiefRE chiefre = new ChiefRE(userID,res.getValue1());
							break;
						case 3:
							MainRefe mainrefe = new MainRefe(userID);
							break;
						case 4:
						case 5:
						case 6:
						case 9:
							Massagesearch messagesearch = new Massagesearch();
							break;
						//TODO:-1账号已经在线  0登录失败 1裁判 2小组裁判  3总裁判  4领队  5队医 6教练员 9(serverData.NumOfGroup)代表队账号
						default:
							jf2=new JFrame();
							jf2.setTitle("登录失败");
							jf2.setBounds(250, 250, 300, 200);
							jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							jf2.setResizable(false);
							jf2.getContentPane().setLayout(null);

							jl2 = new JLabel("登录失败");
							jl2.setFont(new Font("宋体", Font.PLAIN, 18));
							jl2.setBounds(110, 40, 250, 30);
							jf2.getContentPane().add(jl2);

							canceljb2 = new JButton("返回");
							canceljb2.setFont(new Font("宋体",Font.PLAIN,18));
							canceljb2.setBounds(110,100, 70, 30);
							jf2.getContentPane().add(canceljb2);
							canceljb2.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent arg0) {
									jf2.dispose();
								}
							});

							jf2.setVisible(true);
							break;
					}
				}

				//Apply apply = new Apply();//临时调试用
//				Referee referee = new Referee();
			}
		});
		login_in.setBounds(326, 210, 90, 30);
		frame.getContentPane().add(login_in);
		
		JButton reset = new JButton("清空信息");//重置账号密码
		reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nameField.setText("");
				passwordField.setText("");
			}
		});
		reset.setBounds(126, 210, 90, 30);
		frame.getContentPane().add(reset);
		
		JButton register = new JButton("录入信息");
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Apply apply = new Apply();
			}
		});
		register.setBounds(26, 210, 90, 30);
		frame.getContentPane().add(register);

		JButton reload = new JButton("重置密码");
		reload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame jf=new JFrame();
				jf.setTitle("重置密码");
				jf.setBounds(250,250,400,270);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.getContentPane().setLayout(null);

				JLabel jb = new JLabel("用户名");
				jb.setFont(new Font("宋体", Font.PLAIN, 18));
				jb.setBounds(20, 20, 90, 30);
				jf.getContentPane().add(jb);

				JTextField rename = new JTextField();
				rename.setFont(new Font("宋体", Font.PLAIN, 18));
				rename.setBounds(100,20,250,30);
				jf.getContentPane().add(rename);

				JLabel jb_1 = new JLabel("旧密码:");
				jb_1.setFont(new Font("宋体", Font.PLAIN, 18));
				jb_1.setBounds(20, 60, 90, 30);
				jf.getContentPane().add(jb_1);

				JTextField oldword = new JTextField();
				oldword.setFont(new Font("宋体", Font.PLAIN, 18));
				oldword.setBounds(100,60,250,30);
				jf.getContentPane().add(oldword);

				JLabel jb_2 = new JLabel("新密码：");
				jb_2.setFont(new Font("宋体", Font.PLAIN, 18));
				jb_2.setBounds(20, 100, 90, 30);
				jf.getContentPane().add(jb_2);

				JTextField newword = new JTextField();
				newword.setFont(new Font("宋体", Font.PLAIN, 18));
				newword.setBounds(100,100,250,30);
				jf.getContentPane().add(newword);

				JLabel jb_3 = new JLabel("确认密码：");
				jb_3.setFont(new Font("宋体", Font.PLAIN, 18));
				jb_3.setBounds(20, 140, 90, 30);
				jf.getContentPane().add(jb_3);

				JTextField renewword = new JTextField();
				renewword.setFont(new Font("宋体", Font.PLAIN, 18));
				renewword.setBounds(100,140,250,30);
				jf.getContentPane().add(renewword);

				JButton jb_4 = new JButton("确认修改");
				jb_4.setFont(new Font("宋体",Font.PLAIN,18));
				jb_4.setBounds(200,190, 110, 30);
				jb_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						//TODO:判别用户名密码是否正确
						if(!newword.getText().equals("")&&newword.getText().equals(renewword)){
							//TODO:更换密码
						}
					}
				});
				jf.getContentPane().add(jb_4);

				JButton jb_5 = new JButton("取消修改");
				jb_5.setFont(new Font("宋体",Font.PLAIN,18));
				jb_5.setBounds(30,190, 110, 30);
				jb_5.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						jf.dispose();
					}
				});
				jf.getContentPane().add(jb_5);

				jf.setVisible(true);
			}
		});
		reload.setBounds(226, 210, 90, 30);
		frame.getContentPane().add(reload);
		//插入图片背景
		/*JLayeredPane backpic = new JLayeredPane();
		backpic.setBounds(0, 0, 1, 1);
		ImageIcon img = new ImageIcon(getClass().getResource("/1.jpg"));
		img.setImage(img.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
		frame.getContentPane().add(backpic);
		backpic.setLayout(null);*/
		
	}
}
