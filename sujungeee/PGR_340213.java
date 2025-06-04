// https://school.programmers.co.kr/learn/courses/30/lessons/340213

/**
 * 340213: 동영상 재생기
 * # summary
 * : commands로 영상이 끝나는 시간을 return
 * # logic
 * 1. command에 따라 시간 계산(초로 변환)
 * 2. 10초 후로 이동 -> 갱신 시간이 전체 비디오 시간을 넘었을 때
 *    10초 전으로 이동 -> 갱신 시간이 0분 0초 미만일 때
 * 3. 오프닝 시간일 때 -> 오프닝 끝으로 이동
 */

class Solution340213 {
    static int totalMinutes, totalSeconds; // 전체 비디오 시간
    static int posMinutes, posSeconds; // 현재 시간
    static int opsMinutes, opsSeconds; // 오프닝 시작 시간
    static int opeMinutes, opeSeconds; // 오프닝 엔딩 시간

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        totalMinutes = Integer.parseInt(video_len.substring(0, 2));
        totalSeconds = totalMinutes * 60 + Integer.parseInt(video_len.substring(3));
        posMinutes = Integer.parseInt(pos.substring(0, 2));
        posSeconds = posMinutes * 60 + Integer.parseInt(pos.substring(3));
        opsMinutes = Integer.parseInt(op_start.substring(0, 2));
        opsSeconds = opsMinutes * 60 + Integer.parseInt(op_start.substring(3));
        opeMinutes = Integer.parseInt(op_end.substring(0, 2));
        opeSeconds = opeMinutes * 60 + Integer.parseInt(op_end.substring(3));

        opening();
        for (String command: commands) {
            calculate(command);
        }

        return String.format("%02d:%02d", posSeconds / 60, posSeconds % 60);
    }

    public void calculate(String command) {
        if (command.equals("next")) { // 1
            posSeconds += 10;
            over();
        } else { // 1
            posSeconds -= 10;
            under();
        }
        opening();
    }

    // 2-1
    public void over() {
        int remaining = totalSeconds - posSeconds;

        if (remaining < 10 || totalSeconds < posSeconds) {
            posSeconds = totalSeconds;
        }
    }

    // 2-2
    public void under() {
        if (posSeconds < 10) {
            posSeconds = 0;
        }
    }

    // 3
    public void opening() {
        if (posSeconds >= opsSeconds && posSeconds <= opeSeconds) {
            posSeconds = opeSeconds;
        }
    }
}

public class PGR_340213 {
    public static void main(String[] args) {
        Solution340213 s = new Solution340213();
        System.out.println(s.solution("34:33", "13:00", "00:55", "02:55", new String[] {"next", "prev"}));
        System.out.println(s.solution("10:55", "00:05", "00:15", "06:55", new String[] {"prev", "next", "next"}));
        System.out.println(s.solution("07:22", "04:05", "00:15", "04:07", new String[] {"next"}));
    }
}