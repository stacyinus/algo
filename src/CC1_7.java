/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column is set to 0.
 */

public class CC1_7 {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3,4,5,6},{0,3,4,5,2,0},{1,5,0,2,4,5},{5,4,3,2,1,1},{9,8,1,0,4,7}};
		CC1_6.printMatrix(matrix);
		processMatrix(matrix);
		CC1_6.printMatrix(matrix);
	}
	//O(m*n)
	private static void processMatrix( int[][] matrix ){
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		boolean[] row = new boolean[rowLength];
		boolean[] col = new boolean[colLength];
		for(int i = 0; i<rowLength; i++)
			for(int j = 0;j<colLength;j++){
				if(matrix[i][j]==0 ){
					row[i]=true;
					col[j]=true;
				}
			}
		for( int i = 0;i<rowLength;i++ )
			if( row[i] )
				for(int j = 0;j<colLength;j++)
					matrix[i][j] = 0;
		
		for( int j = 0;j<colLength;j++ )
			if( col[j] )
				for(int i = 0;i<rowLength;i++)
					matrix[i][j] = 0;
	}
}
