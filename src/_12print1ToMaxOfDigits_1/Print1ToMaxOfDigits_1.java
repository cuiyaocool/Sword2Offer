package _12print1ToMaxOfDigits_1;

/**
 * ��ӡ1������nλ��
 * 
 * Ҫ��������Խ������⣬���������n�ܴ���ô��int����long�������Ҳ����Ҫ����  ��������
 * 
 * @author cuiyao
 *
 */
public class Print1ToMaxOfDigits_1 {
	void Print1ToMaxDigits(int n) {
		if (n < 0) {
			return;
		}
		char[] chars = new char[n];
		for (int c = 0; c < chars.length; c++) {
			chars[c] = '0';
		}
		while (!Increment(chars)) {
			printChars(chars);
		}
		
	}
	void printChars(char[] chars) {
		boolean flag = false;
		for (char c : chars) {
			if (c == '0' && !flag) {
				continue;
			} else {
				System.out.print(c);
				flag = true;
			}
		}
		System.out.println();
	}
	//�Ƿ�������Ƿ��Ѿ������ֵ
	boolean Increment(char[] chars) {
		int carry = 0;//��λ
		boolean isOverflow = false;
		for (int i = chars.length - 1; i >= 0; i--) {
			//��iλ�ӽ�λ��Ȼ���ڼ�1���ж��Ƿ����һλ��λ
			int nsum = chars[i] - '0' + carry;
			if (i == chars.length - 1) {
				nsum++;
			}
			if (nsum >= 10) {
				if (i == 0) {
					isOverflow = true;
				} else {
					nsum -= 10;
					carry = 1;
					chars[i] = (char)('0' + nsum);
				}
				
			}else {
				chars[i] = (char)('0' + nsum);
				break;
			}
			
		}
		return isOverflow;
	}
}
