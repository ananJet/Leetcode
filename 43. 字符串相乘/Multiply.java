import java.util.Arrays;
import java.util.Objects;

public class Multiply {
    public String multiply(String num1, String num2) {
        if (Objects.equals(num1, "0") || Objects.equals(num2, "0"))
            return "0";
        String res = "";
        String big = "";
        String small = "";
        if (num1.length() > num2.length()) {
            big = num1;
            small = num2;
        }else {
            big = num2;
            small = num1;
        }

        String[] ss = new String[small.length()];
//        ½øÎ»
        int carry = 0;
//        big * small
        for (int i = small.length() - 1; i >= 0; i--) {
            int ahead = small.charAt(i) - '0';
            ss[i] = "";
//            System.out.println("----------------------");
//            System.out.println(small.charAt(i));
            for (int j = big.length() - 1; j >= 0; j--) {
//                System.out.println(big.charAt(j));
                int behind = big.charAt(j) - '0';
                int temp = ahead * behind;
//                System.out.println(temp);
                int a = (temp + carry) / 10;
                char b = (char) ((temp + carry) % 10 + '0');
//                System.out.println("a:" + a + "\tb:" + b);
                ss[i] = b + ss[i];
//                System.out.println("ss:" + ss[i]);
                carry = a;
            }
            if (carry != 0) {
                ss[i] = (char) (carry + '0') + ss[i];
                carry = 0;
            }
            for (int j = 0; j < small.length() - 1 - i; j++){
                ss[i] += '0';
            }
//            System.exit(0);
        }
//        System.out.println(Arrays.toString(ss));
        int index = 1;
        carry = 0;
        while (true) {
//            System.out.println(index);
            int temp = 0;
            int flag = 0;
            for (int i = 0; i < ss.length; i++) {
                if (index > ss[i].length()) {
                    flag++;
                    continue;
                }
                temp += ss[i].charAt(ss[i].length() - index) - '0';
            }
            if (flag == ss.length)
                break;
            int a = (temp + carry) / 10;
            char b = (char) ((temp + carry) % 10 + '0');
            res = b + res;
            index++;
            carry = a;
        }
        if (carry != 0) {
            res = (char) (carry + '0') + res;
            carry = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Multiply().multiply("9133", "0"));
    }
}
