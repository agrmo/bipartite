package zahl.eins;

import java.util.Random;

public class Zufall {

    // Nehme eine zufällige Zahl zwischen [a,b].
    public static int zwischen(Random r, int a, int b) {
	return r.nextInt(b - a + 1) + a;
    }
}
