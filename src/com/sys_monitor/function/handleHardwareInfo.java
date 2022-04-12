package com.sys_monitor.function;

import java.util.ArrayList;

import com.sys_monitor.dom.cpuBaseInfoBean;
import com.sys_monitor.dom.ioBaseInfoBean;
import com.sys_monitor.dom.memBaseInfoBean;
import com.sys_monitor.dom.netBaseInfoBean;

public class handleHardwareInfo {
	
	
	/**
	 * 处理分割cpu基本信息
	 * @param cpuBaseInfo
	 * @return
	 */
	public ArrayList<cpuBaseInfoBean> handleCPUInfo(String cpuBaseInfo) {
		ArrayList<cpuBaseInfoBean> al = new ArrayList<cpuBaseInfoBean>();
		String[] cpuInfo = cpuBaseInfo.split("\n");
		for(int i=0;i<cpuInfo.length;i++) 
		{
			cpuBaseInfoBean cpu = new cpuBaseInfoBean();
			if(cpuInfo[i].startsWith(" cpu")) {
				cpu.setCpuBaseInfo(cpuInfo[i]);
				al.add(cpu);
			}
		}
		return al;
	}

	/**
	 * 切割cpu的每个值
	 * @param cpu
	 */
	public void SplitCPU(String cpu){
		String[] singleCpu = cpu.split(" ");
		System.out.println(singleCpu[0]);
		System.out.println(singleCpu[1]);
		System.out.println(singleCpu[2]);
		System.out.println(singleCpu[3]);
		System.out.println(singleCpu[4]);
		System.out.println(singleCpu[5]);
		System.out.println(singleCpu[6]);
		System.out.println(singleCpu[7]);
		System.out.println(singleCpu[8]);
		System.out.println(singleCpu[9]);
		System.out.println(singleCpu[10]);
		System.out.println(singleCpu[11]);
//		System.out.println(singleCpu[12]);
	}
	
	
	
	

	/**
	 * 处理获取内存信息
	 * @param memBaseInfo
	 * @return
	 */
	public ArrayList<memBaseInfoBean> handleMEMInfo(String memBaseInfo) {
		ArrayList<memBaseInfoBean> al = new ArrayList<memBaseInfoBean>();
		String[] memInfo = memBaseInfo.split("\n");
		for(int i=0;i<memInfo.length;i++) {
			memBaseInfoBean mbif = new memBaseInfoBean();
			mbif.setMemBaseInfo(memInfo[i]);
			al.add(mbif);
		}
		return al;
	}
	
	/**
	 * 切割内存信息具体值
	 * @param mem
	 */
	public void SplitMem(String mem){
		float memUsage = 0.0f;
		String[] singleMem = mem.split("\\s+");
		if(mem.startsWith(" M")) {
//			System.out.println("singleMem size = "+singleMem.length);
//			System.out.println(singleMem[2]+"|"+singleMem[3]+"|"+singleMem[4]+"|"+singleMem[5]+"|"+singleMem[6]+"|"+singleMem[7]);
			float memTotal = Float.parseFloat(singleMem[2]);
         float memUsed = Float.parseFloat(singleMem[3]);
         System.out.println("内存总量 = "+memTotal);
         System.out.println("已用内存 = "+memUsed);
		}
		if(mem.startsWith(" S")) {
			System.out.println(singleMem[2]+"|"+singleMem[3]+"|"+singleMem[4]);
		}
//		System.out.println("singleMem value = "+mem);
	}

	/**
	 * 处理获取io基本信息	avgqu-sz,await(r,w),svctm,util,
	 * @param ioBaseInfo
	 * @return
	 */
	public ArrayList<ioBaseInfoBean> handleIOInfo(String ioBaseInfo){
		ArrayList<ioBaseInfoBean> al = new ArrayList<ioBaseInfoBean>();
		String[] ioInfo = ioBaseInfo.split("\n");
		for(int i=0;i<ioInfo.length;i++) {
			ioBaseInfoBean ib = new ioBaseInfoBean();
			ib.setIoBaseInfo(ioInfo[i]);
			al.add(ib);
		}
		return al;
	}
	
	/**
	 * 切割IO信息具体值
	 * @param io
	 */
	public void SplitIo(String io){
		String[] singleIO = io.split("\\s+");
		if(io.startsWith(" s")||io.startsWith(" v")){
			System.out.println("io length : "+singleIO.length);
			System.out.println("io value : "+io);
			System.out.println("rrqm/s : "+singleIO[2]);
			System.out.println("wrqm/s : "+singleIO[3]);
			System.out.println("r/s : "+singleIO[4]);
			System.out.println("w/s : "+singleIO[5]);
			System.out.println("rkB/s : "+singleIO[6]);
			System.out.println("wkB/s : "+singleIO[7]);
			System.out.println("avgrq-sz : "+singleIO[8]);
			System.out.println("avgqu-sz : "+singleIO[9]);
			System.out.println("await : "+singleIO[10]);
			System.out.println("r_await : "+singleIO[11]);
			System.out.println("w_await : "+singleIO[12]);
			System.out.println("svctm : "+singleIO[13]);
			System.out.println("%util : "+singleIO[14]);
		}
		
	}

