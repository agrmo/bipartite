package heirat;

import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

// heirat.Main

public class Main {
    public static void main(String[] args) {

	// Es gibt 3 Männer: 0,1,2
	// 0 liebt vor: 3,5,4
	// 1 liebt vor: 3,4,5
	// 2 liebt vor: 5,4,3
	// Es gibt 3 Frauen: 3,4,5
	// 0 liebt vor: 2,1,0
	// 1 liebt vor: 1,2,0
	// 2 liebt vor: 1,2,0
	// Eine stabile Verlobung ist [[1, 3], [2, 5], [0, 4]]
	
	HashMap<Integer,List<Integer>> mannVorliebe = new HashMap<Integer,List<Integer>>();
	mannVorliebe.put(0,Arrays.asList(3,5,4));
	mannVorliebe.put(1,Arrays.asList(3,4,5));
	mannVorliebe.put(2,Arrays.asList(5,4,3));

	HashMap<Integer,List<Integer>> frauVorliebe = new HashMap<Integer,List<Integer>>();
	frauVorliebe.put(3,Arrays.asList(2,1,0));
	frauVorliebe.put(4,Arrays.asList(1,2,0));
	frauVorliebe.put(5,Arrays.asList(1,2,0));

	Heirat h = new Heirat(mannVorliebe, frauVorliebe);

	while (h.nichtAlleVorgeschlagen()) {
	    List<List<Integer>> verlobung = h.match();
	    System.out.println(verlobung);
	}
    }
}
