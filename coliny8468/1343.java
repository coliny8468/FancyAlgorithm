import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        ArrayList<String> parts = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append(a.charAt(0));

        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i - 1) == a.charAt(i)) {
                sb.append(a.charAt(i));
            } else {
                parts.add(sb.toString());
                sb = new StringBuilder();
                sb.append(a.charAt(i));
            }
        }
        parts.add(sb.toString());

        StringBuilder ans = new StringBuilder();
        boolean hasAns = true;

        for (int i = 0; i < parts.size() ; i++) {
            if (parts.get(i).charAt(0) == 'X') {
                if (parts.get(i).length() % 2 == 0) {
                    int x = parts.get(i).length() / 4;
                    for (int j = 0; j < x; j++) {
                        ans.append("AAAA");
                    }
                    if (parts.get(i).length() % 4 != 0) {
                        ans.append("BB");
                    }
                }else{
                    hasAns = false;
                    break;
                }
            }else{
                ans.append(parts.get(i));
            }

        }

        if (hasAns) {
            System.out.println(ans);
        }else{
            System.out.println(-1);
        }


    }

}
