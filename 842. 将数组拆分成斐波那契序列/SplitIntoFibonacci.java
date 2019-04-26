import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SplitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new LinkedList<>();
        int len = S.length();
        if (len < 3)
            return res;
//        先裁出前2个数
        for (int i = 1; i < len; i++) {
            String a_temp = S.substring(0, i);
            if (!this.isVaild(a_temp)) {
                break;
            }
            int a = Integer.parseInt(a_temp);
            for (int j = i; j < len; j++) {
                if (j + 1 - i > len - j - 1)
                    break;
                String b_temp = S.substring(i, j + 1);
                if (!this.isVaild(b_temp)) {
                    break;
                }
                int b = Integer.parseInt(b_temp);
                res.add(a);
                res.add(b);
                if (this.dg(a, b, res, S.substring(j + 1, len)))
                    return res;
                res.remove(0);
                res.remove(0);

            }
        }
        return res;
    }

    public boolean dg(int a, int b, List<Integer> res, String s) {
//        System.out.println(res);
        if (Objects.equals(s, "")) {
            return true;
        }
        int last_sum = a + b;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String t_temp = s.substring(0, i + 1);
//            System.out.println(t_temp);
            if (!this.isVaild(t_temp)) {
                return false;
            }
//            System.out.println(t_temp);
            int t = Integer.parseInt(t_temp);
            if (t < last_sum)
                continue;
            else if (t > last_sum)
                return false;
            else {
                res.add(t);
                if (this.dg(b, t, res, s.substring(i + 1, len))) {
                    return true;
                }
                res.remove(res.size() - 1);
            }

        }
        return false;
    }

    public boolean isVaild(String t) {
        if (t.charAt(0) == '0' && t.length() != 1)
            return false;
        String max = "2147483647";
        if (t.length() > max.length())
            return false;
        if (t.length() == max.length()) {
            for (int i = 0; i < t.length(); i++) {
                char a1 = t.charAt(i);
                char a2 = max.charAt(i);
                if (a1 == a2)
                    continue;
                if (a1 < a2)
                    return true;
                if (a1 > a2)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SplitIntoFibonacci().splitIntoFibonacci("417420815174208193484163452262453871040871393665402264706273658371675923077949581449611550452755"));
        System.out.println("155045275".length());
        System.out.println("2147483647".length());
    }
}
