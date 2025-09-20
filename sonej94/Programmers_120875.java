class Solution {
    public int solution(int[][] dots) {
        if (isParallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        if (isParallel(dots[0], dots[2], dots[1], dots[3])) return 1;
        if (isParallel(dots[0], dots[3], dots[1], dots[2])) return 1;
        
        return 0;
    }
    
    // 평행 (yb-ya)*(xd-xc) == (yd-yc)*(xb-xa) 
    private boolean isParallel(int[] a, int[] b, int[] c, int[] d) {
        long dx1 = b[0] - a[0];
        long dy1 = b[1] - a[1];
        long dx2 = d[0] - c[0];
        long dy2 = d[1] - c[1];
        return dy1 * dx2 == dy2 * dx1;
    }
}
