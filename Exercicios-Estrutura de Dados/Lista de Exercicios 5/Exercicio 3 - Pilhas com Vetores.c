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

void inverter(Pilha *P1){
	if(vazia(P1)){
		printf("Lista vazia, nao eh possivel inverter\n");
	}
	
	else {
		Pilha *aux;
		aux = cria();
		int i;
		
		for(i = 0; i < P1->n; i++){
			aux->vet[i] = P1->vet[P1->n - (i + 1)];
		}
		
		for(i = 0; i < P1->n; i++){
			P1->vet[i] = aux->vet[i];
		}
	}
}

int main(){
	Pilha *P1;
	P1 = cria();
	
	push(P1,4.2);
	push(P1,1.1);
	push(P1,0.2);
	push(P1,7.2);	
	
	
	imprimir(P1);
	printf("\n");

	inverter(P1);
	
	imprimir(P1);
	P1 = libera(P1);
				
	return 0;
}