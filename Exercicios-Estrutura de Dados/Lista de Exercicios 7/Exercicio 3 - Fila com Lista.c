#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct no {
	int id;
	char descricao[50];
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

void insere(Fila *f, int x, char descricao[50]){
	No *novo;
	novo = (No*)malloc(sizeof(No));
	
	novo->id = x;
	strcpy(novo->descricao, descricao);
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
			printf("%d, %s \n", aux->id, aux->descricao);
			aux = aux->prox;
		}
	}
}


int main() {
	Fila *f = cria();
	
	insere(f, 1, "Teste 1");
	insere(f, 2, "Teste 2");
	insere(f, 3, "Teste 3");
	
	imprime(f);
	
	return 0;
}