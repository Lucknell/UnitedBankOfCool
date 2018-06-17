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
public class Address
{
 String street;
 String city;
 String state;
 String zip;
 
 Address(String Str, String city, String state,String zip)
 {
     street = Str;
     this.city = city;
     this.state = state;
 this.zip = zip;
 }
         
 public String getAddressString()
 {
     return street+ "\n"+ city +"\n" + state+ "\n"+zip;
 }
    
}
