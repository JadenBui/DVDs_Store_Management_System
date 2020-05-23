package Movie;

public class MergeSort {
    public MergeSort() {
    }

    public Movie[] mergeSort(Movie[] array){

        if(array.length <= 1){
            return array;
        }

        int midPoint = array.length / 2;
        Movie[] left = new Movie[midPoint];
        Movie[] right;
        if(array.length % 2 == 0){
            right = new Movie[midPoint];
        }else{
            right = new Movie[midPoint + 1];
        }

        for(int i = 0; i < midPoint; i++){
            left[i] = array[i];
        }
        for(int i = 0; i < right.length; i++){
            right[i] = array[midPoint + i];
        }

        Movie[] res;

        left = mergeSort(left);
        right = mergeSort(right);
        res = merge(left,right);

        return res;
    }

    public Movie[] merge(Movie[] left, Movie[] right){
        Movie[] result = new Movie[left.length + right.length];
        int pointerLeft = 0;
        int pointerRight = 0;
        int pointerRes = 0;
        while (pointerLeft < left.length || pointerRight < right.length ){
            if(pointerLeft < left.length && pointerRight < right.length){
                if(left[pointerLeft].getBorrowedTime() < right[pointerRight].getBorrowedTime()){
                    result[pointerRes++] = left[pointerLeft++];
                }else{
                    result[pointerRes++] = right[pointerRight++];
                }
            }else if (pointerLeft < left.length){
                result[pointerRes++] = left[pointerLeft++];
            }else{
                result[pointerRes++] = right[pointerRight++];
            }
        }
        return result;
    }
}
