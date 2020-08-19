package greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;
        int currTank = 0;
        int startPos = 0;
        for (int i = 0; i < n; i++) {
            totalTank = totalTank + gas[i] - cost[i];
            currTank = currTank + gas[i] - cost[i];
            if (currTank < 0) {
                startPos = i + 1;
                currTank = 0;
            }
        }
        return totalTank >= 0 ? startPos : -1;
    }
}
