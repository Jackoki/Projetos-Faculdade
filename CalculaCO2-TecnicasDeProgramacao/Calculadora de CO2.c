#include <stdio.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	char nome[30];
	int idade;
}Info; //Cria struct para registrar dados do usuário

typedef struct {
	float gas, energia;
	float combustivel;
	float horaviagem;
	float carne, queijo;
	float roupas, eletronicos;
}Consumo; //Cria struct para registrar a quantidade de consumo do usuário

typedef struct {
	float CO2_energia;
	float CO2_transporte;
	float CO2_transporteaereo;
	float CO2_comida;
	float CO2_consumo;
}Emissao; //Cria struct para registrar a quantidade de emissao por categoria

float consumomedia[] =  {0.25, 188.3, 108.3, 1.8, 2.06, 0.416, 7.5, 3.5}; //Vetor de valores médios de consumo (gas, energia, combustivel, horas de viagem aerea, carne, queijo, roupas e eletronicos) do brasileiro
float emissaomedia[] = {25.38, 265.22, 13.5, 133.58, 17.37}; //Vetor de valores médios de emissão de CO2 mensal do brasileiro por categoria. 

Info *cadastro(); // Função para cadastro de dados com registros e alocação dinamica de memória. Função que utiliza ponteiros

float cal_energia(float *quant_gas, float *quant_energia); //Função para calcular CO2 emitido por KWH e gás
float cal_transporte(float *quant_combustivel); //Função para calcular CO2 emitido por consumo de combustivel
float cal_transporteaereo(float *quant_horaviagem); //Função para calcular CO2 emitido por hora de viagem aerea
float cal_comida(float *quant_carne, float *quant_queijo); //Função para calcular CO2 emitido por KGs de comida
float cal_consumo(float *quant_roupas, float *quant_eletronicos); //Função para calcular CO2 emitido por consumos
float cal_total(float energia, float transpo, float transpoaereo, float comida, float consumo); //Função para somar o total de CO2 emitido. Função com passagem por valor

void compara_consumo(Consumo quantidade);//Função que busca os dados de consumo do usuario para comparar com a media brasileira. Função com busca de dados
void compara_emissao(Emissao categoria);//Função que busca os dados de emissao do usuario para comparar com a media brasileira. Função com busca de dados

void apresentacao(Info informacao, Consumo quantidade, Emissao categoria, float total);//Uma função para apresentação dos dados cadastrados
void salvararquivo(Info informacao, Consumo quantidade, Emissao categoria, float total);//Função para gravação de dados em um arquivo texto

