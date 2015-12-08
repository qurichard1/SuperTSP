/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;

import model.Monde;
import model.Ville;

/**
 *
 * @author keduminy
 */
public class FakeRandom {
   
    public static Monde projRandom(Monde m, int number){
        Monde mOrdre = m;
        mOrdre.tabVille = worldorder(m, number);
        mOrdre.setDistanceTotal(calculdistancetotal(mOrdre));
        return mOrdre;
    }
    
    
    
    public static Ville[] worldorder(Monde m, int number){
        int nbVille=m.getNbVilleTotal();
        int i=0;
        int numbers = nbVille + number;
        int y;
        Ville[] newOrder = new Ville[nbVille];;
        
        /*int test=0;
        int cpttest;*/
        
        
        y = (i*numbers*369)%nbVille;
            
        while(i<m.getNbVilleTotal()){
            if(y<0){
                y = -y;
            }
            if(!m.tabVille[y].isVisited()){
                newOrder[i]=m.tabVille[y];
                i++;
                y = (i*numbers*369)%(nbVille);
            }else{
                y = y+1;               
            }            
        }
        
        /*for(cpttest=0;cpttest<(m.getNbVilleTotal()-1);cpttest++){
            if(newOrder[cpttest].getNumVille()= 13553252 ){
                test= test+1;
            }
        }
        System.out.println(test);*/
        
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