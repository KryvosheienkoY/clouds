import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortingDNA {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int num = in.nextInt();
		if (num >= 1) {
			// make m tests
			for (int i = 0; i < num; i++) {
				int rowLength = in.nextInt();
				if (rowLength > 0 && rowLength <= 50) {
					int rowNum = in.nextInt();
					if (rowNum > 0 && rowNum <= 100) {
						ArrayList<Pair> pairs = new ArrayList<>(rowNum);
						for (int k = 0; k < rowNum; k++) {
							String str = in.next();
							int inv = getInvCount(str);
							pairs.add(new Pair(str, inv));
						}

						// sorting
						Collections.sort(pairs);

						for (int j = 0; j < rowNum; j++) {
							out.println(pairs.get(j).toString());
						}
						out.print('\n');
					}
				}
			}
		}

		out.flush();
	}

	public static int getInvCount(String ar) {
		char arr[] = ar.toCharArray();
		int n = arr.length;
		int inv_count = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (arr[i] > arr[j])
					inv_count++;

		return inv_count;
	}
}

class Pair implements Comparable<Pair> {
	String str;
	int num;

	Pair(String string, int number) {
		this.str = string;
		this.num = number;
	}

	@Override
	public int compareTo(Pair o) {
		if (num > o.num)
			return 1;
		if (num < o.num)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return str;
	}

}
