package com.sys_monitor.TL.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

//import com.sys_monitor.function._controlResult;
//import com.sys_monitor.function.controlSHELLbyJava;
//import com.sys_monitor.function._controlTestLink;

public class testLink2shellTest extends JFrame implements ActionListener,Runnable{

	
//	_controlTestLink ctl = new _controlTestLink();
//	controlSHELLbyJava csj = new controlSHELLbyJava();
//	_controlResult cr = new _controlResult();
	
	//锟斤拷锟斤拷锟斤拷锟斤拷值锟斤拷锟斤拷锟节匡拷锟斤拷为锟斤拷锟斤拷锟斤拷锟解部锟斤拷锟截★拷
//	String url = "http://192.168.72.158/testlink/lib/api/xmlrpc/v1/xmlrpc.php"; //锟斤拷锟绞碉拷址锟斤拷锟斤拷时锟教讹拷
////	String url = "http://10.167.35.126/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
//	String devKey = "94ef168bd9f373d91b8e1678d2e786ea";//锟矫伙拷api
//	String projectName = "锟斤拷目Project_1";	//锟斤拷目锟斤拷锟斤拷
//	String planName ="Project1_testPlan1";		//锟斤拷锟皆计伙拷锟斤拷锟斤拷
//	String hostUsr = "gpadmin";
//	String hostPass = "123456";
//	String host = "10.167.35.37";
//	String comPrefix = "psql test -c ";
	
	String buildName = "1.0";//锟斤拷时锟教讹拷

	
	//锟斤拷锟侥诧拷锟斤拷锟斤拷锟斤拷执锟叫斤拷锟�
//	ctl.changeCaseResult(url,devKey,projectName, planName,buildName,hostUsr,hostPass,host,comPrefix);
	
	//锟斤拷锟捷匡拷锟斤拷锟接诧拷锟斤拷
	JPanel jp1 = new JPanel();
	TitledBorder tb1 = new TitledBorder("tb1");
	JLabel jlbusr = new JLabel("锟矫伙拷锟斤拷锟斤拷");
	JLabel jlbpass = new JLabel("锟斤拷锟诫：");
	JLabel jlbhost = new JLabel("锟斤拷锟斤拷锟斤拷址锟斤拷");
	JTextField jtxusr = new JTextField("gpadmin",12);
	JPasswordField jtxpass = new JPasswordField("123456",12);
	JTextField jtxhost = new JTextField("10.167.35.37",17);
	
	
	//锟斤拷锟斤拷锟斤拷目锟斤拷息锟斤拷锟接诧拷锟斤拷
	JPanel  jp2 = new JPanel();
	TitledBorder tb2 = new TitledBorder("锟斤拷锟斤拷锟斤拷目锟斤拷锟斤拷锟斤拷息");
	JLabel jlbapi = new JLabel("API锟斤拷");
	JLabel jlbproj = new JLabel("锟斤拷锟斤拷锟斤拷目锟斤拷");
	JLabel jlbplan = new JLabel("锟斤拷锟皆计伙拷锟斤拷");
	JTextField jtxapi = new JTextField("94ef168bd9f373d91b8e1678d2e786ea",33);
	JTextField jtxproj = new JTextField("锟斤拷目Project_1",24);
	JTextField jtxplan = new JTextField("Project1_testPlan1",24);
	JPanel jpa = new JPanel();
	JPanel jpc = new JPanel();
	JPanel jpb = new JPanel();
	//执锟斤拷锟斤拷锟斤拷前锟斤拷
	JPanel jp3 = new JPanel();
	TitledBorder tb3 = new TitledBorder("锟斤拷锟斤拷前锟斤拷锟斤拷锟�");
	JLabel jlbpfx = new JLabel("SQL前锟斤拷锟斤拷洌�");
	JTextField jtxpfx = new JTextField("psql test -c ",48);
	
	//执锟叫诧拷锟斤拷
	JPanel jp4 = new JPanel();
	TitledBorder tb4 = new TitledBorder("执锟叫诧拷锟斤拷");
	JButton jbt = new JButton("锟斤拷锟斤拷");
	
