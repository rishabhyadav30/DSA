class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        
        Set<String> seen = new HashSet<>();

        q.offer(s);
        seen.add(s);

        boolean found = false;

        while (!q.isEmpty()) {
            String str = q.poll();

            if (isValid(str)) {
                ans.add(str);
                found = true;
            }
            if (found) {
                continue;
            }

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                    continue;
                }
                String next = str.substring(0, i) + str.substring(i + 1);

                if(seen.add(next)) {
                    q.offer(next);
                }
            }
        }

        return ans;
    }

    private boolean isValid(String s) {
        int count= 0;

        for (char c: s.toCharArray()) {
            if (c=='(') {
                count++;
            } else if(c ==')') {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}