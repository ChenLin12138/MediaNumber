package com.test.ali;

import java.util.ArrayList;
import java.util.List;

/*
 * ����list,�ҳ���Ӧ����λ��,��λ������Ҫ˼·ʱ����λ����������������м�λ�ã���ô
 * ����������Ϊ������ʱ����λ����λ�ô�������������Ԫ�صĸ������ڣ�С������Ԫ�صĸ���
 * Ϊż��ʱ����ʵӦ����������λ������û��д��Ӧ���߼�������
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
	
	
	//��װList<List<Integer>> list��Ŀ���ǣ�����Ϊ2�����ϵ��ļ��ṩ����λ���Ĺ���
	public Integer getMedianNumber(List<List<Integer>> list){
		
		boolean findMedianNo = false;
		Integer result = 0;
		List<List<Integer>> baseList = new ArrayList<List<Integer>>(list);
		
		//��list.get(0)��Ϊ��ʼ�ı�������λ����currentList
		int currentListNo = 0;
		while(!findMedianNo){
			MedianNnumberResult nmr = findMedianNumber(list.get(currentListNo), list);
			findMedianNo = nmr.isFindMedianNo();
			result = nmr.getMedianNo();
			//������һ�� file��Ԫ������Ϊcurrentlist
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
		
		//�������ڱ����ҵ�file�ڵ�Ԫ��
		for(int indexCurrentList = 0 ;  indexCurrentList < currentList.size(); indexCurrentList ++){
			
			int count = 0;
			//�뵱ǰ file������fileһ��ȶԣ��ҵ���ǰԪ�ش�������Ԫ�صĸ���count�Ƿ����rankNo
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
