package Movie;

import java.util.Arrays;

public class Algorithms {
    public Algorithms() { }

    //count sort to sort movie in order of borrowing frequent
    public Movie[] countSort(Movie[] array){
        int arrayLength = array.length;
        Movie[] sortedArray = new Movie[arrayLength];
        int range = array[0].getBorrowedTime();
        //find the max range of the elements
        for(int i = 0; i < arrayLength; i++){
            if(range < array[i].getBorrowedTime()){
                range = array[i].getBorrowedTime();
            }
        }
        int[] count = new int[range + 1] ;

        //count the occurs of a single element
        for(int i = 0; i < arrayLength; i++){
            count[array[i].getBorrowedTime()]++;
        }

        //find the start index of a specific element
        for(int i = 1; i <= range; i++){
            count[i] = count[i] + count[i-1];
        }

        //arrange a specific element to the acceding order
        for(int i = arrayLength - 1; i>=0; i-- ){
            sortedArray[--count[array[i].getBorrowedTime()]] = array[i];
        }
        return sortedArray;
    }

}
