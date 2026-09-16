package heirat;

import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import zahl.eins.Zufall;

public class VorliebeZufall {

    // Mache eine vollig zufällig liste von Vorlieben.
    public static Heirat mache(int groesse) {
	    
	Random r = new Random();

	// Vorliebe: Mann bis Frau
	// -----------------------------------------------------------------------
	HashMap<Integer,Integer[]> mannVorliebe = new HashMap<Integer,Integer[]>();

	// e.g. [n, n+1, ..., 2n - 1]
	ArrayList<Integer> vorliebeVoll = new ArrayList<Integer>();
	for (int i = 0; i < groesse; i++) {
	    vorliebeVoll.add(i + groesse);
	}

	// System.out.println("voll: " + vorliebeVoll);

	// i: ein Mann, der eine Vorliebeliste braucht
	for (int i = 0; i < groesse; i++) {

	    // e.g. [n, n+1, ..., 2n - 1]
	    ArrayList<Integer> vorliebeNeuVoll = new ArrayList<Integer>(vorliebeVoll);

	    // e.g. []
	    ArrayList<Integer> vorliebeNeu = new ArrayList<Integer>();

	    while (vorliebeNeuVoll.size() > 0) {
		
		// Zwischen 0 und (Größe der Liste - 1)
		int zufallIndex = Zufall.zwischen(r, 0, vorliebeNeuVoll.size() - 1);
		int zufallZahl = vorliebeNeuVoll.remove(zufallIndex);

		vorliebeNeu.add(zufallZahl);
	    }

	    // Jetzt hat vorliebeNeu eine zufällige Ordnung von Zahlen
	    // zwischen [n ... 2n - 1]. Das ist eine zufällige
	    // Vorliebe von einem Mann bis die Frauen.


	    Integer[] vorliebeNeuArray = new Integer[vorliebeNeu.size()];

	    for (int j = 0; j < vorliebeNeu.size(); j++) {
		vorliebeNeuArray[j] = vorliebeNeu.get(j);
	    }
	    
	    // System.out.println("zuf: " + i + ": " + vorliebeNeu);
	    mannVorliebe.put(i, vorliebeNeuArray);
	}

	// Vorliebe: Frau bis Mann
	// -----------------------------------------------------------------------

	HashMap<Integer,Integer[]> frauVorliebe = new HashMap<Integer,Integer[]>();
	// e.g. [0, ..., n - 1]
	vorliebeVoll = new ArrayList<Integer>();
	for (int i = 0; i < groesse; i++) {
	    vorliebeVoll.add(i);
	}

	// System.out.println("voll: " + vorliebeVoll);

	// i: ein Mann, der eine Vorliebeliste braucht
	for (int i = 0; i < groesse; i++) {

	    // e.g. [0, ..., n - 1]
	    ArrayList<Integer> vorliebeNeuVoll = new ArrayList<Integer>(vorliebeVoll);

	    // e.g. []
	    ArrayList<Integer> vorliebeNeu = new ArrayList<Integer>();

	    while (vorliebeNeuVoll.size() > 0) {
		
		// Zwischen 0 und (Größe der Liste - 1)
		int zufallIndex = Zufall.zwischen(r, 0, vorliebeNeuVoll.size() - 1);
		int zufallZahl = vorliebeNeuVoll.remove(zufallIndex);

		vorliebeNeu.add(zufallZahl);
	    }

	    // Jetzt hat vorliebeNeu eine zufällige Ordnung von Zahlen
	    // zwischen [0 ... n - 1]. Das ist eine zufällige
	    // Vorliebe von einem Mann bis die Frauen.


	    Integer[] vorliebeNeuArray = new Integer[vorliebeNeu.size()];

	    for (int j = 0; j < vorliebeNeu.size(); j++) {
		vorliebeNeuArray[j] = vorliebeNeu.get(j);
	    }
	    
	    // System.out.println("zuf: " + (i + groesse) + ": " + vorliebeNeu);
	    frauVorliebe.put(i + groesse, vorliebeNeuArray);
	}

	// Fertig
	
	Heirat h = new Heirat(mannVorliebe, frauVorliebe);

	return h;
    }
}
