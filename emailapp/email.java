package emailapp;

import java.util.Scanner;

public class email{
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String companysuffix = "company.com";
    private int mailboxCapacity = 500;
    private int defaultPasswordLength=10;
    private String alternateEmail;    

    //constructor to receive fname and lname
    public email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Email Created: " + this.firstName + " " + this.lastName);

        // call a method asking for the department - return the department
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);

        //call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password is: " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +"."+ companysuffix;
      //  System.out.println("Your Email is: " + email);
    }
    //ask for the department
    private String setDepartment(){
        System.out.print("New worker: " + firstName +". DEPARTMENT CODES: \n1 for Sales\n2 for Department\n3 for Accounting\n0 for none\nEnter Department Code: ");
         Scanner in = new Scanner(System.in);
        int depChoice = in. nextInt();
        if (depChoice == 1) {
            in.close();
            return "sales";
        }
        else if (depChoice == 2) {
            in.close();
            return "dev";
        }
        else if(depChoice == 3){
            in.close();
            return "acct";
        }
        else{
            in.close();
            return "";
        }
    }   

    //generate a password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&^*(%)";
        char[] password = new char[length];
        for(int i = 0; i<length; i++){
           int rand = (int)(Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    //set mailboxcapacity
    public void setMailBoxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    //set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //change password
    public void changePassWord(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }
    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + "\n"+
                "COMPANY EMAIL: " + email + "\n"+
                "MAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}