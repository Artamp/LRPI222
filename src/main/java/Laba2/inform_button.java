package Laba2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import Laba2.subversion.*;


// ��������� ������
public class inform_button implements ActionListener {
	
	static boolean check = false;
	//int countDocs = 0;
	@Override
	
	public void actionPerformed(ActionEvent arg0) {
	
	//	panel = new JPanel();
	//	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		 JPanel panel = new JPanel();//������ ����� ������
		 JFrame InfoGUI = new JFrame(); // ����� ���� - InfoGUI
		
		InfoGUI.setTitle ("����������");
		InfoGUI.setBounds(400,300,400,350); // ����� ���������� ���� InfoGUI
		InfoGUI.setVisible(true);
		

		
		JButton button_back = new JButton("�����");// ��������� ������ �����
		button_back.setBounds(450, 420, 100, 50);
		button_back.setVisible(true);
		button_back.addActionListener(actionEvent ->  {
		    	InfoGUI.setVisible(false); 
		    });
		
		//int x;
		//int y;
		
		//x = 200;
		//y = 213;
		panel.setBounds(400,200,600,450);
		InfoGUI.add(panel);
		panel.setVisible(true);
		panel.setLayout (new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		JLabel txt;
		//�������, ��� ������� ���� check - true.
		if(check) {   
			// � ���������� f ����������� ����� ���� ��������� ���������� java.io.File
			File f = new File(subversion.s); 
			
			 try{
			      FileReader fr = new FileReader(f);//������ �����
			       BufferedReader br = new BufferedReader(fr); 
			       while(br.ready()){
			    	   String brr;
			    	   brr = br.readLine();
			    	   txt = new JLabel(brr);
			    	
			    	   txt.setBounds(0, 113, 250, 130);//���������� ��� ���������� �����
			    	
			    	   panel.add(txt);
			      
			        }	
		}catch(Exception e){
			    System.out.println(e);
				
			}
		}
		

		panel.add(button_back);	
		InfoGUI.setVisible(true);
	}
}




