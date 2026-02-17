import java.util.*;
class  Alphanumeric
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a string:");
		String s=sc.next();
		//String str=s.replaceAll("[0-9]","");
		//System.out.println(str);
		StringBuilder alphabets=new StringBuilder();
		StringBuilder digits=new StringBuilder();
		StringBuilder symbols=new StringBuilder();

		for(char ch:s.toCharArray())
		{
			if(Character.isLetter(ch))
			{
				alphabets.append(ch);
			}
			else if(Character.isDigit(ch))
			{
                 digits.append(ch);
			}
			else
			{
                symbols.append(ch);
			}
		}
		System.out.println("alphabets: "+alphabets);
		System.out.println("digits: "+digits);
		System.out.println("symbols: "+symbols);
               

	}
}
