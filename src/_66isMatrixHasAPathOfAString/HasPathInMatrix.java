package _66isMatrixHasAPathOfAString;

import java.util.ArrayList;
import java.util.List;

/**
 * �����е�·��
 * ��Ŀ�������һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ���������һ��ʼ��ÿһ�������ھ����м������ҡ��ϡ����ƶ�һ��
 * ���һ��·�������˾����ĳһ����ô��·�������ٴν���ø��ӡ�
 * 
 * ��˷�����
 * 
 * @author cuiyao
 *
 */

public class HasPathInMatrix {
	private static boolean hasPath(char[][] matrix, int rows, int cols, String str) {
		
		if (matrix == null || rows < 1 || cols < 1 || str == null) {
			return false;
		}
		boolean[] visited = new boolean[rows * cols];
		for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
		int pathlength = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (hasPathCore(matrix, rows, cols, str, i, j, visited, pathlength)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean hasPathCore(char[][] matrix, int rows, int cols,
			String str, int i, int j, boolean[] visited, int pathlength) {
//		if (str.charAt(pathlength) == '\0') {
//			return true;
//		}
		if (pathlength >= str.length()) {
			return true;
		}
		boolean hasPath = false;
		// �ж�λ���Ƿ�Ϸ�
        if (i >= 0 && i < rows
                && j >= 0 && j < cols
                && matrix[i][j] == str.charAt(pathlength)
                && !visited[i * cols + j]) {
        	++pathlength;
        	visited[i * cols + j] = true;
        	hasPath = hasPathCore(matrix, rows, cols, str, i, j + 1, visited, pathlength)
        		   || hasPathCore(matrix, rows, cols, str, i + 1, j, visited, pathlength)
        		   || hasPathCore(matrix, rows, cols, str, i - 1, j, visited, pathlength)
        		   || hasPathCore(matrix, rows, cols, str, i, j - 1, visited, pathlength);
        	if (!hasPath) {
				pathlength--;
				visited[i * cols + j] = false;
			}
        }
		return hasPath;
	}

	public static void main(String[] args) {
		char[][] matrix = {{'a', 'b', 'c', 'e'},{'s', 'f', 'c', 's'},{'a', 'd', 'e', 'e'}};
		int rows = matrix.length;
		int cols = matrix[0].length;
		List<String> str = new ArrayList<String>();
		str.add("afe");
		str.add("abcb");
		str.add("bcced");
		boolean res[] = new boolean[3];
		res[0] = hasPath(matrix, rows, cols, str.get(0));
		res[1] = hasPath(matrix, rows, cols, str.get(1));
		res[2] = hasPath(matrix, rows, cols, str.get(2));
		for (int i = 0; i < res.length; i++) {
			if (res[i]) {
				System.out.println("matrix has a path for  " + str.get(i));
			} else {
				System.out.println("matrix has no path for  " + str.get(i));
			}
		}
	
	}

}
