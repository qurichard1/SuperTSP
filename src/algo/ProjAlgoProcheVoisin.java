/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import model.Monde;
import model.Ville;

/**
 *
 * @author qurichard1
 */
public class ProjAlgoProcheVoisin {
        
    
    public static Monde projAlgoProcheVoisin(Monde m) {
       
        Monde mOrdre=new Monde(m.getNbVilleTotal());
        mOrdre.tabVille=ordre(m);
        return mOrdre;
    }

    
    
    public static float distance2Ville(Ville v1,Ville v2){
        
        float distance,x,xcarre,y,ycarre;
        x=v2.getLongitude()-v1.getLongitude();
        xcarre=x*x;
        y=v2.getLatitude()-v1.getLatitude();
        ycarre=y*y;
        distance= (float) Math.sqrt(xcarre+ycarre);
       return distance;
    }
    
    public static int plusProcheVoisin(Monde m, Ville v1){
        v1.setVisited(Boolean.TRUE);
        int procheVoisin=0,index=0;
        float distance,distMin=0;
        for(Ville v:m.tabVille){
            if(v.getNumVille()!=v1.getNumVille() && v.isVisited()==false){
                distance=distance2Ville(v1, v);
                if(distance>distMin){
                    distMin=distance;
                    procheVoisin=index; 
                } 
            }
            index++;   
        }

        ajouterDistance(m, distMin);
        
        return procheVoisin;        
    }
    
    private static void ajouterDistance(Monde m,float distMin){
       if(distMin!=10000000){
            m.addDistanceTotal(distMin);
        } 
    }
      
    public static int rechercherVille(Ville[] tab, int id){        
        int index=0;      
        for(Ville v:tab){            
            if(v!=null){
                if(v.getNumVille()==id /*||index==tab.length*/){
                   break;
                }            
                else{
                    index++;
                }
            }
        }
        return index;
    }
    
    
    public static Ville[] ordre(Monde m) {
        
        int nbVille=m.getNbVilleTotal(),y=0;
        
        Ville[] newOrder=new Ville[nbVille];
        
        int indexVilleATraite=0,i=0;
        
        while(m.getNbVilleTraitees()<nbVille){
            try {
                pourcentage(y, nbVille);
            } catch (IOException e) {
                }

            
            newOrder[i]=m.tabVille[indexVilleATraite];
            
            i++;
            m.tabVille[indexVilleATraite].setVisited(Boolean.TRUE);
            m.addNbVilleTraitees();
            indexVilleATraite= plusProcheVoisin(m, m.tabVille[indexVilleATraite]);
            y++;
            
        }
        

        
        System.out.println("Distance Totale: "+m.getDistanceTotal());
        
        
        
        return newOrder;
    }
    
    public static void pourcentage(int a, int total) throws IOException{
        float pourcent,cast,modulo;
        modulo=a%100;
        if(modulo==1){
            pourcent=(float)a*100/total;
            DecimalFormat df = new DecimalFormat("0.000");
            df.setRoundingMode(RoundingMode.DOWN);
            String value = df.format(pourcent);
            System.out.println("pourcentage: "+value+"%");   
        } 
    }
    
}
