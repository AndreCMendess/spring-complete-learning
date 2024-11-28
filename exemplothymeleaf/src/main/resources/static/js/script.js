function atualizarProduto(element){
    if(element.innerHTML ==='Esgotado'){
        element.innerHTML = 'A Venda';
        element.className = 'produto-a-venda';
    } else {
         element.innerHTML = 'Esgotado';
        element.className = 'produto-vendido';
    }
}