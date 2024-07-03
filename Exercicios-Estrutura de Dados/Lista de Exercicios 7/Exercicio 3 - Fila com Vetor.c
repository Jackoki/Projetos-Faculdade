#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 5

struct no {
	int id;
	char descricao[20];	
};
typedef struct no No;

struct fila {
	int ini;
	int fim;
	int qtd;
	No vet[N];
};

typedef struct fila Fila;

Fila* cria() {
    Fila* novo = (Fila*)malloc(sizeof(Fila));
    novo->ini = 0;
    novo->fim = 0;
	novo->qtd = 0;
    return novo;
}

int incr(int i) {
    return (i + 1) % N;
}

void inserir(Fila* f, int id, char descricao[20]) {
    if (f->qtd != N) {
        f->vet[f->fim].id = id;
        strcpy(f->vet[f->fim].descricao, descricao);
		
        f->fim = incr(f->fim);
        f->qtd++;
    }
    else {
        printf("\nNao ha espaco para inserir na fila!");
    }
}

void retirar(Fila* f) {
	No aux;
	
    if (f->qtd == 0) {
        printf("\nFila vazia!");
        exit(1);
    }
    else {
        aux = f->vet[f->ini];
        f->ini = incr(f->ini);
        f->qtd--;
    }
}

void imprimir(Fila* f1) {
    int i, aux = f1->ini;
    for (i = 0; i < f1->qtd; i++) {
        printf("%d, %s\n", f1->vet[aux].id, f1->vet[aux].descricao);
        aux = incr(aux);
    }
}


int main() {
    Fila* f = cria();
	inserir(f, 1, "Processo numero 1");
	inserir(f, 2, "Processo numero 2");
	inserir(f, 3, "Processo numero 3");
	inserir(f, 4, "Processo numero 4");
	retirar(f);


    imprimir(f);

    return 0;
}
