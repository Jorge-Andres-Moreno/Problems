import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtremelyBasic {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("X = " + ((Integer.parseInt(in.readLine()) + Integer.parseInt(in.readLine()))));
	}
}
