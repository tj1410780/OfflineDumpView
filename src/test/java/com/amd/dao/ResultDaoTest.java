package com.amd.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amd.entity.BugcheckCount;
import com.amd.entity.Result;


/**
 * 配置spring和Junit整合，Junit启动时加载springIOC容器
 * spring-test, junit
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉Junit spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ResultDaoTest {
	//注入dao接口实现类的依赖	
	@Resource
	private ResultDao resultDao;
	
	@Test
	public void testGetById() {
		long id = 1;
		Result result = resultDao.getById(id);
		System.out.println(result);
	}
//JDBC Connection [jdbc:sqlserver://SHDUMPVIEWPRD01:1433;authenticationScheme=nativeAuthentication;xopenStates=false;sendTimeAsDatetime=true;trustServerCertificate=false;sendStringParametersAsUnicode=true;selectMethod=direct;responseBuffering=adaptive;packetSize=8000;multiSubnetFailover=false;loginTimeout=15;lockTimeout=-1;lastUpdateCount=true;encrypt=false;disableStatementPooling=true;databaseName=DumpViewOffLineDB;applicationName=Microsoft JDBC Driver for SQL Server;applicationIntent=readwrite;, UserName=dvol, Microsoft JDBC Driver 4.0 for SQL Server] will not be managed by Spring
//Preparing: select * from DumpViewOffLineDB.dbo.result where id = ? 
//Parameters: 1(Long)
//Total: 1

	@Test
	public void testGetByBugcheck() {
		String bugcheck = "0x116";
		List<Result> list = resultDao.getByBugcheck(bugcheck);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId() + " " + list.get(i).getDumpFile());
		}
	}
//Preparing: select * from DumpViewOffLineDB.dbo.result where bugcheck = ? order by id DESC 
//Parameters: 0x133(String)
//Total: 2

	@Test
	public void testGetAllBugcheckCount() {
		List<BugcheckCount> list = resultDao.getAllBugcheckCount();
		System.out.println("count = " + list);
	}        
//	 Preparing: select bugcheck, count(*) as number from DumpViewOffLineDB.dbo.result group by bugcheck 
//	 Parameters: 
//	 Total: 5
//	 count = [BugcheckList [bugcheck=0x100000EA, number=9], BugcheckList [bugcheck=0x116, number=15], BugcheckList [bugcheck=0x133, number=37], BugcheckList [bugcheck=0x141, number=2], BugcheckList [bugcheck=0xD1, number=26]]
//	
	@Test
	public void testGetLastFifty() {
		List<Result> list = resultDao.getLastFifty();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId() + " " + list.get(i).getDumpFile());
		}
	}
//	 Preparing: select top 50 * from DumpViewOffLineDB.dbo.result order by id DESC 
//	 Parameters: 
//	 Total: 10
//	 10 7-040518-18593-01.dmp
//	 9 MEMORY.DMP
//	 8 8-timespy.dmp
//	 7 MEMORY.DMP
//	 6 7-040518-18593-01.dmp
//	 5 4-HGS3Cycles.dmp
//	 4 MEMORY.DMP
//	 3 MEMORY.DMP
//	 2 7-040518-18593-01.dmp
//	 1 8-timespy.dmp


	@Test
	public void testGetAll() {
		List<Result> list = resultDao.getAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId() + " " + list.get(i).getDumpFile());
		}
	}	
//	Preparing: select * from DumpViewOffLineDB.dbo.result order by id DESC 
//	Parameters: 
//	Total: 7
//	7 MEMORY.DMP
//	6 7-040518-18593-01.dmp
//	5 4-HGS3Cycles.dmp
//	4 MEMORY.DMP
//	3 MEMORY.DMP
//	2 7-040518-18593-01.dmp
//	1 8-timespy.dmp

	@Test
	public void testGetCount() {
		long count = resultDao.getCount();
		System.out.println("count = " + count);
	}
//Preparing: select count(*) from DumpViewOffLineDB.dbo.result 
//Parameters: 
//Total: 1
//count = 5

}
