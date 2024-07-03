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

int altura(Arvore *a) {
	int i;
	if(a != NULL){
		if(altura(a->esq) > altura(a->dir)){
			return i = 1 + altura(a->esq);
		}
		else {
			return i = 1 + altura(a->dir);
		}
	}
	
	else {
		return 0;
	}
}

int main() {
	int i;
	
	Arvore *a1;
	a1 = inicializa();
	a1 = cria(1, cria(2, cria(4, inicializa(), inicializa()), inicializa()), cria(5, inicializa(), inicializa())), cria(3, cria(6, inicializa(), inicializa()), cria(7, inicializa(), inicializa()));
	
	i = altura(a1);
	printf("%d", i);
	
	return 0;
}