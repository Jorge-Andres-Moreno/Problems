import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class godelsDream {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		while ((line = in.readLine()) != null) {
			int sequence = 0, ones = 0;
			boolean fail = false;
			for (int i = 0; i < line.length(); i++) {
				char letter = line.charAt(i);
				if (letter == '0' || letter == '?') {
					if (ones > 0) {
						if (ones == 1) {
							fail = true;
						}
						ones--;
					} else {
						sequence++;
						fail = false;
					}
				} else
					ones++;
			}
			if (ones > 0 || fail)
				out.write("0\n");
			else
				out.write(sequence + "\n");
		}
		out.flush();
	}
}
