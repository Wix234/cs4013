// The main purpose of this class is to return the 
public class Owners {
	- ownerDetails : ArrayList<Owner>
	- propertiesOwned : ArrayList<Property>
	- taxPaid : ArrayList<Tax>
	- taxDue : ArrayList<Tax>
-------------------------------------------------
	+ ownersProperties //returns the details of the owner as well as all the properties they own
	+ ownersPaidTax // returns the tax paid on each property by that owner in all the years the owner owned it 
	+ ownersTaxProperty // this returns all the tax on the specific property (both paid and due/overdue) in all the years the owner owned it
	+ ownersDueTax // this returns what tax is due on which property the owner owns and any overdue tax as well
}
