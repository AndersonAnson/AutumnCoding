package swordToOffer;

public class ConstructMultiply {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp = A[i];
            A[i] = 1;
            B[i] = 1;
            for (int j = 0; j < A.length; j++) {
                B[i] *= A[j];
            }
            A[i] = temp;
        }
        return B;
    }

    public int[] multiplyV2(int[] A) {
        int[] B = new int[A.length];
        if (A == null || A.length < 1) {
            return null;
        }
        // 计算下三角
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        // 计算上三角
        int temp = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            B[i] = temp * B[i];
            temp = A[i] * temp;
        }
        return B;
    }
}
