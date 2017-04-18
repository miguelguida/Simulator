/**
 * Created by miguel on 23/03/17.
 */
public class Main {
    public static void main(String[] args) {
        Simulator mVrep = new Simulator("177.220.85.170", 25000);

        System.out.println("\nCheck Connection: "+mVrep.checkConnection());
    }
}
