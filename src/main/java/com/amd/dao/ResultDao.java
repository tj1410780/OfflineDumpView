package com.amd.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.amd.entity.BugcheckCount;
import com.amd.entity.Result;

public interface ResultDao {
	/**
	 * 根据id查询具体的分析结果
	 * @param id
	 * @return
	 */
	Result getById(long id);
	
	/**
	 * 根据bugcheck对所有的结果文件进行分类查询
	 * @param bugcheck
	 * @return
	 */    
	List<Result> getByBugcheck(String bugcheck);
	
	/**
	 * 不同bugcheck分类的记录数
	 * @param bugcheck
	 * @return
	 */
	List<BugcheckCount> getAllBugcheckCount();
	
	/**
	 * 若记录数大于50条，查询最新的50条记录（从大到小的顺序DESC）
	 * @param offset   倒数第51条记录的id
	 * @param limit
	 * @return
	 */
	List<Result> getLastFifty();
	
	/**
	 * 若记录数少于50条时，调用这个方法显示所有的记录
	 * @return
	 */
	List<Result> getAll();
	
	/**
	 * 查询所有的记录数
	 * @return
	 */
	long getCount();
	
	
}
