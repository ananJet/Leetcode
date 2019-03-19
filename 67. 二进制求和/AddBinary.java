public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        String res = "";
        boolean flag = false; //标志进位，true为需要进位
        while (true) {
            if (i >= 0 && j >= 0) {
                char ac = a.charAt(i);
                char bc = b.charAt(j);
                if (ac == '1' && bc == '1' && flag) {
                    flag = true;
                    res = "1" + res;
                }else if (ac == '1' && bc == '1' && !flag) {
                    flag = true;
                    res = '0' + res;
                }else if ((ac == '1' || bc == '1') && flag) {
                    flag = true;
                    res = '0' + res;
                }else if ((ac == '1' || bc == '1') && !flag) {
                    flag = false;
                    res = '1' + res;
                }else if (ac == '0' && bc == '0' && flag) {
                    flag = false;
                    res = '1' + res;
                }else if (ac == '0' && bc == '0' && !flag) {
                    flag = false;
                    res = '0' + res;
                }else {
                    System.out.println("---------error----------");
                    System.exit(0);
                }
                i--;
                j--;
            }else if (i >= 0 && j < 0) {
                char ac = a.charAt(i);
                if (ac == '1' && flag) {
                    flag = true;
                    res = '0' + res;
                }else if (ac == '0' && flag) {
                    flag = false;
                    res = '1' + res;
                }else if (ac == '1' && !flag) {
                    flag = false;
                    res = '1' + res;
                }else if (ac == '0' && !flag) {
                    flag = false;
                    res = '0' + res;
                }else {
                    System.out.println("---------error----------");
                    System.exit(0);
                }
                i--;
            }else if (i < 0 && j >= 0) {
                char bc = b.charAt(j);
                if (bc == '1' && flag) {
                    flag = true;
                    res = '0' + res;
                }else if (bc == '0' && flag) {
                    flag = false;
                    res = '1' + res;
                }else if (bc == '1' && !flag) {
                    flag = false;
                    res = '1' + res;
                }else if (bc == '0' && !flag) {
                    flag = false;
                    res = '0' + res;
                }else {
                    System.out.println("---------error----------");
                    System.exit(0);
                }
                j--;
            }else {
                if (flag)
                    res = '1' + res;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1", "111"));
    }
}
