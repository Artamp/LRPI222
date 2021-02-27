package Laba2; //����� Java �������

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //���������� ��� ������� ���������
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import Laba2.inform_button.*;

import javax.imageio.ImageIO;
import javax.swing.*; // ���������� ��� GUI (��������� �� ������ awt)
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;




public class subversion {
	public static String s;
	public subversion() {
	JFrame main_GUI = new JFrame("subversion");	// �������� ������������ ����
	main_GUI.setTitle ("Using subversion for developers");
	main_GUI.setBounds(500,500,400,400);
	main_GUI.setResizable(false); // ������������� ������ ����
	

	
	JPanel main_panel = new JPanel(); // ������ - ������������ ��� ����������� ����������� � ����
	main_panel.setLayout(null);
	main_GUI.add(main_panel);
	
	
	JLabel task_1 = new JLabel("Subversion and Eclipse and Mantis"); 
	task_1.setBounds(70,85,250,30);
	main_panel.add(task_1);
	
	
	
	JLabel laba_info = new JLabel("������������ ������ �2"); // ����������� ������ ��� �����������
	laba_info.setBounds(120,125,150,30);
	main_panel.add(laba_info);
	
	
	JButton button_inform = new JButton("����������"); // ���������� ������ ����������
	button_inform.setBounds(20,290,140,40); // ����� �� ����������
	ActionListener inform_listener = new inform_button(); //������� ��������� ������
	button_inform.addActionListener(inform_listener); //��������� ��������� � ������
	main_panel.add(button_inform);
	

	
	JButton button_exit = new JButton("�����"); // ��������� ������
	button_exit.setBounds(270,290,100,40);
	ActionListener actionListener = new ListenerButton(); //������� ���������
	button_exit.addActionListener(actionListener); // ��������� ��������� � ������
	main_panel.add(button_exit);
	
	JTextField textfield = new JTextField(""); // ���������� ������� ���������� ����
	textfield.setBounds(75,190,150,30); // ����������� �������������
	main_panel.add(textfield); // ���������� �� ������
	
	JLabel laba_info1 = new JLabel("������� �:"); // ����������� ������ ��� �����������
	laba_info1.setBounds(10,190,150,30);
	main_panel.add(laba_info1);
	
	JTextField textfield1 = new JTextField(""); // ���������� ������� ���������� ����
	textfield1.setBounds(75,230,150,30); // ����������� ��������������
	main_panel.add(textfield1); // ���������� �� ������
	
	JLabel laba_info2 = new JLabel("������� �:"); // ����������� ������ ��� �����������
	laba_info2.setBounds(10,230,150,30);
	
	main_panel.add(laba_info2);
	
	JTextArea  laba_info3 = new JTextArea("�����: " ); // ����������� ������ ��� �����������
	laba_info3.setBounds(230,185,150,30);
	laba_info3.setOpaque(false);
	laba_info3.setEditable(false);
	laba_info3.setLineWrap(true);
	main_panel.add(laba_info3);
	
	ActionListener actionListenerCalc = new ActionListener() { //��������� ��� ������� �������
		public void actionPerformed(ActionEvent e) {
			try{ // ������������ ������ ��� �������� ������ � ����� 
				double a = Double.parseDouble(textfield.getText());
				double b = Double.parseDouble(textfield1.getText());
				if (a <= 0 || b <= 0) { //�������� ������������ ����� �����
					laba_info3.setText("�����\n ������ ���� > 0");
				}
				else {
				String result = Double.toString(a*b);
				laba_info3.setText("�����: " + result);
				}
		    }
			catch (NumberFormatException nfe) { 
				laba_info3.setText("ERROR: ������� �����"); //����� ��������� � ������ ������
			}
		}
	};
	JButton button_calc = new JButton("������"); // ���������� ������ �������
	button_calc.setBounds(230,230,140,30); // ����� �� ����������
	button_calc.addActionListener(actionListenerCalc); //��������� ��������� � ������
	main_panel.add(button_calc); //���������� ������ ������� �� ������� ������
	
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("����");
    menuBar.add(fileMenu);
    //String path = "src\\main\\resources\\�������.jpg";
    BufferedImage image = null;
    
    try {
    image= ImageIO.read(new URL("http://xn--e1afhkfagivn.xn--p1ai/media/foto/logo.jpg"));} //���������� ����������� � ���������
    		catch (IOException e){
    			System.out.println (e);
    		}	
    		
	JLabel label = new JLabel(new ImageIcon(image));
    JMenuItem menuItem1 = new JMenuItem("�������� ������� �����");
    
    menuItem1.addActionListener(actionEvent ->  {
    	main_panel.add(label);
        label.setVisible(false);
	    label.setBounds(245,10,138,69);  
	    label.setVisible(true);
    });
    String[] items = { // �������� ��������� ��� jcombobox
			"����������� ������� ����� � ����� ������� ����",
			"����������� ������� ����� � ��������",
			"����������� ������� ����� � ������� ������ ����",
			"������������� ������ � �������12"
	};
	JComboBox jcomboBox = new JComboBox(items);//�������� jcombobox

	jcomboBox.setBounds(35, 150,330,30);// ����� ���������� jcombobox
    ActionListener actionListenerLabelMove = new ActionListener() { //��������� ��� ����������� ������
		public void actionPerformed(ActionEvent e) {
			JComboBox box = (JComboBox)e.getSource();
			String item = (String)box.getSelectedItem();//������ �������� �� ����������� ������ � ������
			switch (item){ //����������� ����, � ����������� �� ������
				case ("����������� ������� ����� � ����� ������� ����"):
					label.setBounds(0, 10,138,69);
					break;
				case ("����������� ������� ����� � ������� ������ ����"):
					label.setBounds(245, 10,138,69);
					break;
				case ("����������� ������� ����� � ��������"):
					label.setBounds(125, 10,138,69);
					break;
				case ("������������� ������ � �������12"):
					ArrayInfo.arra();
					break;
					
			}

		}
	};
	
	 JMenuItem menuItem3 = new JMenuItem("��������� ���� � ������ 12");
	 menuItem3.addActionListener(actionEvent ->  {
		 FileFilter filter = new FileNameExtensionFilter("txt","TXT");
	        inform_button.check = true; // ���� check ���������� true
	         JFileChooser fileopen = new JFileChooser();
	         fileopen.setFileFilter(filter);
	         int ret = fileopen.showDialog(null, "������� ����");
	         if (ret == JFileChooser.APPROVE_OPTION) {
	            File file = fileopen.getSelectedFile();
	            s = file.getAbsolutePath();
	         }
         
	
		});
	jcomboBox.addActionListener(actionListenerLabelMove);// ��������� ��������� � jcombobox
	main_panel.add(jcomboBox);// ���������� jcombobox �� main_panel
    JMenuItem menuItem2 = new JMenuItem("�����");
    fileMenu.add(menuItem1);
    fileMenu.add(menuItem3);
    fileMenu.add(menuItem2);
    ActionListener actionListener2 = new ListenerButton(); //������� ���������
    menuItem2.addActionListener(actionListener2); // ��������� ��������� � ������
    main_GUI.setJMenuBar(menuBar);
	main_GUI.setVisible(true);
	main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���� JFrame � �������� Java
	}
	
	public static void main(String[] args) { 
		subversion student = new subversion();
	}
	
}

