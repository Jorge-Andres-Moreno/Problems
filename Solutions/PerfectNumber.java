import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PerfectNumber {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(in.readLine());
		for (int i = 0; i < cases; i++) {
			int number = Integer.parseInt(in.readLine());
			int aux = 0;
			for (int j = 1; j < number / 2 + 1; j++) {
				if (number % j == 0)
					aux += j;
			}
			if (number == aux)
				out.write(number + " eh perfeito\n");
			else
				out.write(number + " nao eh perfeito\n");
		}
		out.flush();
	}
}
