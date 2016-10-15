import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class AgeSort {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		while (!(in.readLine()).equals("0")) {
			StringTokenizer tokens = new StringTokenizer(in.readLine());
			ArrayList<Integer> array = new ArrayList<Integer>();
			while (tokens.hasMoreTokens())
				array.add(Integer.parseInt(tokens.nextToken()));
			Collections.sort(array);
			int i = 0;
			for (; i < (array.size() - 1); i++) {
				out.write(array.get(i) + " ");
			}
			out.write(array.get(i) + "\n");
		}
		out.flush();
	}

}
