package swordToOffer;

public class CutRope {
    public int cutRope(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] product = new int[target + 1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;
        int max = 0;
        for (int i = 4; i < target + 1; i++) {
            max = 0;
            for (int j = 1; j < i / 2 + 1; j++) {
                max = Math.max(product[j] * product[i - j], max);
            }
            product[i] = max;
        }
        max = product[target];
        return max;
    }
}
