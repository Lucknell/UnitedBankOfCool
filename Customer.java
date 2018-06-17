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
public class Customer 
{
    Name name;
    Address addr;
    String accNo;
    Customer (Name n, Address addr, String s)
    {
        name = n;
        this.addr= addr;
        accNo = s;
    }
    
    Address getAddress()
    {
        return addr;
    }
    
    Name getName()
    {
        return name;
    }
    
    String getAccountNumber()
    {
        return accNo;
    }
    
    void changeAccountNumber(String s)
    {
        accNo = s;
    }
    
    void changeAddress(Address a)
    {
        addr = a;
    }
    
    void changeName(Name n)
    {
        name=n;
    }
    
    
    
}
