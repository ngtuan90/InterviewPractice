package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int kthGrammar(int N, int K) {
        // Construct the array base on N
        int[] nextArray = getNextArray(new int[]{0,1}, N);
        return (int) nextArray[K-1];
    }
    
    public int[] getNextArray(int[] currentArray, int N){
        int length = currentArray.length * 2;
        int [] nextArray;      
        do {            
            nextArray = new int[currentArray.length * 2];        
            for (int i = 0 ; i < currentArray.length; i ++){
                int j = nextArray.length -1 - i;
                nextArray[i] = currentArray[i];
                nextArray[j] = currentArray[i];
            }
            
            
            length = nextArray.length;
            currentArray = nextArray;
        }
        while (length <= Math.pow(2, N-1));
        return nextArray;
    }
}

public class KthSymbolGramar {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int N = Integer.parseInt(line);
            line = in.readLine();
            int K = Integer.parseInt(line);
            
            int ret = new Solution().kthGrammar(N, K);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
