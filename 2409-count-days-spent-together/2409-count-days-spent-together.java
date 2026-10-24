class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        int aa = 0, la = 0, ab = 0, lb = 0;

        for(int i = 0; i < 5; i++) {
            char a = arriveAlice.charAt(i);
            char b = leaveAlice.charAt(i);
            char c = arriveBob.charAt(i);
            char d = leaveBob.charAt(i);

            if(i == 0 || i == 1) {
                aa = aa * 10 + (a - '0');
                la = la * 10 + (b - '0');
                ab = ab * 10 + (c - '0');
                lb = lb * 10 + (d - '0');
            } else if(i == 3 || i == 4) {
                aa = aa * 10 + (a - '0');
                la = la * 10 + (b - '0');
                ab = ab * 10 + (c - '0');
                lb = lb * 10 + (d - '0');
            }
        }

        int start = Math.max(
            Integer.parseInt(arriveAlice.substring(0, 2)) * 100 +
            Integer.parseInt(arriveAlice.substring(3, 5)),
            Integer.parseInt(arriveBob.substring(0, 2)) * 100 +
            Integer.parseInt(arriveBob.substring(3, 5))
        );

        int end = Math.min(
            Integer.parseInt(leaveAlice.substring(0, 2)) * 100 +
            Integer.parseInt(leaveAlice.substring(3, 5)),
            Integer.parseInt(leaveBob.substring(0, 2)) * 100 +
            Integer.parseInt(leaveBob.substring(3, 5))
        );

        if(start > end) return 0;

        int count = 0;
        for(int m = 1; m <= 12; m++) {
            for(int d = 1; d <= days[m - 1]; d++) {
                int date = m * 100 + d;
                if(date >= start && date <= end) count++;
            }
        }

        return count;
    }
}