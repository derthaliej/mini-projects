

public class CarLoan {

    /* Original Calculator:
    This program calculates the monthly payment for a car loan.
    First, we calculate the balance left to be paid off after making the down payment on the vehicle. 
    Then we divide the remaining balance by the months of the loan length.
    Then we calculate interest and add it to the principal monthly balance. 
    

    Upgraded Calculator:
    1. Now, customers are able to make payments that are at least the minimum monthly balance, except when 
    they are making their last payment. 
    2. They are also to see how many payments they have left after making each payment.
    3. When they make a successful payment, they receive a message confirmation, and 
    when they try to make a payment lower than the minimum balance before their last payment,
    they recieve an Error message. 
    4. When the balance is finished eing paid off, they will be notified. 
    */
    
    int payment;
    int monthlyPayment; 
    int carLoan;
    int loanLength;
    int interestRate;
    int downPayment;
    int remainingBalance;
    
    /*This method let's people know that they are eligible for a car loan.
    It also lets them know what their monthly payments will be from their 
    remaining balance after putting a down payment on the car. 
    */
    public void CarLoan(int loanAmount, int loanLength, int interestRate, int downPayment) {
      carLoan = loanAmount;
      loanLength = loanLength;
      interestRate = interestRate;
      downPayment = downPayment;
    
      if (loanLength <= 0 || interestRate <= 0) {
          System.out.println("You must take out a valid car loan.");
        } else if (downPayment > loanAmount) {
          System.out.println("The car can be paid in full.");
        }
        else {
          int months = loanLength * 12;
          remainingBalance = loanAmount - downPayment;
          int monthlyBalance = remainingBalance / months;
          int interest = (monthlyBalance * interestRate) / 100;
          monthlyPayment = monthlyBalance + interest;
          System.out.println("Congrats! You are eligible for a car loan and your monthly payment is: $" + monthlyPayment);
          System.out.println("Your starting balance is: $" + remainingBalance);
    
      
    } 
    }
    
    
    //This method allows customers to make a payment.
    public int makePayment (int paymentAmount) {
      payment = paymentAmount; 
    //I want the payment amount to be received when it's less than the minimum balance ONLY if the balance is less than the minimum monthly payment.
    
    if (paymentAmount >= monthlyPayment || remainingBalance < monthlyPayment) {
        
        //I think the problem is here. Remaining balance is not calculated correctly. What should the formula be?
        remainingBalance = remainingBalance - paymentAmount;
      System.out.println("You just made a payment of: $" + paymentAmount);
      System.out.println("Thank you for your payment today!");
    } else {
      System.out.println("Sorry, you can only pay the minimum balance or higher.");
    }
      return remainingBalance;
    
    }
    
    //This method calculates the currently balance after making another monthly payment + mhow many payments you have left based on your minimum balance. 
    //It will also let you know when the loan is paid off. 
    public int currentBalance () {
    
    //I want the balance and payments left to be zero when the balance is finished being paid off. 
      int mostRecentBalance = remainingBalance - payment; 
      int paymentsLeft = mostRecentBalance / monthlyPayment;
      
    //When the balance is finished being paid off, they will be notified.
    if (mostRecentBalance == 0 ) {
      System.out.println("Your current balance is: $0!");
      System.out.println("Congrats! You have finished your car payments!");
    } else {
      System.out.println("Your current balance is: $" + mostRecentBalance);
      
      System.out.println("You have " + paymentsLeft + " payments left.");
    }
    
      return mostRecentBalance;
    
    }
    
    
    //This is the main method.
        public static void main(String[] args) {
    
        CarLoan blake = new CarLoan();
        blake.CarLoan(10000,3,5,2000);
        CarLoan jane = new CarLoan();
        jane.CarLoan(15000,4,3,5000);
    
        blake.makePayment(233);
        blake.currentBalance();
        
    
        jane.makePayment(10000);
        jane.currentBalance();
        }
    
    
    
    

         /*Fixes needed:
        -When Jane tries to pay off her balance completely, her remaining balance 
        becomes zero, and it miscalculates remaining payments and balance. 

        */



        /*Possible future upgrades (How can this program be better?):
        1. Make accounts that will hold their payment records.
        2. Love for it to hold the date of the payment. 
        3. And even upon login, it coudl tell them if they have a payment due that 
        day or not. 

        */
        }



       




    