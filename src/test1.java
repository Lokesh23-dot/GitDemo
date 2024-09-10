import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class test1 {
	
	// count the number of names starting with alphabets "a".
	//@Test()
	public void count()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("ashok");
		names.add("akash");
		names.add("raj");
		names.add("abishek");
		names.add("kumar");
		int count =0;
		
		for(int i=0; i<names.size();i++)
		{
			String actual =names.get(i);
			if(actual.startsWith("a"))
			{
				count++;
			}
		}
		System.out.println("The total number of names starts with a is: " +count );
	}
	
	@Test(enabled=false)
	public void streams()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("ashok");
		names.add("akash");
		names.add("raj");
		names.add("abishek");
		names.add("kumar");
		
		// notes:
		// The indermediate operations will not work if there is no terminal opeation followed by.
		//The terminal opeartions will when intermediate operations(filter) returns true.
		long c = names.stream().filter(s->s.startsWith("a")).count();
		System.out.println(c);
		
		// To create a stream:
		long d=Stream.of("ashok","akash","raj","abishek","kumar").filter(s->s.startsWith("k")).count();
		
		System.out.println(d);
		
		// print all the names whose length is greater than 4 in arraylist.
		System.out.println(" names whose length is greater than 4 :");
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		// print only one name whose length is greater than 4 in arraylist.
		System.out.println("one name whose length is greater than 4 :");
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	@Test
	public void StreamMap()
	{
		// print the names that ends with "k" and convert them to uppercase:
		
				System.out.println("names that ends with k and convert them to uppercase");
				Stream.of("ashok","akash","raj","abishek","kumar").filter(s->s.endsWith("k")).map(s->s.toUpperCase())
				.forEach(s->System.out.println(s));
				
				// print the names that starts with "a" and convert it to upper case and sort it.
				
				System.out.println("names that starts with a and convert it to upper case and sort it: ");
				Stream.of("abi","kumar","abishek","dilip","lokesh","abibhav","dhanush","ashok")
				.filter(s->s.startsWith("a")).map(s->s.toUpperCase()).sorted()
				.forEach(s->System.out.println(s));
				
				// merging two different Arraylist and sorting them.
				ArrayList<String>fruits= new ArrayList<String>();
				fruits.add("apple");
				fruits.add("orange");
				fruits.add("grapes");
				
				ArrayList<String>vegetables= new ArrayList<String>();
				fruits.add("carrot");
				fruits.add("beans");
				fruits.add("mushroom");
				
			Stream<String> newStream = Stream.concat(fruits.stream(), vegetables.stream());
			newStream.sorted().forEach(s->System.out.println(s));
			
			// To check wheater grapes is present inside the stream.
			//note: anymatch method is used to check any value is present in stream.
			Stream<String> newStream2=Stream.concat(fruits.stream(), vegetables.stream());
			boolean result = newStream2.anyMatch(s->s.equalsIgnoreCase("grapes"));
			System.out.println(result);
	}
	
	
	public void demochange()
	{
		System.out.println("firstchange after cloning");
	}
	

}
