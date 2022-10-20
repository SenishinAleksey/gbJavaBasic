public class Homework2 {
    /**
     * https://leetcode.com/problems/powx-n/
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1 || x == 0 || x == 1) return x;
        if (n < 0) {
            return 1 / (myPow(x, -(n + 1)) * x);
        }
        double half = myPow(x, n / 2);
        double result = half * half;
        if (n % 2 == 1) {
            result *= x;
        }
        return result;
    }

    /**
     * https://leetcode.com/problems/climbing-stairs/
     */
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return climbStairs(n, cache);
    }

    private int climbStairs(int n, int[] cache) {
        if (n <= 1) {
            cache[n] = 1;
        }
        if (cache[n] == 0) {
            cache[n] = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
        }
        return cache[n];
    }

    /**
     * https://leetcode.com/problems/max-area-of-island/
     */
    public int maxAreaOfIsland(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int area = 0;
                if (grid[i][j] == 1) {
                    area = getArea(grid, i, j);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private int getArea(int[][] grid, int i, int j) {
        int area = 1;
        grid[i][j] = 0;
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            area += getArea(grid, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            area += getArea(grid, i - 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            area += getArea(grid, i, j - 1);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            area += getArea(grid, i, j + 1);
        }
        return area;
    }
}
