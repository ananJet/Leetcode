public class HasAlternatingBits {

    public boolean hasAlternatingBits(int n) {
//        ��������ת��Ϊ���������Ĺ������ж��Ƿ�����Ϊ���
        int last = -1;
        while (n > 0) {
            int a = n % 2;
            if (a == last)
                return false;
            else
                last = a;
            n /= 2;
        }
        return true;
    }
}
