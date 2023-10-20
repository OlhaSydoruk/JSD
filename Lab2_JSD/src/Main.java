public class Main {
    public static void main(String[] args) {
        int gradeBook = 1324;
        int C5 = gradeBook%5;
        int C7 = gradeBook%7;
        int C11 = gradeBook%11;
        System.out.println("C5="+C5+", C7="+C7+", C11="+C11);
        byte[][] matrixA = {{1, 2, 6},
                            {-3, 9, 4}};

        byte[][] matrixB = {{1, 2, 6},
                            {3, -9, 4},
                            {1, 4, 7}};
        MultiplyMatrix multiplyMatrix = new MultiplyMatrix(matrixA, matrixB);
        byte[][] resultMatrix = multiplyMatrix.multiplyMatrix();
        PrintMatrix printMatrix = new PrintMatrix(resultMatrix);
        printMatrix.printMatrix();

        SumRowMatrix sumRowMatrix = new SumRowMatrix(resultMatrix);
        sumRowMatrix.calculate();
        System.out.println("sum of the largest elements in rows of an even-numbered Matrix:  "+sumRowMatrix.getSumPaired());
        System.out.println("sum of the smallest elements in rows of an odd-numbered Matrix: "+sumRowMatrix.getSumUnpaired());

    }
}