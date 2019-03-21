public class ValidPalindrome {
    public boolean validPalindrome1(String s) {
        char[] cs = s.toCharArray();
        int i = 0;
        int j = cs.length - 1;
        boolean flag = false;
        while (i < j) {
//            System.out.println(cs[i] + "\t" + cs[j]);
            if (cs[i] == cs[j]) {
                i++;
                j--;
            }else if (cs[i] != cs[j]) {
                if (!flag) {
                    if (cs[i + 1] == cs[j]) {
                        flag = true;
                        i += 2;
                        j--;
                    }else if (cs[i] == cs[j - 1]){
                        flag = true;
                        i++;
                        j -= 2;
                    }else {
                        return false;
                    }
                }else
                    return false;
            }
        }
        return true;
    }

    public boolean flag = true;

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }else {
                if (this.flag) {
                    this.flag = false;
                    return this.validPalindrome(s.substring(i + 1, j + 1)) || this.validPalindrome(s.substring(i, j));
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println("abcde".substring(0,3));
        System.out.println(new ValidPalindrome().validPalindrome("abcb"));
    }
}
