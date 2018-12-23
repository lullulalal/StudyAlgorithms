import java.util.Arrays;
import java.util.Comparator;

class Compare implements Comparator<Integer> {
    int[] A;

    Compare(int[] A){
        this.A = A;
    }

    public int compare(Integer first, Integer second){
        int fv = A[first.intValue()];
        int sv = A[second.intValue()];

        return fv - sv;
    }
}

class Solution {
    public int maxWidthRamp(int[] A) {
        int size = A.length;

        Integer[] IA = new Integer[size];
        for(int i = 0; i < size; ++i){
            IA[i] = i;
        }
        Arrays.sort(IA, new Compare(A));

        int max = 0;
        int min = size;
        for(int i : IA){
            max = Math.max(max, i - min);
            min = Math.min(min, i);
        }

        return max;
    }
}