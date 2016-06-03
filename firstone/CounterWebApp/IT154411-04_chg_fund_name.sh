#!/bin/ksh
##########################################################################
# IT154411-04.sh  : AAI, AHY Fund Renaming
# Usage           : IT154411-04.sh develop prupd1 N
# Date            : 31/01/2015
# Parameter       : 1. ENV 
#                   2. Target Prulife DB
##########################################################################

##########################################################################
if [ $# -ne 3 ]
then
   echo
   echo "USAGE     : $0 <develop/uat/prod> <Target DB>  <Rollback variable Y/N>"
   echo "e.g.      : $0 develop prupd1 N"
   echo
   exit -1
fi
##########################################################################


ENV=$1
INFORMIXSERVER=$2
TARGET=prulife@$2
fallback=$3
INFORMIXDIR=/usr/informix

if [ "$ENV" = "uat" ]
then
  export tSysEnv=esv_hk
  INFORMIXDIR=/usr/informix
elif [ "$ENV" = "develop" ]
then
  export tSysEnv=esv_hk
  INFORMIXDIR=/usr/informix
elif [ "$ENV" = "prod" ]
then
  export tSysEnv=esv_hk
else
  echo "Undefined Environment variable ..."
  exit -1
fi

LOGFILE=/$ENV/$tSysEnv/script/logs/IT154411-04.log

export INFORMIXSERVER TARGET LOGFILE

export INFORMIXDIR
echo "INFORMIXSERVER = ${INFORMIXSERVER}" > ${LOGFILE}
hostname >> ${LOGFILE}
date >> ${LOGFILE}
echo "Log file is placed in ${LOGFILE}"
echo "-----------------  Begin process  ------------------------" >> ${LOGFILE}


if [ ${fallback} = "Y" ]
then
(
$INFORMIXDIR/bin/isql -s prulife <<!EOF
begin work;
set lock mode to wait;

!echo "-- Start --"

!echo "---------- 1. Before Renaming ----------"
select * from efolder_fund where fund_cd in ('AAI_U', 'AHY_U');
select * from efolder_fund_aa where fund_cd in ('AAI_UA', 'AHY_UA');
select * from fund where fund_code in ('AAI_U', 'AHY_U');
select * from fund_aa where fund_code in ('AAI_UA', 'AHY_UA');

!echo "---------- 2. Falling back Fund Name ----------"
update fund set fund_description = 'AllianceBernstein American Income Portfolio Fund', fund_description_sec = '聯博美元收益基金' where fund_code = 'AAI_U';
update fund_aa set fund_description = 'AllianceBernstein American Income Portfolio Fund', fund_description_sec = '聯博美元收益基金' where fund_code = 'AAI_UA';
update fund set fund_description = 'AllianceBernstein Global High Yield Portfolio Fund', fund_description_sec = '聯博環球高收益基金' where fund_code = 'AHY_U';
update fund_aa set fund_description = 'AllianceBernstein Global High Yield Portfolio Fund', fund_description_sec = '聯博環球高收益基金' where fund_code = 'AHY_UA';

update efolder_fund set fund_name_en = 'AllianceBernstein American Income Portfolio Fund', fund_name_zh = '聯博美元收益基金' where fund_cd = 'AAI_U';
update efolder_fund_aa set fund_name_en = 'AllianceBernstein American Income Portfolio Fund', fund_name_zh = '聯博美元收益基金' where fund_cd = 'AAI_UA';
update efolder_fund set fund_name_en = 'AllianceBernstein Global High Yield Portfolio Fund', fund_name_zh = '聯博環球高收益基金' where fund_cd = 'AHY_U';
update efolder_fund_aa set fund_name_en = 'AllianceBernstein Global High Yield Portfolio Fund', fund_name_zh = '聯博環球高收益基金' where fund_cd = 'AHY_UA';

!echo "---------- 3. After Renaming ----------"
select * from efolder_fund where fund_cd in ('AAI_U', 'AHY_U');
select * from efolder_fund_aa where fund_cd in ('AAI_UA', 'AHY_UA');
select * from fund where fund_code in ('AAI_U', 'AHY_U');
select * from fund_aa where fund_code in ('AAI_UA', 'AHY_UA');
!echo "-- Completed --"

commit work;

!echo "-- Commit Work --"

!EOF
) >> ${LOGFILE} 2>&1

else

(
$INFORMIXDIR/bin/isql -s prulife <<!EOF
begin work;
set lock mode to wait;

!echo "-- Start --"


!echo "---------- 1. Before Renaming ----------"
select * from efolder_fund where fund_cd in ('AAI_U', 'AHY_U');
select * from efolder_fund_aa where fund_cd in ('AAI_UA', 'AHY_UA');
select * from fund where fund_code in ('AAI_U', 'AHY_U');
select * from fund_aa where fund_code in ('AAI_UA', 'AHY_UA');

!echo "---------- 2. Renaming ----------"
update fund set fund_description = 'AB FCP I American Income Portfolio', fund_description_sec = 'AB FCP I 美元收益基金' where fund_code = 'AAI_U';
update fund_aa set fund_description = 'AB FCP I American Income Portfolio', fund_description_sec = 'AB FCP I 美元收益基金' where fund_code = 'AAI_UA';
update fund set fund_description = 'AB FCP I Global High Yield Portfolio', fund_description_sec = 'AB FCP I 環球高收益基金' where fund_code = 'AHY_U';
update fund_aa set fund_description = 'AB FCP I Global High Yield Portfolio', fund_description_sec = 'AB FCP I 環球高收益基金' where fund_code = 'AHY_UA';

update efolder_fund set fund_name_en = 'AB FCP I American Income Portfolio', fund_name_zh = 'AB FCP I 美元收益基金' where fund_cd = 'AAI_U';
update efolder_fund_aa set fund_name_en = 'AB FCP I American Income Portfolio', fund_name_zh = 'AB FCP I 美元收益基金' where fund_cd = 'AAI_UA';
update efolder_fund set fund_name_en = 'AB FCP I Global High Yield Portfolio', fund_name_zh = 'AB FCP I 環球高收益基金' where fund_cd = 'AHY_U';
update efolder_fund_aa set fund_name_en = 'AB FCP I Global High Yield Portfolio', fund_name_zh = 'AB FCP I 環球高收益基金' where fund_cd = 'AHY_UA';

!echo "---------- 3. After Renaming ----------"
select * from efolder_fund where fund_cd in ('AAI_U', 'AHY_U');
select * from efolder_fund_aa where fund_cd in ('AAI_UA', 'AHY_UA');
select * from fund where fund_code in ('AAI_U', 'AHY_U');
select * from fund_aa where fund_code in ('AAI_UA', 'AHY_UA');
!echo "-- Completed --"

commit work;

!echo "-- Commit Work --"

!EOF
) >> ${LOGFILE} 2>&1

fi

echo "-----------------  Finish process  ------------------------" >> ${LOGFILE}
date >> ${LOGFILE}

######
exit 0
######
