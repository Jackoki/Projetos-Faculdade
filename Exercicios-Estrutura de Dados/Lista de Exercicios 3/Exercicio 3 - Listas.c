#include <stdio.h>
#include <stdlib.h>
//Exercicio 3

struct lista{
	int info;
	struct lista *prox;
};
typedef struct lista Lista;

Lista* constroi(int n, int* v){
	Lista *novo;
	novo = (Lista*)malloc(sizeof(Lista));
	
	novo->info = n;
	novo->prox = v;
	return novo;
}

void imprimir(Lista *l){
	Lista *p = l;
	while(p!=NULL){
		printf("%x [%d | %x] -> ",p, p->info, p->prox);
		p = p->prox;
	}
}


int main(){
	Lista *prox1 = NULL;
	int n, i;
	
	printf("Digite a quantidade de elementos da lista: ");
	scanf("%d", &n);
	
	int v[n];
	
	for(i = 0; i< n; i++){
		scanf("%d", &v[i]);
	}
	
	if(n == 0) {
		prox1 = NULL;
	}
	else {
		for(i = 0; i < n; i++) {
			prox1 = constroi(v[i], prox1); }
	}

	printf("\n");
	imprimir(prox1);
	
	return 0;
}