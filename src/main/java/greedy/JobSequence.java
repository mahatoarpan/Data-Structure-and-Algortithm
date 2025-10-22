package greedy;

import java.util.Arrays;

public class JobSequence {
    public int maximizeProfit(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> {
            if (a.deadline == b.deadline) {
                return b.profit - a.profit; // max profit
            }
            return a.deadline - b.deadline; // min deadline
        });

        int currentTime = 0;
        int profit = 0;
        for(Job job : jobs) {
            if (job.deadline > currentTime) {
                profit += job.profit;
                currentTime++;
            }
        }
        return profit;
    }

    public static class Job {
        int jobId;
        int deadline;
        int profit;

        public Job(int jobId, int deadline, int profit) {
            this.jobId = jobId;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
}
