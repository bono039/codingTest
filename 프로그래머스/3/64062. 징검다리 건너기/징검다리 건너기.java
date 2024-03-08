class Solution {
    static int[] stones;
    static int k;

    public int solution(int[] stones, int k) {
        this.stones = stones;
        this.k = k;

        int answer = 0;

        // 이진 탐색으로 최대 인원을 찾음
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(mid)) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static boolean canCross(int num) {
        int count = 0; // 연속으로 0이 되는 횟수
        for (int stone : stones) {
            if (stone - num < 0) {
                count++;
                if (count >= k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        return true;
    }
}
