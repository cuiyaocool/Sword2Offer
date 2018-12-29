package _65maxSlideWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ����һ������ͻ������ڵĴ�С�����ҳ����л�������������ֵ��
 * @author cy
 *
 */
public class RedoOnlyForStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,4,2,6,2,5,1};
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		int windowSize = 3;
		System.out.println(maxInWin(list, windowSize));
	}

	private static List<Integer> maxInWin(List<Integer> data, int size) {
		// TODO Auto-generated method stub
		List<Integer> windowMax = new LinkedList<Integer>();
        // �������
        if (data == null || size < 1 || data.size() < 1) {
            return windowMax;
        }
        Deque<Integer> idx = new LinkedList<Integer>();
        // ���ڻ�û�б�����ʱ�������ֵ������
        for (int i = 0; i < size && i < data.size(); i++) {
            // ���������Ӧ��ֵ��֮ǰ�洢������ֵ��Ӧ��ֵ�������ȣ���ɾ��֮ǰ�洢��ֵ
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }
            //  �������
            idx.addLast(i);
        }
        
        // �����Ѿ���������
        for (int i = size; i < data.size(); i++) {
        	// ��һ�����ڵ����ֵ����
            windowMax.add(data.get(idx.getFirst()));
         // ���������Ӧ��ֵ��֮ǰ�洢������ֵ��Ӧ��ֵ�������ȣ���ɾ��֮ǰ�洢��ֵ
         while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
            idx.removeLast();
         }
         // ɾ���Ѿ��������ڵ����ݶ�Ӧ���±�
         if (!idx.isEmpty() && idx.getFirst() <= (i - size)) {
             idx.removeFirst();
         }
         // ���ܵ������±��������
         idx.addLast(i);
        }
        // ���һ���������ֵ���
        windowMax.add(data.get(idx.getFirst()));
		return windowMax;
		
	}

}
