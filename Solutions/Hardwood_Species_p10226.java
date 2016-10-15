import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Hardwood_Species_p10226 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(in.readLine());
		String line = in.readLine();
		for (int i = 0; i < cases; i++) {
			int total = 0;
			TreeMap<String, Integer> list = new TreeMap<>();
			while ((line = in.readLine()) != null && !line.equals("")) {
				Integer size = list.get(line);
				if (size != null)
					list.put(line, ++size);
				else
					list.put(line, 1);
				total++;
			}
			Iterator<Entry<String, Integer>> j = list.entrySet().iterator();
			while (j.hasNext()) {
				Entry<String, Integer> entry = j.next();
				BigDecimal decimal = new BigDecimal((((entry.getValue() + 0.0) / total) * 100) + "");
				out.write(entry.getKey() + " " + decimal.setScale(4, BigDecimal.ROUND_HALF_UP) + "\n");
			}
			if (i + 1 < cases)
				out.write("\n");
		}
		out.close();
	}
}
