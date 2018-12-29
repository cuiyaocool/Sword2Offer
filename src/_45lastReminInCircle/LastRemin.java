package _45lastReminInCircle;

import java.util.LinkedList;
import java.util.List;

/**
 * ԲȦ�����ʣ�µ�����
 * @author cuiyao
 * @param n ���ֵĸ���
 * @param m ɾ���ڼ���
 *
 */
public class LastRemin {
	public static int lastRemin1(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		}
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		// Ҫɾ��Ԫ�ص�λ��
	    int idx = 0;
	    while (list.size() > 1) {
	    	 // ֻҪ�ƶ�m-1�ξͿ����ƶ�����һ��Ҫɾ����Ԫ����   1 2 3 4 5 ��1��ʼ��ɾ����3��Ԫ�أ��ƶ����μ���
			for(int i = 0; i < m - 1; i++) {
				idx = (idx + 1) % list.size();
			}
			list.remove(idx);
		}
		return list.get(0);
	}
}
