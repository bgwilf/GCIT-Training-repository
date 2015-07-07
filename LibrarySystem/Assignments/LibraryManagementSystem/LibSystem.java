package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.Date;
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
 * LibSystem.java -------> Library Management System
 * @author Gilles W Bassole <gilles_bassole@gcitsolutions.com>
 * created on June 25, 2015
 *
 */
public class LibSystem {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		boolean check =true;

		while(check)
		{	
			System.out.println("Welcome to  GCIT Library Management System. \n"
							 + "\nWhich Category of user are you?");
			System.out.println("\n 1) Librarian"
							  +"\n 2) Administrator"
							  +"\n 3) Borrower");
			System.out.print("\n<Take input---->");
			int select=sc.nextInt();
			System.out.println();

			switch(select)
			{
				case 1: LibMenu();
					//System.out.println("***LIBRARIAN MENU***\n");
					break; 
					
				case 2 : try {
					AdminMenu();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					//System.out.println("***ADMINISTRATOR MENU***\n");
					break; //case 2

				case 3:  try {
					borrowMenu();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					//System.out.println("*** BORROWER MENU***\n");
					break; //case 3

				default:
				{		System.out.println("Exiting Main menu ....");
					check = false;	}
				
			}//switch 
			
			System.out.println("Want to continue using the system? yes/no");
			String reply = sc.next();
			if(reply.equalsIgnoreCase("yes"))
			check=true;
			else if(reply.equalsIgnoreCase("no"))
				check=false;
			System.out.println("Good bye!");
			
			System.out.println();
			}

	}// main
	
	/*
	 * METHODS USED in MAIN
	 * 
	 */
	
	//Librarian Menu method
	static void LibMenu() 
{		
	boolean check= true;
	 System.out.println("***LIBRARIAN MENU***\n");
		do{
			System.out.println("1) Enter Branch you Manage\n"
							 + "2) Quit to previous");		
			System.out.println("<take input>");
			int select1 =sc.nextInt();

			if (select1==1)
			{
				while(check) {
			
					
					try {
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
						Statement stmts = conn.createStatement();
						String myQuery= "SELECT * FROM tbl_library_branch";
						
						ResultSet lib = stmts.executeQuery(myQuery);
						
						System.out.println("0) Quit to previous");
						while(lib.next()){
							System.out.println(lib.getInt("branchId") + ") "+lib.getString("branchName")+" : "+ lib.getString("branchAddress") );
							}
						System.out.println("\nSelect a branch now \n<Take input>");  
						int select2 = sc.nextInt();
						
						if(select2==0) {
							break;
						}
						else if(select2 > 0)
						{	
							check=true;
							
							while(check)
							{
								System.out.println("1) Update the details of the Library \n"
												 + "2) Add copies of the book to the branch \n"
											   	+ "3) Quit to previous");
								
								System.out.println("<Taking input now>");
								int select3 =sc.nextInt();

								if (select3 ==1)
								{
									check=false; 
									System.out.println("You have chosen to update the Branch with branch ID:"
												+select2 +" Enter ‘quit’ at any prompt to cancel operation" );

									System.out.print("\nPlease enter new branch name... "
														+ "or enter N/A for no change: <taking input now>");

									String branchName = sc.next();
									System.out.println();
									
									if(branchName.equalsIgnoreCase("N/A") )
									{
										System.out.println("No change for branchName");											
									}
									else if (branchName.equalsIgnoreCase("quit")) 
										continue;
									else {
										String updateQuery = "update tbl_library_branch Set branchName =? Where branchId=?";
										
										PreparedStatement stmt2 = conn.prepareStatement(updateQuery);
										stmt2.setString(1, "'"+branchName+"'");
										stmt2.setInt(2, select2);
										stmt2.executeUpdate(updateQuery);
									}
									
									System.out.println("\nPlease enter new branch address or enter N/A for no change <take input>");
									String branchAddress = sc.nextLine();
									System.out.println();
									
									if(branchAddress.equalsIgnoreCase("N/A") )
									{
										System.out.println("No change for branchAddress");											
									}
									else if (branchAddress.equalsIgnoreCase("quit")) 
										continue;
									else {
										String updateQuery = "update tbl_library_branch Sets branchAddress=? where branchId= ?";
										
										PreparedStatement stmt3 = conn.prepareStatement(updateQuery);
										stmt3.setString(1, branchAddress);
										stmt3.setInt(2, select2);
										stmt3.executeUpdate(updateQuery);
									
									}

								}
								/*
								 * adding copies
								 */
								
								else if(select3==2)
								{
									check=false;
									System.out.println("Pick the book you want to add copies of, to your branch :");
									
									String query= "SELECT distinct title, noOfCopies FROM (tbl_library_branch Join tbl_book_copies join tbl_book) where branchId='"+select2+"'";
									
									ResultSet set = stmts.executeQuery(query);
									
									System.out.println("0) Quit to previous");
									while(set.next()){
										System.out.println(set.getInt("noOfCopies") + ") "+set.getString("title") );
										}
									
									
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
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						} 
				
				} // end while loop
			}
			else if(select1==2)
					break;
							
		}while(check); 
	
}

/*
 * ADMIN MENU
 */


static void AdminMenu() throws SQLException 
{
	Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
	//Statement stmt = connect.createStatement();
	
	boolean flag= true;
	do {
	System.out.println("******ADMINISTRATOR MENU******");
	System.out.println();
	
	System.out.println("Which category do you wish to edit?");
	System.out.println("0) Quit to previous");
	System.out.println("1) Book and Author");
	System.out.println("2) Publishers");
	System.out.println("3) Library Branches");
	System.out.println("4) Borrowers");
	System.out.println("5) Over-ride Due Date for a Book Loan");
	System.out.println("Enter choice number <take input>");
	int input= sc.nextInt();
	
	if(input==0) {	flag= false; 
					continue;	}
	
	else if (input==1) {		// A/U/D Book & Author
		System.out.println("Now select operation type:");
		System.out.println("0) quit to previous");
		System.out.println("1) add book & author");
		System.out.println("2) update book & author");
		System.out.println("3) delete book & author");
		int in = sc.nextInt();
		System.out.println("Make selection by entering number <Take input> ");
		
		if(in==0) { 
					System.out.println("returning to previous menu...");
					flag= true;
				}
		else if(in==1) {
						System.out.println("Adding book & author");
						System.out.print("Enter Author name: ");
						String author =sc.next();
						System.out.println();
						
						System.out.print("Enter Book title: ");
						String title = sc.next();
						System.out.println();
					
						
						String createQuery = "insert into tbl_author(authorName) values (?)";
						String createQuery1 = "insert into tbl_book(title) values (?)";
						
						PreparedStatement create = connect.prepareStatement(createQuery);
						PreparedStatement create1 = connect.prepareStatement(createQuery1);
						
						create.setString(1, author);
						create1.setString(1, title);
						
						create.executeUpdate();
						create1.executeUpdate();
						
						
			
					}
		else if(in==2) {
						System.out.println("Updating book & author");
						String selectQuery1="select distinct * from tbl_author";
						String selectQuery2="select distinct * from tbl_book";
						Statement myStmt = connect.createStatement();
						
						ResultSet rs1 = myStmt.executeQuery(selectQuery1);
						ResultSet rs2 =myStmt.executeQuery(selectQuery2);
						
						while(rs2.next()){
							System.out.println(rs2.getInt("bookId") + ") "+rs2.getString("title") );
							}
						System.out.println("");
						
						while(rs1.next()){
							System.out.println(rs1.getInt("authorId") + ") "+rs1.getString("authorName") );
							}
						
						
						String updateQuery = "update tbl_author sets authorName = ? where authorId = ?";
						PreparedStatement update = connect.prepareStatement(updateQuery);
						update.setString(1, "");
						update.setInt(2, 37);
						update.executeUpdate();
			
					}
		else if(in==3) {
						System.out.println("Deleting book and author");
			
						}
		
		}
	else if(input ==2) {		//A/U/D Publishers
		System.out.println("Now select operation type:");
		System.out.println("0) quit to previous");
		System.out.println("1) add publisher");
		System.out.println("2) update publisher");
		System.out.println("3) delete publisher");
		int in = sc.nextInt();
		System.out.println("Make selection by entering number <Take input> ");
		
		if(in==0) { 
					System.out.println("returning to previous menu...");
					flag= true;
				}
		else if(in==1) {
						System.out.println("Adding Publisher");
			
					}
		else if(in==2) {
						System.out.println("Updating Publisher");
			
					}
		else if(in==3) {
						System.out.println("Deleting Publisher");
			
						}
		
	}
	else if (input == 3) {		//A/U/D Library branch
		System.out.println("Now select operation type:");
		System.out.println("0) quit to previous");
		System.out.println("1) add Library branch");
		System.out.println("2) update Library branch");
		System.out.println("3) delete Library branch");
		int in = sc.nextInt();
		System.out.println("Make selection by entering number <Take input> ");
		
		if(in==0) { 
					System.out.println("returning to previous menu...");
					flag= true;
				}
		else if(in==1) {
						System.out.println("Adding Library branch");
			
					}
		else if(in==2) {
						System.out.println("Updating Library branch");
			
					}
		else if(in==3) {
						System.out.println("Deleting Library branch");
			
						}
		
	
		
	}
	else if (input ==4)	{		//A/U/D Borrowers
		
		System.out.println("Now select operation type:");
		System.out.println("0) quit to previous");
		System.out.println("1) add Borrower");
		System.out.println("2) update Borrower");
		System.out.println("3) delete Borrower");
		int in = sc.nextInt();
		System.out.println("Make selection by entering number <Take input> ");
		
		if(in==0) { 
					System.out.println("returning to previous menu...");
					flag= true;
				}
		else if(in==1) {
						System.out.println("Adding Borrower");
			
					}
		else if(in==2) {
						System.out.println("Updating Borrower");
			
					}
		else if(in==3) {
						System.out.println("Deleting Borrower");
			
						}
		
	}
	else if(input ==5) {		//Over-ride DueDate 
		
	}
	
	}while(flag);
	
}



/*
 * BORROWER Menu
 */
static void borrowMenu() throws SQLException 
{
		System.out.println("******BORROWER MENU******\n");
		boolean check =true;
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			Statement stmt = connect.createStatement();
			String selectQuery= "SELECT * FROM tbl_library_branch";
			
			ResultSet rs = stmt.executeQuery(selectQuery);
		
		while(check){
		
		System.out.print("Please Enter your Card Number: ");
		int cardNo= sc.nextInt(5); // card number must be valid
		
		System.out.println("1) Check out a book\n"
						+ "2) Return a book\n"
						+ "3) Quit to Previous");
		System.out.println("<take input>");
		int choice= sc.nextInt();
		
		if(choice ==1)
		{
					System.out.println("Pick the branch you want to check out from:");  // Listing Library branches associated with borrower
					System.out.println("0) Quit to previous");
					
					while(rs.next()){
						System.out.println(rs.getInt("branchId") + ") "+rs.getString("BranchName") );
						}
					System.out.println( );
					System.out.println("Enter Branch by number: <taking input>");
					int choice1= sc.nextInt();
					
					
					/*
					 * Book CHeckOUT
					 */
					if(choice1 == 0) {	continue;}
					
					else if (choice1 >0)
					{
						System.out.println("Pick the book you want to check out"); // List books that have at least 1 copy at that branch
						System.out.println("0) Quit to cancel operation");
						String selectQuery2="select * from (tbl_book_copies Natural Join tbl_book) where branchId ='"+choice1+"'";
						Statement stmt2 = connect.createStatement();
						ResultSet rs2 = stmt2.executeQuery(selectQuery2);	

						while(rs2.next()){
							System.out.println( rs2.getInt("bookId")+") "+rs2.getString("title") );
								}
						System.out.println("Enter book by number: <taking input>");
						int choice2= sc.nextInt();
						
						 if(choice2==0)
							{	continue;	}
						 
						 /*
						  * //add entry to book_loans, date out= curentdate, due date = 1week later
						  */
						 else if(choice2>0){
							// Statement stmt3 = connect.createStatement();
							 String  createQuery= "Insert into tbl_book_loans(bookId, branchId, cardNo) Values (bookId=?, branchId=?, cardNo=?)"; //, dateOut=?, dueDate=?";
							 //String updateQuery="update tbl";
							 PreparedStatement create= connect.prepareStatement(createQuery);
							 
							 create.setInt(1, choice2);
							 create.setInt(2, choice1);
							 create.setInt(3, cardNo);
							// create.setDate(4, today.getDate());
							// create.setDate(5, );
							 
							 create.executeUpdate();
								
							// System.out.println("Query Executed");
						System.out.println("Query Executed--Updating databse...");
						check= false;
						
						}
					}
				}
		/*
		 * Book Return
		 */
		else if (choice ==2)
		{
			//List library branches available
			System.out.println("Returning book -- Pick the Branch you want to check in from : ");
			System.out.println("0) quit to previous");
			
			while(rs.next()){
				System.out.println(rs.getInt("branchId") + ") "+rs.getString("BranchName") );
						}
			
			System.out.println("Pick the returning branch<take input>");
			int choice3= sc.nextInt();
			
			if(choice3==0) { continue; }
			
			/*
			 * //for Returns: add entry to book_loans, date out= curentdate, due date = 1week later
			 */
			else if(choice3 > 0)
			{
				System.out.println("Pick the book you want to return"); 
				System.out.println("0) Quit to cancel operation");
				String selectQuery3="select * from (tbl_book_copies Natural Join tbl_book) where branchId ='"+choice3+"'";
				Statement stmt3 = connect.createStatement();
				ResultSet rs3 = stmt3.executeQuery(selectQuery3);	

				while(rs3.next()){
					System.out.println( rs3.getInt("bookId")+") "+rs3.getString("title") );
						}
				System.out.println("Enter book by number: <taking input>");
				int choice4= sc.nextInt();
				

				 if(choice4==0)		{	continue;	}
				 else if(choice4>0){
		
					// String  createQuery= "Insert into tbl_book_loans(bookId, branchId, cardNo) Values (bookId=?, branchId=?, cardNo=?)"; //, dateOut=?, dueDate=?";
					String deleteQuery="delete from tbl_borrower where cardNo=?";
					// String updateQuery="update tbl_book_loans";
					 PreparedStatement delete= connect.prepareStatement(deleteQuery);
					 
					 delete.setInt(1, cardNo );
					 delete.executeUpdate();
					
					 // update.setInt(2, );
					// update.setInt(3, );
	
				System.out.println("Updating databse...Boorower returned book");
				check= false;
			}
		  }	
		} 
		else if(choice==3)
			break;
		
		}
	
  }


}// end class


