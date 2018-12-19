package com.test.ali;
/*
 * 封装该对象是因为，一组文件中不存在中位数，那么返回的medianNo为0，
 * findMedianNo为false,表示已个无效中位数的值
 * @author  Chen Lin
 */
public class MedianNnumberResult {
	
	
	private final boolean findMedianNo ;
	private final int medianNo;
	
	public MedianNnumberResult(boolean findMedianNo, int medianNo){
		this.findMedianNo = findMedianNo;
		this.medianNo = medianNo;
	}

	public boolean isFindMedianNo() {
		return findMedianNo;
	}

	public int getMedianNo() {
		return medianNo;
	}
	
}	
