#include <stdio.h>
#include <stdlib.h>

int main () {
	int i, j, num1, num2;
	printf("Escreva quantas colunas tem a matriz: ");
	scanf("%d", &num1);
	printf("Escreva quantas linhas tem a matriz: ");
	scanf("%d", &num2);
	
	int *mat1[num1], *mat2[num1], *multiplicado[num1];
	
	
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