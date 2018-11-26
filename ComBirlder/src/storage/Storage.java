/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.ArrayList;

/**
 *
 * @author jorgekg3
 */
public class Storage {
    
    private static Storage instance = null;
    
    public ArrayList<String> script = new ArrayList();
    public ArrayList<String> pilha = new ArrayList();
    
    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }
    
}
