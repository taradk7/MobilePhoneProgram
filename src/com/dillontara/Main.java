package com.dillontara;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("123-456-7890");

    public static void main(String[] args) {

       boolean quit = false;
       startphone();
       printActions();
       while(!quit){
           System.out.println("\nEnter action: (6 to show available actions)");
           int action = scanner.nextInt();
           scanner.nextLine();

           switch (action){
               case 0:
                   System.out.println("\nShutting Down...");
                   quit = true;
                   break;
               case 1:
                   printContacts();
                   break;
               case 2:
                   addNewContact();
                   break;
               case 3:
                   updateContact();
                   break;
               case 4:
                   removeContact();
                   break;
               case 5:
                   queryContact();
                   break;
               case 6:
                   printActions();
                   break;



           }





       }


    }

    private static void printContacts(){
        mobilePhone.printContacts();
    }

    private static void addNewContact(){
        System.out.println("Enter New Contact Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Contact Phone Number");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact " + name + " added.\n" +
                    "name: " + name + "\nphone: " + phone);
        }
        else {
            System.out.println("Contact" + name + ", is already on file.");
        }
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact was not found");
            return;
        }

        System.out.println("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("Successfully updated contact.");
        }
        else{
            System.out.println("Error updating record");
        }

    }

    private static void removeContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact was not found");
            return;
        }

        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Contact successfully deleted");
        }
        else{
            System.out.println("Error. Contact not removed.");
        }
    }

    private static void queryContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact was not found");
            return;
        }

        System.out.println("Name: " + existingContactRecord.getContactName() + "\nPhone Number: " +
                existingContactRecord.getPhoneNumber());
    }


    private static void startphone(){
        System.out.println("Starting mobile phone...");
    }

    private static void printActions(){
        System.out.println("\nPress a number for specific action:\n");
        System.out.println("0 - to Shutdown Application\n" +
                           "1 - to Print Contacts\n" +
                           "2 - to Add a New Contact\n" +
                           "3 - to Update an Existing Contact\n" +
                           "4 - to Remove a Contact\n" +
                           "5 - to Query if a Contact Exists\n" +
                           "6 - to Print Options Menu");


    }


}