int main(){
	Consumo quantidade; //Cria uma struct global do tipo Consumo
	Emissao categoria; //Cria uma struct global do tipo Emissao
	Info *informacao; //Cria um ponteiro de struct do tipo Info
	
	int escolha, opcao;
	float total;
	
	informacao = cadastro(); //Cadastra dados da pessoa
	
	categoria.CO2_energia = cal_energia(&quantidade.gas, &quantidade.energia); //Insere informações e calcula KGs de CO2 sobre consumo de energia e gas por mês
	categoria.CO2_transporte = cal_transporte(&quantidade.combustivel); //Insere informações e calcula  KGs de CO2 sobre combustivel por mês
	categoria.CO2_transporteaereo = cal_transporteaereo(&quantidade.horaviagem); //Insere informações e calcula  KGs de CO2 sobre viagens aereas por mês
	categoria.CO2_comida = cal_comida(&quantidade.carne, &quantidade.queijo); //Insere informações e calcula  KGs de CO2 sobre comida por mês
	categoria.CO2_consumo = cal_consumo(&quantidade.roupas, &quantidade.eletronicos); //Insere informações e calcula  KGs de CO2 sobre atos de consumo por mês
	
	printf("========================Confirmacao de dados========================\n");
	do {
		fflush(stdin);
		printf("\nAperte '1' se queira mudar algum dado e '2' para consultar algum dado e '3' caso queira sair: ");
		scanf("%d", &opcao);
		
		if (opcao == 1) {
				do {
					escolha = 0;
					printf("\nDigite '1' para mudar informacoes de energia/gas\nDigite '2' para mudar informacoes de combustiveis\nDigite '3' para mudar informacoes de viagens aereas\nDigite '4' para mudar informacoes de comida\nDigite '5' para mudar informacoes de consumo: ");
					scanf("%d", &escolha);
					
					switch(escolha) {
						case 1:
							categoria.CO2_energia = cal_energia(&quantidade.gas, &quantidade.energia);
							break;
			
						case 2:
							categoria.CO2_transporte = cal_transporte(&quantidade.combustivel); 
							break;
						
						case 3:
							categoria.CO2_transporteaereo = cal_transporteaereo(&quantidade.horaviagem);
							break;
											
						case 4:
							categoria.CO2_comida = cal_comida(&quantidade.carne, &quantidade.queijo);
							break;
						
						case 5:
							categoria.CO2_consumo = cal_consumo(&quantidade.roupas, &quantidade.eletronicos);
							break;
						
						default:
							printf("Opcao invalida\n");
							break; }
						
					}while (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4 && escolha != 5);
		}
		
		else if (opcao == 2) {
				do {
					escolha = 0;
					printf("\nDigite '1' para comparar quantidade de consumo do usuario com media brasileira\nDigite '2' para comparar CO2 emitido por categoria com a media brasileira: ");
					scanf("%d", &escolha);
					switch(escolha) {
						case 1:
							compara_consumo(quantidade);
							break;
			
						case 2:
							compara_emissao(categoria); 
							break;
						
						default:
							printf("Opcao invalida\n");
							break; }
						
					} while (escolha != 1 && escolha != 2);
		}
		
		else if (opcao == 3) {
			printf("Dados registrados!");
		}
		
		else {
			printf("Opcao invalida");
		}
		
	} while (opcao != 3);
		printf("\n=====================================================================\n\n");
	
	total = cal_total(categoria.CO2_energia, categoria.CO2_transporte, categoria.CO2_transporteaereo, categoria.CO2_comida, categoria.CO2_consumo); // Calcula o total de CO2 emitido por mês
	
	apresentacao(*informacao, quantidade, categoria, total); //Chama função para imprimir na tela as informações registradas
	salvararquivo(*informacao, quantidade, categoria, total); //Chama função para salvar informações em um arquivo TXT
	
	free(informacao); //Libera o espaço alocado da struct informação
	return 0;	
}



Info *cadastro(){
	printf("====Registro de informacoes====\n");
	Info *informacao;
	informacao = malloc(sizeof(Info));
	
	printf("Digite a sua idade: ");
	scanf("%d", &informacao->idade);
	
	fflush(stdin);
	
	printf("Digite o seu nome: ");
	fgets(informacao->nome, 30, stdin);
	printf("===============================\n\n");
	
	return informacao;
}

float cal_energia(float *quant_gas, float *quant_energia) {
	printf("\n===========================Coloque os dados de energia e gas consumido===========================\n");
	float gas, energia;
	
	printf("Digite aqui quantos kWh voce gasta por mes: ");
	scanf("%f", &energia);
	*quant_energia = energia;
	energia *= 0.0817;
	

	printf("Digite quantos botijoes P13 voce utiliza por mes (se utiliza <1, coloque o valor em decimal): " );
	scanf("%f", &gas);
	*quant_gas = gas;
	gas *= 40;
	
	printf("=================================================================================================\n\n");
	return (gas + energia);
}


