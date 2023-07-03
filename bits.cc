#include <stdio.h>

int highLow(int x, int y){
int umask = 0xFFFF0000;
int dmask = 0x0000FFFF;
int  ans = x & umask;
ans = ans +(y & dmask);
return ans;
}
//this method counts the pairs of 1's that are exclusively 0110 with the edge case of 110 or 011 at the start and end respectively
int countPairs(int x){
int num = x;
//int mask = 0xF;
int ans = 0;
	if((num & 0xE0000000) != 0xE0000000 && (num & 0x00000007)!= 0x00000007){ 
	if((num & 0xC0000000) == 0xC0000000){
		ans +=1;}
	if((num & 0x00000003) == 0x00000003){
		ans+=1;}}
	for(int i = 0; i<= 28; i++){
	int bits = (num>>i) & 0xF;
		if(bits == 0x6){
			ans+=1;
			
			
		}
	
	}
return ans;
}
//this method prints the given binary as an octal number seperated by the character '-'
void printDashOct(int x){
unsigned int num =x;
//int oct = 0;
unsigned int octNums[12];
int digits = 0;

while(num){

	octNums[digits]=num%8;
	num/=8;
	digits +=1;
	}
while(digits<11){
	octNums[digits] = 0;
	digits++;

	}
    for (int i = 10; i >= 0; i--) {
	
        printf("%d", octNums[i]);
        if (i > 0) {
            printf("-");
       }
    }

    printf("\n");

   
}

