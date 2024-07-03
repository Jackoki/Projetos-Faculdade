#include <stdio.h>
#include <string.h>

int verificaExpre(char str[]) {
	int i;
	int esquerda = 0;
	int direita = 0;
	
    int num = strlen(str);
    
    
    for (i = 0; i < num; i++) {
        if (str[i] == '(') {
            esquerda++;
        } 
        
        else if (str[i] == ')') {
            direita++;
            
            if(direita > esquerda) {
				return 0;
			}
        } 
	}
	
	if(direita != esquerda) {
		return 0;
	}
    
    return 1;
}

int main() {
	int i;
    char string1[] = "((A+B)";
    char string2[] = "(A+B)) – (C + D)";
    char string3[] = "((A+B)+(C+D))";
    
    i = verificaExpre(string1);
    printf("%d\n", i);

	i = verificaExpre(string2);
	printf("%d\n", i);
	
	i = verificaExpre(string3);
    printf("%d\n", i);


    return 0;
}
