package com.amd.util;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.amd.entity.ResultInfo;

public class ParseXML {

	public static List<ResultInfo> parse(String xml) {
	
		List<ResultInfo> list = new ArrayList<ResultInfo>();	  
		Document document = null;
		try {
			document = DocumentHelper.parseText(xml); 
			Element root = document.getRootElement();     
		    //System.out.println("root name:" + root.getName());
			List<Element> elements = root.elements("command");  
			for (Element child : elements) {
			   String title = child.attributeValue("txt");
			   String information = child.getText();
			   ResultInfo resultInfo = new ResultInfo(title, information);
			   list.add(resultInfo);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}    
		return list;   
	}
}
	
	

