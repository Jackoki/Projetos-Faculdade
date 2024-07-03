function calcularEmissao() {
    const kwh = parseFloat(document.getElementById('kwh').value);
    const gas = parseFloat(document.getElementById('gas').value);
    const combustivel = parseFloat(document.getElementById('combustivel').value);
    
    const tipoCombustivelElement = document.querySelector('input[name="combustivel"]:checked');
    if (!tipoCombustivelElement) {
        return;
    }
    const tipoCombustivel = tipoCombustivelElement.value;
    
    const aviao = parseFloat(document.getElementById('aviao').value);
    const carne = parseFloat(document.getElementById('carne').value);
    const queijo = parseFloat(document.getElementById('queijo').value);
    const cafe = parseFloat(document.getElementById('cafe').value);
    const roupa = parseFloat(document.getElementById('roupa').value);
    const eletronicos = parseFloat(document.getElementById('eletronicos').value);

    const fatorKwh = 0.0817;
    const fatorGas = 39.4;
    const fatorCombustivel = {
        gasolina: 2.28,
        etanol: 1.867,
        diesel: 3.2
    };
	
    const fatorAviao = 90 / 12;
    const fatorCarne = 60;
    const fatorQueijo = 24;
    const fatorCafe = 1;
    const fatorRoupa = 16.125;
    const fatorEletronicos = 25;

    const emissaoKwh = kwh * fatorKwh;
    const emissaoGas = gas * fatorGas;
    const emissaoCombustivel = combustivel * fatorCombustivel[tipoCombustivel];
    const emissaoAviao = aviao * fatorAviao;
    const emissaoCarne = carne * fatorCarne;
    const emissaoQueijo = queijo * fatorQueijo;
    const emissaoCafe = cafe * fatorCafe;
    const emissaoRoupa = (roupa / 12) * fatorRoupa;
    const emissaoEletronicos = (eletronicos / 12) * fatorEletronicos;

    const emissaoTotal = emissaoKwh + emissaoGas + emissaoCombustivel + emissaoAviao + emissaoCarne + emissaoQueijo + emissaoCafe + emissaoRoupa + emissaoEletronicos;

    document.getElementById('resultadoEmissao').textContent = emissaoTotal.toFixed(2) + " KGs";
}