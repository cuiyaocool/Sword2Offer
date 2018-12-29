package _20printMatrixClockWisely;

//ͬ��һ���ļ�����classֻ��Ϊ����ϰ

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{8,9,4},{7,6,5}};
		
		printMatrixClockWisely(matrix);
	}

	private static void printMatrixClockWisely(int[][] matrix) {
		// TODO Auto-generated method stub
		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
			return;
		}
		int start = 0;
		while (start*2 < matrix.length && start*2 < matrix[0].length) {
			printMatrixCircle(matrix, start, matrix.length, matrix[0].length);
			start++;
		}
	}

	private static void printMatrixCircle(int[][] matrix, int start,
			int rows, int columns) {
		int endY = rows - start - 1;
		int endX = columns - start - 1;
		
		
		for (int i = start; i <= endX; i++) {
			System.out.print(matrix[start][i] + " ");
		}
		
		if (start < endY) {
			for (int i = start+1; i <= endY; i++) {
				System.out.print(matrix[i][endX] + " ");
			}
		}
		
		if (start < endY && start < endX) {
			for (int i = endX - 1; i >= start; i--) {
				System.out.print(matrix[endX][i] + " ");
			}
		}
		
		if (start < endX && start < endY - 1) {
			for (int i = endY-1; i > start; i--) {
				System.out.print(matrix[i][start] + " ");
			}
		}
	}

}
