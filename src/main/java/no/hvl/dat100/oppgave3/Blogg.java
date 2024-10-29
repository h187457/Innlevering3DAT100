package no.hvl.dat100.oppgave3;

import no.hvl.dat100.oppgave1.Innlegg;

public class Blogg {

	private Innlegg[] innleggs;
	private int nesteledig;

	public Blogg() {
		this.innleggs = new Innlegg[20];
		this.nesteledig = 0;
	}

	public Blogg(int lengde) {
		this.innleggs = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggs;
	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innleggs[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) != -1;
	}

	public boolean ledigPlass() {
		return nesteledig < innleggs.length;
	}

	public boolean leggTil(Innlegg innlegg) {
		if (innlegg != null && ledigPlass()) {
			innleggs[nesteledig++] = innlegg;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nesteledig).append("\n");
		for (int i = 0; i < nesteledig; i++) {
			sb.append(innleggs[i].toString());
		}
		return sb.toString();
	}

	// Optional methods to be implemented later
	public void utvid() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public boolean slett(Innlegg innlegg) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public int[] search(String keyword) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