	public testLink2shellTest(){
		
		
		//锟斤拷锟捷匡拷锟斤拷锟接诧拷锟斤拷
		jp1.setBorder(tb1);
		jp1.add(jlbusr);
		jp1.add(jtxusr);
		jp1.add(jlbpass);
		jp1.add(jtxpass);
		jp1.add(jlbhost);
		jp1.add(jtxhost);

		//锟斤拷锟斤拷锟斤拷目锟斤拷息锟斤拷锟接诧拷锟斤拷
		jp2.setBorder(tb2);
		jpa.add(jlbapi);
		jpa.add(jtxapi);
		jpb.add(jlbproj);
		jpb.add(jtxproj);
		jpc.add(jlbplan);
		jpc.add(jtxplan);
		jp2.add(jpa);
		jp2.add(jpb);
		jp2.add(jpc);
		jp2.setLayout(new GridLayout(3, 1, 2, 2));
		//执锟斤拷锟斤拷锟斤拷前锟斤拷
		jp3.setBorder(tb3);
		jp3.add(jlbpfx);
		jp3.add(jtxpfx);
		//执锟叫诧拷锟斤拷
		jp4.setBorder(tb4);
		jp4.add(jbt);
		jbt.addActionListener(this);
		jbt.setActionCommand("launch");
		
		//锟斤拷锟斤拷锟斤拷锟�
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.setLayout(new GridLayout(4, 1, 2, 2));
		
		
		
		 //锟斤拷锟斤拷锟斤拷锟斤拷锟矫憋拷锟斤拷  
        this.setTitle("TestLink 锟斤拷锟斤拷锟斤拷锟斤拷执锟叫癸拷锟斤拷");  
        //锟斤拷锟矫达拷小  
        this.setSize(840,480); 
//        this.setSize(scrnsize.width, scrnsize.height);
        //锟斤拷锟矫筹拷始位锟斤拷  
        this.setLocation(0, 0);  
        //锟斤拷锟矫碉拷锟截闭达拷锟斤拷时jvm也锟剿筹拷锟斤拷  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //锟斤拷示  
        this.setVisible(true); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("launch")){
//			System.out.println("锟斤拷锟斤拷锟斤拷锟斤拷谋锟斤拷锟斤拷欠锟轿拷眨锟斤拷锟绞憋拷锟斤拷锟斤拷卸稀锟�");
			
			Thread runTest = new Thread(new Runnable() {
				@Override
				
				public void run() {
					int times = 0;
					while(times < 1){
						try {
							String url = "http://192.168.72.158/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
							String devKey = jtxapi.getText();
							String projectName = jtxproj.getText();
							String planName = jtxplan.getText();		//锟斤拷锟皆计伙拷锟斤拷锟斤拷
							String hostUsr = jtxusr.getText();
							String hostPass = jtxpass.getText();
							String host = jtxhost.getText();
							String comPrefix = jtxpfx.getText();
//						ctl.changeCaseResult(url,devKey,projectName, planName,buildName,hostUsr,hostPass,host,comPrefix);
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						times ++;
					}
				}
			});
			runTest.start(); 
			if(runTest.isAlive()){
				System.out.println("锟斤拷锟斤拷锟斤拷... ... ");
			}
			else{
				JOptionPane.showMessageDialog(null, "执锟斤拷锟斤拷锟�");
			}
			
		
//			if((!jtxusr.getText().equals(""))||(!jtxusr.getText().equals(""))||(!jtxpass.getText().equals(""))||(!jtxhost.getText().equals(""))||(!jtxapi.getText().equals(""))||(!jtxproj.getText().equals(""))||(!jtxplan.getText().equals(""))||(!jtxpfx.getText().equals(""))){
//			    System.out.println("锟斤拷锟叫碉拷锟侥憋拷锟斤拷锟斤拷锟轿拷铡锟�");
//				JOptionPane.showMessageDialog(null, "锟斤拷锟叫碉拷锟侥憋拷锟斤拷锟斤拷锟轿拷锟�");
//
//			}
//			else{
//				System.out.println("锟叫匡拷锟侥憋拷锟斤拷");
//				JOptionPane.showMessageDialog(null, "锟叫匡拷锟侥憋拷锟斤拷");
//			}
			
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