float cal_transporte(float *quant_combustivel) {
	printf("\n===========================Coloque os dados de combustiveis===========================\n");
	float combustivel;
	int opcao;
	
	do {
		printf("Qual tipo de combustivel voce utiliza? Digite 1 para gasolina, 2 para diesel e 3 para etanol: ");
		scanf("%d", &opcao);
		
		switch(opcao) {
			case 1:
				printf("Digite quantos litros de gasolina voce utiliza por mes: " );
				scanf("%f", &combustivel);
				*quant_combustivel = combustivel;
				combustivel *= 2.28;
				break;
			
			case 2:
				printf("Digite quantos litros de diesel voce utiliza por mes: " );
				scanf("%f", &combustivel);
				*quant_combustivel = combustivel;
				combustivel *= 1.9;
				break;
			
			case 3:
				printf("Digite quantos litros de etanol voce utiliza por mes: " );
				scanf("%f", &combustivel);
				*quant_combustivel = combustivel;
				combustivel *= 1.9;
				break;
			
			default:
				printf("Opcao invalida\n");
				break;
		}
	} while (opcao != 1 && opcao != 2 && opcao != 3);
	
	printf("======================================================================================\n\n");
	
	return combustivel;
}


float cal_transporteaereo(float *quant_horaviagem) {
	printf("\n=======================Coloque os dados de viagens aereas=======================\n");
	float horaviagem;
	
	printf("Digite quantas horas de aviao voce viajou no ultimo ano: ");
	scanf("%f", &horaviagem);
	*quant_horaviagem = horaviagem;
	
	
	horaviagem *= 90;
	horaviagem /= 12;
	
	printf("================================================================================\n\n");
	
	return horaviagem;
}


float cal_comida(float *quant_carne, float *quant_queijo) {
	printf("\n========================Coloque os dados de comida========================\n");
	float carne, queijo;
	
	printf("Digite quantos KG de carne bovina voce come por mes: ");	
	scanf("%f", &carne);
	*quant_carne = carne;
	carne *= 60;
	
	printf("Digite quantos KG de queijo voce come por mes: ");
	scanf("%f", &queijo);
	*quant_queijo = queijo;
	queijo *= 24;
	
	printf("==========================================================================\n\n");
	return (carne + queijo);
}


float cal_consumo(float *quant_roupas, float *quant_eletronicos) {
	printf("\n=======================Coloque os dados de consumo=======================\n");
	float roupas, eletronicos;
	
	printf("Digite quantos KG de roupa voce comprou no ultimo ano: ");
	scanf("%f", &roupas);
	*quant_roupas = roupas;
	roupas *= 16.125;
	roupas /= 12;
	
	printf("Digite quantos KG de eletronicos voce comprou no ultimo ano: ");
	scanf("%f", &eletronicos);
	*quant_eletronicos = eletronicos;
	eletronicos *= 25;
	eletronicos /= 12;
	
	printf("=========================================================================\n\n");
	return (roupas + eletronicos);
}

float cal_total(float energia, float transpo, float transpoaereo, float comida, float consumo) {
	return (energia + transpo + transpoaereo + comida + consumo);
}

