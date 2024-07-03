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

int iguais(Pilha *p1, Pilha *p2){
	if(p1->prim == NULL && p2->prim == NULL){
		printf("Ambas as listas estao vazias\n");
		return 1;
	}
	
	else if(p1->prim == NULL){
		printf("Lista 1 esta vazia\n");
		return 0;
	}
	
	else if(p2->prim == NULL){
		printf("Lista 2 esta vazia\n");
		return 0;
	}
	
	else {
		No *aux1 = p1->prim;
		No *aux2 = p2->prim;
		int num1 = 0, num2 = 0;
		
		while(aux1 != NULL){
			num1++;
			aux1 = aux1->prox;
		}
		
		while(aux2 != NULL){
			num2++;
			aux2 = aux2->prox;
		}
		
		if(num1 != num2){
			printf("As listas nao contem a mesma quantidade de elementos\n");
			return 0;
		}
		
		else{
			aux1 = p1->prim;
			aux2 = p2->prim;
			
			while(aux1 != NULL && aux2 != NULL) {
				if(aux1->info == aux2->info) {
					aux1 = aux1->prox;
					aux2 = aux2->prox;
				}
				
				else{
					printf("Nao contem o mesmo elemento na lista: %d %d\n", aux1->info, aux2->info);
					return 0;
				}
			}
			
			
			printf("As listas sao iguais\n");
			return 1;
		}
	}
}

int main () {
	int i;
	Pilha *P1, *P2;
	P1 = cria();
	P2 = cria();
	
	push(P1, 4);
	push(P1, 5);
	push(P1, 6);
	push(P1, 7);
	
	push(P2, 4);
	push(P2, 5);
	push(P2, 6);
	push(P2, 7);
	
	i = iguais(P1, P2);
	
	printf("%d \n", i);
	imprimir(P1);
	printf("\n");
	imprimir(P2);
		
	return 0;
}