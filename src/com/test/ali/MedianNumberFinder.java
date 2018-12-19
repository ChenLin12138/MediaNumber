package com.test.ali;

import java.util.ArrayList;
import java.util.List;

/*
 * 传入list,找出对应的中位数,中位数的主要思路时候中位数处于有序数组的中间位置，那么
 * 在数组总量为奇数的时候，中位数的位置大于数组中其它元素的个数等于，小于其它元素的个数
 * 为偶数时，其实应该有两个中位数，我没有写对应的逻辑来处理。
 * @author  Chen Lin
 */
public class MedianNumberFinder {
	
	
	private List<List<Integer>> list = new ArrayList<List<Integer>>();
	
	
	public MedianNumberFinder(){
	}
	
	public MedianNumberFinder(List<Integer> list1, List<Integer> list2){
		list.add(list1);
		list.add(list2);
	}
	
	
	//封装List<List<Integer>> list的目的是，可以为2个以上的文件提供找中位数的功能
	public Integer getMedianNumber(List<List<Integer>> list){
		
		boolean findMedianNo = false;
		Integer result = 0;
		List<List<Integer>> baseList = new ArrayList<List<Integer>>(list);
		
		//用list.get(0)作为初始的被查找中位数的currentList
		int currentListNo = 0;
		while(!findMedianNo){
			MedianNnumberResult nmr = findMedianNumber(list.get(currentListNo), list);
			findMedianNo = nmr.isFindMedianNo();
			result = nmr.getMedianNo();
			//将来下一个 file的元素设置为currentlist
			if(!findMedianNo && currentListNo < list.size()){	
				currentListNo ++;
			}
			
		}
		
		return result;
		
	}
	
	private MedianNnumberResult findMedianNumber(List<Integer> currentList, List<List<Integer>> searchBaseList){
		
		Integer result = 0;
		boolean findMedianNo = false;
		
		int rankNo =getRankNo(searchBaseList);
		
		//遍历正在被查找的file内的元素
		for(int indexCurrentList = 0 ;  indexCurrentList < currentList.size(); indexCurrentList ++){
			
			int count = 0;
			//与当前 file和其它file一起比对，找到当前元素大于其它元素的个数count是否等于rankNo
			for(int listId = 0; listId< searchBaseList.size(); listId++){
				count += getCountFromSubList(currentList,searchBaseList.get(listId), indexCurrentList);
			}
		
			if(count == rankNo){		
				result = currentList.get(indexCurrentList);
				findMedianNo = true;
				
			}
			
		}
		
		if(findMedianNo){
			MedianNnumberResult mnr = new MedianNnumberResult(true,result);
			return mnr;
		}else{
			MedianNnumberResult mnr = new MedianNnumberResult(false,result);
			return mnr;
		}
		
	}
	
	private int getCountFromSubList(List<Integer> currentList, List<Integer> searchBaseList , int indexCurrentList){
		
		int count = 0;
		
		for(int indexSearchBaseList = 0; indexSearchBaseList < searchBaseList.size() ; indexSearchBaseList ++){
			
			if(currentList == searchBaseList){
				if(indexCurrentList != indexSearchBaseList && currentList.get(indexCurrentList) >=  searchBaseList.get(indexSearchBaseList))
					count ++;
			}else{
				if(currentList.get(indexCurrentList) >=  searchBaseList.get(indexSearchBaseList)){
					count ++;
				}
			}
			

		}
		
		return count;
	}
	
	private int getRankNo(List<List<Integer>> list){
		
		int sum = 0;
		
		for(List<Integer> sublist : list){
			sum+= sublist.size();
		}
		
		return sum/list.size();
	}
	
	
}
