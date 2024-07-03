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
		printf("Pilha esta vazia");
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

int testaMaisElementos(Pilha *P1, Pilha *P2){
	if(P1->prim == NULL && P2->prim == NULL) {
		printf("Ambas as listas sao vazias\n");
		return 0;
	}
	
	else if(P1->prim == NULL) {
		printf("A primeira lista eh vazia\n");
		return 0;
	}
	
	else if(P2->prim == NULL) {
		printf("A segunda lista eh vazia\n");
		return 1;
	}
	
	else{
		No* aux1 = P1->prim;
		No* aux2 = P2->prim;
		int num1 = 0, num2 = 0;
		
		while(aux1 != NULL) {
			num1++;
			aux1 = aux1->prox;
		}
		
		while(aux2 != NULL) {
			num2++;
			aux2 = aux2->prox;
		}
		
		if(num1 > num2) {
			return 1;
		}
		else {
			return 0;
		}
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
	
	push(P2, 8);
	push(P2, 9);
	
	num = testaMaisElementos(P1, P2);
	
	printf("%d\n", num);
	imprimir(P1);
	
	printf("\n");
	imprimir(P2);
	
	return 0;
}