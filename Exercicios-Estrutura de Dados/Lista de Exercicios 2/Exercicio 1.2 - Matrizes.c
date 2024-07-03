#include <stdio.h>
#include <stdlib.h>

int main () {
	int i, j, num1, num2;
	printf("Escreva quantas colunas tem a matriz: ");
	scanf("%d", &num1);
	printf("Escreva quantas linhas tem a matriz: ");
	scanf("%d", &num2);
	
	int *mat1[num1], *mat2[num2];
	
	for(i = 0; i < num1; i++) {
		mat1[i] = malloc(num2 * sizeof(int));
	}
	
	for(i = 0; i < num2; i++) {
		mat2[i] = malloc(num1 * sizeof(int));
	}
	
	for(i = 0; i < num1; i++) {
		for(j = 0; j < num2; j++) {
			mat1[i][j] = i+j;
		}
	}
	
	for(j = 0; j < num2; j++) {
		for(i = 0; i < num1; i++) {
			mat2[j][i] = mat1[i][j];
		}
	}
	
	for(i = 0; i < num1; i++) {
		printf("\n");
		for(j = 0; j < num2; j++) {
			printf("%d ", mat1[i][j]);
		}
	}

	printf("\n");
	
	for(j = 0; j < num2; j++) {
		printf("\n");	
		for(i = 0; i < num1; i++) {
			printf("%d ", mat2[j][i]);
		}
	}
	
	for(i = 0; i < num1; i++) {
		free(mat1[i]);
	}
	for(j = 0; j < num2; j++) {
		free(mat1[j]);
	}
	free(mat1);
	free(mat2);
	
	return 0;
}