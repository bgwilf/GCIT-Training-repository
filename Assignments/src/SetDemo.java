import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SetDemo {

  public static void main( String [] args ) {

    // Create a set called mySet
    Set mySet = new HashSet();

    // Ensure that this set contains an interesting selection of fruit 
    String fruit1 = "pear", fruit2 = "banana", fruit3 = "tangerine",
                            fruit4 = "strawberry", fruit5 = "blackberry";
    mySet.add( fruit1 );
    mySet.add( fruit2 );
    mySet.add( fruit3 );
    mySet.add( fruit2 );
    mySet.add( fruit4 );
    mySet.add( fruit5 );

    // Display contents of mySet
    System.out.println( "mySet now contains:" );
    System.out.println( mySet );
    
    System.out.println("Cardinality of mySet: " + mySet.size() );
    
    mySet.remove(fruit5);
    mySet.remove(fruit4);
    
    System.out.println("\nAfter removal of blackberry, strawberry:");
    System.out.println( mySet );
    
    System.out.println("After removal of all fruits");
    mySet.removeAll(mySet);
    System.out.println("mySet is empty? "+ mySet.isEmpty());
    
   /******************************************************
    *                       Part 2
    ******************************************************/
    System.out.println("\n          Part2           ");
    List myList = new ArrayList();
    
    myList.add(fruit1);		myList.add(fruit2);
    myList.add(fruit3); 	myList.add(fruit4);
    myList.add(fruit5);
  
    //System.out.println(myList);
    ListIterator<String> itr = myList.listIterator();
    System.out.print("\nOrder of Insertion: ");
    while (itr.hasNext()){
    	System.out.print(itr.next()+ " ");
    }
    System.out.println();
    
    System.out.print("\n Reverse Order: ");
    while(itr.hasPrevious() ){
    	System.out.print(itr.previous()+" ");
    	}
    System.out.println();
    
    myList.add(3, fruit2);
    System.out.println("\n Content of myList after 2nd insertion");
    System.out.println(myList);
    
    /******************************************************
     *                       Part 3
     ******************************************************/
     System.out.println("\nPart3: File Processing Program          ");
    
     List<Student> stdList= new ArrayList<Student>();
     
     
     Scanner sc = new Scanner(System.in); 
     System.out.print(" Please enter file name--->");
     String myFile= sc.nextLine();
     
     System.out.println("Thanks!");
     //System.out.println();
     
		     try{ 	Scanner reader = new Scanner(new File(myFile));
		         	while ( reader.hasNextLine() )
		               {   
		                  String tempLine ="" + reader.nextLine();
		                  Scanner tokenReader = new Scanner(tempLine);
		                  tokenReader.useDelimiter(" ");
		
		                  while ( tokenReader.hasNext()  )
		                   {
		                	   Student std = new Student();
		                	   std.setName(tokenReader.next());
		                	   std.setMark(tokenReader.nextInt());
		                       stdList.add(std);
		                   }
		                
		               }
		         	System.out.println("\nReading completed!");
		         	System.out.println("List contain : "+stdList.toString());
		         	}	
		       catch(FileNotFoundException e){
		       System.out.println(" File not located- Please check directory");
		       }
		     
		     System.out.println("Alphabetic Ordering: ");
		     List<Student> alphaOrder= new ArrayList<Student>();
		     for(int i=0; i< stdList.size(); i++)
		     {
		    	// if (stdList.get(i).getName().equalsIgnoreCase(anotherString))
		    	 
		     }
		     
		     System.out.println("by order of Merit: ");
		     
		     
		     System.out.println("Number of Students: "+ stdList.size());
		     System.out.println("Average Student mark: ");
		     System.out.println(" standard deviation:");
  
  	}// Main
  }//set Demo
