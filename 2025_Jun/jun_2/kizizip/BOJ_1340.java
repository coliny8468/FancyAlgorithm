import java.util.Scanner;

public class BOJ_1340 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String[] parts = input.split(" ");
        String monthName = parts[0];
        int day = Integer.parseInt(parts[1].substring(0, parts[1].length() - 1));
        int year = Integer.parseInt(parts[2]);
        String[] time = parts[3].split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        int month = 0;
        for (int i = 0; i < 12; i++) {
            if (months[i].equals(monthName)) {
                month = i + 1;
                break;
            }
        }

        // 윤년 확인
        boolean febCheck = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if (febCheck) {
            daysInMonth[1] = 29; 
        }

        // 올해 총 일수 계산 (윤년 반영해서)
        int totalDays = febCheck ? 366 : 365;

        // 현재까지 지난 분 수 계산
        long passedMinutes = 0;

        // 지난 달들의 분 수 ++
        for (int i = 0; i < month - 1; i++) {
            passedMinutes += daysInMonth[i] * 24 * 60;
        }

        // 이번 달 중 지난 일들의 분 수 ++
        passedMinutes += (day - 1) * 24 * 60;

        // 오늘 중 지난 시간의 분 수 ++
        passedMinutes += hour * 60 + minute;

        // 올해 총 분 수
        long totalMinutes = totalDays * 24L * 60L;

        double answer = (double) passedMinutes / totalMinutes * 100.0;

        System.out.println(answer);
    }
}
