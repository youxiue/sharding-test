# sharding-test

### 1. 将现有的数据库拷贝一份, mysql-5.7(作为主库) -> mysql-5.7-s1(作为从库)

1. 安装位置

​      ![image.png](https://cdn.nlark.com/yuque/0/2020/png/1008903/1591060840768-c5e19053-2c2e-4102-95e1-b94fcbaad196.png)

1. 数据存储位置

​    ![image.png](https://cdn.nlark.com/yuque/0/2020/png/1008903/1591060942132-fee8ec0e-740b-46ed-a1bd-7e9db3e749e3.png)

### 2. 新增mysql实例

1. 修改从库的 `my.ini` 

```
# 主库的端口是3306, 从库设置为3307, 注意有两个port 都要改
port=3307

# 设置mysql 的安装目录, 下面的路径在原文件中就是被注释掉的, 不知道这改了有没有用?或者不改也行?
# basedir="C:/Program Files/MySQL/MySQL Server 5.7-s1/"

# 设置mysql数据库的存放路径
datadir=C:/ProgramData/MySQL/MySQL Server 5.7-s1/Data
```

1. 在从库的bin目录下将从库安装为 windows服务, 注意配置文件位置

```
mysqld install mysqls1 --defaults-file="C:\ProgramData\MySQL\MySQL Server 5.7-s1\my.ini"
```

### 3. 修改数据存储文件夹下的 `my.ini` 文件

1. 修改主库的my.ini 文件

```
# 开启日志
log-bin = mysql-bin
# 设置需要同步的数据库
binlog-do-db=user_db
# 屏蔽系统库同步
binlog-ignore-db=mysql
binlog-ignore-db=information_schema
binlog-ignore-db=performance_schema
```

1. 修改从库的 `my.ini` 文件

```
# 开启日志
log-bin = mysql-bin
# 设置服务id, 主从不能一致
server-id = 2
# 设置需要同步的数据库
replicate_wild_do_table=user_db.%
# 屏蔽系统库同步
replicate_wild_ignore_table=mysql.%
replicate_wild_ignore_table=information_schema.%
replicate_wild_ignore_table=performance_schema.%
```

1. 重启主库和从库

请注意，主从 MySQL下的数据(data)目录下有个文件auto.cnf，文件中定义了uuid，要保证主从数据库实例的

uuid不一样，建议直接删除掉，重启服务后将会重新生成

### 4. 授权主从复制专用账号

```
#切换至主库bin目录，登录主库
mysql ‐h localhost ‐uroot ‐p
#授权主备复制专用账号
GRANT REPLICATION SLAVE ON *.* TO 'db_sync'@'%' IDENTIFIED BY 'db_sync';
#刷新权限
FLUSH PRIVILEGES;
#确认位点 记录下文件名以及位点
show master status;
```

![image.png](https://cdn.nlark.com/yuque/0/2020/png/1008903/1591177729876-05979b58-52b5-4bdf-adb2-34f7ec0dc8a1.png)



### 5. 设置从库向主库同步数据, 并检查链路

```
#切换至从库bin目录，登录从库
mysql ‐h localhost ‐P3307 ‐uroot ‐p
#先停止同步
STOP SLAVE;
#修改从库指向到主库，使用上一步记录的文件名以及位点
CHANGE MASTER TO
MASTER_HOST = 'localhost',
MASTER_USER = 'db_sync',
MASTER_PASSWORD = 'db_sync',
MASTER_LOG_FILE = 'mysql-bin.000004',
MASTER_LOG_POS = 592;
#启动同步
START SLAVE;
#查看从库状态Slave_IO_Runing和Slave_SQL_Runing都为Yes说明同步成功，如果不为Yes，请检查error_log，然后
排查相关异常。
show slave status
#注意 如果之前此备库已有主库指向 需要先执行以下命令清空
STOP SLAVE IO_THREAD FOR CHANNEL '';
reset slave all;
```

最后测试在主库修改数据库，看从库是否能够同步成功。

注意: 从库修改数据是不会影响主库的.



### 6. 后续添加需要同步的数据库

只需要同步骤3修改my.ini 文件, 添加需要同步的数据库, 并重启服务即可