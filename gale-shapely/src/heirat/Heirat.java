package heirat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import liste.Liste;
import java.util.List;
import java.util.Map;
import java.util.Set;

//  Ein Mann ist eine ganze Zahl
//  
//  Eine Frau ist eine ganze Zahl
//
//  Eine Mann-Vorliebe ist eine Abbildung von
//  Mann zu einer Liste von Frauen
//
//  Eine Frau-Vorliebe ist eine Abbildung von
//  Frau zu einer Liste von Männern.
//
//  Ein Paar ist ein Paar von (Mann, Frau)
//  
//  Eine Verlobung ist eine Liste von Paare

public class Heirat {
    
    public int groesse;
    public HashMap<Integer,Integer[]> mannVorliebe;
    public HashMap<Integer,Integer[]> frauVorliebe;
    public HashMap<Integer,HashSet<Integer>> vorschlaege;
    public ArrayList<Integer[]> verlobung;
    
    public Heirat(HashMap<Integer,Integer[]> m,
		  HashMap<Integer,Integer[]> f) {

	if (m.size() != f.size()) {
	    System.out.println("Problem");
	}
	
	this.groesse = m.size();
	this.mannVorliebe = m;
	this.frauVorliebe = f;
	this.verlobung = new ArrayList<Integer[]>();
	this.vorschlaege = new HashMap<Integer,HashSet<Integer>>();
    }

    // Ist der Mann frei?
    boolean istFreiMann(int mann) {
	for (Integer[] paar : this.verlobung) {
	    if (paar[0] == mann) {
		// Der Mann ist schon in einem Paar.
		return false;
	    }
	}

	// Der Mann ist frei.
	return true;
    }

    // Ist die Frau frei?
    boolean istFreiFrau(int frau) {
	for (Integer[] paar : this.verlobung) {
	    if (paar[1] == frau) {
		// Die Frau ist schon in einem Paar.
		return false;
	    }
	}

	// Die Frau ist frei.
	return true;
    }

    // Für jede Mann, nehme den Mann.
    // Ist er frei? Falls ja, geh weiter.
    // Laufe durch jede mögliche Frau.
    // Gibt es eine Frau, die er nicht ein Paar vorgeschlagen hat?
    public boolean nichtAlleVorgeschlagen() {
	
	for (int mann : this.mannVorliebe.keySet()) {

	    // Ist er frei?
	    if (this.istFreiMann(mann)) {
		
		// Er ist frei. Geh weiter.
		// Frauen, die er vorliebt.
		Integer[] frauen = this.mannVorliebe.get(mann);

		if (this.vorschlaege.keySet().contains(mann)) {
		    // Der Mann hat mindestens eine Frau schon
		    // vorgeschlagen.  Frauen, die er vorgeschlagen hat.
		    Set<Integer> mannVorschlaege = this.vorschlaege.get(mann);

		    for (int frau : frauen) {
			// Hat er nicht schon die Frau vorgeschlagen?
			if (!mannVorschlaege.contains(frau)) {
			    return true;
			}
		    }
		} else {
		    // Der Mann hat bereits keine Frau vorgeschlagen.
		    this.vorschlaege.put(mann, new HashSet<Integer>());
		    return true;
		}
	    }
 	}
	
	return false;
    }

    // Nehme den Mann, der nicht alle Frauen vorgeschlagen hat.
    int mannNichtAlleVorgeschlagen() {
	
	for (int mann : this.mannVorliebe.keySet()) {
	    // Ist er frei?
	    if (this.istFreiMann(mann)) {
		// Er ist frei. Geh weiter.		
		// Frauen, die er vorliebt.
		Integer[] frauen = this.mannVorliebe.get(mann);
		// Frauen, die er vorgeschlagen hat.
		Set<Integer> mannVorschlaege = this.vorschlaege.get(mann);
	    
		for (int frau : frauen) {
		    // Hat er nicht schon die Frau vorgeschlagen?
		    if (!mannVorschlaege.contains(frau)) {
			return mann;
		    }
		}
	    }
	}

	System.out.println("Problem.");
	return 0;
    }

