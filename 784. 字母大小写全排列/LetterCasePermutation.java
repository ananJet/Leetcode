import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new LinkedList<>();
        this.bt(res, S, 0);
        return res;
    }

//    res是结果列表，字符串S是上一次修改的字符串，index是当前要开始搜索修改的字符位置索引
    public void bt(List<String> res, String S, int index) {
        if (index == S.length()) {
            res.add(S);
            return;
        }
        int next_index = index + 1;
        this.bt(res, S, next_index);
        char c = S.charAt(index);
        StringBuilder s = new StringBuilder(S);
        if (c >= 'a' && c <= 'z') {
            s.setCharAt(index, (char) (c - 'a' + 'A'));
            this.bt(res, s.toString(), next_index);
        }else if (c >= 'A' && c <= 'Z'){
            s.setCharAt(index, (char) (c - 'A' + 'a'));
            this.bt(res, s.toString(), next_index);
        }
    }

    public static void main(String[] args) {
        String S = "a1b1";
        System.out.println(new LetterCasePermutation().letterCasePermutation(S));
    }

}
