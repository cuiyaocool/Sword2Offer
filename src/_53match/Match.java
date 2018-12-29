package _53match;

/**
 * ��Ŀ����ʵ��һ����������ƥ�������.���͡�����������ʽ��
 * ģʽ�е��ַ���.����ʾ����һ���ַ���
 * ��������ʾ��ǰ����ַ����Գ�������Σ���0�Σ���
 * �����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
 * ���磬�ַ�����aaa����ģʽ��a.a���͡�ab*ac*a��ƥ�䣬���롰aa.a������ab*a������ƥ�䡣
 * @author cy
 *
 */

public class Match {

	public static void main(String[] args) {
		String src = "aaa";
		String parntern1 = "a.a";
		String parntern2 = "ab*ac*a";
		String parntern3 = "aa.a";
		String parntern4 = "ab*a";
		
		System.out.println(match(src, parntern1));
		System.out.println(match(src, parntern2));
		System.out.println(match(src, parntern3));
		System.out.println(match(src, parntern4));
	}

	private static boolean match(String src, String parntern) {
		if (src == null || parntern == null) {
			return false;
		}
		return docore(src, parntern);
	}

	private static boolean docore(String src, String parntern) {
		// TODO Auto-generated method stub
		if (src.isEmpty() && parntern.isEmpty()) {
			return true;
		}else if (!src.isEmpty() && parntern.isEmpty()) {
			return false;
		}else if (src.isEmpty() && !parntern.isEmpty()) {
			return false;
		}
		boolean flag = src.charAt(0) == parntern.charAt(0) || parntern.charAt(0) == '.';
		if (parntern.length() > 2 && parntern.charAt(1) == '*') {
			return docore(src, parntern.substring(2)) ||
				   (flag && docore(src.substring(1), parntern));
		}else {
			return flag && docore(src.substring(1), parntern.substring(1));
		}
	}

}
