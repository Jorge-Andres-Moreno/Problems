import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TennisRounds {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		while ((line = in.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(line);
			tokens.nextToken();
			int cont = 0;
			int p1 = Integer.parseInt(tokens.nextToken());
			int p2 = Integer.parseInt(tokens.nextToken());
			boolean stop = false;
			do {
				if (Math.abs(p1 - p2) == 0)
					stop = true;
				else {
					if (p1 % 2 == 0 && p1 != 1)
						p1 /= 2;
					else
						p1 = (p1 + 1) / 2;

					if (p2 % 2 == 0 && p2 != 1)
						p2 /= 2;
					else
						p2 = (p2 + 1) / 2;
					cont++;
				}
			} while (!stop);
			out.write(cont + "\n");
		}
		out.flush();
	}
}
