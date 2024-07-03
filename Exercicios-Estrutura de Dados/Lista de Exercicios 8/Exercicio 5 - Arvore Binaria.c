#include <stdio.h>
#include <stdlib.h>

struct arvore {
	int x;
	struct arvore *esq;
	struct arvore *dir;
};

typedef struct arvore Arvore;

Arvore* inicializa(){
	return NULL;
}

Arvore* cria(int x, Arvore *sae, Arvore *sad){
	Arvore *novo;
	novo = (Arvore*)malloc(sizeof(Arvore));
	
	novo->x = x;
	novo->esq = sae;
	novo->dir = sad;
	
	return novo;
}


int contador(Arvore* a){
	int i = 0;
	
	if(a != NULL){
		i++;
		i += contador(a->esq);
		i += contador(a->dir);
	}

	return i;
}

int main() {
	int i;
	
	Arvore *a1;
	a1 = inicializa();
	
	a1 = cria(1, cria(1, cria(1, inicializa(), inicializa()), inicializa()), cria(5, inicializa(), inicializa())), cria(3, cria(6, inicializa(), inicializa()), cria(7, inicializa(), inicializa()));
	i = contador(a1);
	
	printf("%d", i);
	
	return 0;
}