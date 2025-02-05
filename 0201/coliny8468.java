
import java.util.*;

public class Main {

    static class Room implements Comparable<Room> {
        int roomNum, roomWidth;

        public Room(int roomNum, int roomWidth) {
            this.roomNum = roomNum;
            this.roomWidth = roomWidth;
        }

        @Override
        public int compareTo(Room other) {
            return Integer.compare(this.roomWidth, other.roomWidth);
        }

    }

    static class SumRoom implements Comparable<SumRoom> {
        int sum, room1, room2;

        public SumRoom(int sum, int room1, int room2) {
            this.sum = sum;
            this.room1 = room1;
            this.room2 = room2;
        }

        @Override
        public int compareTo(SumRoom other) {
            return Integer.compare(other.sum, this.sum);
        }
    }

    static int n, m;
    static int[][] map;
    static int[][] mapV;
    static int roomNum = 0;
    static List<Room> rooms = new ArrayList<>();
    static List<SumRoom> sums = new ArrayList<>();
    //wallDir = {1,2,4,8};
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[n][m];
        mapV = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mapV[i][j] == 0) {
                    roomNum++;
                    findRoom(i, j);
                }

            }
        }

        for (int i = 0; i < rooms.size() - 1; i++) {
            for (int j = i + 1; j < rooms.size(); j++) {
                sums.add(new SumRoom(rooms.get(i).roomWidth + rooms.get(j).roomWidth
                        , rooms.get(i).roomNum, rooms.get(j).roomNum));
            }
        }


        Collections.sort(rooms);
        System.out.println(rooms.size());
        System.out.println(rooms.get(rooms.size()-1).roomWidth);

        Collections.sort(sums);
        findMaxSumRoom();

    }


    static void findRoom(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        mapV[x][y] = roomNum;
        int width = 1;
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int now[] = q.poll();
            for (int i = 0; i < 4; i++) {
                if ((map[now[0]][now[1]] & (1 << i)) == 0) {
                    int nx = now[0] + dir[i][0];
                    int ny = now[1] + dir[i][1];

                    if (ny >= 0 && nx >= 0 && nx < n && ny < m && mapV[nx][ny]==0) {
                        q.add(new int[]{nx, ny});
                        mapV[nx][ny] = roomNum;
                        width++;
                    }
                }
            }
        }
        rooms.add(new Room(roomNum, width));
    }

    private static void findMaxSumRoom() {

        for (int i = 0; i < sums.size(); i++) {
            SumRoom a = sums.get(i);
            int v[][] = new int[n][m];
            Queue<int[]> q = new ArrayDeque<>();

            loop:
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (mapV[j][k] == a.room1) {
                        q.add(new int[]{j, k});
                        break loop;
                    }
                }
            }

            while (!q.isEmpty()) {
                int now[] = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dir[j][0];
                    int ny = now[1] + dir[j][1];

                    if (ny >= 0 && nx >= 0 && nx < n && ny < m && v[nx][ny] == 0 && mapV[nx][ny] == a.room2) {
                        System.out.println(a.sum);
                        return;
                    }
                    if (ny >= 0 && nx >= 0 && nx < n && ny < m && v[nx][ny] == 0 && mapV[nx][ny] == a.room1) {
                        q.add(new int[]{nx, ny});
                        v[nx][ny] = -1;
                    }
                }

            }

        }
    }
    
}
