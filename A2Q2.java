/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Tyler McEwen
 *
 * 
 * Program that simulates an ATM machine
 * 
 */
public class ATM {

    /**
     * @param args the command line arguments
     * main method that utilizes the Account class and creates an array of objects
     * and allowing the user to choose between an array of operations on each 
     * account created
     */
    public static void main(String[] args) 
    {
        
        Account[] accounts = new Account[10];
        Scanner input = new Scanner(System.in);
        
        for(int i = 0; i < accounts.length; i++)
        {
            accounts[i] = new Account(i, 100);
        }
        boolean check = false;
        int IdInput = 0;
        
        while(check == false)
        { 
        System.out.print("Please enter a valid account ID: ");
        IdInput = input.nextInt();

        for(int i = 0; i < accounts.length; i++)
        {
            if(IdInput == accounts[i].GetID())
            {
                System.out.println("ID found.");
                check = true;
                break;
            }     
        }
        if(check == false)
            System.out.print("ID does not exist. ");
            
        }
        
        int choice;
        
        do
        {
        menu();
        choice = input.nextInt();
        
        switch(choice)
        {
            case 1:
                System.out.println ("Balance is " + accounts[IdInput].GetBalance());
                break;
            case 2: 
                System.out.print("How much would you like to withdraw? ");
                double amount = input.nextDouble();
                accounts[IdInput].withdraw(amount);
                break;
            case 3:
                System.out.print("How much would you like to deposit? ");
                amount = input.nextDouble();
                accounts[IdInput].deposit(amount);
                break;
            case 4:
                break;
                
        }
        } while(choice != 4);
    }
    
    public static void menu()
    {
        System.out.print("Main menu\n1: Check balance\n2: Withdraw\n"
            + "3: Deposit\n4: Exit\nEnter a choice: ");
    }
}


class Account
    {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated = new Date();
    
    Account()
    {
       
    }
    
    Account(int id, double balance)
    {
        this.id = id;
        this.balance = balance;
    }
    
    public int GetID()
    {
        return this.id;
    }
    
    public double GetBalance()
    {
        return this.balance;
    }
    
    public double GetInterestRate()
    {
        return this.annualInterestRate;
    }
    
    public void SetID(int id)
    {
        this.id = id;
    }
    
    public void SetBalance(double balance)
    {
        this.balance = balance;
    }
    
    public void SetInterestRate(double annualInterestRate)
    {
        this.annualInterestRate = annualInterestRate;
    }
    
    public String GetDateCreated()
    {
        return this.dateCreated.toString();
    }
    
    public double getMonthlyInterestRate()
    {
        return ((annualInterestRate / 12) / 100);
    }
    
    public void withdraw(double amount)
    {
        this.balance = balance - amount;
    }
    
    public void deposit(double amount)
    {
        this.balance = balance + amount;
    }
    }
    
