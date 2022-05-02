import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'quartiles' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int median(List<Integer> arr) {
    int result =0 ;
    int length=arr.size();
    System.out.println(arr);
    if(length%2==0)
    {
       result=(  arr.get((length/2))+arr.get((length/2)-1)  )/2;
    }
    else{
        result=arr.get(length/2);
        }
        
    return result;
    }

    public static List<Integer> quartiles(List<Integer> arr) {
    // Write your code here
    int q1=0;
    int q2=0;
    int q3=0;
    List<Integer> finalList = new ArrayList<Integer>();
   
    int length=arr.size();
    Collections.sort(arr);
    List<Integer> q1A = new ArrayList<Integer>();
    List<Integer> q3A = new ArrayList<Integer>();
    if(length%2==0){
    q1A=arr.subList(0, length/2);
    q3A = arr.subList(length/2, length);
    }
    else
    {
    q1A=arr.subList(0, length/2);
    q3A = arr.subList(length/2+1, length);
    }
    q2= median(arr);
    q1 =median(q1A);
    q3=median(q3A);

    finalList.add(q1);
    finalList.add(q2);
    finalList.add(q3);
    return finalList;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> res = Result.quartiles(data);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
