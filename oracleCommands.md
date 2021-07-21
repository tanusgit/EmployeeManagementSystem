//show datatbase
SELECT * FROM DBA_USERS;
//to see user name and password of oracle
select username,password from dba_users;
//to change the password
alter user username identified by password;
//alter user HR identified by 1234; 
//alter user SYSTEM identified by 1234;
//Here username is the name of user whose password you want to change and password is the new password.
https://stackoverflow.com/questions/35199084/forgot-oracle-username-and-password-how-to-retrieve
//to unlock db
ALTER USER USER_NAME ACCOUNT UNLOCK;



to show the current user
//show user
to change the password of the current user
//alter user SYSTEM identified by 1234;



docker ps
sudo docker run -d -p 1521:1521 epiclabs/docker-oracle-xe-11g 
we will get a sha key
sudo docker exec -it 3a96e607dc39dbc9209ce5766a0b7a32cf2bd0088aa9ec85b103c12af8bee0aa /bin/bash
sha key always changes
then run
sqlplus system/oracle@//localhost:1521/xe

there is only one database in oracle
