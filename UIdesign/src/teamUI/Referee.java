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
		setTitle("����Ա���ã�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("��ǰ�����˶�Ա����");
		label.setFont(new Font("����", Font.PLAIN, 18));
		label.setBounds(22, 34, 182, 29);
		contentPane.add(label);
		
		textField = new JTextField();//����
		textField.setFont(new Font("����", Font.PLAIN, 18));
		textField.setBounds(231, 34, 118, 29);
		textField.setEditable(false);//��ֹ�ⲿ��д
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("�˶�Ա���");
		label_1.setFont(new Font("����", Font.PLAIN, 18));
		label_1.setBounds(22, 83, 99, 29);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();//�˶�Ա���
		textField_1.setFont(new Font("����", Font.PLAIN, 18));
		textField_1.setBounds(231, 87, 118, 29);
		textField_1.setEditable(false);//��ֹ�ⲿ��д
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("�÷�");
		label_2.setFont(new Font("����", Font.PLAIN, 18));
		label_2.setBounds(22, 138, 99, 29);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();//�ɼ�
		textField_2.setFont(new Font("����", Font.PLAIN, 18));
		textField_2.setBounds(231, 136, 118, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("�ύ");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//�ύ�ɼ�,������һλ�˶�Ա
			}
		});
		button.setBounds(154, 211, 99, 29);
		contentPane.add(button);
	}
}
