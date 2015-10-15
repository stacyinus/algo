/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 * @author yue
 *
 */
public class CC1_6 {
	public static void main(String[] args){
		int[][] matrix = {{11,12,13,14,15},{21,22,23,24,25},{31,32,33,34,35},{41,42,43,44,45},{51,52,53,54,55}};
		printMatrix(matrix);
		rotate1(matrix);
		printMatrix(matrix);
	}

	public static void rotate1(int[][] matrix)
	{
		int size = matrix.length;
		//first rotate 180
		for(int i = 0;i<size;i++)
		{
			for(int j= i+1;j<size;j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		//second, flip
		for(int i =0; i<size;i++)
		{
			for(int j = 0;j<size/2;j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][size-1-j];
				matrix[i][size-1-j] = temp;
			}
		}
	}
	public static void printMatrix(int[][] matrix)
	{
		for(int i = 0;i<matrix.length;i++)
		{
			for(int j= 0;j<matrix.length;j++)
			{
				System.out.printf("%s  ",matrix[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
