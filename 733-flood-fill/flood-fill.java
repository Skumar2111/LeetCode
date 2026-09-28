class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int[][] ans_matrix = image;
        int old_colour = image[sr][sc];

        int[] delta_row = {-1,0,+1,0};
        int[] delta_column = {0,+1,0,-1};

        dfs(sr, sc , image , ans_matrix , old_colour , color ,delta_row , delta_column);

        return ans_matrix;
    }


     private void dfs(int initialRow, int initialColumn, int[][] matrix, int[][] ansMatrix, int colour, int newColour, int[] deltaRow, int[] deltaColumn) {


        ansMatrix[initialRow][initialColumn] = newColour;

        int actual_row = matrix.length;
        int actual_column = matrix[0].length;

        for(int delta = 0 ; delta < 4 ; delta++)
        {
            int new_row = initialRow + deltaRow[delta];
            int new_column = initialColumn + deltaColumn[delta];

            if(new_row >= 0 && new_row < actual_row && new_column >= 0 && new_column < actual_column
            && matrix[new_row][new_column] == colour && ansMatrix[new_row][new_column] != newColour)

            {
                dfs(new_row,new_column,matrix,ansMatrix,colour,newColour,deltaRow,deltaColumn);
            }

        }
    }
}