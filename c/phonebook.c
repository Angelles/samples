#include <stdio.h>
#include <stdlib.h>

struct Entry {
	char[] firstName;
	char[] lastName;
	char[] email; // consider required attributes for email
	char[] phone; // consider regex for phone number and consider requiring international number format
	int addressNumber; // just the number part
	char[] street; // streetname
	char[] streetType; // consider enum for street types to ensure consistency
	char[] postalCode; // includes postal codes (non-US) that include letters
	char[] country // could probably import a list from a file...
} 
// create new entry and write to file
// read entry
// update entry
// delete entry
int main(){
	return 0;

}
	
