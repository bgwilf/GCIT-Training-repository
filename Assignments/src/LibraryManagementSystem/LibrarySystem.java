package LibraryManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * LibrarySystem.java -------> Library Management System
 * @author Gilles W Bassole <gilles_bassole@gcitsolutions.com>
 * created on June 25, 2015
 *
 */
public class LibrarySystem {

	public static void main(String[] args) 
	{

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			Statement stmt =conn.createStatement();
			String selectQuery= "select * from tbl_author where authorName= ?";
		
			PreparedStatement pstmt= conn.prepareStatement(selectQuery);
			pstmt.setString(1, "Author");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				System.out.println("Author ID: " +rs.getInt("authorId"));
				System.out.println("Author Name: " +rs.getString("authorName"));
				System.out.println("-----------------------------");
			}
			
			/*Scanner scan = new Scanner(System.in);
			System.out.println("Enter a new Author: ");
			String authorName = scan.nextLine();

			String createQuery = "insert into tbl_author (authorName) values('" +authorName+"')";

			stmt.executeUpdate(createQuery);*/
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		boolean flag=true, check= true;
		
		while(check)
		{
			
			System.out.println("Welcome to  GCIT Library Management System. \n"
							 + "Which Category of user are you?");
			System.out.println("\n 1) Librarian"
							  +"\n 2) Administrator"
							  +"\n 3) Borrower");
			System.out.println("\n<Take input>");

			Scanner sc = new Scanner(System.in);
			int select=sc.nextInt();

			switch(select)
			{
			case 1: System.out.println("***LIBRARIAN MENU***\n");
					
					do{
						System.out.println("1) Enter Branch you Manage\n"
										 + "2) Quit to previous");		
						System.out.println("<take input>");
						int select1 =sc.nextInt();

						if (select1==1)
						{
							while(check){
								
							/*System.out.println("1) University Library, Boston \n"
											+ "2) State Library, New York \n"
											+ "3) Federal Library, Washington DC \n"
											+ "4) County Library, McLean VA\n"
											+ "5) Quit to previous"); */	
							System.out.println("<Take input>");  
							
							int select2 = sc.nextInt();
			
							if(select2 >=1 && select2 <= 4)
							{
								check=true;
								while(check)
								{
									System.out.println("1) Update the details of the Library \n"
													+ "2) Add copies of the book to the branch \n"
													+ "3) Quit to previous");				
									System.out.println("<Take input>");
									int select3 =sc.nextInt();

									if (select3 ==1)
									{
										check=false; // insure quit to cancel option
						
										//todo details update of library
										System.out.println("You have chosen to update the Branch with Branch Id: "
												+ "X and Branch Name: ABCD. Enter ‘quit’ at any prompt to cancel operation");

										System.out.print("Please enter new branch name or enter N/A for no change:<take input>");
										//scanner reading input from user

										System.out.println("Please enter new branch address or enter N/A for no change <take input>");
										// possible user input

									}
									else if(select3==2)
									{
										//to do copies addition
										check=false;
										System.out.println("Pick the book you want to add copies of, to your branch :");
										System.out.println("1) The Lost tribe by Sydney Sheldon\n"
														+ "2) The Haunting by Stephen King \n"
														+ "3) MicroTrends by Mark Penn \n"
														+ "4) Quit to cancel");
										System.out.println("<take input>");
										int select4 = sc.nextInt();
										
										if(select4>=1 && select4<=3)
										{
											//book copies number to add to library
											System.out.println("Exixting number of copies: ");
											System.out.println("Enter new number of copies: ");
										}
										else if(select4==4)
											check=true;					
									}
									else if(select3==3)	
										check=false; 	
								} // end while loop
								check=true;
							}
							else if(select2 ==5 ) 
								break;
							
						} // end while loop
					}
					else if(select1==2)
								break;
										
				}while(check);    // do while
					//check =true;
					
					break; 


		
					
			case 2 : 
				System.out.println("******ADMINISTRATOR MENU******");
				System.out.println();
				
				System.out.println("Which operation do wish to complete?");
				System.out.println("1) ADD");
				System.out.println("2) UPDATE");
				System.out.println("3) DELETE");
				System.out.println("<take input>");
				int input= sc.nextInt();

			break; //case 2



			case 3: while(check)
					{
						System.out.println("******BORROWER MENU******\n");
						
						System.out.print("Please Enter your Card Number: ");
						int CardNo= sc.nextInt(); // card number must be valid
						
						System.out.println("1) Check out a book\n"
										+ "2) Return a book\n"
										+ "3) Quit to Previous");
						System.out.println("<take input>");
						int choice= sc.nextInt();
						
						if(choice ==1)
						{
									System.out.println("Pick the branch you want to check out from:");  // Listing Library branches associted with borrower
									System.out.println("1) University Library, Boston");
									System.out.println("2) State Library, New York");
									System.out.println("3) Federal Library, Wasington DC");
									System.out.println("4) County Library, McLean VA");
									System.out.println("5) Quit to previous");
									System.out.println("<take input>");
									int choice1= sc.nextInt();
									
									if(choice1>=1 && choice1<=4)
									{
										System.out.println("Pick the book you want to check out"); // List books that have at least 1 copy at that branch
										System.out.println("1) Lost Tribe by Sidney Sheldon");
										System.out.println("2) The haunting by Stephen King");
										System.out.println("3) MIcrotrends by Mark Penn");
										System.out.println("4) Quit to cancel operation");
										System.out.println("<take input>");
										int choice2= sc.nextInt();
										
										if(choice2>=1 && choice2<=3){
											System.out.println("Updating databse...");
											//add entry to book_loans, date out= curentdate, due date = 1week later
											
										check= false;
										}else if(choice2==4)
											continue;
									
									}else if (choice1==5)
										continue;
								
						
						}
						else if (choice ==2)
						{
							//List library branches available
							System.out.println("Returning book-Pick the Branch you want to check in : ");
							System.out.println("1) University Library, Boston\n"
											+ "2) State Library, New York\n"
											+ "------------------------\n"
											+ "5) quit to previous");
							System.out.println("<take input>");
							int choice3= sc.nextInt();
							
							if(choice3>=1 && choice3 <=4)
							{
								System.out.println("Updating databse...");
								//for Returns: add entry to book_loans, date out= curentdate, due date = 1week later
								check= false;
							}else if (choice3==5)
								continue;
							
						} 
						else if(choice==3)
							break;
						
					}// first while loop
			break; //case 2


			default:
			{
				System.out.println("Exiting Main menu ....");
				flag = false;
			}


		  }//switch 
			
			System.out.println("want to continue using the system? yes/no");
			String reply = sc.next();
			if(reply.equalsIgnoreCase("yes"))
			check=true;
			else if(reply.equalsIgnoreCase("no"))
				check=false;
			System.out.println("Good bye!");
			
			System.out.println();
		}

	}// main
	
	
	/*static void ListBranches(){
		//list library branch available
		List<String> branchList = new ArrayList<String>();
		
		try{
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
				Statement stmt =conn.createStatement();	
			
				String selectQuery= "select * from tbl_library_branch where branchName= ?";
				PreparedStatement pstmt= conn.prepareStatement(selectQuery);
				pstmt.setString(1, "branchName");
	
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					branchList.add(rs.getString("branchName"));
				  System.out.print("branch ID: " +rs.getInt("branchId"));
					System.out.println("\t\tbranch Name: " +rs.getString("branchName"));
					System.out.println("-----------------------------");
									
				}
				ListIterator<String> itr = branchList.listIterator();
				while (itr.hasNext()){
			    	System.out.print(itr.nextIndex()+ 1 + ")"+ itr.next()+ " ");
			    }
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} 
			
	}*/


}// end class


