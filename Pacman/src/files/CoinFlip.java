package files;
import java.awt.List;
import java.util.ArrayList;
import java.math.*;

public class CoinFlip {

	public static void main(String[] args) {
		
		ArrayList<Integer> temp = new ArrayList<>();
		
		temp.add(5);
		temp.add(9);
		temp.add(2);
		temp.add(2);
		int m = CoinGameValue(temp);
		System.out.print(m);
		
	}
	

    public static int CoinGameValue(ArrayList<Integer> V) {
    // Determine the maximum payoff of the given array of coins V for the first player
        int[][] memo = new int[V.size()][V.size()];
        for (int i = 0; i <V.size(); i++){
            for (int j =0; j < V.size();j++) {
            	if (i == j) {
            		memo[i][j] = V.get(i);
            		System.out.printf("loop number %-4d %-4d, number stored %-4d\n", i ,j , V.get(i));
            	}
            	if (Math.abs(i-j) == 1) {
            		int max = Math.max(V.get(i), V.get(j));
            		memo[i][j] = max;
            		memo[j][i] = max;
            	}
            	
            }
        }
        

        //memo[i] = max(V[i]+ min(memo[i+2][j],memo[i+1][j-1]), V[j] + min(memo[i][j-2],memo[i+1][j-1]));
        for (int i = 2; i< V.size();i++){
          for (int j = 0; j<V.size()-i ; j++){
                int mem = Math.max(V.get(j)+ Math.min(memo[j+2][j+i],memo[j+1][j+i-1]), V.get(j+i) + Math.min(memo[j][j+i-2],memo[j+1][j+i-1])); 
                memo[j][j+i]=mem;
                memo[j+i][j]=mem;
          }
    }
        
        for (int i = 0; i <V.size(); i++){
            for (int j = 0; j <V.size(); j++){
                System.out.print(memo[i][j] + "    ");
            }
           System.out.println();
       }
      
        
        return memo[0][V.size()-1];
}
    
    
    
	
	
}
