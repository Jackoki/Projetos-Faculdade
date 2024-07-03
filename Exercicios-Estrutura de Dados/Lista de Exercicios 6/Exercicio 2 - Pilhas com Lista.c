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

void transferirElementos(Pilha *P1, Pilha *P2, int *flagErro){
	if(P1->prim == NULL){
		printf("Lista esta vazia");
		*flagErro = 1;
	}
	else {
		No *aux1 = P1->prim;
		P2->prim = aux1;
		No *aux2 = P2->prim;
		
		while(aux1 != NULL){
			aux2->info = aux1->info;
			aux2->prox = aux1->prox;
			
			aux1 = aux1->prox;
			aux2 = aux2->prox;
		}
		
		*flagErro = 0;
	}
}

int main () {
	int num;
	Pilha *P1, *P2;
	P1 = cria();
	P2 = cria();
	
	push(P1, 4);
	push(P1, 5);
	push(P1, 6);
	push(P1, 7);
	
	transferirElementos(P1, P2, &num);
	
	printf("%d\n", num);
	imprimir(P1);
	
	printf("\n");
	imprimir(P2);
	
	return 0;
}