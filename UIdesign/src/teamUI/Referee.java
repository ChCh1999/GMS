package teamUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Referee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Referee frame = new Referee();
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
	public Referee() {
		setTitle("裁判员您好！");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("当前比赛运动员姓名");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(22, 34, 182, 29);
		contentPane.add(label);
		
		textField = new JTextField();//姓名
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setBounds(231, 34, 118, 29);
		textField.setEditable(false);//禁止外部编写
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("运动员编号");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(22, 83, 99, 29);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();//运动员编号
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_1.setBounds(231, 87, 118, 29);
		textField_1.setEditable(false);//禁止外部编写
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("得分");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(22, 138, 99, 29);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();//成绩
		textField_2.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_2.setBounds(231, 136, 118, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//提交成绩,导入下一位运动员
			}
		});
		button.setBounds(154, 211, 99, 29);
		contentPane.add(button);
	}
}
