import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class NumberFrecuenci {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		while ((line = in.readLine()) != null) {
			int cases = Integer.parseInt(line);
			HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
			for (int i = 0; i < cases; i++) {
				int number = Integer.parseInt(in.readLine());
				if (numbers.containsKey(number)) {
					Integer e = (numbers.get(number));
					++e;
					numbers.remove(number);
					numbers.put(number, e);
				} else {
					numbers.put(number, 1);
				}
			}
			Map<Integer, Integer> miMap = new TreeMap<Integer, Integer>(numbers);
			Set<Integer> ref = miMap.keySet();
			Iterator<Integer> it = ref.iterator();
			while (it.hasNext()) {
				Integer integer = it.next();
				out.write("" + integer + " aparece " + numbers.get(integer).toString() + " vez(es)\n");
			}
		}
		out.flush();
	}

}
