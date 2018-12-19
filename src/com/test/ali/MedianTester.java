package com.test.ali;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
 * ≤‚ ‘¿‡
 * @author  Chen Lin
 */
public class MedianTester {

	public static void main(String[] args) throws IOException {
		
		ResourceLoader rl = new ResourceLoader();
		List<Integer>  list1 =  rl.getIntList("E:/median/f1.txt");
		List<Integer>  list2 =  rl.getIntList("E:/median/f2.txt");
		
		List<List<Integer>> fileList = new ArrayList<List<Integer>>();
		
		fileList.add(list1);
		fileList.add(list2);

		MedianNumberFinder mnf = new MedianNumberFinder();
		int medNo = mnf.getMedianNumber(fileList);
		System.out.println(medNo);
				
	}
}
