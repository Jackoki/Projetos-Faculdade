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

int igual(Arvore *a, Arvore *b){
	int i = 0;
	
	if(a == NULL && b == NULL) {
		return 0;
	}
	
	if(a == NULL || b == NULL) {
		return 1;
	}
	
	else {
		if(a->x == b->x){
			i += igual(a->esq, b->esq);
			i += igual(a->dir, b->dir); }		
			
		else {
			return 1;
		}	
	}
	

			
 	
 	return i;
}

int main() {
	int i;
	
	Arvore *a1;
	a1 = inicializa();
	a1 = cria(1, cria(1, cria(4, inicializa(), inicializa()), inicializa()), cria(5, inicializa(), inicializa())), cria(3, cria(6, inicializa(), inicializa()), cria(7, inicializa(), inicializa()));
	
	Arvore *a2;
	a2 = inicializa();
	a2 = cria(1, cria(2, cria(3, inicializa(), inicializa()), inicializa()), cria(5, inicializa(), inicializa())), cria(3, cria(6, inicializa(), inicializa()), cria(7, inicializa(), inicializa()));
	
	i = igual(a1, a2);
	printf("%d", i);
	
	return 0;
}