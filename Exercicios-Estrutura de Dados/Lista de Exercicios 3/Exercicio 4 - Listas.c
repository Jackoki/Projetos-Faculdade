#include <stdio.h>
#include <stdlib.h>
//Exercicio 4

struct lista {
	float info;
	struct lista *prox;
};
typedef struct lista Lista;

Lista* retira_prefixo(Lista* l, int n){
	int i = 0;
	Lista *p1 = l;
	Lista *p2;
	
	for(i = 0; i < n; i++) {
		p2 = p1;
		p1 = p1->prox;
		free(p2);
	}
	
	return p1;
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
	int num;
	
	prox1 = NULL;
	
	prox1 = insere(prox1, 1);
	prox1 = insere(prox1, 12);
	prox1 = insere(prox1, 5);
	prox1 = insere(prox1, 17);
	prox1 = insere(prox1, 3);
	
	printf("Digite aqui quantos nos queira retirar: ");
	scanf("%d", &num);
	
	prox1 = retira_prefixo(prox1, num);
	
	printf("\n");
	imprimir(prox1);
	
	return 0;
}