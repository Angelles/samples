#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

struct Person {
	char firstName[];
	char lastName[];
};

struct Address {
	int buildingNumber; // just the number part
	char street[30]; // street name
	char postfix[20]; // avenue, road, street, etc.
	char poBoxOrApartmentNumber[10];
	char postalCode[11]; // includes postal codes (non-US) that include letters
	char country[60]; 
};

struct Entry {
	struct Person name;
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
		if (option == 0){
			printf("Goodbye!");
			exit(0);
		}
	}
}
// create new entry and write to file - option 1
// read entry - option 2, then select an option to read
// update entry - option 3, which is option 2 then select an option to update
// delete entry - option 4, which is option 2 then select an option to delete
int main(){
	menu();
	return 0;

}
	
