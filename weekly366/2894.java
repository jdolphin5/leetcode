class Solution {
    public int differenceOfSums(int n, int m) {
        int a = 0;
        int b = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                b += i;
            }
            else {
                a += i;
            }
        }
        
        return a-b;
    }
}