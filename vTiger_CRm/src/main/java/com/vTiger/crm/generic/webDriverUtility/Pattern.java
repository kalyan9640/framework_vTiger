package com.vTiger.crm.generic.webDriverUtility;

class Pattern38{
public static void main(String[]args){
	int n=4,space=5,star=1,i,j,k,l;
	for(i=1;i<=n;i++){
	for(j=1;j<=star;j++){
	System.out.print("*");
	}
	for(k=1;k<=space;k++){
	System.out.print(" ");
	}
	if(i==4){
	System.out.print("*");
	}
	for(l=1;l<=star;l++){
	System.out.print("*");
	}
	space-=2;
	if(i<3){
	star++;
	}
	System.out.println();
	}
}
}