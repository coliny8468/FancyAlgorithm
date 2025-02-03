// https://www.google.com/search?q=1085+%EC%9E%90%EB%B0%94&oq=1085+wkqk&gs_lcrp=EgZjaHJvbWUqCAgBEAAYDRgeMgYIABBFGDkyCAgBEAAYDRgeMgcIAhAAGO8FMgoIAxAAGIAEGKIEMgoIBBAAGIAEGKIEMgoIBRAAGIAEGKIE0gEIMzc2NmowajeoAgCwAgA&sourceid=chrome&ie=UTF-8
// 1085: 직사각형에서 탈출

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x= Integer.parseInt(st.nextToken());
        int y= Integer.parseInt(st.nextToken());
        int w= Integer.parseInt(st.nextToken());
        int h= Integer.parseInt(st.nextToken());

        int xMin= Math.min(x, w - x);
        int yMin= Math.min(y, h - y);

        System.out.println(Math.min(xMin, yMin));
    }
}
