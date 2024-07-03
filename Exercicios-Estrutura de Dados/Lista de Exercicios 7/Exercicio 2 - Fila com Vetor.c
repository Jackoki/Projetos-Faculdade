#include<stdio.h>
#include<stdlib.h>

#define N 5


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

void FuraFila(Fila *f, float x) {
	if(f->qtd != N) {
		if(f->qtd != 0) {
			f->ini = (f->ini - 1 + N);
			f->vet[f->ini] = x;
		}
		else {
			f->vet[f->ini] = x; 
		} 
		
		f->qtd++;
	}
	
	else {
		printf("\nNao ha espaco para inserir na fila!");
	}
}



int main(){
	Fila *f1;
	f1 = cria();
	
	inserir(f1,2);
	inserir(f1,3);
	inserir(f1,4);
	inserir(f1,5);
	FuraFila(f1, 6);
	
	imprimir(f1);
	

	
	return 0;
}
