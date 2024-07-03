#include <stdio.h>
#include <stdlib.h>

struct list{
	int x;
	struct list *ponteiro;
};

typedef struct list Lista;

Lista* add(int num, Lista* prim){
	Lista *novo, *aux=prim;
	novo = (Lista*)malloc(sizeof(Lista));
	
    novo->x = num;
	if(prim==NULL){
		prim = novo;
        novo->ponteiro = novo;
    }    
    
	else{			
		while(aux->ponteiro != prim){			
			aux = aux->ponteiro;
		}
		
		aux->ponteiro = novo;
        novo->ponteiro = prim;
        prim = novo;
	}	
   
	return novo;
}


Lista* addFinal(int num, Lista* prim){
	Lista *novo, *aux = prim;;
	novo = (Lista*)malloc(sizeof(Lista));
	
	novo->x = num;
	
	if(prim == NULL){
		prim = novo;
		novo->ponteiro = novo;
	}
	
	else{
		while(aux->ponteiro != prim){
			aux = aux->ponteiro;
		}
		aux->ponteiro = novo;
		novo->ponteiro = prim;
	}
	
	return prim;
}

Lista* excluir(int num, Lista* prim){
	Lista *aux1 = prim, *aux2 = NULL;
	
	if(prim == NULL){
		printf("Lista vazia \n");
	}

	do{ //A gente faz um do while pelo fato que pode ser que apaguemos a 1� struct e se utilizarmos o while apenas, ele n�o funcionar�
		if(aux1->x == num){ //Se o numero encontrado foi o que a gente passou
			
			if(aux2 == NULL){ //Exclui caso foi o primeiro elemento 
				if(aux1->ponteiro == prim){  //Exclui caso foi o primeiro elemento e cont�m apenas 1 struct
					free(aux1);
					return NULL;
				}
				
				else{ //Exclui caso foi o primeiro elemento mas cont�m mais de 1 struct na lista.
					aux2 = aux1; //Fazemos com que o aux2 guarde a 1� struct da lista
					
					while(aux1->ponteiro != prim){ //Enquanto isso, o aux1 vai navegando ate o "final" da lista para modificar o ponteiro da �ltima struct
						aux1 = aux1->ponteiro;
					}
					
					prim = aux2->ponteiro; //Quando ele terminar de sair da modifica��o, o prim ter� agora como valor a 2� struct, sendo a 2� struct guardada como "aux2->ponteiro"
					
					aux1->ponteiro = prim; //Como o aux1 est� na ultima lista, o ponteiro dele apontara para o come�o
					
					free(aux2); //Apagamos entao o 1� elemento da struct e retornamos a struct
					return prim; 
				}
			}
			
			else{ //Exclui a partir do meio da lista, ser� ativada depois do aux2 = aux1 && aux1 = aux2->ponteiro
				aux2->ponteiro = aux1->ponteiro; // O aux2 est� como o anterior, e ent�o o ponteiro do anterior receber� o ponteiro do atual
				free(aux1);
				return prim;
			}
		}
		
		aux2 = aux1; //Ser� ativado essa condi��o caso o numero n�o for o que estamos procurando
		aux1 = aux2->ponteiro; //Ser� ativado essa condi��o caso o numero n�o for o que estamos procurando
	} while(aux1 != prim); 
	
	printf("\n O numero enviado nao existe na lista"); //Como todas as condi��es retorna, ent�o se ele nao retornar algo, � porque nao existe o numero na lista
	return prim;
}

void imprimir(Lista* prim){
	Lista* aux = prim;
	
	if(prim == NULL){
		printf("Lista vazia");
	}
	
	else{
		do{
			printf("%d ", aux->x);
			aux = aux->ponteiro;
		}while(aux != prim);
	}
	
}

Lista* retira_prefixo(Lista* l, int n){
	int i, contador = 0;
	Lista* aux = l;
	Lista* aux2 = l;
	Lista* aux3 = l;
	
	Lista* contElementos = l;
	
	
	if(n == 0 || l == NULL){
		return l;
	}
	
	
	else{
		do{
			contador++;
			contElementos = contElementos->ponteiro;
		}while(contElementos != aux);
		
		if(n >= contador){
			return NULL;
		}
		
		else{
			for(i = 0; i < n; i++){
				
				do{
					aux2 = aux2->ponteiro;
				}while(aux2->ponteiro != aux);
			
				aux2->ponteiro = aux3->ponteiro;
			
				aux3 = aux3->ponteiro;
			
				free(aux);
			
				aux = aux3;	
			}
		return aux;	
		}
	}
}



int main(){
	Lista* prim = NULL;
	
	prim = addFinal(1, prim);
	prim = addFinal(2, prim);
	prim = addFinal(3, prim);
	prim = addFinal(4, prim);
	
	imprimir(prim);	
	printf("\n");
	
	prim = retira_prefixo(prim, 2);
		
	imprimir(prim);	

	
	return 0;
}