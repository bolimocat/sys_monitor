package com.sys_monitor.function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.sys_monitor.dom.cpuBaseInfoBean;
import com.sys_monitor.dom.ioBaseInfoBean;
import com.sys_monitor.dom.memBaseInfoBean;
import com.sys_monitor.dom.netBaseInfoBean;


public class monitor_thread implements Runnable{

	
	private String sshUser;
	private String sshPass;
	private String sshIp;
	private int sshPort;
	private String cpuCommand;
	private String memCommand;
	private String ioCommand;
	private String netCommand;
	private String recordPath;
	private int interval;
	
	
	
	
	controlSHELLbyJava csbj = new controlSHELLbyJava();
	handleHardwareInfo hhwi = new handleHardwareInfo();
	controlFile cf = new controlFile();
	
	ArrayList<cpuBaseInfoBean> alcpu = new ArrayList<cpuBaseInfoBean>();
	ArrayList<memBaseInfoBean> almem = new ArrayList<memBaseInfoBean>();
	ArrayList<ioBaseInfoBean> alio = new ArrayList<ioBaseInfoBean>();
	ArrayList<netBaseInfoBean> alnet = new ArrayList<netBaseInfoBean>();
	
	
	public monitor_thread(String sshUser,String sshPass,String sshIp,int sshPort,String cpuCommand,String memCommand,String ioCommand,String netCommand,String recordPath,int interval) {
		this.sshUser = sshUser;
		this.sshPass = sshPass;
		this.sshIp = sshIp;
		this.sshPort = sshPort;
		this.cpuCommand = cpuCommand;
		this.ioCommand = ioCommand;
		this.netCommand = netCommand;
		this.memCommand = memCommand;
		this.recordPath = recordPath;
//		this.interval = interval;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Long currentTime = cf.Time();
			if(cf.Time() == currentTime + interval * 1000) {
				alcpu = hhwi.handleCPUInfo(csbj.fetchHardInfo(sshUser, sshPass, sshIp, sshPort, cpuCommand));
				for(int i=0;i<alcpu.size();i++) {
					cpuBaseInfoBean hwb = (cpuBaseInfoBean)alcpu.get(i);
					hhwi.recordSamplingCSV(recordPath, hwb.getCpuBaseInfo(), "cpu",sshIp);
				}
				almem = hhwi.handleMEMInfo(csbj.fetchHardInfo(sshUser, sshPass, sshIp, sshPort, memCommand));
				for(int i=0;i<almem.size();i++) {
				memBaseInfoBean mb = (memBaseInfoBean)almem.get(i);
				hhwi.recordSamplingCSV(recordPath, mb.getMemBaseInfo(), "mem",sshIp);
				}
				
				alio = hhwi.handleIOInfo(csbj.fetchHardInfo(sshUser, sshPass, sshIp, sshPort, ioCommand));
				for(int i=0;i<alio.size();i++){
					ioBaseInfoBean ib = (ioBaseInfoBean)alio.get(i);
					hhwi.recordSamplingCSV(recordPath, ib.getIoBaseInfo(), "io",sshIp);
				}
				
				alnet = hhwi.handleNETInfo(csbj.fetchHardInfo(sshUser, sshPass, sshIp, sshPort, netCommand));
				for(int i=0;i<alnet.size();i++){
					netBaseInfoBean nib = (netBaseInfoBean)alnet.get(i);
					hhwi.recordSamplingCSV(recordPath, nib.getNetBase(), "net",sshIp);
				}
				
			}
			
			
		}
		
	}
	
	
	

	
}
