import java.sql.Connection;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.*;

public class Assignment2 {

	public static void main(String[] args) {
		MySQLAccess dao = new MySQLAccess();
		String yorn = "";
		FileHandler fh;
		SimpleFormatter formatter = new SimpleFormatter();
		Logger logger = Logger.getLogger("MyLog");
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				Connection connection = dao.setupConnection();

				fh = new FileHandler("C:\\Users\\Admin\\Documents\\Assignment_2_Logser.log");
				logger.addHandler(fh);
				fh.setFormatter(formatter);
				{
					System.out.println("---------------------------Welcome---------------------------");
					System.out.println("Select one the options : \r\n" + "1.Insert a transaction \r\n"
							+ "2.Delete a transaction \r\n" + "3.View all the transactions \r\n"
							+ "4.Update a transaction");
					String choice = scanner.next();
					switch (choice) {
					case "1":
					// System.out.println("Transaction details project");

					{
						logger.info("Create Module Selected");
						Insertclass ins = new Insertclass();
						boolean b = ins.insertMethod(scanner, connection, logger);
						//System.out.println(b);
						logger.info(b ? "Insertion Sucess" : "Insertion Failure");
						break;
					}
					case "2": {
						removeTransactionclass del = new removeTransactionclass();
						logger.info("Remove Module Selected");
						boolean c = del.removeTransaction(scanner, connection, logger);
						// System.out.println(c);
						logger.info(c ? "Deletion Sucess" : "No such ID found");
					}
					case "3":

					{
						Collection<Transaction> trxns = dao.getAllTransactions(connection, logger);

						logger.info("Display Module Selected");
						for (Transaction trxn : trxns) {
							System.out.println(trxn.toString());
						}
					}
						break;
					case "4": {
						Updateclass upd = new Updateclass();
						logger.info("Update Module Selected");
						boolean d = upd.update(scanner, connection, logger);
						//System.out.println(d);
						logger.info(d ? "Updation Sucess" : "Updation Failure");
					}
					default:
						System.out.println("Not a valid option");

					}

				}
				// while(yorn.equals("Y")||yorn.equals("y")||yorn.equals("yes"));

				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block

				logger.severe(e.getMessage());
				System.out.println("Please check your input");

			}
			System.out.println("Do you want to make an another operation y/n");
			yorn = scanner.next();
		} while (yorn.equals("Y") || yorn.equals("y") || yorn.equals("yes"));
		System.out.println("---------------------------Thank you---------------------------");
	}

}
