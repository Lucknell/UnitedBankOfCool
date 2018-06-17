/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author lucknell
 */
public class Name 
{
 String First,Last;
 
 Name(String F, String L)
 {
     First = F;
     Last  = L;
 }
 
 public String getCustomername()
 {
     return First + " "+ Last;
 }
    
}
