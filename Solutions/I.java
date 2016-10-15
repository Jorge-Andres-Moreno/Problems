import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class I {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String linea = "";
		while ((linea = in.readLine()) != null) {
			int size = Integer.parseInt(linea);
			StringTokenizer tokens = new StringTokenizer(in.readLine());
			int[] sizes = new int[size];
			sizes[0] = 1;
			tokens.nextToken();
			for (int i = 1; i < sizes.length; i++) {
				int number = Integer.parseInt(tokens.nextToken());
				if (sizes[i - 1] < number)
					sizes[i] = sizes[i - 1] + 1;
				else
					sizes[i] = number;
			}
			sizes[size - 1] = 1;
			int maxValue = 1;
			for (int i = sizes.length - 2; i > -1; i--) {
				if (sizes[i + 1] < sizes[i])
					sizes[i] = sizes[i + 1] + 1;
				else
					sizes[i] = sizes[i];

				if (sizes[i + 1] > maxValue)
					maxValue = sizes[i + 1];
			}
			out.write(maxValue + "\n");
		}
		out.close();
	}

}
