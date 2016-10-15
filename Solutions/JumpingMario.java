import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Jorge Andrés Moreno Mera
 *
 */
public class JumpingMario {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String salidaConsola = "";
		int casos = Integer.parseInt(lector.readLine());

		for (int p = 0; p < casos; p++) {

			int saltosAlto = 0;
			int saltosBajo = 0;

			lector.readLine();

			int tamañoBloques[] = convertirArreglo(lector.readLine().split(" "));

			for (int i = 0; i < tamañoBloques.length - 1; i++) {

				if (tamañoBloques[i] > tamañoBloques[i + 1]) {
					saltosBajo++;

				} else if (tamañoBloques[i] < tamañoBloques[i + 1]) {
					saltosAlto++;

				}

			}
			if (p == 0) {
				salidaConsola += ("Case " + (p + 1) + ": " + saltosAlto + " " + saltosBajo);
			} else {
				salidaConsola += "\n" + ("Case " + (p + 1) + ": " + saltosAlto + " " + saltosBajo);
			}
		}
		System.out.println(salidaConsola);

	}

	/**
	 * Convierte un arreglo de String a int.
	 * 
	 * @param entrada
	 *            arreglo de String.
	 * @return arrreglo de int.
	 */
	static int[] convertirArreglo(String[] entrada) {
		int arreglo[] = new int[entrada.length];
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = Integer.parseInt(entrada[i]);
		}
		return arreglo;
	}

}
