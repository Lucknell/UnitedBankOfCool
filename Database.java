/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;

/**
 *
 * @author lucknell
 */

public class Database 
{
    boolean found;
    Bank ba,b;
    int index;
    
    ArrayList <Bank> list;
    //ArrayList <Bank> list2;
    Database()
    {
        list = new ArrayList <Bank>();
       // list2 = new ArrayList <Bank>();
    }
    boolean inList(String key2)
    {
        
        found = false;
        int length = list.size(),i =0;
        while (i<length && !found)
        {
            Bank b = list.get(i);
            if (b.getCustomer().getAccountNumber().equalsIgnoreCase(key2))
            {
                ba = b;
                index = i;
                found = true;
            }
            else
            {
                i++;
            }
        
    }
        return found;
    }
    Bank getBankAccount()
    {
        return ba;
    }
    int getIndex()
    {
        return index;
    }
    void add( Bank b )
    {
        list.add( b );
    }
    void search(String key)
    {
        found = false;
        int length = list.size(),i =0;
        while (i<length && !found)
        {
            Bank b = list.get(i);
            if (b.getCustomer().getAccountNumber().equalsIgnoreCase(key))
            {
                ba = b;
                index = i;
                found = true;
            }
            else
            {
                i++;
            }
        }
        
    }
    void remove (Bank b)
    {
     list.remove(b);
    }
    String printaccounts()
    {
        String stuff = null;
        for (int i=0; i<list.size();i++ )
        {
          stuff = stuff + list.get(i);  
        }
        return stuff;
    }
}
