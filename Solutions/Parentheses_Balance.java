import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Parentheses_Balance {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(in.readLine());
		for (int j = 0; j < cases; j++) {
			String line = in.readLine();
			Stack<String> stack = new Stack<>();
			boolean correct = line.length() % 2 == 0;
			for (int i = 0; i < line.length() && correct; i++) {
				char key = line.charAt(i);
				if (key == '(' || key == '[')
					stack.add(key + "");
				else {
					if (stack.isEmpty())
						correct = false;
					else if (!keyCloseKey(stack.pop().charAt(0), key))
						correct = false;
				}
			}
			if (stack.isEmpty() && correct)
				out.write("Yes\n");
			else
				out.write("No\n");
		}
		out.close();
	}

	public static boolean keyCloseKey(char k1, char k2) {
		return (k1 == '(' && k2 == ')') || (k1 == '[' && k2 == ']');
	}
}
