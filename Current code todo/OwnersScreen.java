import java.io.IOException;
import java.util.Scanner;

public class OwnersScreen {
	private Scanner in;

	public OwnersScreen() {
		in = new Scanner(System.in);
	}

	public void run(Owners machine) throws IOException {
		boolean more = true;

		while (more) {
			System.out.println("1) Show All Owners and their properties \n2) Show Specific Owner Details \n3) Add Owner 4) Remove Owner \n");
			String command = in.nextLine().toUpperCase();

			if (command.equals("1")) {
				/*
				 * Returns Owner details
				 */
				System.out.println(machine.getOwnersProperties());
			} else if (command.equals("2")) {
				/** Shows list of owners to pick */
				System.out.println("\nPick which Owners Details and Properties to see:");
				for (int i = 0; i < machine.getOwnerDetails().size(); i++) {
					//changed it so it just prints out the name of the owner rather than all the details so it doesn't take up too much space
					System.out.println((i + 1) + ") " + machine.getOwnerDetails().get(i).getName());
				}
				int choice = in.nextInt();
				Owner ownerPicked = machine.getOwnerDetails().get(choice - 1);
				/**
				 * Owner has been picked Now show details and properties of that
				 * owner
				 */
				System.out.println(ownerPicked.getProperties());
				boolean more2 = true;
				while (more2) {
					System.out.println("\n1) Add Property \n2) Remove Property \n3) Go back");
					String propertyScreenChoice = in.nextLine().toUpperCase();

					if (propertyScreenChoice.equals("1")) {
						//added in the new values needed to make a property
						System.out.println("What's the Owner's name: ");
						String name = in.nextLine().toUpperCase();
						
						System.out.println("What's the address: ");
						String address = in.nextLine().toUpperCase();
						//changed this to be called eircode
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

					} else if (propertyScreenChoice.equals("2")) {
						System.out.println("Which property are you removing?\n" + ownerPicked.getProperties());
						int propertyToRemove = in.nextInt();
						ownerPicked.removeProperty(ownerPicked.getPropertiesArray().get(propertyToRemove - 1));
					} else if (propertyScreenChoice.equals("3")) {
						more2 = false;
					} else {
						System.out.println("not a valid input");
					}
				}
			} else if (command.equals("3")) {
				// String name1, String currentAddress1, String currentPostcode1
				System.out.println("What's the Owners name: ");
				String name = in.nextLine().toUpperCase();

				System.out.println("What's the owner's current address: ");
				String address = in.nextLine().toUpperCase();

				System.out.println("What's the Owner's postcode: ");
				String postcode = in.nextLine().toUpperCase();

				Owner o = new Owner(name, address, postcode);

				machine.addOwner(o);

			} else if (command.equals("4")) {
				System.out.println("Which owner are you removing?");
				for (int i = 0; i < machine.getOwnerDetails().size(); i++) {
					System.out.println((i + 1) + ") " + machine.getOwnerDetails().get(i));
				}
				int ownerToRemove = in.nextInt();
				machine.removeOwner(machine.getOwnerDetails().get(ownerToRemove - 1));

			} else if (command.equals("Q"))

			{
				more = false;
			} else {
				System.out.println("not a valid input");
			}
		}
	}

}
