package com.amd.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amd.entity.BugcheckCount;
import com.amd.entity.Result;
import com.amd.entity.ResultInfo;
import com.amd.service.ResultService;
import com.amd.util.ParseXML;

@Controller
@RequestMapping("/Dump")
public class ResultController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ResultService resultService;
	
	@RequestMapping(value = "/List", method = RequestMethod.GET)
	public String list(Model model) {
		//list.jsp + model = ModelAndView
		List<Result> results = resultService.getResultList();
		List<BugcheckCount> bugcheckCount = resultService.getBugcheckCountList();
		model.addAttribute("results", results);
		model.addAttribute("count", bugcheckCount);
		return "list";		///WEB-INF/jsp/list.jsp
	}
		
	@RequestMapping(value = "/BugCheck/{bugcheck}", method = RequestMethod.GET)
	public String list(@PathVariable("bugcheck") String bugcheck, Model model) {	
		if (bugcheck.equals("")) {
			return "redirect:/result/list";
		}
		List<Result> list = resultService.getByBugcheck(bugcheck);
		model.addAttribute("list", list);
		model.addAttribute("bugcheck", bugcheck);
		return "bugcheckDetail";		///WEB-INF/jsp/bugcheckDetail.jsp
	}
		
	@RequestMapping(value = "/View/{id}", method = RequestMethod.GET)
	public String list(@PathVariable("id") Long id, Model model) {	
		if (id == null) {
			return "redirect:/result/list";
		}
		Result result = resultService.getById(id);
		model.addAttribute("result", result);
		List<ResultInfo> list = ParseXML.parse(result.getInformation());
		model.addAttribute("contents", list);		
		return "detail";		///WEB-INF/jsp/detail.jsp
	}			
	
}


