class Solution {


    public double myPow(double x, int n) {
        if (n >= 0) return myPow1(x, n);
        else return 1 / myPow1(x, -n);
    }

    public double myPow1(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double v = myPow(x, n / 2);
        return n % 2 == 1 ? x * v * v : v * v;
    }

    //findDuplicateSubtrees
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2, -2147483648));
    }

}

