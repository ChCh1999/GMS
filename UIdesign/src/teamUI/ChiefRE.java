package teamUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


//����Աҳ��
public class ChiefRE extends JFrame {

	private JPanel contentPane;
	private JTextField score_1;
	private JTextField score_2;
	private JTextField score_3;
	private JTextField score_4;
	private JTextField score_5;
	private JTextField avgNum;
	private JTextField B_Num;
	private JTextField P_Num;
	private JTextField final_Num;
	private JTextField playername;
	private JTextField player_Num;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiefRE frame = new ChiefRE();
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
	public ChiefRE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel P_name = new JLabel("�˶�Ա����");
		P_name.setFont(new Font("����", Font.PLAIN, 18));
		P_name.setBounds(225, 20, 106, 30);
		contentPane.add(P_name);
		
		playername = new JTextField();
		playername.setFont(new Font("����", Font.PLAIN, 18));
		playername.setColumns(10);
		playername.setBounds(341, 17, 84, 30);
		playername.setEditable(false);//��ֹ�ⲿ�༭
		contentPane.add(playername);
		
		JLabel Playernumber = new JLabel("�˶�Ա���");
		Playernumber.setFont(new Font("����", Font.PLAIN, 18));
		Playernumber.setBounds(225, 51, 106, 30);
		contentPane.add(Playernumber);
		
		player_Num = new JTextField();//�˶�Ա���
		player_Num.setFont(new Font("����", Font.PLAIN, 18));
		player_Num.setEditable(false);
		player_Num.setColumns(10);
		player_Num.setBounds(341, 52, 149, 30);
		contentPane.add(player_Num);
		
		JLabel score = new JLabel("�÷�");
		score.setFont(new Font("����", Font.PLAIN, 18));
		score.setBounds(124, 10, 46, 30);
		contentPane.add(score);
		
		JLabel refe_1 = new JLabel("����1");
		refe_1.setFont(new Font("����", Font.PLAIN, 18));
		refe_1.setBounds(20, 51, 72, 30);
		contentPane.add(refe_1);
		
		JLabel refe_2 = new JLabel("����2");
		refe_2.setFont(new Font("����", Font.PLAIN, 18));
		refe_2.setBounds(20, 91, 72, 30);
		contentPane.add(refe_2);
		
		JLabel refe_3 = new JLabel("����3");
		refe_3.setFont(new Font("����", Font.PLAIN, 18));
		refe_3.setBounds(20, 130, 72, 30);
		contentPane.add(refe_3);
		
		JLabel refe_4 = new JLabel("����4");
		refe_4.setFont(new Font("����", Font.PLAIN, 18));
		refe_4.setBounds(20, 170, 72, 30);
		contentPane.add(refe_4);
		
		JLabel refe_5 = new JLabel("����5");
		refe_5.setFont(new Font("����", Font.PLAIN, 18));
		refe_5.setBounds(20, 210, 72, 30);
		contentPane.add(refe_5);
		
		score_1 = new JTextField();//�÷�1
		score_1.setBounds(110, 54, 72, 30);
		score_1.setEditable(false);
		contentPane.add(score_1);
		score_1.setColumns(10);
		
		score_2 = new JTextField();//�÷�2
		score_2.setColumns(10);
		score_2.setEditable(false);
		score_2.setBounds(110, 94, 72, 30);
		contentPane.add(score_2);
		
		score_3 = new JTextField();//�÷�3
		score_3.setColumns(10);
		score_3.setEditable(false);
		score_3.setBounds(110, 133, 72, 30);
		contentPane.add(score_3);
		
		score_4 = new JTextField();//�÷�4
		score_4.setColumns(10);
		score_4.setEditable(false);
		score_4.setBounds(110, 173, 72, 30);
		contentPane.add(score_4);
		
		score_5 = new JTextField();//�÷�5
		score_5.setColumns(10);
		score_5.setEditable(false);
		score_5.setBounds(110, 213, 72, 30);
		contentPane.add(score_5);
		
		JLabel avg_score = new JLabel("ƽ����");
		avg_score.setFont(new Font("����", Font.PLAIN, 18));
		avg_score.setBounds(225, 91, 62, 30);
		contentPane.add(avg_score);
		
		avgNum = new JTextField();//ƽ���÷�
		avgNum.setFont(new Font("����", Font.PLAIN, 18));
		avgNum.setBounds(311, 92, 84, 30);
		avgNum.setEditable(false);
		contentPane.add(avgNum);
		avgNum.setColumns(10);
		
		JLabel lblB = new JLabel("B��");
		lblB.setFont(new Font("����", Font.PLAIN, 18));
		lblB.setBounds(235, 136, 32, 30);
		contentPane.add(lblB);
		
		B_Num = new JTextField();//������
		B_Num.setFont(new Font("����", Font.PLAIN, 18));
		B_Num.setColumns(10);
		B_Num.setBounds(311, 137, 84, 30);
		contentPane.add(B_Num);
		
		JLabel lblP = new JLabel("P��");
		lblP.setFont(new Font("����", Font.PLAIN, 18));
		lblP.setBounds(235, 180, 32, 30);
		contentPane.add(lblP);
		
		P_Num = new JTextField();//�ͷ���
		P_Num.setFont(new Font("����", Font.PLAIN, 18));
		P_Num.setColumns(10);
		P_Num.setBounds(311, 177, 84, 30);
		contentPane.add(P_Num);
		
		JButton button = new JButton("ȷ��");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//�����ܷ�,�ϴ�����,������һλ�˶�Ա
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 18));
		button.setBounds(226, 266, 106, 30);
		contentPane.add(button);
		
		JLabel final_score = new JLabel("���÷�");
		final_score.setFont(new Font("����", Font.PLAIN, 18));
		final_score.setBounds(212, 220, 84, 30);
		contentPane.add(final_score);
		
		final_Num = new JTextField();//���շ�
		final_Num.setFont(new Font("����", Font.PLAIN, 18));
		final_Num.setColumns(10);
		final_Num.setBounds(311, 217, 84, 30);
		contentPane.add(final_Num);
	}

}
