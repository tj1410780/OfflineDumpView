package com.amd.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amd.entity.BugcheckCount;
import com.amd.entity.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class ResultServiceTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ResultService resultService;
	
	@Test
	public void testGetResultList() {
		List<Result> results = resultService.getResultList();
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i).getId() + " " + results.get(i).getDumpFile());
		}
		//logger.info("results = {}", results);	
	}
//	Preparing: select top 50 * from DumpViewOffLineDB.dbo.result order by id DESC 
//	Parameters: 
//	Total: 50
//	85 3-FJmoryCopy28.dmp
//	84 1-Copy288749difjheslsuyen.dmp
//	83 2-fF3Cycles.dmp
//	82 MEMORY.DMP
//	81 7-040518-18593-01.dmp
//	80 7-040518-18593-01.dmp
//	79 MEMORY.DMP
//	78 7-040518-18593-01.dmp
//	77 MEMORY.DMP
//	76 MEMORY.DMP
//	75 5-memory28874900228.DMP
//	74 MEMORY.DMP
//	73 7-040518-18593-01.dmp
//	72 3-FJmoryCopy28.dmp
//	71 1-Copy288749difjheslsuyen.dmp
//	70 5-memory28874900228.DMP
//	69 4-HGS3Cycles.dmp
//	68 2-fF3Cycles.dmp
//	67 MEMORY.DMP
//	66 7-040518-18593-01.dmp
//	65 MEMORY.DMP
//	64 7-040518-18593-01.dmp
//	63 MEMORY.DMP
//	62 7-040518-18593-01.dmp
//	61 7-040518-18593-01.dmp
//	60 MEMORY.DMP
//	59 MEMORY.DMP
//	58 7-040518-18593-01.dmp
//	57 MEMORY.DMP
//	56 7-040518-18593-01.dmp
//	55 MEMORY.DMP
//	54 MEMORY.DMP
//	53 MEMORY.DMP
//	52 7-040518-18593-01.dmp
//	51 MEMORY.DMP
//	50 MEMORY.DMP
//	49 MEMORY.DMP
//	48 MEMORY.DMP
//	47 7-040518-18593-01.dmp
//	46 MEMORY.DMP
//	45 MEMORY.DMP
//	44 MEMORY.DMP
//	43 7-040518-18593-01.dmp
//	42 5-memory28874900228.DMP
//	41 7-040518-18593-01.dmp
//	40 MEMORY.DMP
//	39 5-memory28874900228.DMP
//	38 1-Copy288749difjheslsuyen.dmp
//	37 3-FJmoryCopy28.dmp
//	36 2-fF3Cycles.dmp


	@Test
	public void testGetById() {
		long id = 80L;
		Result result = resultService.getById(id);
		logger.info("result = {}", result);
	}
	
//Preparing: select * from DumpViewOffLineDB.dbo.result where id = ? 
//Parameters: 80(Long)
//Total: 1
//result = Result [id=80, dumpFile=7-040518-18593-01.dmp, endTime=4/19/2018 3:03:12 PM, bugcheck=0xD1, summary= this issue is probably caused by AMD gfx driver with the following reason.

	@Test
	public void testGetBugcheckCountList() {
		System.out.println("start");
		List<BugcheckCount> list = resultService.getBugcheckCountList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getBugcheck() + " " + list.get(i).getNumber());
		}
	}
//Preparing: select bugcheck, count(*) as number from DumpViewOffLineDB.dbo.result group by bugcheck 
//Parameters: 
//Total: 5
//0x133 37
//0xD1 26
//0x116 15
//0x100000EA 9
//0x141 2
		

	@Test
	public void testGetByBugcheck() {
		String bugcheck = "0x116";
		List<Result> results = resultService.getByBugcheck(bugcheck);
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i).getId() + " " + results.get(i).getDumpFile());
		}
	}
//	 Preparing: select * from DumpViewOffLineDB.dbo.result where bugcheck = ? order by id DESC 
//	 Parameters: 0x116(String)
//	 Total: 15
//	 85 3-FJmoryCopy28.dmp
//	 84 1-Copy288749difjheslsuyen.dmp
//	 75 5-memory28874900228.DMP
//	 72 3-FJmoryCopy28.dmp
//	 71 1-Copy288749difjheslsuyen.dmp
//	 70 5-memory28874900228.DMP
//	 42 5-memory28874900228.DMP
//	 39 5-memory28874900228.DMP
//	 38 1-Copy288749difjheslsuyen.dmp
//	 37 3-FJmoryCopy28.dmp
//	 32 3-FJmoryCopy28.dmp
//	 30 5-memory28874900228.DMP
//	 28 5-memory28874900228.DMP
//	 24 5-memory28874900228.DMP
//	 19 5-memory28874900228.DMP

}
