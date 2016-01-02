package UI;

import java.awt.Container;

import javax.swing.*;

import dicSentiment.sentiment;
import fengCi.fengCi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class analysisUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton confrombutton = new JButton("analysis");
	private final JLabel lbAnalysis = new JLabel("���ϣ�");
	private final JLabel lbCode = new JLabel("���ϸ�ʽ��");
	private final JLabel lbFC = new JLabel("�ִʣ�");
	private final JLabel lbSentiment = new JLabel("��У�");
	private JTextField jtAnalysis = new JTextField("����·��");
	private JTextField jtFC    = new JTextField("����·��");
	private JTextField jtSentiment  = new JTextField("����·��");
	private JTextField jtCode  = new JTextField("�ļ���ʽ��UTF8/GB2312��");
	BackgroundPanel bgp;
	java.net.URL imgURL = analysisUI.class.getResource("robotImage.jpg");

	
	public analysisUI(){
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	���ñ���ͼƬ
	public void drawBack(){
		Container ct=this.getContentPane();
		getContentPane().setLayout(null);
		
		//��������Ƭ���Կ������Խ����	
		ImageIcon image1 = new ImageIcon(imgURL);
		bgp=new BackgroundPanel(image1.getImage());
		bgp.setBounds(0,0,530,288);
		ct.add(bgp);
	
	}
	
	public void init() {
		Container cop = this.getContentPane();
		cop.setLayout(null);
//	����������˺�λ�ñ߿�	
		lbAnalysis.setBounds(100, 33, 51, 20);
		cop.add(lbAnalysis);			
		lbCode.setBounds(100, 63, 78, 20);
		cop.add(lbCode);
		lbFC.setBounds(100, 116, 100, 20);
		cop.add(lbFC);
		lbSentiment.setBounds(100, 146, 100, 20);
		cop.add(lbSentiment);

		jtAnalysis.setBounds(171, 33, 170, 20);
		cop.add(jtAnalysis);	
		jtCode.setBounds(170, 63, 170, 20);
		cop.add(jtCode);
		jtFC.setBounds(171, 116, 170, 20);
		cop.add(jtFC);
		jtSentiment.setBounds(171, 146, 170, 20);
		cop.add(jtSentiment);


//		����analysis��ť
		confrombutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {					
//					if (jtnumber.getText().equals("number") & jtkey.getText().equals("key") ){
//						JOptionPane.showMessageDialog(null, "��¼�ɹ�");
//					}else if (jtnumber.getText().equals("")) {
//						JOptionPane.showMessageDialog(null, "������ѧ��");
//					}else if (jtkey.getText().equals("")) {
//						JOptionPane.showMessageDialog(null, "����������");
//					}else {
//						JOptionPane.showMessageDialog(null, "���û������벻��");
//					}
					String analysis = jtAnalysis.getText();
					String FC = jtFC.getText();
					String code = jtCode.getText();
					String sentiment = jtSentiment.getText();
					File analysisFile = new File(analysis);
					if (analysisFile.exists()&&(code.equals("UTF8")||code.equals("GB2312"))) {
						//��ʼ�ִʣ�������ִʵ��ļ��Լ�Ҫ������ļ�
						fengCi jd = new fengCi(analysis,FC,code);
						jd.getFengci();
						//��ʼsentiment
						sentiment a = new sentiment();
						a.readDoc(FC,sentiment);
						
					}else{
						JOptionPane.showMessageDialog(null, "��ȷ��������ȷ��=.=");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}	
			}
				
		});
		
		
		confrombutton.setBounds(171, 217, 100, 34);
		cop.add(confrombutton);
		//��ӱ���ͼƬ
		drawBack();
	}

	public static void main(String[] args) {
		analysisUI onelogin = new analysisUI();
		onelogin.setTitle("Sentiment Analysis");
		onelogin.setSize(500, 300);
		onelogin.setResizable(false);
		onelogin.setLocation(400, 200);
		onelogin.setVisible(true);
		
	}


}
