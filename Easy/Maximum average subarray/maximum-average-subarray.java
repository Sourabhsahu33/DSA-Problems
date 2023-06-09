//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxAverage(arr, n, k);
            for(int i=ans; i<ans+k; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
        }
    }
}

// } Driver Code End
//User function Template for Java

class Solution {
    int findMaxAverage(int[] arr, int n, int k) {

        if(k>n) return -1;
        int [] sum = new int[n];
        sum[0] = arr[0];
        for(int i=1; i<n; i++)
        sum[i] = sum[i-1]+arr[i];
        int max_sum = sum[k-1], max_end= k-1;
        for(int i=k; i<n; i++){
            int curr_sum = sum[i] - sum[i-k];
            if(curr_sum> max_sum){
                max_sum = curr_sum;
                max_end = i;
            }
        }
        return max_end-k +1;
    }
}
