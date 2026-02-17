import java.util.*;
 class Payments 
{   
	static Scanner sc=new Scanner(System.in);
	static double pay;
	
	static void processPayments(double totalPrice ) 
	{
		pay=totalPrice;
		System.out.println("Select payment options");
		System.out.println("1.PhonePe");
		System.out.println("2.Googlepay");
		System.out.println("3.Paytm");
		System.out.println("4.Net Banking");
		int n=sc.nextInt();
		if(n==1)
		{
			System.out.println("You have selected the payment option through PhonePe ");
			 try 
		     {
                 PhonePe.amountPayment(); // Call the method that may throw InterruptedException
             } 
			 catch (InterruptedException e) 
			{
              System.out.println("Payment process was interrupted. Please try again.");
            }
		}
		else if(n==2)
		{
			System.out.println("You have selected the payment option through GooglePay ");
			 try 
		     {
                 GooglePay.amountPayment(); // Call the method that may throw InterruptedException
             } 
			 catch (InterruptedException e) 
			{
              System.out.println("Payment process was interrupted. Please try again.");
            }
		}
		else if(n==3)
		{
		   System.out.println("You have selected the payment option through Paytm ");
		}
		else if(n==4)
		{
		  System.out.println("You have selected the payment option through NetBanking ");
		}
		else
		{
			System.out.println("You have not selected any of the payment process...");
			System.out.println("Select any one of the payment process..");
			processPayments(totalPrice);
			
		}
	}

	 class PhonePe 
	{
        //static Phonepe pp=new Phonepe();
        static double balance=10000;
		static long phonePePin=852416;
		
		static void number() throws InterruptedException
		{
			System.out.print("Enter the mobile number:");
			String num=sc.next();
			if(num.length()==10 && num.charAt(0)!='0'&&num.charAt(0)!='1'&&num.charAt(0)!='2'&&num.charAt(0)!='3'&&num.charAt(0)!='4'&&num.charAt(0)!='5')
		    {
			   System.out.println(" Entered mobile number is correct ");
			   System.out.println("Enter the amount to process the payment");
			   PhonePe.amountPayment();
			}
		   else
		   {
			  System.out.println("Entered Mobile Number is In-correct ");
			  number();
		   }
	    }
       public static void pin() throws InterruptedException
		{
           System.out.println(" Enter 6-digit UPI pin ");
			long l=sc.nextLong();
			if(l==phonePePin){
			}
			else
			{	System.out.println("Incorrect UPI pin  please re-enter it");
				pin();
			}
	    } 
	    static void amountPayment() throws InterruptedException 
	    {
            System.out.print("Enter the amount to process the payment: ");
            double a = sc.nextDouble();
            if (a > balance) 
			{
                System.out.println("Insufficient balance! Please add funds to your account.");
                addBalance();
                return;
            }
          if (a == pay) 
	       {
             pin();
			 Thread.sleep(2000);
			 System.out.println("*****Processing the payment..Pls wait...************");
			 Thread.sleep(3000);
			 System.out.println("Payment is done...");
			 balance -= a; // Deduct the amount from balance
            addBalance(); // Display the remaining balance
		   } 
			else 
			{
                System.out.println("Incorrect amount is sentered. Please try again.");
                amountPayment();
            }
		 }
		 static void addBalance() 
		{
            System.out.println("Your current balance is: " + balance);
		}
       

   }

 class GooglePay 
	{
       
        static double balance=10000;
		static long googlePayPin=852416;
		
		static void number() throws InterruptedException
		{
			System.out.print("Enter the mobile number:");
			String num=sc.next();
			if(num.length()==10 && num.charAt(0)!='0'&&num.charAt(0)!='1'&&num.charAt(0)!='2'&&num.charAt(0)!='3'&&num.charAt(0)!='4'&&num.charAt(0)!='5')
		    {
			   System.out.println(" Entered mobile number is correct ");
			   System.out.println("Enter the amount to process the payment");
			   PhonePe.amountPayment();
			}
		   else
		   {
			  System.out.println("Entered Mobile Number is In-correct ");
			  number();
		   }
	    }
       public static void pin() throws InterruptedException
		{
           System.out.println(" Enter 6-digit UPI pin ");
			long l=sc.nextLong();
			if(l==googlePayPin){
			}
			else
			{	System.out.println("Incorrect UPI pin  please re-enter it");
				pin();
			}
	    } 
	    static void amountPayment() throws InterruptedException 
	    {
            System.out.print("Enter the amount to process the payment: ");
            double a = sc.nextDouble();
            if (a > balance) 
			{
                System.out.println("Insufficient balance! Please add funds to your account.");
                addBalance();
                return;
            }
          if (a == pay) 
	       {
             pin();
			 Thread.sleep(2000);
			 System.out.println("*****Processing the payment..Pls wait...");
			 Thread.sleep(3000);
			 System.out.println("Payment is done...");
			 balance -= a; // Deduct the amount from balance
            addBalance(); // Display the remaining balance
		   } 
			else 
			{
                System.out.println("Incorrect amount is sentered. Please try again.");
                amountPayment();
            }
		 }
		 static void addBalance() 
		{
            System.out.println("Your current balance is: " + balance);
		}
       

   }
} 