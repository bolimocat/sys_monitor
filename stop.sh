#!/bin/bash
java -jar ./sys_monitor.jar stop
PID=`jps -l | grep sys_monitor.jar|tr -cd "[0-9]"`
kill -9 $PID
