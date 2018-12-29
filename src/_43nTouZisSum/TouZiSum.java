package _43nTouZisSum;

/**
 * ���ƹ�ʽ������
 * n�����Ӻ�Ϊs����ô��Ϊs�Ĵ�����n-1�����ӵĺ��й�
 * ���������Ϊ1����ôǰn-1�����Ӻ�Ϊs-1��ͬ�����һ��Ϊ6��ǰn-1��Ϊs-6
 * ���ԣ�
 * f(n,s) = f(n-1,s-1) + f(n-1, s-2) + ... + f(n - 1, s - 6)
 * �����ǣ� 6n>=s>=n
 * ��n>s����s>6n ����0
 * @author cuiyao
 *
 */

public class TouZiSum {
	//�ݹ�
	private static int getNSumCount(int n, int sum) {
		//1 �� 2 ��˳���ܴ����磨1��-2���Ƿ���0�������1 �� 2 �ߵ��ͷ���1��
		//1
		if (n > sum || sum > 6*n || n < 1) {
			return 0;
		}
		//2
		if (n == 1) {
			return 1;
		}
		return getNSumCount(n-1, sum-1) + 
			   getNSumCount(n-1, sum-2) +
			   getNSumCount(n-1, sum-3) +
			   getNSumCount(n-1, sum-4) +
			   getNSumCount(n-1, sum-5) +
			   getNSumCount(n-1, sum-6) ;
	}
	
	//�ǵݹ�
	//numsΪһ������Ϊ6*n - n + 1 ������
	private static void getNSumCount(int n, int[] nums) {
		if (n < 0) {
			return;
		}
		nums[0] = nums[1] = nums[2] = nums[3] = nums[4] = nums[5] = 1;
		//����Ϊj,i������ʱ����Ӧ�������j-i�±�
		//nums[j-i]=nums[j-1-(i-1)]+nums[j-2-(i-1)]+...+nums[j-6-(i-1)];
		//������Ҫע����ǣ�
		//�ڲ�ѭ����Ҫ��6i��i����Ϊ��nums[15]��num[14...9],�����С������ô����15ʱ14��9�ѽᱻ�ı�
		for (int i = 2; i <= n; i++) {
			for (int j = 6*i; j >=i; j--) {
				nums[j - i] = ((j-1-(i-1))<0?0:nums[j-1-(i-1)]) + 
						      ((j-2-(i-1))<0?0:nums[j-2-(i-1)]) +
						      ((j-3-(i-1))<0?0:nums[j-3-(i-1)]) + 
							  ((j-4-(i-1))<0?0:nums[j-4-(i-1)]) +
							  ((j-5-(i-1))<0?0:nums[j-5-(i-1)]) + 
							  ((j-6-(i-1))<0?0:nums[j-6-(i-1)]) ;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[16];
		for (int i = 3; i <= 18; i++) {
			System.out.print(getNSumCount(3, i) + " ");
		}
		System.out.println();
		getNSumCount(3, nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
/**
 * 1 3 6 10 15 21 25 27 27 25 21 15 10 6 3 1 
 * 1 3 6 10 15 21 25 27 27 25 21 15 10 6 3 1 
 */
}
