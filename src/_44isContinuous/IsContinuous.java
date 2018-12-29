package _44isContinuous;

import java.util.Arrays;

public class IsContinuous {
	
	/**
	 * 
     * ��Ŀ�����˿����������5���ƣ��ж��ǲ���һ��˳�ӣ� ����5�����ǲ��������ġ�
     * 2��10Ϊ���ֱ��� AΪ1�� JΪ11��QΪ12�� Ϊ13��С�����Կ����������֡�
     * @param nums
     * @return
     * 
	 */
	
	static boolean isContinuous(int[] nums) {
		if (nums == null || nums.length != 5) {
			return false;
		}
		Arrays.sort(nums);
		int numberOfZero = 0;
		int numberOfGap = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				numberOfZero++;
			} else {
				break;
			}
		}
		for (int i = numberOfZero; i < nums.length - 1; i++) {
			if ((nums[i + 1] - nums[i]) == 0) {
				return false;	
			}
			if (Math.abs(nums[i + 1] - nums[i]) > 0) {
				numberOfGap+=Math.abs(nums[i + 1] - nums[i]) - 1;	
			}
		}
		return numberOfGap <= numberOfZero;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {2, 3, 6, 0, 0};
		System.out.println(isContinuous(nums1));
		int[] nums2 = {2, 3, 4, 7, 0};
		System.out.println(isContinuous(nums2));
	}

}
