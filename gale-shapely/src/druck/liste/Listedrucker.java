package druck.liste;

import java.util.ArrayList;

// Einfache Funktionen, um Listen zu drucken.
public class Listedrucker {

    public static String druckeliste(ArrayList<Integer> liste) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	
	for (int i = 0; i < liste.size(); i++) {

	    if (i != 0) {
		sb.append(",");
	    }

	    sb.append(liste.get(i));
	}

	sb.append("]\n");

	return sb.toString();
    }

    public static String drucke(ArrayList<int[]> liste) {

	StringBuilder sb = new StringBuilder();
	sb.append("[");
	
	for (int i = 0; i < liste.size(); i++) {

	    if (i == 0) {
		sb.append("[");
	    } else if (i != 0) {
		sb.append(",[");
	    }

	    for (int j = 0; j < liste.get(i).length; j++) {
		if (j != 0) {
		    sb.append(",");
		}

		sb.append(liste.get(i)[j]);
	    }

	    sb.append("]");
	}

	sb.append("]\n");

	return sb.toString();
    }

    public static String druckeprimitiv(ArrayList<Integer[]> liste) {

	StringBuilder sb = new StringBuilder();
	sb.append("[");
	
	for (int i = 0; i < liste.size(); i++) {

	    if (i == 0) {
		sb.append("[");
	    } else if (i != 0) {
		sb.append(",[");
	    }

	    for (int j = 0; j < liste.get(i).length; j++) {
		if (j != 0) {
		    sb.append(",");
		}

		sb.append(liste.get(i)[j]);
	    }

	    sb.append("]");
	}

	sb.append("]");

	return sb.toString();
    }
}
