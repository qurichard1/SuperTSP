/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcheVoisin;

/**
 *
 * @author qurichard1
 */
public class Position {
    String id;
    int longitude;
    int latitude;
    
    public Position(int longi,int lat){
    
        longitude=longi;
        latitude=lat;
        id=String.format("%d%d",longi,lat);
    
    }
    
    
}