void compara_consumo(Consumo quantidade) {
	int opcao;
	printf("\nDigite qual informacao queira comparar:\n1 - Gas\n2 - Energia\n3 - Combustivel\n4 - Tempo de viagem aerea\n5 - Carne\n6 - Queijo\n7 - Roupas\n8 - Eletronicos\n9 - Todos: ");
	scanf("%d", &opcao);
		switch(opcao) {
			case 1:
				printf("\nVoce utilza %.2f de botijao, enquanto a media por brasileiro eh de %.2f botijoes \n", quantidade.gas, consumomedia[0]);
				break;
			
			case 2:
				printf("\nVoce utilza %.1f kWh de energia, enquanto a media por brasileiro eh de %.1f kWh de energia \n", quantidade.energia, consumomedia[1]);
				break;
			
			case 3:
				printf("\nVoce utilza %.1fL de combustivel, enquanto a media por brasileiro eh de %.1fL de combustivel \n", quantidade.combustivel, consumomedia[2]);
				break;
			
			case 4:
				printf("\nVoce viajou %.1f hrs de aviao por ano, enquanto a media por brasileiro eh de %.1f hrs de viagem aerea por ano \n", quantidade.horaviagem, consumomedia[3]);
				break;
			
			case 5:
				printf("\nVoce come %.2f KGs de carne vermelha por mes, enquanto a media por brasileiro eh de %.2f KGs de carne por mes \n", quantidade.carne, consumomedia[4]);
				break;
			
			case 6:
				printf("\nVoce come %.2f KGs de queijo por mes, enquanto a media por brasileiro eh de %.3f KGs de queijo por mes \n", quantidade.queijo, consumomedia[5]);
				break;
			
			case 7:
				printf("\nVoce compra %.1f KGs de roupa por ano, enquanto a media por brasileiro eh de %.1f KGs de roupa por ano \n", quantidade.roupas, consumomedia[6]);
				break;
			
			case 8:
				printf("\nVoce compra %.1f KGs de eletronicos por ano, enquanto a media por brasileiro eh de %.1f KGs de eletronicos por ano \n", quantidade.eletronicos, consumomedia[7]);
				break;
			
			case 9:
				printf("\nSeu consumo medio:\nBotijao de gas: %.2f\nQuantidade de energia: %.1f kWh\nCombustivel: %.1fL\nViagem aerea anual: %.1f hrs\nCarne vermelha: %.2f KGs\nQueijo: %.2f KGs anualmente\nRoupas: %.1f KGs anualmente\nEletronicos: %.1f KGs anualmente", 
				quantidade.gas, quantidade.energia, quantidade.combustivel, quantidade.horaviagem,quantidade.carne,quantidade.queijo,quantidade.roupas,quantidade.eletronicos);
				
				printf("\n\n\nConsumo medio de um brasileiro:\nBotijao de gas: %.2f\nQuantidade de energia: %.1f kWh\nCombustivel: %.1fL\nViagem aerea anual: %.1f hrs\nCarne vermelha: %.2f KGs\nQueijo: %.3f KGs anualmente\nRoupas: %.1f KGs anualmente\nEletronicos: %.1f KGs anualmente\n", 
				consumomedia[0], consumomedia[1], consumomedia[2], consumomedia[3], consumomedia[4], consumomedia[5], consumomedia[6], consumomedia[7]);
				break;

			default:
				printf("Opcao invalida\n");
				break;
		}
}

void compara_emissao(Emissao categoria) {
	int opcao;
	printf("\nDigite qual informacao queira comparar:\n1 - Energia\n2 - Combustivel\n3 - Tempo de viagem aerea\n4 - Comida\n5 - Consumo\n6 - Todos: ");
	scanf("%d", &opcao);
		switch(opcao) {
			case 1:
				printf("\nVoce emite %.2f KGs de CO2 por mes em energia, enquanto a media por brasileiro eh de %.2f KGs \n", categoria.CO2_energia, consumomedia[0]);
				break;
			
			case 2:
				printf("\nVoce emite %.2f KGs de CO2 por mes em combustivel, enquanto a media por brasileiro eh de %.2f KGs \n", categoria.CO2_transporte, consumomedia[1]);
				break;
			
			case 3:
				printf("\nVoce emite %.2f KGs de CO2 por mes em viagens aereas, enquanto a media por brasileiro eh de %.2f KGs \n", categoria.CO2_transporteaereo, consumomedia[2]);
				break;
			
			case 4:
				printf("\nVoce emite %.2f KGs de CO2 por mes em comida, enquanto a media por brasileiro eh de %.2f KGs \n", categoria.CO2_comida, consumomedia[3]);
				break;
			
			case 5:
				printf("\nVoce emite %.2f KGs de CO2 por mes em atos de consumo, enquanto a media por brasileiro eh de %.2f KGs \n", categoria.CO2_consumo, consumomedia[4]);
				break;
			
			case 6:
				printf("\nSua emissao media mensal por categoria eh:\nEnergia: %.2f KGs de CO2\nCombustivel: %.2f KGs de CO2\nViagens aereas: %.2f KGs de CO2\nComida: %.2f KGs de CO2\nAtos de consumo: %.2f KGs de CO2\n", 
				categoria.CO2_energia, categoria.CO2_transporte, categoria.CO2_transporteaereo, categoria.CO2_comida, categoria.CO2_consumo);
				
				printf("\n\n\nEmissao media de um brasileiro:\nEnergia: %.2f KGs de CO2\nCombustivel: %.2f KGs de CO2\nViagens aereas: %.2f KGs de CO2\nComida: %.2f KGs de CO2\nAtos de consumo: %.2f KGs de CO2\n", 
				emissaomedia[0], emissaomedia[1], emissaomedia[2], emissaomedia[3], emissaomedia[4]);
				break;

			default:
				printf("Opcao invalida\n");
				break;
		}
}

