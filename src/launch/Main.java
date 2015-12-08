package launch;
import ProcheVoisin.AlgoProcheVoisin;
import java.io.IOException;
import model.LectureFichier;
import model.Monde;
import model.Sauvegarde;

public class Main {

    public static void main(String[] args) throws IOException {
        
        // ***** /!\ UTILISER CECI POUR LES TESTS /!\ ***** //
        Monde m,newm;
        m= LectureFichier.LireFichier("./world.txt");
        long startTime = System.currentTimeMillis();
        
        newm=AlgoProcheVoisin.projAlgoProcheVoisin(m); // <-- mettre ici l'algo que vous voulez tester
        
        long endTime = System.currentTimeMillis();
        float totalTime = ((float) (endTime-startTime)) / 1000f;
        Sauvegarde.sauv(newm);
        
        //Un petit affichage sympatique de fin de parcour
        System.out.println("Done after ["+totalTime+"]\nTotal Distance : ["+m.getDistanceTotal()+"]\n");
        System.out.println("["+m.getNbVilleTraitees()+"] city done out of ["+m.getNbVilleTotal()+"]");
       
        // ***** /!\ EN CHANTIER /!\ ***** //
        /* /// LAISSER EN COMMENTAIRE SVP ///
       
        // ***** // [Manuel SuperTSP] // ***** //
        // arg[1] -> Fichier contenant les éléments à traiter [ "/home/world.tsp" ]
        // arg[2] -> Algo [ "proche_voisin" , "loin_voisin" , "random_seed" ]
        // arg[3] -> Ville de début (id) [ "0" , "1" , "2" , ... , "1942574" ]
        // arg[4] -> Désactiver/Acitver d'affichage des résultat [ "dis_scr" , "en_scr" ]
        // exmple :
        // root@anbassot# DoneTsp.txt < SuperTsp ~/tsp/world.tsp proche_voisin 115 en_scr
       
        long startTime = System.currentTimeMillis();
        switch(args[2]){
            case "proche_voisin":
                AlgoProcheVoisin.plusProcheVoisin(m, m.getVille(0));
                break;
            case "loin_voisin":
                AlgoLoinVoisin.AlgoLoinVoisin(m, 0);
                break;
            case "random_seed":
                RandomWithSeed.RandomWithSeed(m, 1001);
                break;
        }
        long endTime = System.currentTimeMillis();
        float totalTime = ((float) (endTime-startTime)) / 1000f;
        RandomWithSeed.RandomWithSeed(m, 1001);
        
        switch(args[4]){
            case "dis_scr":
                break;
            case "en_scr":
                System.out.println("Done after ["+totalTime+"]\nTotal Distance : ["+m.getDistanceTotal()+"]\n");
                System.out.println("["+m.getNbVilleTraitees()+"] city done out of ["+m.getNbVilleTotal()+"]");
                break;
            default:
                // affichage du resultat par défaut ?
                // -> pas pratique si on fait du scripting
                // -> pratique si on exécute qu'une fois
                break;*/
    }
    
}
