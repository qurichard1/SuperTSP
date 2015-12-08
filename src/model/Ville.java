/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Ville {

    private int numVille;
    private float longitude;
    private float latitude;
    private Boolean visited;

    public Ville(int numVilleValue, float longitudeValue, float latitudeValue) {
        this.setNumVille(numVilleValue);
        this.setLongitude(longitudeValue);
        this.setLatitude(latitudeValue);
        this.setVisited(false);
    }
    
    public int getNumVille(){return numVille;}
    public void setNumVille(int numVilleValue){ numVille = numVilleValue;}
    
    public float getLongitude(){return longitude;}
    public void setLongitude(float longitudeValue){ longitude = longitudeValue;}
    
    public float getLatitude(){return latitude;}
    public void setLatitude(float latitudeValue){latitude = latitudeValue;}
    
    public Boolean isVisited(){return visited;}
    public void setVisited(Boolean visitedValue){visited=visitedValue;}
    public Boolean ChangeVisited(){if(visited==false){return true;}else{return false;}}
    
    @Override
    public String toString(){
        return String.format("%d %.4f %.4f", numVille,longitude,latitude);
    }
    
}
