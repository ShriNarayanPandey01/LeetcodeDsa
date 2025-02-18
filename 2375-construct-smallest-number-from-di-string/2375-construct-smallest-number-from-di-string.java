class Solution {
    public String smallestNumber(String pattern) {
        return help(pattern, 0, -1, new int[10], -1);
    }

    public String help(String p, int ind, int prev, int[] map, int flag) {
        if (ind > p.length()) {
            return "";
        }

        for (int i = 1; i <= 9; i++) {
            if (map[i] == 1) continue;

            if (prev == -1 || (flag == 1 && i < prev) || (flag == 0 && i > prev)) {
                map[i] = 1;
                int newF = (ind < p.length() && p.charAt(ind) == 'D') ? 1 : 0;
                String next = help(p, ind + 1, i, map, newF);
                // if(prev == 5 && ind == 4)System.out.println(next);
                map[i] = 0;

                if (next != null) {
                    return i + next;
                }
            }
        }
        return null;
    }
}
