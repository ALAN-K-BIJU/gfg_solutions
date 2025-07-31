class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        int n = intervals.length;
        if (n < k) return -1;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = n - 1; i >= 0; i--) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            pq.offer(start);
            while (!pq.isEmpty() && pq.peek() > end) {
                pq.poll();
            }
            if (pq.size() >= k) {
                return end;
            }
        }
        return -1;
    }
}