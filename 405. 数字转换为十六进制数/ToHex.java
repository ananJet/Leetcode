import java.util.HashMap;

public class ToHex {
    public String toHex1(int num) {
        if (num == -2147483648)
            return "80000000";
        StringBuilder res = new StringBuilder();
        if (num == 0)
            return "0";
        if (num > 0) {
//            十进制的正数转十六进制的方法：不断对数除以16，将每次所得的余数拼接在一起，直到除到0为止
            while (num > 0) {
                res.append(this.get16C(num % 16));
                num /= 16;
            }
//            反转
            int len = res.length() / 2 - 1;
            for (int i = 0; i <= len; i++) {
                char temp = res.charAt(i);
                int index = res.length() - i - 1;
                res.setCharAt(i, res.charAt(index));
                res.setCharAt(index, temp);
            }
        }else {
//            十进制的负数转十六进制的方法：先按十进制正数的方法转为十六进制，然后再求反加1
//            按十进制正数的方法转为十六进制
//            System.out.println(num);
            num = -num;
//            System.out.println(num);
            while (num > 0) {
                res.append(this.get16C(num % 16));
                num /= 16;
            }
//            System.out.println(res);
//            求反
            HashMap<Character, Integer> hashMap = new HashMap<>();
            hashMap.put('0', 0);
            hashMap.put('1', 1);
            hashMap.put('2', 2);
            hashMap.put('3', 3);
            hashMap.put('4', 4);
            hashMap.put('5', 5);
            hashMap.put('6', 6);
            hashMap.put('7', 7);
            hashMap.put('8', 8);
            hashMap.put('9', 9);
            hashMap.put('a', 10);
            hashMap.put('b', 11);
            hashMap.put('c', 12);
            hashMap.put('d', 13);
            hashMap.put('e', 14);
            hashMap.put('f', 15);
            char[] record = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            for (int i = 0; i < res.length(); i++) {
                res.setCharAt(i, record[record.length - hashMap.get(res.charAt(i)) - 1]);
            }
//            System.out.println(res);
            while (res.length() < 8) {
                res.append('f');
            }
//            反转
            int len = res.length() / 2 - 1;
            for (int i = 0; i <= len; i++) {
                char temp = res.charAt(i);
                int index = res.length() - i - 1;
                res.setCharAt(i, res.charAt(index));
                res.setCharAt(index, temp);
            }
//            System.out.println(res);
//            加1
            int i= 7;
            int poi = hashMap.get(res.charAt(i)) + 1;
            if (poi > 15) {
                res.setCharAt(i, '0');
                int go = 1;
                int p = i - 1;
                while (go > 0) {
                    int t = hashMap.get(res.charAt(p)) + go;
                    if (t > 15) {
                        res.setCharAt(p, '0');
                        p--;
                        go = 1;
                    }else {
                        res.setCharAt(p, record[t]);
                        go = 0;
                    }
                }
            }else {
                res.setCharAt(i, record[poi]);
            }
        }
//        System.out.println(res);
        return String.valueOf(res);
    }

    public char get16C(int num) {
        if (num < 10) {
            return (char) (num + '0');
        }else {
            return (char) (num - 10 + 'a');
        }
    }

    public String toHex(int num) {
        if (num == 0)
            return "0";
        char[] record = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder res = new StringBuilder();
        while (num != 0 && res.length() < 8) {
            res.insert(0, record[num & 0xf]);
            num >>= 4;
        }
//        System.out.println(res);
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        ToHex toHex = new ToHex();
        System.out.println(toHex.toHex(-2147483648));
//        System.out.println('1'-'0');
    }
}
