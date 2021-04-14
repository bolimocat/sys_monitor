# sys_monitor
a monitor for linux by java
there is a runnable jar in the folder ./sys_monitor ,its name is sys_monitor.jar, and the properties file linkfile in the same place.You can edit the linkfile to observate the machine withc do you want.For example:
192.168.130.13,username,usrepassword,sshPort
You can write more than one row to observate other machines,but it's a not good choice as maybe you could get some different interval sampling.

## use
java -jar sys_monitor.jar "start"
start to get sampling from your linkFile and record the info into folder sampling.
It will record 4 latitudes : 
cpu:cat /proc/stat
mem:free
io: iostat -x 1 1
net: cat /proc/net/dev
