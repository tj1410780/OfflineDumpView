package com.amd.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.amd.dao.ResultDao;
import com.amd.entity.BugcheckCount;
import com.amd.entity.Result;
import com.amd.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ResultDao resultDao;	

	public List<Result> getResultList() {
		long count = resultDao.getCount();
		if (count <= 50) {
			return resultDao.getAll();
		} else {
			return resultDao.getLastFifty();     
		}
	}

	public Result getById(long id) {
		return resultDao.getById(id);
	}	
	
	public List<BugcheckCount> getBugcheckCountList() {
		List<BugcheckCount> list = resultDao.getAllBugcheckCount();
		//Comparator cmp = Collections.reverseOrder(); 
        Collections.sort(list, Collections.reverseOrder());    //按从大到小顺序排列
        return list;
	}
		
	public List<Result> getByBugcheck(String bugcheck) {
		return resultDao.getByBugcheck(bugcheck);
	}


}
