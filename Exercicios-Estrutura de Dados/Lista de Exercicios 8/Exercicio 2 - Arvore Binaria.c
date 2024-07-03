#include <stdio.h>
#include <stdlib.h>

struct arvore {
	int x;
	struct arvore *esq;
	struct arvore *dir;	
};
typedef struct arvore Arvore;

Arvore* inicializa() {
	return NULL;
}

Arvore* cria(int x, Arvore *sae, Arvore *sad) {
	Arvore *novo = (Arvore*)malloc(sizeof(Arvore));
	novo->x = x;
	novo->esq = sae;
	novo->dir = sad;
	
	return novo;
}

int ocorrencias(Arvore *a, int x){
	int i = 0;
	
	if(a != NULL){
		i += ocorrencias(a->esq, x);
		i += ocorrencias(a->dir, x);
		
		if(a->x == x) {
			i++;
		}
		
		return i;
	}
	
	else {
		return 0;
	}
}

int main() {
	int i;
	Arvore *a1;
	a1 = inicializa();
	
	a1 = cria(1, cria(1, cria(1, inicializa(), inicializa()), inicializa()), cria(5, inicializa(), inicializa())), cria(3, cria(6, inicializa(), inicializa()), cria(7, inicializa(), inicializa()));
	
	i = ocorrencias(a1, 1);
	printf("%d", i);
	
	return 0;
}

