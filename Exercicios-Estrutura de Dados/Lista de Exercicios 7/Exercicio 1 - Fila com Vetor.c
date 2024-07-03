#include<stdio.h>
#include<stdlib.h>

#define N 4


struct fila{
	int ini;
	int fim;
	int qtd;
	float vet[N];
};
typedef struct fila Fila;

Fila* cria(){
	Fila* novo;
	novo = (Fila*) malloc(sizeof(Fila));
	novo->ini=0;
	novo->fim=0;
	novo->qtd=0;
	return novo;
}

int incr(int i){
	return (i+1)%N;
}

void inserir(Fila *f, float v){
	if(f->qtd!=N){
		f->vet[f->fim] = v;
		f->fim = incr(f->fim);
		f->qtd++;
	}
	else
		printf("\nNao ha espaco para inserir na fila!");
}

float retirar(Fila *f){
	float r;
	if(f->qtd==0){
		printf("\nFila vazia!");
		exit(1);
	}
	else{
		r = f->vet[f->ini];
		f->ini = incr(f->ini);	
		f->qtd--;	 
	}
	return r;
}

void imprimir(Fila* f1){
	int i, aux=f1->ini;	
	for(i=0; i<f1->qtd; i++){ 			
		printf("%.2f\t", f1->vet[aux]);	
		aux = incr(aux);	
	}
	printf("\n");
}

void imprimirQuantidade(Fila* f1){
	printf("A quantidade eh: %d\n", f1->qtd);
}

int main(){
	Fila *f1;
	f1 = cria();
	
	inserir(f1,2);
	inserir(f1,4);
	inserir(f1,6);
		
	imprimir(f1);
	retirar(f1);
	
	inserir(f1,8);	
	inserir(f1,9);
	imprimir(f1);
	
	imprimirQuantidade(f1);
	
	return 0;
}
