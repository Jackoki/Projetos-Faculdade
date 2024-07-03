#include <stdio.h>
#include <stdlib.h>

struct no {
	int info;
	struct no *prox;	
};

typedef struct no No;

struct pilha {
	No *prim;
};

typedef struct pilha Pilha;


Pilha* cria() {
	Pilha *novo;
	novo = (Pilha*)malloc(sizeof(Pilha));
	novo->prim = NULL;
	return novo;
}

void push(Pilha *p, int num) {
	No *novo;
	novo = (No*)malloc(sizeof(No));
	
	if(novo!=NULL) {
		novo->info = num;
	   	novo->prox = p->prim;
		p->prim = NULL;
	}
	else {
		printf("Nao foi possivel alocar");
	}
	
	p->prim = novo;
}


void imprimir(Pilha *p) {
	No *aux = p->prim;
	
	if(aux == NULL){
		printf("Lista vazia");
	}
	
	else {
		while(aux != NULL){
			printf("%d ", aux->info);
			aux = aux->prox;
		}
	}
}

int pop(Pilha *p){
	int r;
	No *aux;
	
	if(p->prim == NULL){
		printf("Pilha esta vazia");
		exit(1);
	}
	
	else {
		r = p->prim->info;
		aux = p->prim->prox;
		
		free(p->prim);
		p->prim = aux;
		return r;
	}
}

void elimina(Pilha *p){
	if(p->prim == NULL){
		printf("Pilha esta vazia\n");
	}
	
	else{
		No *aux;
		
		while(p->prim != NULL){
			aux = p->prim->prox;
			free(p->prim);
			p->prim = aux;
		}
	}
}

void inverter(Pilha *P){
	if(P->prim == NULL){
		printf("Lista esta vazia\n");
	}
	
	else {
		int i = 0;
		int num = 0;
		No *aux = P->prim;

		while(aux != NULL){
			num++;
			aux = aux->prox;
		}
		
		int vet[num];
		aux = P->prim;
		
		while(aux != NULL){
			vet[i] = aux->info;
			aux = aux->prox;
			i++;
		}
		
		aux = P->prim;
		
		for(i = 0; i < num; i++){
			aux->info = vet[num - (i + 1)];
			aux = aux->prox;
		}

	}
}

int main () {
	Pilha *P1;
	P1 = cria();
	
	push(P1, 4);
	push(P1, 5);
	push(P1, 6);
	push(P1, 7);
	
	inverter(P1);
	
	imprimir(P1);
	return 0;
}