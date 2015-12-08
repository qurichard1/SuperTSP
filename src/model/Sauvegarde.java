/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Utilisateur
 */
public class Sauvegarde {
    
    public static void sauv(Monde m){
        
        File f = new File ("villeTrie.txt");
        try
        {
            FileWriter fw = new FileWriter (f);
            fw.write("DIMENSION : "+m.tabVille.length);
            for (Ville v : m.tabVille)
            {
                    fw.write ("\r\n");
                    fw.write (v.toString().replace(",","."));
                    
            }
            fw.close();
        }
        catch (IOException e)
        {
            System.out.println ("Erreur lors de la sauvegarde : " + e.getMessage());
        }
        
    }
    
    
}
