import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class passwords {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		while ((line = in.readLine()) != null) {
			out.write("--\n");
			int n = Integer.parseInt(line);
			String array[] = new String[n];
			for (int i = 0; i < n; i++)
				array[i] = in.readLine();
			int m = Integer.parseInt(in.readLine());
			for (int i = 0; i < m; i++)
				out.write(format(in.readLine(), array, 0, "") + "\n");
		}
		out.close();
	}

	public static String format(String format, String array[], int i, String status) {
		if (i == format.length())
			return "";
		else if (format.charAt(i) == '0') {
			String mensaje = "0" + format(format, array, i + 1, status + 0);
			for (int j = 1; j < 10; j++)
				mensaje += "\n" + status + j + format(format, array, i + 1, status + j);
			return mensaje;

		} else {
			String mensaje = array[0] + format(format, array, i + 1, status + array[0]);
			for (int j = 1; j < array.length; j++)
				mensaje += "\n" + status + array[j] + format(format, array, i + 1, status + array[j]);
			return mensaje;
		}
	}
}
