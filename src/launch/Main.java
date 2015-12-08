package launch;
import ProcheVoisin.AlgoProcheVoisin;
import java.io.IOException;
import java.util.StringTokenizer;
import model.LectureFichier;
import model.Monde;
import model.Sauvegarde;

public class Main {

    /**
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
       Monde m,newm;
       m= LectureFichier.LireFichier("./world.txt");
       newm=AlgoProcheVoisin.projAlgoProcheVoisin(m);
       Sauvegarde.sauv(newm);
        
        
    }
    
}
