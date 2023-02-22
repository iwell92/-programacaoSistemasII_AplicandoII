package LeArquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeArquivo {

	public static void main(String[] args) {

		String path = "C:\\ws-eclipse-mackenzie\\Aula2_Aplicando2\\alunos.txt";
		double somaNota = 0;
		double mediaNota = 0;

		List<Double> list = new ArrayList<Double>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = " ";
			line = br.readLine();
			while (line != null) {

				String[] vect = line.split(";");
				Double nota = Double.parseDouble(vect[2]);

				line = br.readLine();

				somaNota += nota;

				list.add(nota);
			}

			mediaNota = somaNota / list.size();
			System.out.println("Media das notas = " + mediaNota);
			
			// imprimir as notas maiores que a media calculada
			for (int i = 0; i < list.size(); i++)
				if (list.get(i) >= mediaNota)
					System.out.println("Nota maior que a media => " + list.get(i));
			System.out.println("fim de programa.");

			line = br.readLine();

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
