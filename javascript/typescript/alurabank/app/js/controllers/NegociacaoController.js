class NegociacaoController {
    private _inputData: HttpInputElement;
    private _inputQuantidade: HttpInputElement;
    private _inputValor: HttpInputElement;
    private _negociacoes: Negociacoes = new Negociacoes();

    constructor() {
        this._inputData = document.querySelector('#data');
        this._inputQuantidade = document.querySelector('#quantidade');
        this._inputValor = document.querySelector('#valor');
        this._negociacoes = 
    }
    adiciona(event: Event) {
        event.preventDefault();
        const negociacao = new Negociacao(
            new Date(this._inputData.value.replace(/-/g, '/')), 
            parseInt(this._inputQuantidade.value),
            parseFloat(this._inputValor.value));
        console.log(negociacao);
    }
}
