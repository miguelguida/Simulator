/**
 * Created by miguel on 23/03/17.
 */
public class Main {
    public static void main(String[] args) {
        Simulator mVrep = new Simulator("177.220.84.242", 25000);

        System.out.println("\nCheck Connection: "+mVrep.checkConnection());
        System.out.println("\nClientID: "+mVrep.getClientID());
    }
}
