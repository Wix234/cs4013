
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OwnersScreen {
	private Scanner in;
	private ArrayList<Admin> Admins = new ArrayList<Admin>();
	Admin DefaultAdmin = new Admin("default");

	public OwnersScreen() {
		in = new Scanner(System.in);
	}

	public void login(Owners machine) throws IOException {
		boolean more = true;
		Admins.add(DefaultAdmin);

		while (more) {
			System.out.println("How are you logging in? \n1) User \n2) Admin \n3) New User");
			String command = in.nextLine();

			if (command.equals("1")) {
				System.out.println("Enter Name:");
				String loginAttempt = in.nextLine();
				Owner ownerPicked = null;
				for (int i = 0; i < machine.getOwnerDetails().size(); i++) {
					if ((machine.getOwnerDetails().get(i).getName()).equalsIgnoreCase(loginAttempt)) {
						ownerPicked = (machine.getOwnerDetails().get(i));
					}
				}
				if (ownerPicked != null) {
					SingleOwnerScreen(ownerPicked);
				} else {
					System.out.println("Invalid Login");
				}
			} else if (command.equals("2")) {
				System.out.println("Enter Name:");
				String loginAttempt = in.nextLine();
				Admin adminPicked = null;
				for (int i = 0; i < Admins.size(); i++) {
					if ((Admins.get(i).getAdminName()).equalsIgnoreCase(loginAttempt)) {
						adminPicked = (Admins.get(i));
					}
				}
				if (adminPicked != null) {
					runAdmin(machine);
				} else {
					System.out.println("Invalid Login");
				}
			} else if (command.equals("3")) {
				addOwner(machine);
			} else {
				System.out.println("invalid input");
			}
		}
	}

	public void runAdmin(Owners machine) throws IOException {
		boolean more = true;

		while (more) {
			System.out.println(
					"\n1) Get tax info on property \n2) Get tax info for owner \n3) Get all overdue tax for year \n4) Get statistics for and area \n5) Add admin \n6) Add Owner \n7) Remove Owner");
			// "1) Show All Owners and their properties \n2) Show Specific Owner
			// Details \n3) Add Owner 4) Remove Owner \n");
			int command = in.nextInt();

			if (command == 1 ) {
				/*
				 * Returns Owner details
				 */
				/** Shows list of owners to pick */
				System.out.println("\nPick which Owner's Details tax information to see:");
				for (int i = 0; i < machine.getOwnerDetails().size(); i++) {
					// changed it so it just prints out the name of the owner
					// rather than all the details so it doesn't take up too
					// much space
					System.out.println((i + 1) + ") " + machine.getOwnerDetails().get(i).getName());
				}
				int choice = in.nextInt();
				Owner ownerPicked = machine.getOwnerDetails().get(choice - 1);
				System.out.println("Pick which property's tax information to see:");
				for (int i = 0; i < ownerPicked.getPropertiesArray().size(); i++) {
					System.out.println((i + 1) + ") " + ownerPicked.getPropertiesArray().get(i).getAddress());
				}
				int choices = in.nextInt();
				Property property = ownerPicked.getPropertiesArray().get(choices - 1);
				System.out.println(ownerPicked.getProperty(property.getAddress()));
				// System.out.println(machine.getOwnersProperties());
			} else if (command == 2) {
				/** Shows list of owners to pick */
				System.out.println("\nPick which Owners Details and Properties tax information to see:");
				for (int i = 0; i < machine.getOwnerDetails().size(); i++) {
					// changed it so it just prints out the name of the owner
					// rather than all the details so it doesn't take up too
					// much space
					System.out.println((i + 1) + ") " + machine.getOwnerDetails().get(i).getName());
				}
				int choice = in.nextInt();
				Owner ownerPicked = machine.getOwnerDetails().get(choice - 1);
				/**
				 * Owner has been picked Now show details and properties of that
				 * owner
				 */
				System.out.println(ownerPicked.getName() + "\n" +ownerPicked.getCurrentAddress()+ "\n" + ownerPicked.getCurrentPostcode() 
				+ "\n" + ownerPicked.getPropertiesWithTax());
			} else if (command == 3) {
				String eircode = null;
					System.out.println("Enter year: ");
					int year = in.nextInt();
					in.nextLine();
					System.out.println("Enter key eircode (press enter for all of Ireland): ");
					eircode = in.nextLine().toUpperCase();
					
					if (eircode.equals("")) {
						machine.taxesPaidYear(year);
					System.out.println(machine.taxesPaidYear(year));
					}else {
						machine.taxesPaidYearLoc(eircode,year);
						System.out.println(machine.taxesPaidYearLoc(eircode,year));
					}
					
		
				
			} else if (command == 4 ) {
				System.out.println("Enter key eircode (press enter for all of Ireland): ");
				in.nextLine();
				String eircode = in.nextLine().toUpperCase();
				System.out.println(machine.taxesStatics(eircode));

			} else if (command == 5) {
				System.out.println("Enter the new Admin's name");
				String newAdminName = in.nextLine().toUpperCase();
				Admin newAdmin = new Admin(newAdminName);
				Admins.add(newAdmin);
			} else if (command == 6) {
				addOwner(machine);
			} else if (command == 7) {
				System.out.println("Which owner are you removing?");
				for (int i = 0; i < machine.getOwnerDetails().size(); i++) {
					System.out.println((i + 1) + ") " + machine.getOwnerDetails().get(i));
				}
				int ownerToRemove = in.nextInt();
				machine.removeOwner(machine.getOwnerDetails().get(ownerToRemove - 1));

			} else if (command == 0) {
				more = false;
			} else {
				System.out.println("not a valid input");
			}
		}
	}

	public void SingleOwnerScreen(Owner ownerPicked) {
		// System.out.println("This should only be here once");
		boolean more2 = true;

		while (more2) {
			System.out.println(
					"\n1) View All Properties \n2) View a specific Property \n3) Pay tax \n4) Add Property \n5) Remove Property \n6) View payments made \n7) Go back");
			int propertyScreenChoice = in.nextInt();

			if (propertyScreenChoice == 4) {
				// added in the new values needed to make a property
				System.out.println("What's the Owner's name: ");
				String name = in.nextLine().toUpperCase();

				System.out.println("What's the address: ");
				String address = in.nextLine().toUpperCase();
				// changed this to be called eircode
				System.out.println("What's the Eircode: ");
				String eircode = in.nextLine().toUpperCase();

				System.out.println("What's the location. City, Large town, Small town, Village, Countryside: ");
				String location = in.nextLine().toUpperCase();

				System.out.println("It is a private residence. Yes or No: ");
				String privateResidence = in.nextLine().toUpperCase();

				System.out.println("What's the estMarketVal: ");
				double estMarketVal = in.nextDouble();

				System.out.println("What's the year bought: ");
				int yearBought = in.nextInt();

				Property p = new Property(name, address, eircode, estMarketVal, location, privateResidence, yearBought);

				ownerPicked.addProperty(p);

			} else if (propertyScreenChoice == 5) {
				System.out.println("Which property are you removing?\n" + ownerPicked.getProperties());
				int propertyToRemove = in.nextInt();
				ownerPicked.removeProperty(ownerPicked.getPropertiesArray().get(propertyToRemove - 1));

			} else if (propertyScreenChoice == 6) {
				for (int i = 0; i < ownerPicked.getPropertiesArray().size(); i++) {
					System.out.println("Property number " + (i + 1) + ")");
					for (int j = 0; j < ownerPicked.getPropertiesArray().get(i).getTaxesPaid().size(); j++) {
						System.out.println("butts" + ownerPicked.getPropertiesArray().get(i).getTaxesPaid().get(j));
					}
				}
			} else if (propertyScreenChoice == 7) {
				more2 = false;

			} else if (propertyScreenChoice == 1) {
				System.out.println(ownerPicked.getProperties());

			} else if (propertyScreenChoice == 2) {
				System.out.println("Pick a property");
				for (int i = 0; i < ownerPicked.getPropertiesArray().size(); i++) {
					System.out.println((i + 1) + ") " + ownerPicked.getPropertiesArray().get(i).getAddress());
				}
				int choice = in.nextInt();
				Property property = ownerPicked.getPropertiesArray().get(choice - 1);
				System.out.println(ownerPicked.getProperty(property.getAddress()));
			} else if (propertyScreenChoice == 3) {

				System.out.println("Choose a property to pay tax on");
				for (int i = 0; i < ownerPicked.getPropertiesArray().size(); i++) {
					System.out.println((i + 1) + ") " + ownerPicked.getPropertiesArray().get(i).getAddress());
				}
				int choice = in.nextInt();
				Property property = ownerPicked.getPropertiesArray().get(choice - 1);

				int sizeTax = property.getOverDueTax().size();
				System.out.println(sizeTax);
				if (property.getOverDueTax().toString() != "[]") {
					System.out.println("Choose a tax to pay");
					for (int i = 0; i < sizeTax; i++) {
						System.out.println((i + 1) + ") " + property.getOverDueTax().get(i).toString());
					}
				} else {
					System.out.println("No taxes to pay");
				}

				/**
				 * if (property.getOverDueTax().size() > 0) { Tax t =
				 * property.getOverDueTax().get(choice - 1);
				 * System.out.println(t); property.payTax(t); } else {
				 * System.out.println("No overdue tax left"); }
				 */

			} else if (propertyScreenChoice == 4) {
				System.out.println("Input year to view:");
				int year = in.nextInt();
				System.out.print(ownerPicked.taxesPaidYear(year));

			} else

			{
				System.out.println("not a valid input");
			}
		}

	}

	public void addOwner(Owners machine) {
		System.out.println("What's the Owners name: ");
		String name = in.nextLine().toUpperCase();

		System.out.println("What's the owner's current address: ");
		String address = in.nextLine().toUpperCase();

		System.out.println("What's the Owner's postcode: ");
		String postcode = in.nextLine().toUpperCase();

		Owner o = new Owner(name, address, postcode);

		machine.addOwner(o);
	}

}
