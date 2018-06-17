/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author lucknell
 */
public class Banktester {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database db = new Database();
        Database close = new Database();
        String bankinfo, s ="blank for testing";
        boolean done = false;
        //JTextArea text  = new JTextArea(s,10,20);
        //JScrollPane pane = new JScrollPane(text);
        
        while (!done)
        {
             String menu = ("       United Bank of Cool \n" +
                    "\n Please Choose from the following:" + "\n1.Create"
                    + " New Account\n2. Update Existing Account "
                    + "\n3. Close an Account\n4. View Account Information\n5."
                    + " Exit");
        //JTextArea text  = new JTextArea(menu,10,20);
        //JScrollPane pane = new JScrollPane(text);
        //JOptionPane.showInputDialog(pane);
             int num = GetData.getInt(menu);
            switch (num)
            {
                case 1: String first = GetData.getString("First name?\n");
                        String last = GetData.getString("Last name?");
                        Name cust = new Name(first,last);
                        String street = GetData.getString("Enter Address?");
                        String city = GetData.getString("Enter City?");
                        String state = GetData.getString("Enter State?");
                        String zip = GetData.getString("Enter Zipcode?");
                        Address addr = new Address(street,city, state,zip);
                        String accNo = GetData.getString("Account Number");
                        Customer guy = new Customer (cust,addr,accNo);
                        double startbal = GetData.getDouble("What is the initial "
                                + "deposit?");
                        Bank b = new Bank(guy,startbal);
                        db.add(b);
                        JOptionPane.showMessageDialog(null, "You made an"
                                + " account!","Congrats!" , 1);
                break;
                case 2:String op =JOptionPane.showInputDialog("What is your account"
                                + " number?");
                        
                        db.search(op);
                        if(db.inList(op)){
                        Bank d = db.getBankAccount();
                        int opt = GetData.getInt("What would you like to do?"
                                + "\n1. Withdrawl\n2. Deposit\n3. Exit");
                        switch(opt)
                        {
                            case 1: double withdr = GetData.getDouble("How much"
                                    + "are you taking out?");
                                if (d.isSuffieient(withdr))
                                {
                                d.withdraw(withdr);
                                }
                                else
                                {
                                     JOptionPane.showMessageDialog(null, ""
                                             + "You do not have enough" 
                                             + "", "Error" ,0);
                                }
                                break;
                            case 2: Double Depos = GetData.getDouble("How much"
                                    + " are you depositing ?");
                                d.deposit(Depos);
                                break;
                            case 3: 
                        }
                    }
                        else
                        {
                             JOptionPane.showMessageDialog(null, "You don't "
                                     + "have an account", "Error" ,0);
                        }
                break;
                case 3: String del =JOptionPane.showInputDialog("What is your account"
                                + " number?");
                        
                        db.search(del);
                        Bank bye = db.getBankAccount();
                        close.add(bye);
                        db.remove(bye);
                        JOptionPane.showMessageDialog(null, ""
                                             + "Account removed." 
                                             + "", "Until we meet again!" ,0);
                        
                break;
                case 4: //JTextArea text2  = new JTextArea(menu,10,20);
                        //JScrollPane pane2 = new JScrollPane(text2);
                        //JOptionPane.showInputDialog(pane2);
                    int view =GetData.getInt("What information would you like to "
                        + "view?\n1. Single account\n2. All active accounts\n3."
                        + " All inactive accounts\n");
                    switch(view)
                    {
                        case 1: String op3 =JOptionPane.showInputDialog("What"
                                + " is your account number?");
                       db.search(op3);
                        if (db.inList(op3))
                        {
                        Bank e = db.getBankAccount();
                        String acc = e.getCustomer().getName()
                                .getCustomername();
                        String addre = e.getCustomer().getAddress()
                                .getAddressString();
                        String ym = e.toBalString();
                        
                        String finale = " Name: " + acc +"\n"+" Address: "
                                +addre +"\n"+ "Current Balance: " + ym;
                        JTextArea text2  = new JTextArea(finale,10,20);
                        JScrollPane pane2 = new JScrollPane(text2);
                        JOptionPane.showInputDialog(pane2);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "You don't have"
                                    + " an account", "Error" ,0);    
                        }
                        break;
                        case 2:
                        String openacc = "";
                        for (int z =0; z<db.list.size();z++)    
                        {
                            Bank f = db.list.get(z);
                            String oacc = f.getCustomer().getName()
                                    .getCustomername();
                            String oaddre = f.getCustomer().getAddress()
                                    .getAddressString();
                            String oym = f.toBalString();
                            openacc = openacc + "\n" +"Name: "+ oacc +"\n"+
                                    "Address: "+oaddre+"\n"+"Current Balance:"
                                    +oym;
                        }
                        JTextArea text3  = new JTextArea(openacc,10,20);
                        JScrollPane pane3 = new JScrollPane(text3);
                        JOptionPane.showInputDialog(pane3);
                        
                        break;
                        case 3:
                         String closeacc = "";
                        for (int x =0; x<close.list.size();x++)    
                        {
                            Bank f = close.list.get(x);
                            String cacc = f.getCustomer().getName()
                                    .getCustomername();
                            String caddre = f.getCustomer().getAddress()
                                    .getAddressString();
                            String cym = f.toBalString();
                            closeacc = closeacc + "\n" +"Name: "+ cacc +"\n"+
                                    "Address: "+ caddre+"\n"+"Closed Balance"
                                    +cym;
                        }    
                        JTextArea text4  = new JTextArea(closeacc,10,20);
                        JScrollPane pane4 = new JScrollPane(text4);
                        JOptionPane.showInputDialog(pane4);
                        break;
                        
                        default: JOptionPane.showMessageDialog(null, "Invalid"
                                + "", "Error" ,0);
                        break;      
                    }
                break;
                case 5: 
                    done = true;
                break;
                    
                default:JOptionPane.showMessageDialog(null, "Invalid"
                                + " Option", "Error" ,0);
                break;    
            }
        }
    }
    
}
