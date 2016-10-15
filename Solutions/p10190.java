import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p10190 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";

		while ((line = in.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(line);
			int n = Integer.parseInt(tokens.nextToken());
			int m = Integer.parseInt(tokens.nextToken());
			if (n == 0 || m == 0 || n == 1 || m == 1) {
				out.write("Boring!\n");
				continue;
			}
			out.write(f(n, m));
		}
		out.close();
	}

	public static String f(int n, int m) {
		if (n % m != 0)
			return "Boring!\n";
		if (n / m == 1)
			return n + " " + 1 + "\n";
		else {
			String request = f(n / m, m);
			return request.equals("Boring!\n") ? request : n + " " + request;
		}
	}
}
