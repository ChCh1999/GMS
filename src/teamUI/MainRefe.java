package teamUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainRefe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainRefe frame = new MainRefe();
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
	public MainRefe() {
		setTitle("总裁判您好");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("通知栏");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(10, 10, 64, 32);
		contentPane.add(label);
		
		JTextArea messageArea = new JTextArea();
		messageArea.setBounds(84, 10, 609, 140);
		messageArea.setLineWrap(true);
		JScrollPane messagePane=new JScrollPane(messageArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		messagePane.setBounds(84, 16, 592, 139);
		contentPane.add(messagePane);
		
		JLabel label_2 = new JLabel("性别");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(21, 177, 53, 20);
		contentPane.add(label_2);
		
		JPanel sex_panel = new JPanel();
		sex_panel.setBounds(117, 165, 491, 39);
		contentPane.add(sex_panel);
		
		JRadioButton radioB_man = new JRadioButton("男");
		radioB_man.setFont(new Font("宋体", Font.PLAIN, 18));
		sex_panel.add(radioB_man);
		
		JRadioButton radioB_woman = new JRadioButton("女");
		radioB_woman.setFont(new Font("宋体", Font.PLAIN, 18));
		sex_panel.add(radioB_woman);
		
		JLabel label_3 = new JLabel("年龄组");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(19, 219, 64, 20);
		contentPane.add(label_3);
		
		JPanel age_panel = new JPanel();
		age_panel.setBounds(117, 214, 491, 39);
		contentPane.add(age_panel);
		
		JRadioButton radioButton_2 = new JRadioButton("7-8");
		radioButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		age_panel.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("9-10");
		radioButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
		age_panel.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("11-12");
		radioButton_4.setFont(new Font("宋体", Font.PLAIN, 18));
		age_panel.add(radioButton_4);
		
		JLabel label_1 = new JLabel("比赛项目");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(10, 266, 81, 20);
		contentPane.add(label_1);
		
		JPanel game_panel = new JPanel();
		game_panel.setLayout(null);
		game_panel.setBounds(117, 266, 491, 81);
		contentPane.add(game_panel);
		
		JCheckBox dangang = new JCheckBox("单杠");
		dangang.setBounds(6, 6, 56, 23);
		game_panel.add(dangang);
		
		JCheckBox shuanggang = new JCheckBox("双杠");
		shuanggang.setBounds(97, 6, 56, 23);
		game_panel.add(shuanggang);
		
		JCheckBox diaohuan = new JCheckBox("吊环");
		diaohuan.setBounds(187, 6, 63, 23);
		game_panel.add(diaohuan);
		
		JCheckBox tiaoma = new JCheckBox("跳马");
		tiaoma.setBounds(6, 41, 56, 23);
		game_panel.add(tiaoma);
		
		JCheckBox ticao = new JCheckBox("自由体操");
		ticao.setBounds(292, 41, 80, 23);
		game_panel.add(ticao);
		
		JCheckBox anma = new JCheckBox("鞍马");
		anma.setBounds(292, 6, 56, 23);
		game_panel.add(anma);
		
		JCheckBox bengchuang = new JCheckBox("蹦床");
		bengchuang.setBounds(402, 6, 63, 23);
		game_panel.add(bengchuang);
		
		JCheckBox gaodigang = new JCheckBox("高低杠");
		gaodigang.setBounds(97, 41, 69, 23);
		game_panel.add(gaodigang);
		
		JCheckBox pinghengmu = new JCheckBox("平衡木");
		pinghengmu.setBounds(187, 41, 80, 23);
		game_panel.add(pinghengmu);
		
		JLabel label_4 = new JLabel("预决赛");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		label_4.setBounds(21, 354, 64, 20);
		contentPane.add(label_4);
		
		JPanel befinal_panel = new JPanel();
		befinal_panel.setBounds(117, 351, 491, 39);
		contentPane.add(befinal_panel);
		
		JRadioButton jRB_yusai = new JRadioButton("预赛");
		jRB_yusai.setFont(new Font("宋体", Font.PLAIN, 18));
		befinal_panel.add(jRB_yusai);
		
		JRadioButton jRB_juesai = new JRadioButton("决赛");
		jRB_juesai.setFont(new Font("宋体", Font.PLAIN, 18));
		befinal_panel.add(jRB_juesai);
		
		JButton button = new JButton("比赛开始");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(278, 415, 145, 30);
		contentPane.add(button);
	}
}
