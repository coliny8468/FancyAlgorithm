import java.util.*;

public class Main {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int n = sc.nextInt();
		
		while(n != 0) {
			cnt++;
			int[][] map = new int[n][n];
			int[][] minus = new int[n][n];
			int dirX[] = {1,-1,0,0};
			int dirY[] = {0,0,1,-1};

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					minus[i][j] = Integer.MAX_VALUE;
				}
			}           
			
			Queue<int[]>q = new ArrayDeque<int[]>();
			q.add(new int[]{0,0});
			minus[0][0] = map[0][0];
			while(!q.isEmpty()){
				int[] now = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nX = now[0] + dirX[i];
					int nY = now[1] + dirY[i];
					
					if(nX>=0 && nX<n &&nY>=0 && nY<n 
							&& minus[now[0]][now[1]] + map[nX][nY] < minus[nX][nY]) {
						q.add(new int[] {nX, nY});
						minus[nX][nY] = minus[now[0]][now[1]] + map[nX][nY];
					}
				}
				
				
			}
			
			System.out.println("Problem"+ " "+ cnt+": " + minus[n-1][n-1]);
			n = sc.nextInt();
	
		}
		}
		
	}
