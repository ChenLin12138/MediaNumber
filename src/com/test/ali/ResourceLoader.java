package com.test.ali;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 根据文件路劲与文件名，返回对应的ArrayList<Integer>
 * @author  Chen Lin
 */
public class ResourceLoader {

	private final static String COMMA = ",";
	
	private String fullName;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public List<Integer> getIntList(String fullName) throws IOException{
			
		InputStreamReader isr = new InputStreamReader(new FileInputStream(fullName.toString()), "utf-8");
		BufferedReader br = new BufferedReader(isr);
	    String lineTxt = null;
	    String context = null;
	    
	    while ((lineTxt = br.readLine()) != null) {
	    	context = lineTxt;
	    }
	      
	    br.close(); 
		
	    ArrayList<Integer> list = new ArrayList<Integer> ();
	    
	    for(String s : context.split(COMMA)){
	    	list.add(Integer.valueOf(s.trim()));
	    }
		
		return new ArrayList<Integer>(list);
	}
}
