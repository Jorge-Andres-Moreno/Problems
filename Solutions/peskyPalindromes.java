import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class peskyPalindromes {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		while ((line = in.readLine()) != null) {
			char letters[] = line.toCharArray();
			int palindromes = 0;
			HashSet<String> list = new HashSet<String>();
			for (int i = 0; i < letters.length; i++)
				for (int j = i; j < letters.length; j++) {
					String request = toString(letters, i, j + 1);
					if (request != null) {
						if (!list.contains(request)) {
							list.add(request);
							palindromes++;
						}
					}
				}
			out.write("The string '" + line + "' contains " + palindromes + " palindromes.\n");
		}
		out.close();
	}

	public static String toString(char[] letters, int begin, int n) {
		String msj = "";
		for (int i = begin, j = n - 1; i < n; i++, j--)
			if (letters[i] != letters[j])
				return null;
			else
				msj += letters[i] + "";
		return msj;
	}
}
