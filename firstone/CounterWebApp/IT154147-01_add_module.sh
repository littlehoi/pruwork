#!/bin/ksh
####################################################################
#
# Script      : IT154147-01_add_module.sh
# Description : CWS add new purpose for cws admin 
#               
# Parameter   : 1. Environment (develop/uat/prod) 
#
####################################################################

if [ $# -ne 1 ]
then
    echo "USAGE: $0 [ Environment variable 'develop/uat/prod']"
    exit -1
fi

#Variable
module = 'content'
purpose = 'KeepAlive'
JOB_NO="IT154147-01_add_module"

ENV=$1
DB2="db2"
export ENV JOB_NO DB2

if [ "$ENV" = "develop" ]
then
    export DB_INSTANCE="cwsdev"    
    export CWS_ENV="_dev"
elif [ "$ENV" = "uat" ]
then
    export DB_INSTANCE="cwsuat"
    export CWS_ENV="_uat"
elif [ "$ENV" = "prod" ]
then
    export DB_INSTANCE="cws"
    export CWS_ENV=""
else
  echo "Undefined Environment variable ..."
  exit -1
fi

export LOGFILE=/${ENV}/esv_hk/script/logs/${JOB_NO}.log

echo "${JOB_NO}" > ${LOGFILE}
hostname >> ${LOGFILE}
date >> ${LOGFILE}

echo "----------------- Start ----------------"
echo $LOGFILE
echo "----------------- Begin process ------------------------" >> ${LOGFILE}
(

echo "--------------- CONNECT TO DATABASE  -------------- " 
$DB2 "connect to $DB_INSTANCE"                                 

echo "--------------- Select SFA_ROLE_PRIVILEGE start-----------------"   
$DB2 " Select * from db2hk.SFA_ROLE_PRIVILEGE where METHOD in ('KeepAlive') "   

echo "--------------- DELETE SFA_ROLE_PRIVILEGE start-----------------"   
$DB2 " delete from db2hk.SFA_ROLE_PRIVILEGE where METHOD in ('KeepAlive') "   

echo "--------------- Select SFA_MODULE start-----------------"   
$DB2 " SELECT * from db2hk.SFA_MODULE where METHOD in ('KeepAlive') "   

echo "--------------- DELETE SFA_MODULE start-----------------"   
$DB2 " delete from db2hk.SFA_MODULE where METHOD in ('KeepAlive') "   

echo "--------------- INSERT into sfa_module start-----------------"
$DB2 " INSERT INTO db2hk.SFA_MODULE(REALM, MODULE, METHOD, DESC, REC_UPDATE_USR, REC_UPDATE_DTE) VALUES('esv_hk${CWS_ENV}', 'content', 'KeepAlive', 'KeepAlive', 'esvadmin', current timestamp) "

echo "--------------- INSERT into sfa_role_privilege start-----------------"
$DB2 " INSERT INTO db2hk.SFA_ROLE_PRIVILEGE(REALM, MODULE, METHOD, ROLE, REC_UPDATE_USR, REC_UPDATE_DTE) VALUES('esv_hk${CWS_ENV}', 'content', 'KeepAlive', 'client ', 'esvadmin',current timestamp) "
$DB2 " INSERT INTO db2hk.SFA_ROLE_PRIVILEGE(REALM, MODULE, METHOD, ROLE, REC_UPDATE_USR, REC_UPDATE_DTE) VALUES('esv_hk${CWS_ENV}', 'content', 'KeepAlive', 'user ', 'esvadmin',current timestamp) "

echo "--------------- SELECT SFA_ROLE_PRIVILEGE start-----------------"   
$DB2 " SELECT * from db2hk.SFA_ROLE_PRIVILEGE where METHOD in ('KeepAlive') "   

echo "--------------- SELECT SFA_MODULE start-----------------"   
$DB2 " SELECT * from db2hk.SFA_MODULE where METHOD in ('KeepAlive') "   

$DB2 disconnect $DB_INSTANCE 
echo "--------------- DISCONNECT  -------------- " 

) >> ${LOGFILE} 2>&1
echo "----------------- END ----------------" >> ${LOGFILE}










