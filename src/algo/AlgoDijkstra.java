package algo;

import model.Monde;

public class AlgoDijkstra {
    
    public static Monde AlgoDijkstra(Monde monde, int IDVilleDebut){
        
        int IDVilleFin = VillePlusEloignee(IDVilleDebut);
        
        while(monde.getNbVilleTraitees()<monde.getNbVilleTotal()){
            monde = DijkstraSurDeuxVilles(monde, IDVilleDebut, IDVilleFin);
            IDVilleDebut = IDVilleFin;
            IDVilleFin = VillePlusEloignee(IDVilleDebut);
        }
        
        return monde;
    };
    
    private static int VillePlusEloignee(int IDVilleDebut){
        int villeEloignee = 0;
        return villeEloignee;
    }
    
    private static Monde DijkstraSurDeuxVilles(Monde world, int IDVilleDebut, int IDVilleFin){
        
        return world;
    }
    
}
