#!/bin/bash
port=8080;
serverName=springboot-mybatis
if [ -z $1 ];
then
    echo "********************************************************************************************"
    echo "Error: Please enter the environment name and instance count in the argument like: st, uat, sim, prod, ect."
    echo "Example:"
    echo "./start.sh prod 1"
    echo "********************************************************************************************"
    exit 1;
fi
echo "********************************************************************************************"
echo "Inputs - Environment [$1]"
mkdir -p ../logs
echo "Starting $serverName instance [$1] for  environment at port [$port]..."
outfile="../logs/catalina.log"
if [ -f $outfile ];
  then
  rm $outfile
fi
touch $outfile
java -Xms1g -Xmx1g -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=512m -XX:MaxNewSize=256m -jar ../lib/springboot-mybatis*.jar  --spring.config.location=file:../env/application_config_$1.yml > $outfile 2>&1 &

for((i=0;i<10;i++))
{
    echo -ne "."
    sleep 1
}

ps -fu $USER | grep -w $serverName | grep -v grep |awk '{print "Running Service - PID ["$2"] - Start Time ["$5"] - ["$11"] - ["$12"]"}'

echo "********************************************************************************************"