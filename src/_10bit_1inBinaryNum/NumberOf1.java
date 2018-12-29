package _10bit_1inBinaryNum;

//��������1�ĸ���

public class NumberOf1 {
	//��Ϊ������ʱ����ܳ�����ѭ��
	public static int numberOf1_1(int n) {
		int count = 0;
		while (n > 0) {
			if ( 0!=(n & 1)) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}
	
	public static int numberOf1_2(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ( 0!=(n & flag)) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	public static int numberOf1_3(int n) {
		int count = 0;
		while(n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}
}
