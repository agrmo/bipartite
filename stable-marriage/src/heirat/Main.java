package heirat;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

// heirat.Main

public class Main {
    public static void main(String[] args) {

	// Es gibt 3 Männer: 0,1,2
	// 0 liebt vor: 0,2,1
	// 1 liebt vor: 0,1,2
	// 2 liebt vor: 2,1,0
	// Es gibt 3 Frauen: 0,1,2
	// 0 liebt vor: 2,1,0
	// 1 liebt vor: 1,2,0
	// 2 liebt vor: 1,2,0
	// Eine stabile Verlobung ist [[1, 0], [2, 2], [0, 1]]
	
	Map<Integer,List<Integer>> mannVorliebe = new HashMap<Integer,List<Integer>>();
	mannVorliebe.put(0,Arrays.asList(0,2,1));
	mannVorliebe.put(1,Arrays.asList(0,1,2));
	mannVorliebe.put(2,Arrays.asList(2,1,0));

	Map<Integer,List<Integer>> frauVorliebe = new HashMap<Integer,List<Integer>>();
	frauVorliebe.put(0,Arrays.asList(2,1,0));
	frauVorliebe.put(1,Arrays.asList(1,2,0));
	frauVorliebe.put(2,Arrays.asList(1,2,0));

	Heirat h = new Heirat(mannVorliebe, frauVorliebe);

	while (h.nichtAlleVorgeschlagen()) {
	    List<List<Integer>> verlobung = h.match();
	    System.out.println(verlobung);
	}
    }
}