	/**
	 * 处理获取net基本信息
	 * @param netBaseInfo
	 * @return
	 */
	public ArrayList<netBaseInfoBean> handleNETInfo(String netBaseInfo){
		ArrayList<netBaseInfoBean> al = new ArrayList<netBaseInfoBean>();
		String[] netInfo = netBaseInfo.split("\n");
		for(int i=0;i<netInfo.length;i++) {
			netBaseInfoBean nb = new netBaseInfoBean();
			nb.setNetBase(netInfo[i]);
			al.add(nb);
		}
		return al;
	}

	/**
	 * 切割网络信息具体值
	 * @param net
	 */
	public void SplitNet(String net) {
		String[] singleNet = net.split("\\s+");
		if(net.startsWith("    e")) {
//			System.out.println("net size : "+singleNet.length);
//			System.out.println("singleNet : "+net);
//			System.out.println("singleNet[0] : "+singleNet[0]);
			System.out.println("Inter-face : "+singleNet[1]);
			System.out.println("R-bytes : "+singleNet[2]);
			System.out.println("R-packets : "+singleNet[3]);
			System.out.println("R-errs : "+singleNet[4]);
			System.out.println("R-drop : "+singleNet[5]);
			System.out.println("R-fifo : "+singleNet[6]);
			System.out.println("R-frame : "+singleNet[7]);
			System.out.println("R-compressed : "+singleNet[8]);
			System.out.println("R-multicast : "+singleNet[9]);
			System.out.println("----------------");
			System.out.println("T-bytes : "+singleNet[10]);
			System.out.println("T-packets : "+singleNet[11]);
			System.out.println("T-errs : "+singleNet[12]);
			System.out.println("T-drop : "+singleNet[13]);
			System.out.println("T-fifo : "+singleNet[14]);
			System.out.println("T-frame : "+singleNet[15]);
			System.out.println("T-compressed : "+singleNet[16]);
			System.out.println("T-multicast : "+singleNet[17]);
//			    
		}
	}

	
	/**
	 * 将系统计数记录到csv文件
	 * @param recordPath
	 * @param hardwareValue
	 * @param hardType
	 * @param recordTime
	 */
			public void recordSamplingCSV(String recordPath,String hardwareValue,String hardType,String samplingIP) {
				controlFile cf = new controlFile();
				//声明记录文件的时间标记
//				String fileTime = cf.logFileFormat(cf.Time());
//				String fileTime = "measure";
				String recordTime = null;
				switch (hardType){
				
					case "cpu":
						String[] singleCpu = hardwareValue.split("\\s+");
						recordTime = cf.recordTime(cf.Time());
						String cpuValue = recordTime+","+singleCpu[1]+","+singleCpu[3]+","+singleCpu[4]+","+singleCpu[5]+","+singleCpu[6]+","+singleCpu[7]+","+singleCpu[8]+","+singleCpu[9]+","+singleCpu[10]+","+singleCpu[11];
						//开始写记录
						cf.writeFile(recordPath,"cpu",samplingIP,cpuValue);
						break;
					
					case "mem":
						float memUsage = 0.0f;
						String[] singleMem = hardwareValue.split("\\s+");
						if(hardwareValue.startsWith(" M")) {
//							System.out.println("singleMem size = "+singleMem.length);
//							System.out.println(singleMem[2]+"|"+singleMem[3]+"|"+singleMem[4]+"|"+singleMem[5]+"|"+singleMem[6]+"|"+singleMem[7]);
							float memTotal = Float.parseFloat(singleMem[2]);
				         float memUsed = Float.parseFloat(singleMem[3]);
//				         System.out.println("内存总量 = "+memTotal);
//				         System.out.println("已用内存 = "+memUsed);
				         recordTime = cf.recordTime(cf.Time());
				         String memValue = recordTime+","+memUsed+","+memTotal;
//				         System.out.println("memValue : "+memValue);
				         cf.writeFile(recordPath, "mem", samplingIP, memValue);
						}
						break;
						
					case "io":
						String[] singleIO = hardwareValue.split("\\s+");
						if(hardwareValue.startsWith(" s")||hardwareValue.startsWith(" v")){
							recordTime = cf.recordTime(cf.Time());
							String ioValue = recordTime+","+singleIO[2]+","+singleIO[3]+","+singleIO[4]+","+singleIO[5]+","+singleIO[6]+","+singleIO[7]+","+singleIO[8]+","+singleIO[9]+
									","+singleIO[10]+","+singleIO[11]+","+singleIO[12]+","+singleIO[13]+","+singleIO[14];
							cf.writeFile(recordPath, "io", samplingIP, ioValue);		
						}
						break;
					
					case "net":
						String[] singleNet = hardwareValue.split("\\s+");
						if(hardwareValue.startsWith("    e")) {
							recordTime = cf.recordTime(cf.Time());
							String netValue = recordTime+","+singleNet[1]+","+singleNet[2]+","+singleNet[10];
							cf.writeFile(recordPath, "net", samplingIP, netValue);
						}
						break;
				
				}
			}
}
