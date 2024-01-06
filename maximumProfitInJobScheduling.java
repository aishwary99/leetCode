// link
/*
https://www.youtube.com/watch?v=3kU7VYcmffU
https://leetcode.com/problems/maximum-profit-in-job-scheduling/
*/

// code
import java.util.*;
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int totalJobs = startTime.length;
        // job -> startTime, endTime, profit
        int[][] jobs = new int[totalJobs][3];
        
        // populating jobs data structure
        for (int index = 0; index < totalJobs; index++) {
            jobs[index] = new int[]{startTime[index], endTime[index], profit[index]};
        }
        
        Arrays.sort(jobs, (jobOne, jobTwo) -> jobOne[1] - jobTwo[1]);
        
        TreeMap<Integer, Integer> bag = new TreeMap();
        bag.put(0, 0);
        
        for (int[] job : jobs) {
            int currentProfit = job[2] + bag.floorEntry(job[0]).getValue();
            if (currentProfit > bag.lastEntry().getValue()) {
                bag.put(job[1], currentProfit);
            }
        }
        
        // returning the max profit
        return bag.lastEntry().getValue();
    }
}