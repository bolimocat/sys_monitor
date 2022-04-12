package com.sys_monitor.function;


import java.io.BufferedReader;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.nio.charset.Charset;
//import java.util.ArrayList;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
//import com.sys_monitor.dom.cpuBaseInfoBean;

public class controlSHELLbyJava {
	
	/**
	 * 获取硬件信息
	 * @param hostUser
	 * @param hostPass
	 * @param hostIP
	 * @param hostPort
	 * @param command
	 * @return
	 */
		public String fetchHardInfo (String hostUser,String hostPass,String hostIP,int hostPort,String command){
			boolean result = false;
			String fetch = null;
			String buf = null;
			ChannelSftp sftp = null;
			
			try {
				JSch jsch=new JSch();
				Session session = jsch.getSession(hostUser,hostIP,hostPort);
	            session.setPassword(hostPass);
	            // username and password will be given via UserInfo interface.
	            session.setUserInfo(new MyUserInfo());
	            session.connect();
	            Channel channel=session.openChannel("exec");
	            ((ChannelExec)channel).setCommand(command);
	            
	            session.setConfig("userauth.gssapi-with-mic", "no");
	            session.setConfig("StrictHostKeyChecking", "no");
	            channel.setInputStream(null);
	            ((ChannelExec)channel).setErrStream(System.err);
	            channel.connect();
	            InputStream in=channel.getInputStream();
	            
	            
	            BufferedReader reader = new BufferedReader(
	            new InputStreamReader(in));
	            			fetch = "\n";
	            		while ((buf = reader.readLine()) != null) {
	                     fetch += " " + buf+"\n";
	                      }

	             byte[] tmp=new byte[1024];
	             while(true){
	                while(in.available()>0){
	                    int i=in.read(tmp, 0, 1024);
	                    if(i<0)break;
	                  
	                }
	                 if(channel.isClosed()){
	                    if(in.available()>0) continue;
//	                    System.out.println("exit-status: "+channel.getExitStatus());
	                    if(channel.getExitStatus() == 0){
	                    	result = true;
	                    }
	                    break;
	                }
	                try{Thread.sleep(1000);}catch(Exception ee){}
	               
	            }
	            
	            channel.disconnect();
	            session.disconnect();
	            
			} catch (Exception echeckDB) {
				echeckDB.printStackTrace();
			}
			return fetch;
		}


	
	
	
	
	private static class MyUserInfo implements UserInfo{
        @Override
        public String getPassphrase() {
//            System.out.println("getPassphrase");
            return null;
        }
        @Override
        public String getPassword() {
//            System.out.println("getPassword");
            return null;
        }
        @Override
        public boolean promptPassword(String s) {
//            System.out.println("promptPassword:"+s);
            return false;
        }
        @Override
        public boolean promptPassphrase(String s) {
//            System.out.println("promptPassphrase:"+s);
            return false;
        }
        @Override
        public boolean promptYesNo(String s) {
//            System.out.println("promptYesNo:"+s);
            return true;//notice here!
        }
        @Override
        public void showMessage(String s) {
//            System.out.println("showMessage:"+s);
        }
    
    }
}
