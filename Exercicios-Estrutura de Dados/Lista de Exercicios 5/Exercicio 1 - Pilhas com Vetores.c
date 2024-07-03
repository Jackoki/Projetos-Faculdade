#include<stdio.h>
#include<stdlib.h>

#define MAX 50

struct pilha {
	int n;
	float vet[MAX];
};
typedef struct pilha Pilha;

Pilha* cria(){
	Pilha *novo;
	novo = (Pilha*)malloc(sizeof(Pilha));
	novo->n = 0;	
	return novo;
}

void push(Pilha *p, float v){
	if(p->n==MAX)
		printf("Stack overflow!");
	else{
		p->vet[p->n] = v;
		p->n++;
	}
}

void imprimir(Pilha *p){
	int i;
	if(p->n==0)
		printf("Pilha vazia!");
	else{
		for(i=0;i<p->n;i++)
			printf("Vet[%d] = %f\n", i, p->vet[i]);
	}
}

int vazia(Pilha *p){
	return p->n==0;
}

float pop(Pilha *p){
	float r=-1;
	if(vazia(p)){	
		printf("Pilha vazia!");
		exit(0);
	}
	else{
		r = p->vet[p->n-1];
		p->n--;
	}	
	return r;	
}

Pilha* libera(Pilha *p){
	free(p);
	return NULL;
}

int testaMaisElementos(Pilha *p1, Pilha *p2){
	if(p1->n > p2->n){
		return 1;
	}

	return 0;
}

int main(){
	int i;
	Pilha *P1;
	Pilha *P2;
	
	P1 = cria();
	P2 = cria();
	
	push(P1,4.2);
	push(P1,1.1);
	push(P1,0.2);
	push(P1,7.2);
	
	push(P2,4.2);
	push(P2,1.1);
	push(P2,0.2);	
	
	
	i = testaMaisElementos(P1, P2);
	imprimir(P1);
	printf("\n");
	imprimir(P2);
	printf("\n%d", i);
	P1 = libera(P1);
	P2 = libera(P2);
				
	return 0;
}