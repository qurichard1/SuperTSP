package algo;

import model.Monde;
import model.Ville;

public class AlgoLoinVoisin {
    
    public static Monde AlgoLoinVoisin(Monde monde, int IDVilleDebut){
            System.out.println("\nJe suis le lapin de feu\n");
        float distTmp, cmp = 0;
        int IDVilleFin = VillePlusEloignee(monde, IDVilleDebut);
        while(monde.getNbVilleTraitees()<monde.getNbVilleTotal()){
            monde.getVille(IDVilleFin).ChangeVisited();
            distTmp = distance2Ville(monde.getVille(IDVilleDebut),monde.getVille(IDVilleFin));
            monde = settings(monde);
            affichagePourcent(monde, cmp);
            monde.addNbVilleTraitees();
            monde.addDistanceTotal(distTmp);
            IDVilleDebut = IDVilleFin;
            IDVilleFin = VillePlusEloignee(monde, IDVilleDebut);
        }
        return monde;
    }
    
    private static int VillePlusEloignee(Monde monde, int IDVilleDebut){
        int IDvilleEloignee = -1;
        float PlusGrandeDistance = 0;
        for(Ville curentVille:monde.getTabVille()){
            if(curentVille.isVisited()==false){
                    if(distance2Ville(curentVille, monde.getVille(IDVilleDebut))>PlusGrandeDistance){ 
                    PlusGrandeDistance=distance2Ville(curentVille, monde.getVille(IDVilleDebut));
                    IDvilleEloignee = curentVille.getNumVille();
                    }
                }
            }
        return IDvilleEloignee-1;
        }
    
    
    private static float distance2Ville(Ville v1,Ville v2){
        return (float) Math.sqrt(
                v2.getLongitude()-v1.getLongitude()
                *v2.getLongitude()-v1.getLongitude()
                +v2.getLatitude()-v1.getLatitude()
                *v2.getLatitude()-v1.getLatitude());
    }

    private static Monde settings(Monde monde) {
        
        return monde;
    }

    private static void affichagePourcent(Monde monde, float cmp) { 
        cmp = (float)monde.getNbVilleTraitees()*(float)100/(float)monde.getNbVilleTotal();
        System.out.println("\n\n\n\n\n>>> [" + cmp + "%] <<<  >>>"+monde.getNbVilleTraitees()+"<<<");
        System.out.print("Execution advencement ::: ");
        for(int i=1;i<cmp/10;i++){
            System.out.print("*");
        }
        for(int i=10;i>cmp/10;i--){
            System.out.print("-");
        }
        System.out.print(" :::\n");
    }
    
}
