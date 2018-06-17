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
public class Bank 
{
  Customer c;
  double balance;
  Bank(Customer c, double b)
  {
      this.c = c;
      balance = b;
  }
  void deposit (double amt)
  {
      balance = balance + amt;
  }
  void withdraw (double amt)
  {
      balance = balance -amt;
  }
  boolean isSuffieient(double amt)
  {
      return balance>=amt;
  }
  Customer getCustomer()
  {
      return c;
  }
  double getBalance()
  {
      return balance;
  }
  public String toBalString()
    {
        return "" +balance;  
    }
  }        
