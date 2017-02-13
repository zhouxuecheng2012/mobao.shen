package com.mo.bao;

/**
 * Created by hadoop on 2017/2/12.
 */
public class SortMain {

    public static void main(String[] args) {
           
    }

    public void selectSort (int[] a) {
        int n = a.length;
        for (int k=0; k<n-1; k++) {
            int min = k;
            for (int i=k+1; i<n; i++)
                if (a[i]<a[min]) min = i;
            if (k!=min){
                int temp = a[k];
                a[k] = a[min];
                a[min] = temp;
            }//end of if
        }//end of for
    }

}
