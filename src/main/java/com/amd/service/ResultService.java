package com.amd.service;

/**业务接口:站在使用者(程序员)的角度设计接口  
 * 三个方面:1.方法定义粒度，方法定义的要非常清楚2.参数，要越简练越好  
 * 3.返回类型(return 类型一定要友好/或者return异常，我们允许的异常)  
 */  
import java.util.List;
import com.amd.entity.BugcheckCount;
import com.amd.entity.Result;

public interface ResultService {
	
	List<Result> getResultList();
	
	Result getById(long id);
		
	List<BugcheckCount> getBugcheckCountList();
	
	List<Result> getByBugcheck(String bugcheck);    
	
}   
