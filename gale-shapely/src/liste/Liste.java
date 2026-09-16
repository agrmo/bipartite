package liste;

import java.util.ArrayList;
import java.util.Arrays;

// Funktionen an Listen.
public class Liste {
    
    // ein: ArrayList<Integer>
    // aus: int[]
    public static int[] nehmeArrayInt(ArrayList<Integer> l) {
	int[] aus = new int[l.size()];

	for (int i = 0; i < l.size(); i++) {
	    aus[i] = l.get(i);
	}

	return aus;
    }

    // ein: Arraylist<int[]>
    // aus: int[][]
    //
    // Gegeben eine ArrayList<int[]>, geben ein int[][] ab.
    public static int[][] nehmeArrayListArrayInteger(ArrayList<int[]> l) {
	int[][] arrayarray = new int[l.size()][];
	
	for (int i = 0; i < l.size(); i++) {
	    int[] zeile = l.get(i);
	    arrayarray[i] = zeile;
	}

	return arrayarray;
    }

    // ein: ArrayList<ArrayList<Integer>>
    // aus: int[][]
    //
    // Gegeben eine ArrayList<ArrayList<Integer>>, geben eine int[][] ab.
    public static int[][] nehmeArrayListArrayListInteger(ArrayList<ArrayList<Integer>> l) {
	int[][] arrayarray = new int[l.size()][];
	
	for (int i = 0; i < l.size(); i++) {
	    ArrayList<Integer> zeile = l.get(i);
	    int[] zeileArray = new int[zeile.size()];
	    int j = 0;
		
	    for (Integer n : zeile) {
		zeileArray[j++] = n;
	    }

	    arrayarray[i] = zeileArray;
	}

	return arrayarray;	
    }

    // und noch mal für double

    // ein: ArrayList<double[]>
    // aus: double[][]
    //
    // Gegeben eine ArrayList<double[]>, geben ein double[][] ab.
    public static double[][] nehmeArrayListArrayDouble(ArrayList<double[]> l) {
	double[][] arrayarray = new double[l.size()][];
	
	for (int i = 0; i < l.size(); i++) {
	    double[] zeile = l.get(i);
	    arrayarray[i] = zeile;
	}

	return arrayarray;
    }

    // ein: ArrayList<ArrayList<Integer>>
    // aus: double[][]
    public static double[][] nehmeArrayListArrayListDouble(ArrayList<ArrayList<Double>> l) {
	double[][] arrayarray = new double[l.size()][];	
	for (int i = 0; i < l.size(); i++) {
	    ArrayList<Double> zeile = l.get(i);
	    double[] zeileArray = new double[zeile.size()];
	    int j = 0;
		
	    for (Double n : zeile) {
		zeileArray[j++] = n;
	    }

	    arrayarray[i] = zeileArray;
	}

	return arrayarray;	
    }

    // ein: int[][]
    // aus: String
    public static String nehmeStringVonArrayArray(int[][] arrayarray) {
	StringBuilder sb = new StringBuilder();

	sb.append("[");
	for (int i = 0; i < arrayarray.length; i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    sb.append(Arrays.toString(arrayarray[i]));
	}
	sb.append("]");

	return sb.toString();
    }

    // ein: double[][]
    // aus: String
    public static String nehmeStringVonArrayArrayDouble(double[][] arrayarray) {
	StringBuilder sb = new StringBuilder();

	sb.append("[");
	for (int i = 0; i < arrayarray.length; i++) {
	    if (i != 0) {
		sb.append(",");
	    }
	    sb.append(Arrays.toString(arrayarray[i]));
	}
	sb.append("]");

	return sb.toString();	
    }

    // ein: Integer[]
    // aus: int
    public static int index(Integer[] liste, int ziel) {
	for (int i = 0; i < liste.length; i++) {
	    if (liste[i] == ziel) {
		return i;
	    }
	}

	return -1;
    }
}
