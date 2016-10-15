import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CD {

	static int sum = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		while ((line = in.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(line);
			int max = Integer.parseInt(tokens.nextToken());
			int size = Integer.parseInt(tokens.nextToken());
			int tracks[] = new int[size];
			for (int i = 0; i < size; i++)
				tracks[i] = Integer.parseInt(tokens.nextToken());
			String small = "";
			int sumtmp = sum = 0;
			for (int i = 0; i < tracks.length; i++) {
				sum = 0;
				String tmp = sum(tracks, i, max);
				if (sum == max) {
					small = tmp;
					sumtmp = sum;
					break;
				} else if (sum > sumtmp) {
					small = tmp;
					sumtmp = sum;
				}
			}
			out.write(small + " sum:" + sumtmp + "\n");
		}
		out.close();
	}

	public static String sum(int array[], int index, int max) {
		if (sum + array[index] > max)
			return "";
		else if (array[index] + sum == max) {
			sum += array[index];
			return "" + array[index];
		} else {
			sum += array[index];
			int aux = sum;
			String sumTmp = array[index] + "";
			int aproximadamente = sum;
			for (int i = index + 1; i < array.length; i++) {
				sum = aux;
				String tmp = array[index] + " " + sum(array, i, max);
				if (sum == max) {
					return tmp;
				} else if (aproximadamente < sum) {
					aproximadamente = sum;
					sumTmp = tmp;
				}
			}
			sum = aproximadamente;
			return sumTmp;

		}
	}

}
