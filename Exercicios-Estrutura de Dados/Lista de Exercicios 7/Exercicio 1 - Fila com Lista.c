#include <stdio.h>
#include <stdlib.h>

struct no {
	float info;
	struct no* prox;
};
typedef struct no No;

struct fila {
	No* ini;
	No* fim;
};
typedef struct fila Fila;

Fila* cria() {
	Fila* novo = (Fila*)malloc(sizeof(Fila));
	novo->ini = NULL;
	novo->fim = NULL;
	
	return novo;
}

void insere(Fila *f, float x){
	No *novo;
	novo = (No*)malloc(sizeof(No));
	
	novo->info = x;
	novo->prox = NULL;
	
	if(f->ini == NULL) {
		f->ini = novo;
		f->fim = novo;
	}
	
	else {
		f->fim->prox = novo;
		f->fim = novo;
	}	
}

void retira(Fila *f){
	if(f->ini == NULL){
		printf("Lista esta vazia\n");
	}
	
	else{
		No* aux = f->ini;
		f->ini = f->ini->prox;
		   
		free(aux);	
	}
}

void imprime(Fila* f){
	if(f->ini == NULL){
		printf("A lista esta vazia\n");
	}
	
	else{
		No *aux = f->ini;
		while(aux != NULL){
			printf("%f \n", aux->info);
			aux = aux->prox;
		}
	}
}

void imprimeQuant(Fila* f){
	int contador = 0;
	
	No *aux = f->ini;
	
	while(aux != NULL){
		contador++;
		aux = aux->prox;
	}
	
	printf("\nA lista contem %d elementos", contador);
}

int main() {
	Fila *f = cria();
	
	insere(f, 1);
	insere(f, 2);
	insere(f, 3);
	
	retira(f);
	
	imprime(f);
	imprimeQuant(f);
	
	return 0;
}