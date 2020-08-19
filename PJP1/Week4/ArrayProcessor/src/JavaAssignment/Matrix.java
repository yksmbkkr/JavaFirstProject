package JavaAssignment;

import java.util.Scanner;

public class Matrix {
    int[][] mat;
    int row, column;

    public Matrix(){
        row=3;
        column=3;
        mat = new int[3][3];
    }

    public Matrix(int r, int c){
        row = r;
        column = c;
        mat = new int[row][column];
    }

    public Matrix(int[][] mat){
        this.row = mat.length;
        this.column =  mat[0].length;
        this.mat = mat;
    }

    public Matrix(Matrix mat){
        this.row = mat.row;
        this.column = mat.column;
        this.mat = mat.mat;
    }

    public void get_mat(){
        Scanner s = new Scanner(System.in);

        for (int i=0; i < this.row; i++){
            for(int j=0; j<this.column; j++){
                System.out.println("Enter the matrix elements("+(i+1)+", "+(j+1)+")");
                this.mat[i][j] = s.nextInt();
            }
        }
    }

    public void display(){
        System.out.println("The matrix is:>>");
        for (int i = 0; i < this.row; i++){
            System.out.println("");
            for (int j = 0; j < this.column; j++){
                System.out.print("   "+this.mat[i][j]);
            }
        }
        System.out.println();
    }

    public Matrix add(Matrix m1){
        Matrix ans = new Matrix(row,column);
        int i=0,j=0;
        if (this.row != m1.row || this.column != m1.column){
            System.out.println("ERROR: The two matrices should have same no. of rows and columns for addition!");
        }else{
            for (i = 0; i < row; i++){
                for (j = 0; j < column; j++){
                    ans.mat[i][j] = this.mat[i][j] + m1.mat[i][j];
                }
            }
        }
        return ans;
    }

    public boolean isScalar(){
        if(row!=column)
            return false;

        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                if ((i != j)
                        && (mat[i][j] != 0))
                    return false;

        for (int i = 0; i < row - 1; i++)
            if (mat[i][i] != mat[i + 1][i + 1])
                return false;
        return true;
    }

    public Matrix multiply(Matrix mat){
        int r1 = this.row, c1 = this.column;
        int r2 = mat.row, c2 = mat.column;

        int[][] product = new int[r1][c2];

        for(int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += this.mat[i][k] * mat.mat[k][j];
                }
            }
        }

        Matrix result = new Matrix(product);
        return result;
    }

}
