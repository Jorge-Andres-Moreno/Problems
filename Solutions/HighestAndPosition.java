import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HighestAndPosition {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long pos = -1, number = -1;
		for (int i = 0; i < 100; i++) {
			long inNumber = Integer.parseInt(in.readLine());
			if (inNumber > number) {
				number = inNumber;
				pos = i + 1;
			}
		}
		System.out.println("" + number + "\n" + pos);
	}

}
