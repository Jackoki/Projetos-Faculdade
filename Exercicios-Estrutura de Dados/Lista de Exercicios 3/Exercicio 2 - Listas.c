#include <stdio.h>
#include <stdlib.h>
//Exercicio 2

struct lista{
	float info;
	struct lista *prox;
};
typedef struct lista Lista;

Lista* concatena(Lista *l1, Lista *l2){
	if(l1 == NULL) {
		return l2;
	}
	
	else if(l2 == NULL) {
		return l1;
	}
	
	
    Lista *p1 = l1;

    while (p1->prox != NULL) {
        p1 = p1->prox;
    }
    
    p1->prox = l2;

    return l1;
}

Lista* insere(Lista *l, float valor){
	Lista *novo;
	novo = (Lista*)malloc(sizeof(Lista));
	novo->info = valor;
	novo->prox = l;
	return novo;
}

void imprimir(Lista *l){
	Lista *p = l;
	while(p!=NULL){
		printf("%x [%f | %x] -> ",p, p->info, p->prox);
		p = p->prox;
	}
}


int main(){
	Lista *prox1;
	Lista *prox2;
	
	prox1 = NULL;
	prox2 = NULL;
	
	prox1 = insere(prox1, 1.0);
	prox1 = insere(prox1, 4.5);
	prox1 = insere(prox1, 2.1);
	
	prox2 = insere(prox2, 9.8);
	prox2 = insere(prox2, 7.2);
	
	prox1 = concatena(prox1, prox2);
	printf("\n");
	imprimir(prox1);
	
	return 0;
}