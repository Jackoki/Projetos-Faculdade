#include <stdio.h>
#include <stdlib.h>
//Exercicio 1

struct lista {
	int num;
	struct lista *prox;
};
typedef struct lista Lista;

Lista* separa(Lista *l, int valor){
    Lista *p1 = l;
    Lista *p2 = NULL;

    while (p1->num != valor) {
        p1 = p1->prox;
    }

    p2 = p1->prox;
    p1->prox = NULL;

    return p2;
}

Lista* insere(Lista *l, int valor){
	Lista *novo;
	novo = (Lista*)malloc(sizeof(Lista));
	novo->num = valor;
	novo->prox = l;
	return novo;
}

void imprimir(Lista *l){
	Lista *p = l;
	while(p!=NULL){
		printf("%x [%d | %x] -> ",p, p->num, p->prox);
		p = p->prox;
	}
}


int main(){
	Lista *prox1;
	Lista *prox2;
	
	prox1 = NULL;
	
	prox1 = insere(prox1, 1);
	prox1 = insere(prox1, 12);
	prox1 = insere(prox1, 5);
	prox1 = insere(prox1, 17);
	prox1 = insere(prox1, 3);
	imprimir(prox1);
	
	
	prox2 = separa(prox1, 5);
	printf("\n");
	imprimir(prox1);
	printf("\n");
	imprimir(prox2);
	
	return 0;
}