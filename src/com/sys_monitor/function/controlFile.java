package com.sys_monitor.function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sys_monitor.dom.linkInfoBean;


public class controlFile {
	
	handleHardwareInfo hhwi = new handleHardwareInfo();
	
	/**
	 * 按行读取配置文件
	 * @param linkFilePath
	 * @return
	 */
	@SuppressWarnings("resource")
	public ArrayList<linkInfoBean> fetchLinkInfo(String linkFilePath){
		 ArrayList<linkInfoBean> linklist = new ArrayList<linkInfoBean>();
		 try {
			 @SuppressWarnings("unused")
			 File file = new File(linkFilePath);
			 BufferedReader reader = null;
	         String line = null;
	         reader = new BufferedReader(new FileReader(linkFilePath));
	         while((line = reader.readLine())!=null){
	        	 linkInfoBean lib = new linkInfoBean();
	        	 lib.setLinkInfo(line);
	        	 linklist.add(lib);
	         }
			
		} catch (Exception fetchLinkInfo) {
			fetchLinkInfo.printStackTrace();
		}
		 
		 return linklist;
	 }
	

	/**切分每行配置文件的内容
	 * 
	 * @param linkInfo
	 * @return
	 */
	public String[] splitLinkInfo(String linkInfo) {
		String[] sshInfo = linkInfo.split(",");
		return sshInfo;
	}

	/**
	  * 获得单个文件的大小(字节)
	  * @param f
	  * @return
	  * @throws Exception
	  */
	 public long getSimpleFileSize(File f)throws Exception
	 {
		 long size = 0;
		 size = f.length();
//		 System.out.println("file size :"+size);
		 return size;
	 }
	
	 /**
		 * 获取当前时间的毫秒数
		 * @return
		 */
		public Long Time(){
			Date dt= new Date();
			long start = dt.getTime();
			return start;
		}
	 
	 /**
		 * 生成日志需要的日期格式
		 * @param t
		 * @return
		 */
		public String logFileFormat(long t)	{
			SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			String time = sdFormatter.format(t);
			return time;
		}
		
		/**
		 * 生成记录时的时间格式
		 * @param t
		 * @return
		 */
		public String recordTime(long t) {
			SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdFormatter.format(t);
			return time;
		}
	 
	 /**
	  * 在csv记录内容
	  * @param recordPath
	  * @param hardwareType
	  * @param recordTime
	  * @param hardwareValue
	  */
	public void writeFile(String recordPath,String hardwareType,String recordTime,String hardwareValue) {
//		System.out.println("执行信息写入： "+hardwareType);
		FileWriter fw = null;
		int flag = 0;//获取目录下的文件个数
		try {
			File f = new File(recordPath+"/"+recordTime+"_"+hardwareType+"_tmp.csv");
			File fl = new File(recordPath);
			File list[] = fl.listFiles();
			for(int i=0;i<list.length;i++){
				flag++;
			}
			long tmpFileSize = this.getSimpleFileSize(f);//获取当前临时文件的size
			int bytesum = 0; 
			int byteread = 0; 
			
//			如果临时文件不存在，则创建一个。
			if(!f.exists()){
				f.createNewFile();
				switch(hardwareType) {
					case "cpu":
						fw = new FileWriter(f,true);
						fw.write("time,name,user,nice,system,idle,iowait,irrq,softirq,steal,guest,guest_nice \n");
					break;
					case "mem":
						fw = new FileWriter(f,true);
						fw.write("time,memUsed,memTotal \n");
					break;
					case "io":
						fw = new FileWriter(f,true);
						fw.write("time,rrqm/s,wrqm/s,r/s,w/s,rkB/s,wkB/s,avgrq-sz,avgqu-sz,await,r_await,w_await,svctm,%util \n");
					break;
					case "net":
						fw = new FileWriter(f,true);
						fw.write("time,inter-face,R-bytes,T-bytes \n");
					break;
					
				}
				//创建表头？
			}
			
//			如果当前临时文件size大与20M
			if(tmpFileSize > 20971520){
				//临时文件超过预订大小，复制临时文件到log，删除临时文件。
				InputStream inStream = new FileInputStream(f); //读入原文件 
				FileOutputStream fs = new FileOutputStream(recordPath+"/"+recordTime+"_"+hardwareType+"_"+flag+".csv");
				byte[] buffer = new byte[1444]; 
//				int length; 
				while ( (byteread = inStream.read(buffer)) != -1) { 
				bytesum += byteread; //字节数 文件大小 
			    fs.write(buffer, 0, byteread); 
			   
			}
				inStream.close(); 
				if(f.delete()){
					
				}
				
			}
			
//			如果当前临时文件小于20M，则继续向该文件里写入内容。
				if(tmpFileSize <= 19922944){//单个文件越1M
				fw = new FileWriter(f,true);
				fw.write(hardwareValue+"\n");

			}
			
			} catch (Exception erecordLog) {
			erecordLog.printStackTrace();
		}
		finally{
			if(fw != null){
				try{
					fw.close();
				}catch (IOException e){
					throw new  RuntimeException("Close Failed");
				}
			}
		}
		
	}

}