void apresentacao(Info informacao, Consumo quantidade, Emissao categoria, float total) {
	printf("\n========================Informacoes registradas========================\n");
	printf("Idade: %d\nNome: %s\n", informacao.idade, informacao.nome);
	
	printf("\nSeu consumo medio:\nBotijao de gas: %.2f\nQuantidade de energia: %.1f kWh\nCombustivel: %.1fL\nViagem aerea anual: %.1f hrs\nCarne vermelha: %.2f KGs\nQueijo: %.2f KGs anualmente\nRoupas: %.1f KGs anualmente\nEletronicos: %.1f KGs anualmente", 
	quantidade.gas, quantidade.energia, quantidade.combustivel, quantidade.horaviagem,quantidade.carne,quantidade.queijo,quantidade.roupas,quantidade.eletronicos);
	
	printf("\n\n\nSua emissao media mensal por categoria eh:\nEnergia: %.2f KGs de CO2\nCombustivel: %.2f KGs de CO2\nViagens aereas: %.2f KGs de CO2\nComida: %.2f KGs de CO2\nAtos de consumo: %.2f KGs de CO2\n", 
	categoria.CO2_energia, categoria.CO2_transporte, categoria.CO2_transporteaereo, categoria.CO2_comida, categoria.CO2_consumo);
	
	printf("\nTotal de CO2 emitido por mes: %f KGs", total);
	
	printf("\n=======================================================================\n");
}

void salvararquivo(Info informacao, Consumo quantidade, Emissao categoria, float total) {
	FILE *fp;
	fp = fopen("dados.txt", "w");
	
	if(fp) {
		fprintf(fp, "Idade: %d\nNome: %s\n\nSeu consumo medio:\nBotijao de gas: %.2f\nQuantidade de energia: %.1f kWh\nCombustivel: %.1fL\nViagem aerea anual: %.1f hrs\nCarne vermelha: %.2f KGs\nQueijo: %.2f KGs anualmente\nRoupas: %.1f KGs anualmente\nEletronicos: %.1f KGs anualmente\n\n\nSua emissao media mensal por categoria eh:\nEnergia: %.2f KGs de CO2\nCombustivel: %.2f KGs de CO2\nViagens aereas: %.2f KGs de CO2\nComida: %.2f KGs de CO2\nAtos de consumo: %.2f KGs de CO2\n\nTotal de CO2 emitido por mes: %f KGs", 
		informacao.idade, informacao.nome, quantidade.gas, quantidade.energia, quantidade.combustivel, quantidade.horaviagem,quantidade.carne,quantidade.queijo,quantidade.roupas,quantidade.eletronicos, categoria.CO2_energia, categoria.CO2_transporte, categoria.CO2_transporteaereo, categoria.CO2_comida, categoria.CO2_consumo, total);
		fclose(fp);
		printf("\nArquivo criado com sucesso.");
	}
	else {
		printf("\nFalha ao criar o arquivo.");
	}
		} 