package swordToOffer;

public class SumSolution {
    public int sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum > 0) && ((sum += sum_Solution(n - 1)) > 0);
        return sum;
    }
}
