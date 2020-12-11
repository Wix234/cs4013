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
			System.out.println("1) Show Owners \n2) Show Specific Owner Details \n3) Add Owner 4) Remove Owner \n");
			String command = in.nextLine().toUpperCase();

			if (command.equals("1")) {
				/*
				 * Returns Owner details
				 */
				System.out.println(machine.getOwnersProperties());
			} else if (command.equals("2")) {
				/** Shows list of owners to pick */
				System.out.println("Pick which Owner:\n");
				for (int i = 0; i < machine.getOwnerDetails().size(); i++) {
					System.out.println((i + 1) + ") " + machine.getOwnerDetails().get(i));
				}
				int choice = in.nextInt();
				Owner ownerPicked = machine.getOwnerDetails().get(choice - 1);
				/**
				 * Owner has been picked Now show details and properties of that
				 * owner
				 */
				System.out.println(ownerPicked.getAllDetails());
				boolean more2 = true;
				while (more2) {
					System.out.println("\n1) Add Property \n2) Remove Property \n3) Go back");
					String propertyScreenChoice = in.nextLine().toUpperCase();

					if (propertyScreenChoice.equals("1")) {
						System.out.println("What's the address: ");
						String address = in.nextLine().toUpperCase();

						System.out.println("What's the pincode: ");
						String pincode = in.nextLine().toUpperCase();

						System.out.println("What's the estMarketVal: ");
						double estMarketVal = in.nextDouble();

						System.out.println("What's the location: ");
						int location = in.nextInt();

						System.out.println("It is a private residence. True or False: ");
						boolean privateResidence = in.nextBoolean();

						Property p = new Property(address, pincode, estMarketVal, location, privateResidence);

						ownerPicked.addProperties(p);

					} else if (propertyScreenChoice.equals("2")) {
						System.out.println("Which property are you removing?\n" + ownerPicked.getProperties());
						int propertyToRemove = in.nextInt();
						ownerPicked.removeProperties(ownerPicked.getPropertiesArray().get(propertyToRemove - 1));
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
