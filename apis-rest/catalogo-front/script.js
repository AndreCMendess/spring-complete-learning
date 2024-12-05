$(document).ready(function () {

    function carregarCatalogo() {
        $.ajax({
            url:'http://localhost:8080/catalogo',
            method: 'GET',
            success: function (data){
                $('#tabelaProdutos tbody').empty();    

                for(let i=0; i< data.length; i++){
                    let produto = data[i];
                    let checkbox = $('<input>')
                    .attr('type','checkbox')
                    .prop('checked',produto.status)
                    .change(function () {
                        atualizarProduto($(this).closest('tr').attr('data-id'), {
                            descricao: produto.descricao,
                            status: $(this).prop('checked')
                        });
                    });
                    let id = $('<td>')
                    .text(produto.id);
                    let descricao = $('<input>')
                    .attr('type', 'text')
                    .val(produto.descricao)
                    .blur(function (){
                        atualizarProduto($(this).closest('tr').attr('data-id'),{
                            descricao: $(this).val(),
                            status: produto.status
                        });
                    });
                    let vendido = $('<td>')
                        .append(checkbox);
                    let botaoDeletar = $('<button>')
                        .text('Excluir')
                        .click(function () {
                            deletarProduto($(this).closest('tr').attr('data-id'));
                        });  
                    let excluir = $('<td>')
                        .append(botaoDeletar);    
                    let tr = $('<tr>')
                        .attr('data-id', produto.id)    
                        .append(id)
                        .append($('<td>').append(descricao))
                        .append(vendido)
                        .append(excluir);
                    $('#tabelaProdutos tbody').append(tr);    

                }
            },
            error: function () {
                alert("Não foi possivel carregar as tarefas da api");
            }
        })
    }

    function criarProduto(produto){
        $.ajax({
            url: 'http://localhost:8080/catalogo', 
            method:'POST',
            contentType: 'application/json', 
            data: JSON.stringify(produto),
            success: function (data) {
                $('#descricao').val(``);
                carregarCatalogo();
            },
            error: function () {
                alert("Não foi possivel cadastrar o produto na API.");
            }
        });
    }

    $('#formCriarProduto').submit(function (event) { 
        event.preventDefault();
        let descricao = $('#descricao').val();
        if(!descricao) {
            alert('Por favor, preencha a descrição do produto.'); 
            return; 
        }
        let produto = {
            descricao: descricao,
            status: true
        };
        criarProduto(produto);
    });

    function atualizarProduto(id, produto){
        $.ajax({
            url: 'http://localhost:8080/catalogo/' + id,
            method:'PUT',
            contentType:'application/json',
            data: JSON.stringify({ 
                descricao: produto.descricao, 
                status: produto.status
            }),
            success: function(data) {
                alert("Produto atualizado na api com sucesso");
                carregarCatalogo();
            }, 
            error: function () { 
                alert('Não foi possível atualizar a tarefa na API.'); 
            }        
        });
    }

    function deletarProduto(id) {
        $.ajax({ 
            url: 'http://localhost:8080/catalogo/' + id, 
            method: 'DELETE', 
            success: function (data) { 
                alert('Tarefa removida na API com sucesso!'); 
                carregarCatalogo(); 
            }, 
            error: function () { 
                alert('Não foi possível deletar a tarefa na API.'); 
            } 
        }); 
    }

    carregarCatalogo();


})
