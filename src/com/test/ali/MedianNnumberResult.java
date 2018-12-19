package com.test.ali;
/*
 * ��װ�ö�������Ϊ��һ���ļ��в�������λ������ô���ص�medianNoΪ0��
 * findMedianNoΪfalse,��ʾ�Ѹ���Ч��λ����ֵ
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
