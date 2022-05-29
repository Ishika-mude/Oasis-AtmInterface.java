package atminterface;

import java.util.Scanner;

class BankAccount{
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 100000f;
    int transactions = 0;
    String transactionHistory = "";
    boolean isFinished;
    
    public void register(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name - ");
        this.name = sc.nextLine();
        System.out.print("\nEnter Your Userame - ");
        this.userName = sc.nextLine();
        System.out.print("\nEnter Your Password - ");
        this.password = sc.nextLine();
        System.out.print("\nEnter Your Account Number - ");
        this.accountNo = sc.nextLine();
        System.out.print("\nRegisteration Completed! Kindly login your account ");
    }
    public boolean login(){
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while(!isLogin){
          System.out.print("\nEnter Your Userame - ");
          String Username = sc.nextLine();
          if(Username.equals(userName)){
              while(!isLogin){
                 System.out.print("\nEnter Your Password - ");
                 String Password = sc.nextLine(); 
                 if(Password.equals(password)){
                   System.out.print("\nLogin Successful !!!"); 
                   isLogin = true;
                 }
                 else{
                     System.out.println("\nIncorrect Password");
                 }
              }
          }
          else{
              System.out.println("\nUserame not found");
          }
        }
        return isLogin;
    }
    
    public void withdraw(){
        System.out.print("\nEnter amount to Withdraw - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(balance >= amount){
                transactions++;
                balance -= amount;
                System.out.println("\nWithdraw Successful !!!");
                String str = amount + "Rs Withdrawed\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else{
                System.out.println("\nInsufficient Balance");
            }
        }
        catch(Exception e){
        }
    }
    
    public void deposit(){
        System.out.print("\nEnter amount to Deposit - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(amount <= 100000f ){
                transactions++;
                balance += amount;
                System.out.println("\nSuccessfully Deposited !!!");
                String str = amount + "Rs Deposited\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else{
                System.out.println("\nSorry ...Limit Exceeded");
            }
        }
        catch(Exception e){
        }
    }
    
    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Receipent's Name - ");
        String receipent = sc.nextLine();
        System.out.print("\nEnter amount to Transfer - ");
        float amount = sc.nextFloat();
        try{
            if(balance >= amount){
            if(amount <= 500000f ){
                transactions++;
                balance -= amount;
                System.out.println("\nSuccessfully Transfered to " + receipent);
                String str = amount + "Rs Transfered to\n" + receipent + "\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else{
                System.out.println("\nSorry ...Limit Exceeded");
            }
        }
        else{
                System.out.println("\nInsufficient Balance");
        }
        
    }
        catch(Exception e){
        }
}
    public void checkBalance(){
        System.out.println("\n" + balance + "Rs");
    }
    
    public void transHistory(){
        if(transactions == 0){
        System.out.println("\nEmpty");
        }
        else{
                System.out.println("\n" + transactionHistory);
        }
    }
}

public class AtmInterface {

    public static int takeIntegerInput(int limit){
        int input = 0;
        boolean flag = false;
        
        while(!flag){
            try{
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                
                if(flag && input > limit || input < 1){
                    System.out.println("Choose the number 1 to " + limit);
                    flag = false;
                }
            }
            catch(Exception e){
                System.out.println("Enter only Integer value");
                flag = false;
            }
        };
        return input;
    }
    
    public static void main(String[] args) {
        
        System.out.println("\n*****WELCOME TO ATM SYSTEM*****");
        System.out.println("1.Register \n2.Exit");
        System.out.println("Enter your choice - ");
        int choice = takeIntegerInput(2);
        
        if(choice == 1){
            BankAccount b = new BankAccount();
            b.register();
            while(true){
                System.out.println("1.Login \n2.Exit");
                System.out.println("Enter your choice - ");
                int ch = takeIntegerInput(2);
                if(ch == 1){
                    if(b.login()){
                        System.out.println("\n\n*****WELCOME BACK*****" + b.name + "*****\n");
                        boolean isFinished = false;
                        while(!isFinished){
                            System.out.println("1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction history \n6.Finished");
                            System.out.println("Enter your choice - ");
                            int c = takeIntegerInput(6);
                            switch(c){
                                case 1:
                                b.withdraw();
                                case 2:
                                b.deposit();
                                case 3:
                                b.transfer();
                                case 4:
                                b.checkBalance();
                                case 5:
                                b.transHistory();
                                case 6:
                                b.isFinished = true;
                            }
                        }
                    }
                }
                else{
                    System.exit(0);
                }
            }
        }
        else{
            System.exit(0);
        }
    }
    
}