    // Nehme die Frau, die er nicht vorgeschlagen hat, und steht für
    // ihn am liebsten. Wir nehmen an, dass der Mann nicht alle Frauen
    // vorgeschlagen hat.
    int nehmeBeliebteste(int mann) {
	
	// Frauen, die er vorliebt.
	Integer[] frauen = this.mannVorliebe.get(mann);
	// Frauen, die er vorgeschlagen hat.
	Set<Integer> mannVorschlaege = this.vorschlaege.get(mann);

	// Die Liste von Frauen steht schon in Ordnung von Liebe.
	for (int frau : frauen) {
	    // Hat er nicht schon die Frau vorgeschlagen?
	    if (!mannVorschlaege.contains(frau)) {
		return frau;
	    }
	}

	System.out.println("Problem");
	return 0;
    }

    // Nehme an, daß die Frau schon in einem Paar steht.
    // Nehme den Mann, mit ihm die Frau steht.
    int nehmeMannVonFrau(int frau) {
	for (Integer[] paar : this.verlobung) {
	    if (paar[1] == frau) {
		// Gebe den Mann von der Frau.
		return paar[0];
	    }
	}

	System.out.println("Problem");
	return 0;
    }

    // Liebt die Frau den Mann meins mehr als mzwei vor?
    boolean stehtHoeher(int frau, int meins, int mzwei) {
	// Die Stelle, an der der Mann meins steht.
	int meinsStelle = Liste.index(this.frauVorliebe.get(frau), meins);
	// Die Stelle, an der der Mann mzwei steht.
	int mzweiStelle = Liste.index(this.frauVorliebe.get(frau), mzwei);

	System.out.println("m1, m2: " + meinsStelle + " " + mzweiStelle);
	
	return meinsStelle < mzweiStelle;    
    }

    // Nehmen das Paar mit der Frau weg, also der vorherige Mann wird
    // frei, und setzen ein neues Paar mit dem neuen Mann ein.
    private void tauschen(int frau, int neuerMann) {
	for (int i = 0; i < this.verlobung.size(); i++) {
	    Integer[] paar = this.verlobung.get(i);
	    if (paar[1] == frau) {
		this.verlobung.set(i, new Integer[] {neuerMann, frau});
	    }
	}
    }

    public ArrayList<Integer[]> schritt() {

	if (this.nichtAlleVorgeschlagen()) {

	    int mann = this.mannNichtAlleVorgeschlagen();
	    int frau = this.nehmeBeliebteste(mann);
	    System.out.println("Vorschlagen Mann " + mann + " und Frau " + frau);

	    if (this.istFreiFrau(frau)) {
		// Die Frau ist frei. Mache ein Paar.
		System.out.println("Die Frau " + frau + " ist frei.");
		this.verlobung.add(new Integer[] {mann, frau});
		
	    } else {
		System.out.println("Die Frau " + frau + " ist nicht frei.");
		
		// Nehme den Mann, mit ihm sie in einem Paar schon steht.
		int mannInPaar = this.nehmeMannVonFrau(frau);
		System.out.println("Der Mann, mit ihm sie in einem Paar schon steht ist " + mannInPaar);

		// Steht der Mann höher als der Mann im Paar?
		// Falls ja, tauchen die Männer.
		if (this.stehtHoeher(frau, mann, mannInPaar)) {
		    System.out.println("Der Mann " + mann + " steht höher. Tauschen.");
		    this.tauschen(frau, mann);
		}
	    }

	    // Der Mann ist fertig, um einen Antrag mit dieser Frau vorzuschlagen.
	    // Addiere sie zu die Frauen, die er schon vorgeschlagen hat.
	    this.vorschlaege.get(mann).add(frau);

	    System.out.println("Vorschlag fertig. Vorschlag ist " + vorschlaege);
	}
	
	return this.verlobung;
    }
}
