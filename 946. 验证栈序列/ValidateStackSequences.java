import java.util.Arrays;
import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        boolean[] isValid = new boolean[pushed.length];
        int last = 0;
        for (int i = 0; i < popped.length; i++) {
            if (!isValid[i]) {
//              对每一个pop出来数字找它在原数组的位置poi
                isValid[i] = true;
                int poi = -1;
                for (int j = last; j < pushed.length; j++) {
                    if (pushed[j] == popped[i]) {
                        poi = j;
                        break;
                    }
                }
                int temp = i + 1;
                for (int j = poi - 1; j >= last; j--) {
                    boolean flag = false;
                    for (int k = temp; k < popped.length; k++) {
                        if (pushed[j] == popped[k]) {
                            temp = k;
                            flag = true;
                            isValid[k] = true;
                            break;
                        }
                    }
                    if (!flag)
                        return false;
                }
                last = poi + 1;
            }
        }
        return true;
    }

    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        boolean[] isValid = new boolean[pushed.length];
        int i = 0;
        while (i < popped.length) {
            int poi = -1;
            for (int j = 0; j < pushed.length; j++) {
                if (pushed[j] == popped[i]) {
                    poi = j;
                    break;
                }
            }
            if (poi == -1)
                return false;
            boolean fa = false;
            for (int j = poi + 1; j < pushed.length; j++) {
                if (isValid[j]) {
                    fa = true;
                    break;
                }
            }
            i++;
            if (fa)
                continue;
            isValid[poi] = true;
            System.out.println(poi);

            if (poi == pushed.length - 1)
                break;

            while (i < popped.length && poi > 0) {
                if (popped[i] == pushed[poi - 1]) {
                    i++;
                    poi--;
                    isValid[poi] = true;
                }else
                    break;
            }
            System.out.println(Arrays.toString(isValid));
        }
        int temp = popped.length - 1;
        System.out.println(Arrays.toString(isValid));
        for (int j = 0; j < pushed.length; j++) {
            if (!isValid[j]) {
                boolean flag = false;
                for (int k = temp; k >= 0; k--) {
                    if (popped[k] == pushed[j]) {
                        flag = true;
                        temp = k - 1;
                        break;
                    }
                }
                if (!flag)
                    return false;
            }
        }
        return true;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0)
            return true;
        Stack<Integer> stack = new Stack<>();
        int push_index = 0;
        int pop_index = 0;
        stack.push(pushed[push_index]);
        while (!(stack.isEmpty() && push_index == pushed.length - 1)) {
            if (stack.isEmpty())
                stack.push(pushed[++push_index]);
            if (stack.peek() != popped[pop_index]) {
                if (push_index < pushed.length - 1) {
                    stack.push(pushed[++push_index]);
                }else {
                    return false;
                }
            }else {
                stack.pop();
                pop_index++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidateStackSequences().validateStackSequences(new int[]{4,0,1,2,3}, new int[]{4,2,3,0,1}));
    }
}
