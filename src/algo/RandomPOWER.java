/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;

import java.time.Clock;
import java.util.Random;
import model.Monde;
import model.Ville;

/**
 *
 * @author keduminy
 */
public class RandomPOWER {
    
    public static Monde projRandom(Monde m) {
        Monde mOrdre= m;
        mOrdre.tabVille = worldorder(mOrdre);
        mOrdre.setDistanceTotal(calculdistancetotal(mOrdre));
        return mOrdre;
    }
    
    
    
    public static Ville[] worldorder(Monde m){
        int nbVille=m.getNbVilleTotal();
        int i=0;
        Ville[] newOrder = new Ville[nbVille];;
        java.util.Random random = new java.util.Random();
        int y;
               
        while(i<m.getNbVilleTotal()){
            y = random.nextInt(nbVille);
            newOrder[i]=m.tabVille[y];
            m.tabVille[y]=m.tabVille[nbVille-1];
            i++;
            nbVille = nbVille-1;
        }
        return newOrder;
    }
    
    public static float calculdistancetotal(Monde m){
        float dTotal=0;
        int i=0;
        for(i=0;i<(m.getNbVilleTotal()-1);i++){
            dTotal=dTotal + distance2Ville(m.tabVille[i],m.tabVille[i+1]);            
        }
        
        return dTotal;       
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
}
