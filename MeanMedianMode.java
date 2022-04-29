import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[]args) {
        
         Scanner scan = new Scanner(System.in);
         int length =scan.nextInt();
         String []list = new String[length];
         for(int i=0;i<length;i++){
             list[i]=scan.next();
         }
         
         
        ArrayList<Integer> arr = new ArrayList<Integer>();
        float mean =0;
        float median=0;
        int max=0;
        int mode=0;
        
        //mean implementation
        for (String i : list) {
            int temp = Integer.parseInt(i);
            arr.add(temp);
            mean+= temp;
        }mean= mean/list.length;
        
        //median implementation
        Collections.sort(arr);
        if(list.length%2==0)
        {
            median = (float)(arr.get((list.length/2))+ arr.get((list.length/2)-1))/2;
        }
        else
        {median = arr.get(list.length/2);}
        
        //mode implementation
        for (Integer integer : arr) {            
            int temp=Collections.frequency(arr,integer);
            if(max < temp) {max=temp;mode=integer;}
        }
        
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
    }
}
