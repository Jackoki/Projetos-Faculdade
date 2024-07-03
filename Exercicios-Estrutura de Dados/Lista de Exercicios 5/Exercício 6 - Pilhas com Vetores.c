#include <stdio.h>
#include <string.h>

int verificaStr(char str[]) {
	int i;
    int num = strlen(str);
    int c = 0;
    

    if (num % 2 != 1) {
        return 0;
    }
    
   for (i = 0; i < num; i++) {
	   if (str[i] == 'C'){
		   c++;
	   }
    }
    
    if(c != 1){
		return 0;
	}
    
    int metade;
	metade = num/ 2;
    
    for (i = 0; i < metade; i++) {
        if (str[i] != 'A' && str[i] != 'B') {
            return 0;
        }
        
        else if (str[i] != str[num - i - 1]) {
            return 0;
        }
    }
    
    return 1;
}

int main() {
	int i;
    char string1[] = "ABCBA";
    char string2[] = "ABCBAA";
    char string3[] = "BACAB";
    char string4[] = "ABAA";
    char string5[] = "ABBA";

    i = verificaStr(string1);
    printf("%d\n", i);

	i = verificaStr(string2);
	printf("%d\n", i);
	
	i = verificaStr(string3);
    printf("%d\n", i);

	i = verificaStr(string4);
	printf("%d\n", i);
	
	i = verificaStr(string5);
	printf("%d\n", i);


    return 0;
}
