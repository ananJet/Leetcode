import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 1)
            return 1;
        int[] res = new int[ratings.length];
        if (ratings[0] <= ratings[1])
            res[0] = 1;
        if (ratings[ratings.length - 1] <= ratings[ratings.length - 2])
            res[ratings.length - 1] = 1;
        for (int i = 1; i < ratings.length - 1; i++) {
//            �ж��ǲ��ǹȵ�
            if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1])
                res[i] = 1;
        }
//        �ҵ���һ���ȵ�
        int first_vally = 0;
        if (res[0] != 1) {
            for (int i = 0; i < ratings.length; i++) {
                if (res[i] == 1) {
                    first_vally = i;
                    break;
                }
            }
            int begin = 1;
            for (int i = first_vally - 1; i >= 0; i--) {
                res[i] = ++begin;
            }
        }
//        �ҵ����һ���ȵ�
        int final_vally = ratings.length - 1;
        if (res[ratings.length - 1] != 1) {
            for (int i = ratings.length - 1; i >= 0; i--) {
                if (res[i] == 1) {
                    final_vally = i;
                    break;
                }
            }
            int begin = 1;
            for (int i = final_vally + 1; i < ratings.length; i++) {
                res[i] = ++begin;
            }
        }
//        �ӵ�һ���ȵ׿�ʼ�ҵ����һ���ȵ�
        int left = first_vally;
        int right = final_vally;
        for (int i = first_vally + 1; i <= final_vally; i++) {
            if (res[i] == 1) {
                right = i;
                for (int j = left + 1; j < right; j++) {
                    if (ratings[j] >= ratings[j + 1]) {
                        break;
                    }
                    if (ratings[j] > ratings[j - 1])
                        res[j] = res[j - 1] + 1;

                }
                for (int j = right - 1; j > left; j--) {
                    if (ratings[j] >= ratings[j - 1]) {
                        break;
                    }
                    if (ratings[j] > ratings[j + 1])
                        res[j] = res[j + 1] + 1;

                }
//                ʣ�·嶥û���
                if (!(left == right - 1)) {
                    int left0 = -1;
                    int right0 = -1;
                    for (int j = left; j < right; j++) {
                        if (res[j] != 0 && res[j + 1] == 0)
                            left0 = j;
                        if (res[j] == 0 && res[j + 1] != 0)
                            right0 = j + 1;
                    }
                    if (right0 - left0 == 2) {
                        res[left0 + 1] = Math.max(res[left0], res[right0]) + 1;
                    }else {
                        res[left0 + 1] = res[left0] + 1;
                        res[right0 - 1] = res[right0] + 1;
                    }

                }
                left = i;
            }
        }

//        ͳ�ƽ��
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Candy().candy(new int[]{1,2,87,87,87,2,1}));
    }

}
