import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class fibonacciFreeze {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		BigInteger fib[] = new BigInteger[5001];
		fib[0] = BigInteger.valueOf(0);
		fib[1] = BigInteger.valueOf(1);
		for (int i = 2; i < fib.length; i++)
			fib[i] = fib[i - 1].add(fib[i - 2]);
		while ((line = in.readLine()) != null) {
			int number = Integer.parseInt(line);
			out.write("The Fibonacci number for " + number + " is " + fib[number] + "\n");
		}
		out.close();
	}
}
