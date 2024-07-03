#include <stdlib.h>
#include <stdio.h>

struct arvore {
	char info;
	struct arvore *dir;
	struct arvore *esq;
};

typedef struct arvore Arvore;

Arvore* inicializa(){
	return NULL;
}

Arvore* cria(char info, Arvore *sae, Arvore *sad){
	Arvore* p = (Arvore*)malloc(sizeof(Arvore));
	p->info = info;
	p->esq = sae;
	p->dir = sad;
	
	return p;
}

int folhas(Arvore* a){
	int i = 0;
	
	if(a!= NULL) {
		if(a->esq != NULL && a->dir != NULL) {
			i += folhas(a->esq);
			i += folhas(a->dir);
		}
		
		else{
			if(a->esq != NULL) {
				i += folhas(a->esq);
			}
			
			else if(a->dir != NULL) {
				i += folhas(a->dir);
			}
			
			else {
				return 1;
			}
		}
	}
	
	else {
		printf("Lista vazia");
	}
	
	return i;
}

int main () {
	int i = 0;
	Arvore *a1;
	a1 = inicializa();
	
	a1 = cria('a', cria('b', inicializa(), cria('d', inicializa(), inicializa())),cria('c',cria('e', inicializa(), inicializa()),cria('f', inicializa(), inicializa())));
	
	i = folhas(a1);
	printf("%d", i);
	
	return 0;
}