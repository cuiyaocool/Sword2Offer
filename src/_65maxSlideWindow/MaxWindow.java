package _65maxSlideWindow;
/**
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 */

import java.util.ArrayList;
import java.util.List;

public class MaxWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
		List<Integer> list = new ArrayList<Integer>();
		findMax(nums, list, 3);
	}

	private static void findMax(int[] nums, List<Integer> list, int size) {
		// TODO Auto-generated method stub
	    List<Integer> res = new ArrayList<>();
		if (nums == null || size < 0 || size > nums.length) {
			return;
		}
		for (int i = 0; i < size; i++) {
			while (!list.isEmpty() && nums[i] >= nums[list.get(0)]) {
				list.remove(0);
			}
			list.add(i);
		}
		
		for (int i = size; i < nums.length; i++) {
			res.add(list.get(0));
			while (!list.isEmpty() && nums[i] >= nums[list.get(list.size()-1)]) {
				list.remove(list.size()-1);
			}
			if (!list.isEmpty() && list.get(0) <= (i - size)) {
				list.remove(0);
			}
			list.add(i);
		}
		res.add(list.get(0));
		for (Integer integer : res) {
			System.out.println(nums[integer]);
		}
		System.out.println("------------------");
	}

}
