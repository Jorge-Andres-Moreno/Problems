import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AgeSort_11462 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String linea = "";
		while (!((linea = in.readLine())).equals("0")) {
			StringTokenizer tokens = new StringTokenizer(in.readLine());
			int[] array = new int[Integer.parseInt(linea)];
			for (int i = 0; i < array.length; i++) {
				array[i] = Integer.parseInt(tokens.nextToken());
			}
			array = countingSort(array, array.length + 10);
			int i = 0;
			for (; i < (array.length - 1); i++) {
				out.write(array[i] + " ");
			}
			out.write(array[i] + "\n");
		}
		out.flush();
	}

	static int[] countingSort(int[] a, int k) {
		int array[] = new int[k];
		for (int i = 0; i < a.length; i++)
			array[a[i]]++;
		for (int i = 1; i < k; i++)
			array[i] += array[i - 1];
		int b[] = new int[a.length];
		for (int i = a.length - 1; i >= 0; i--)
			b[--array[a[i]]] = a[i];
		return b;
	}
}
