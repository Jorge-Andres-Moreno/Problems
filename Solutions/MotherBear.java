import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MotherBear {

	private static int i = -1, j = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		while (!(line = in.readLine()).equals("DONE")) {
			boolean flag = true;
			if (line.length() > 2) {
				for (i = 0, j = line.length() - 1; i <= j && flag; i++, j--) {
					String next = nextLetter(line);
					String last = lastLetter(line);
					if (!next.equalsIgnoreCase(last))
						flag = false;
				}
			}
			if (flag)
				out.write("You won't be eaten!\n");
			else
				out.write("Uh oh..\n");
		}
		out.flush();
	}

	static String nextLetter(String chain) {
		if (chain.length() <= i + 1) {
			return "";
		} else {
			char letter = chain.charAt(i);
			if (!(letter + "").toLowerCase().equals((letter + "").toUpperCase()))
				return letter + "";
			else {
				++i;
				return nextLetter(chain);
			}
		}
	}

	static String lastLetter(String chain) {
		if (-1 >= j - 1) {
			return "";
		} else {
			char letter = chain.charAt(j);
			if (!(letter + "").toLowerCase().equals((letter + "").toUpperCase()))
				return letter + "";
			else {
				--j;
				return lastLetter(chain);
			}
		}
	}
}
