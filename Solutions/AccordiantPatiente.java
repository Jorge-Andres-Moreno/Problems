import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class AccordiantPatiente {

	private static int size;
	// static Stack<String[]> stacks[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		while (!(line = in.readLine()).equals("#")) {
			size = 0;
			StringTokenizer tokens = new StringTokenizer(line);
			Stack<String[]>[] stacks = new Stack[52];
			while (tokens.hasMoreTokens()) {
				String card[] = tokens.nextToken().split("");
				int index = indexCreated(card, stacks);
				stacks[index].push(card);
				organizedStacks(stacks);
			}
			tokens = new StringTokenizer(in.readLine());
			while (tokens.hasMoreTokens()) {
				String card[] = tokens.nextToken().split("");
				int index = indexCreated(card, stacks);
				stacks[index].push(card);
				organizedStacks(stacks);
			}
			if (size > 1)
				out.write(problemToString(stacks) + "\n");
			else
				out.write(size + " pile remaining: " + stacks[0].size() + "\n");
		}
		out.close();
	}

	public static int indexCreated(String card[], Stack<String[]>[] stacks) {
		int index = -1;
		if (size != 0) {
			for (int i = size - 1; i >= size - 3 && i >= 0; i -= 2)
				if (isResemblant(card, stacks[i].peek()))
					index = i;
			if (index == -1) {
				stacks[size] = new Stack<>();
				index = size;
				size++;
			}
		} else {
			index = size;
			stacks[0] = new Stack<>();
			size++;
		}
		return index;
	}

	public static String problemToString(Stack<String[]>[] stacks) {
		String txt = size + " piles remaining:";
		for (int i = 0; i < size; i++)
			txt += " " + stacks[i].size();
		return txt;
	}

	public static boolean isResemblant(String card[], String anotherCard[]) {
		if (anotherCard != null)
			return (card[0].equals(anotherCard[0]) || card[1].equals(anotherCard[1]));
		else
			return false;
	}

	public static void cleanStack(Stack<String[]>[] stacks, int i) {
		stacks[i] = null;
		--size;
		for (int j = i; j < size; j++)
			stacks[j] = stacks[j + 1];
	}

	public static void organizedStacks(Stack<String[]>[] stacks) {
		boolean sePuedeJugar = true;
		while (sePuedeJugar) {
			boolean seJugo = false;
			for (int i = 1; i < size && !seJugo; i++) {
				if (i >= 3) {
					if (isResemblant(stacks[i].peek(), stacks[i - 3].peek())) {
						stacks[i - 3].push(stacks[i].pop());
						seJugo = true;
					} else if (isResemblant(stacks[i].peek(), stacks[i - 1].peek())) {
						stacks[i - 1].push(stacks[i].pop());
						seJugo = true;
					}
				} else if (isResemblant(stacks[i].peek(), stacks[i - 1].peek())) {
					stacks[i - 1].push(stacks[i].pop());
					seJugo = true;
				}
				if (stacks[i].isEmpty())
					cleanStack(stacks, i);
			}
			if (!seJugo)
				sePuedeJugar = false;
		}
	}
}
