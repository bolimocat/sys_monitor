import java.util.ArrayList;
import com.sys_monitor.dom.linkInfoBean;
import com.sys_monitor.function.controlFile;
import com.sys_monitor.function.monitor_thread;

public class main_monitor {

	public static void main(String[] args) {
		
		String command = args[0];
		
		controlFile cf = new controlFile();
		ArrayList linkFile = new ArrayList();
		linkFile = cf.fetchLinkInfo("./linkFile");
		System.out.println("采样数量："+linkFile.size());
		for(int i=0;i<linkFile.size();i++) {
			linkInfoBean lib = (linkInfoBean)linkFile.get(i);
			String[] sshInfo = cf.splitLinkInfo(lib.getLinkInfo());
			String sshIp = sshInfo[0];
			String sshUser = sshInfo[1];
			String sshPass = sshInfo[2];
			int sshPort = Integer.valueOf(sshInfo[3]);
			String cpuCommand = "cat /proc/stat";
			String memCommand  = "free";
			String ioCommand = "iostat -x 2 1";
			String netCommand = "cat /proc/net/dev";
			String recordPath = "./sampling";
			int interval = 2;//采样间隔秒
			
			monitor_thread montior = new monitor_thread(sshUser,sshPass,sshIp,sshPort,cpuCommand,memCommand,ioCommand,netCommand,recordPath,interval);
			Thread t1 = new Thread(montior);
			
			switch(command) {
			case "start":
				t1.start();
				break;
			case "stop":
				t1.stop();
			
			}
			
			
			
			
		}




		
	}

}
