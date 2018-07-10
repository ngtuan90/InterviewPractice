package recursive;

import java.util.ArrayList;
import java.util.List;

public class SolveQueen {

	// Give the list of nxn chessboard -> Find the list of all posible n queen place 
	// that queen cannot attached the other queen
	public static List<List<Integer>> solveQueen(int n)
	{
		List<List<Integer>> results = new ArrayList<>();
		solveQueenHelper(0, n, new ArrayList<Integer>(), results);
		return results;
	}
	
	public static void solveQueenHelper(int currentRow, int n, List<Integer> colPlace, List<List<Integer>> results) {
		if (currentRow == n) {
			results.add(new ArrayList<Integer>(colPlace));
		}
		
		for (int i = 0 ; i < n ; i ++) {
			colPlace.add(i);
			if (isValidPlacement(colPlace)) {
				solveQueenHelper(currentRow+1, n, colPlace, results);
			}
			colPlace.remove(colPlace.size() - 1);
		}
	}

	private static boolean isValidPlacement(List<Integer> colPlace) {
		int rowId = colPlace.size() - 1;
		System.out.println(colPlace);
		for (int i = 0 ; i < rowId ; i ++) {
			int diff = Math.abs(colPlace.get(i) - colPlace.get(rowId));
			if (diff == 0 || diff == rowId - i) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> solutions = solveQueen(4);
	}
	
}
