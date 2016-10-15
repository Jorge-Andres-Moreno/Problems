import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class f91 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		while (!(line = in.readLine()).equals("0")) {
			int n = Integer.parseInt(line);
			out.write("f91(" + n + ") = " + f91(n) + "\n");
		}
		out.close();
	}

	public static int f91(int n) {
		if (n >= 101)
			return n - 10;
		else
			return f91(f91(n + 11));
	}

}
