#include <stdio.h>

int countCharRange (char *str, char c1, char c2) {
int count = 0;
char store;
if(c1 > c2)
{
	store = c2;
	c2 = c1;
	c1 = store;
}	
while (*str) {
	
		
        if((*str-c1)>=0 && (*str-c2)<=0){
		count++;
				    }	

	str+=1;
	     }
return count;
}
//this method is used to find the end of the string
char* findStringEnd(char *str)
{
	char *x=str;
	while(*x)
	{
		x+=1;	
	}
	return x;
}
//this method is used to determine if the word is repeated one after the other by locating the end of the first word and comparing it to the rest of the string
void doubleString(char* str){

	
	char* end = findStringEnd(str);
	char* dst= end;
	printf("%c", str);
	while(str < end){
		
		*(dst++) =*(str++);
		
	}
	*dst='\0';	
}
// this method is used to check if a word is a palindrome
void palindrome(char* str){
	
	char* end = findStringEnd(str);
        char* dst= end;
        (end--);
        while(str <=  end){
                *(dst++) =*(end--);

        }
        *dst='\0';

	
}
