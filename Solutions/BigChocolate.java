import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BigChocolate {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		while ((line = in.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(line);
			int n = Integer.parseInt(tokens.nextToken());
			int m = Integer.parseInt(tokens.nextToken());
			if (n == 1 && m == 1) {
				out.write("0\n");
			} else {
				out.write(separed(m, n) + "\n");
			}
		}
		out.flush();
	}

	public static int down(int m, int n) {
		if (m > 1)
			return down(--m, n) + 1;
		return 0;
	}

	public static int separed(int m, int n) {
		if (m == 1 && n == 1)
			return 0;
		if (n == 1) {
			return down(m, n);
		}
		return separed(m, --n) + 1 + down(m, n);

	}

}
