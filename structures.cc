//Will Blakely
//Program Assignment 4 - structures
#include <stdio.h>
#include <string.h>
#include "structures.h"
	
	void getOneDVD(dvd_t *x){	
	char c;
	printf("Enter title: ");
	scanf("%79[^\n]",x->title);\
	scanf("%c",&c);
	printf("Enter director: ");
	scanf("%79[^\n]",x->director);
	scanf("%c",&c);
	printf("Enter play time in minutes: ");
	scanf("%d",&(x->playTime));
	scanf("%c",&c);
	
			}
//this program is used to manage a collection of dvds and keep track of their names, director, and length
	void printOneDVD(dvd_t x){

		printf("%s:%s:%d\n", x.title, x.director, x.playTime);
				}
	void getCollection(dvd_t x[], int dvds){

		for(int i = 0; i < dvds; i++)
		{	
			getOneDVD(&x[i]);
		}
	}
	void printCollection(dvd_t x[], int dvds){

		for(int i = 0; i < dvds; i++){
			printOneDVD(x[i]);
					}	
		
			}	
		
