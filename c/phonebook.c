#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void create(); // prototype

// consider using pointers for all attribute arrays
struct Person {
	char firstName[30];
	char lastName[30];
};

struct Address {
	int buildingNumber; // just the number part
	char street[30]; // street name
	char postfix[20]; // avenue, road, street, etc.
	char poBoxOrApartmentNumber[10];
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
	file = fopen("phonebook.csv", "w");
	printf("First name:\n");
	scanf("%s,", newEntry.person.firstName);
	fprintf(file, newEntry.person.firstName);
	printf("Last name:\n");
	scanf("%s,", newEntry.person.lastName);
	fprintf(file, newEntry.person.lastName);
	printf("What do you want to enter for %s?\n", newEntry.person.firstName);
	printf("Enter the number for one of the following:\n1 - Phone number\n2 - Email address\n3 - Address\n");
	int entryOption;
	scanf("%d", &entryOption);
	switch (entryOption){
		case 1:
			printf("Phone number:\n");
			scanf("%s,", newEntry.phone);
			fprintf(file, newEntry.phone);
			break;
		case 2:
			printf("Email address:\n");
			scanf("%s,", newEntry.email);
			fprintf(file, newEntry.email);
			break;
		case 3: // add writing to file
			printf("Address number:\n");
			scanf("%d ", &(newEntry.address.buildingNumber));
			printf("Street name:\n");
			scanf("%s ", newEntry.address.street);
			printf("Street type (i.e. Road, Avenue, Boulevard...):\n");
			scanf("%s ", newEntry.address.postfix);
			printf("Enter a space and press enter if there is no apartment number or P.O. Box. Otherwise, enter the data.\n");
			scanf("%s,", newEntry.address.poBoxOrApartmentNumber);
			printf("City or town:\n");
			scanf("%s,", newEntry.address.city);
			printf("State:\n");
			scanf("%s,", newEntry.address.state);
			printf("Postal code:\n");
			scanf("%s,", newEntry.address.postalCode);
			printf("Country:\n");
			scanf("%s,", newEntry.address.country);
			break;
		default:
			printf("Phone number:\n");
			scanf("%s,", newEntry.phone);
			fprintf(file, newEntry.phone);
	}
	fclose(file);
}
// read entry - option 2, then select an option to read
// update entry - option 3, which is option 2 then select an option to update. should include choosing attributes only
// delete entry - option 4, which is option 2 then select an option to delete
int main(){
	menu();
	return 0;

}
	
