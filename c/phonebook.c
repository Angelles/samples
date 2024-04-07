#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// prototypes
void create(); 
// void read();
// void update(struct Entry);
// void delete(struct Entry);

// consider using pointers for all attribute arrays
struct Person {
	char firstName[30];
	char lastName[30];
};

struct Address {
	int buildingNumber; // just the number part
	char street[30]; // street name
	char postfix[20]; // avenue, road, street, etc.
	char apartmentNumber[10];
	char city[30];
	char state[20];
	char postalCode[11]; // includes postal codes (non-US) that include letters
	char country[60]; 
}; 

struct Entry {
	struct Person person;
	struct Address address;
	char email[320]; // consider required attributes for email
	char phone[20]; // consider regex for phone number and consider requiring international number format

};

void menu(){
	bool on = true;
	while (on){
		printf("Welcome to Phone Book! Enter one of the following options.\n");
		printf("1 - Create new entry\n2 - View an entry\n3 - Update an entry\n4 - Delete an entry\n0 - Quit the program\n");
		int option;
		scanf("%d", &option);
		switch (option){
			case 1:
				create();
				break;
			// case 2:
				// read();
				// break;
			case 0:
				printf("Goodbye!\n");
				exit(0);
				break;
			default:
				printf("Goodbye!\n");
				exit(0);
		}
		
	}
}
// create new entry and write to file - option 1
void create(){
	struct Entry newEntry;
	FILE* file;
	file = fopen("phonebook.csv", "a"); // append
	printf("First name:\n"); // consider generating a unique id for each entry to help with reading, updating, and deleting
	scanf("%s", newEntry.person.firstName);
	fprintf(file, "%s,", newEntry.person.firstName);
	printf("Last name:\n");
	scanf("%s", newEntry.person.lastName);
	fprintf(file, "%s,", newEntry.person.lastName);
	printf("What do you want to enter for %s?\n", newEntry.person.firstName);
	printf("Enter the number for one of the following:\n1 - Phone number\n2 - Email address\n3 - Address\n");
	int entryOption;
	scanf("%d", &entryOption);
	switch (entryOption){
		case 1:
			printf("Phone number:\n");
			scanf("%s", newEntry.phone);
			fprintf(file, "%s\n", newEntry.phone);
			break;
		case 2:
			printf("Email address:\n");
			scanf("%s", newEntry.email);
			fprintf(file, "%s\n", newEntry.email);
			break;
		case 3: 
			printf("Address number:\n");
			scanf("%d", &(newEntry.address.buildingNumber));
			fprintf(file, "%d,", newEntry.address.buildingNumber);
			printf("Street name:\n");
			scanf("%s", newEntry.address.street);
			fprintf(file, "%s,", newEntry.address.street);
			printf("Street type (i.e. Road, Avenue, Boulevard...):\n");
			scanf("%s", newEntry.address.postfix);
			fprintf(file, "%s,", newEntry.address.postfix);
			printf("Enter N/A and press enter if there is no apartment number. Otherwise, enter the data.\n");
			scanf("%s", newEntry.address.apartmentNumber);
			fprintf(file, "Apt. %s,", newEntry.address.apartmentNumber);
			printf("City or town:\n"); // Consider towns that include a space
			scanf("%s", newEntry.address.city);
			fprintf(file, "%s,", newEntry.address.city); // Need to consider towns that include a space
			printf("State:\n");
			scanf("%s", newEntry.address.state);
			fprintf(file, "%s,", newEntry.address.state); // Need to consider states that include a space, or limiting to 2-char abbreviations
			printf("Postal code:\n");
			scanf("%s", newEntry.address.postalCode);
			fprintf(file, "%s,", newEntry.address.postalCode); // Need to consider postal codes that include spaces
			printf("Country:\n");
			scanf("%s", newEntry.address.country);
			fprintf(file, "%s\n", newEntry.address.country); // Need to consider requiring abbreviations, or consider how to handle spaces
			break;
		default:
			printf("Phone number:\n");
			scanf("%s", newEntry.phone);
			fprintf(file, "%s\n", newEntry.phone);
	}
	fclose(file);
}
// read entry - option 2, then select an option to read
/* void read(FILE* file){
	// open file
	file = fopen("phonebook.csv", "r"); // read-only
	// establish temp file for data
	char entries[1000];
	// read and display first and last names from file...and ids?
	while (!feof(file)){
		fgets(entries, 1000, file);
		printf("%s", entries);
	}	
	// TO-DO: when the user enters the id for the option, read display the full entry
	// close file
	fclose(file);
	// print menu again, so the user can do more stuff or quit
	menu();
}	
*/
// TO-DO: update entry - option 3, which is option 2 then select an option to update. should include choosing attributes only
// TO-DO: delete entry - option 4, which is option 2 then select an option to delete

int main(){
	menu();
	return 0;

}
	

