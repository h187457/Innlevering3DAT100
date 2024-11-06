package no.hvl.dat100.oppgave5;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave2.Bilde;
import no.hvl.dat100.oppgave2.Tekst;
import no.hvl.dat100.oppgave3.Blogg;

public class LesBlogg {

	public static Blogg les(String mappe, String filnavn) {
		File fil = new File(mappe, filnavn);
		Scanner scanner = null;

		try {
			scanner = new Scanner(new FileReader(fil));
			int antallInnlegg = Integer.parseInt(scanner.nextLine());
			Blogg blogg = new Blogg(antallInnlegg);

			for (int i = 0; i < antallInnlegg; i++) {
				String type = scanner.nextLine();
				int id = Integer.parseInt(scanner.nextLine());
				String bruker = scanner.nextLine();
				String dato = scanner.nextLine();
				int likes = Integer.parseInt(scanner.nextLine());
				String tekst = scanner.nextLine();

				if (type.equals("TEKST")) {
					Tekst tekstInnlegg = new Tekst(id, bruker, dato, likes, tekst);
					blogg.leggTil(tekstInnlegg);
				} else if (type.equals("BILDE")) {
					String url = scanner.nextLine();
					Bilde bildeInnlegg = new Bilde(id, bruker, dato, likes, tekst, url);
					blogg.leggTil(bildeInnlegg);
				}
			}

			return blogg;
		} catch (IOException e) {
			System.out.println("Kunne ikke lese fra filen: " + e.getMessage());
			return null;
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
