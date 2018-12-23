
class Submission {
    public int maxWidthRamp(int[] A) {
        int size = A.length;
        int max = 0;

        for(int i = 0; i < size; i++){
            if( (size - 1 - i) <= max )
                break;

            for(int j = size - 1; j > i; j--){
                int width = j - i;

                if(width <= max) break;

                if(A[i] <= A[j] && width > max){
                    max = width;
                    break;
                }
            }
        }
        return max;
    }
}