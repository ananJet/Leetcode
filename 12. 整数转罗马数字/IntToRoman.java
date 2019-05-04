import java.util.HashMap;

public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        char[] record = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        int factor = 0;
        while (num > 0) {
            int a = num % 10;
            if (a > 0) {
                if (a < 4) {
                    for (int i = 0; i < a; i++) {
                        res.insert(0, record[factor * 2]);
                    }
                }else if (a == 4) {
                    res.insert(0, record[factor * 2 + 1]);
                    res.insert(0, record[factor * 2]);
                }else if (a < 9) {
                    int t = a - 5;
                    for (int i = 0; i < t; i++) {
                        res.insert(0, record[factor * 2]);
                    }
                    res.insert(0, record[factor * 2 + 1]);
                }else {
                    res.insert(0, record[factor * 2 + 2]);
                    res.insert(0, record[factor * 2]);
                }
            }
            num /= 10;
            factor++;
        }
        return String.valueOf(res);
    }
}
