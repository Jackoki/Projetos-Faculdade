#include <stdio.h>
#include <stdlib.h>

int main () {
	int **mat1, **mat2, **multiplicado, i, j, num1, num2;
	printf("Escreva quantas colunas tem a matriz: ");
	scanf("%d", &num1);
	printf("Escreva quantas linhas tem a matriz: ");
	scanf("%d", &num2);
	
	mat1 = malloc(num1 * sizeof(int*));
	mat2 = malloc(num1 * sizeof(int*));
	multiplicado = malloc(num1 * sizeof(int*));
	
	
	for(i = 0; i < num1; i++) {
		mat1[i] = malloc(num2 * sizeof(int));
	}
	
	for(i = 0; i < num1; i++) {
		mat2[i] = malloc(num2 * sizeof(int));
	}
	
	for(i = 0; i < num1; i++) {
		multiplicado[i] = malloc(num2 * sizeof(int));
	}
	
	for(i = 0; i < num1; i++) {
		printf("\n");
		for(j = 0; j < num2; j++) {
			scanf("%d", &mat1[i][j]);
		}
	}
	
	printf("\n");
	
	for(i = 0; i < num1; i++) {
		printf("\n");
		for(j = 0; j < num2; j++) {
			scanf("%d", &mat2[i][j]);
		}
	}
		
	for(i = 0; i < num1; i++) {
		for(j = 0; j < num2; j++) {
			multiplicado[i][j] = mat1[i][j] * mat2[i][j];
		}
	}

	printf("\n");
	
	for(i = 0; i < num1; i++) {
		printf("\n");	
		for(j = 0; j < num2; j++) {
			printf("%d ", multiplicado[i][j]);
		}
	}
	
	for(i = 0; i < num1; i++) {
		free(mat1[i]);
	}
	for(i = 0; i < num2; i++) {
		free(mat2[i]);
	}
	for(i = 0; i < num2; i++) {
		free(multiplicado[i]);
	}
	
	free(mat1);
	free(mat2);
	free(multiplicado);
	
	return 0;
}