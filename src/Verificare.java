public class Verificare {

    boolean verificare(int x) {
        int y = x;
        int i, s = 0, p, c;
        if (x == 0) {
            s = 1;
        }
        while (x != 0) {
            p = 1;
            c = x % 10;
            for (i = 1; i <= c; i++) {
                p *= i;
            }
            s += p;
            x /= 10;
        }
        if (s == y) {
            return true;
        } else {
            return false;
        }
    }
}
