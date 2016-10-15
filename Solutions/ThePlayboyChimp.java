import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ThePlayboyChimp {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		while ((line = in.readLine()) != null) {
			int array[] = new int[Integer.parseInt(line)];
			StringTokenizer tokens = new StringTokenizer(in.readLine());
			for (int i = 0; i < array.length; i++)
				array[i] = Integer.parseInt(tokens.nextToken());
			int queries = Integer.parseInt(in.readLine());
			tokens = new StringTokenizer(in.readLine());
			for (int i = 0; i < queries; i++) {
				int queri = Integer.parseInt(tokens.nextToken());
				int max = max(queri, 0, array.length, array);
				int min = min(queri, 0, array.length, array);
				if (max == array.length && min == -1)
					out.write("X X" + "\n");
				else if (min == -1)
					out.write("X " + array[max] + "\n");
				else if (max == array.length)
					out.write(array[min] + " X" + "\n");
				else
					out.write(array[min] + " " + array[max] + "\n");
			}
		}
		out.close();
	}

	public static int max(int find, int start, int end, int array[]) {
		if (start - end == 0) {
			return start;
		} else if (start < end) {
			int middle = (start + end) >> 1;
			if (array[middle] > find)
				return max(find, start, middle, array);
			else
				return max(find, middle + (start + end) % 2, end, array);
		} else
			return array.length;
	}

	public static int min(int find, int start, int end, int array[]) {
		if (start - end == 0) {
			return start - 1;
		} else if (start < end) {
			int middle = (start + end) >> 1;
			if (array[middle] < find)
				return min(find, middle + (start + end) % 2, end, array);
			else
				return min(find, start, middle, array);
		} else
			return -1;
	}

}
