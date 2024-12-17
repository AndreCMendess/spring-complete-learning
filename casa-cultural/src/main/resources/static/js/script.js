$(document).ready(function () {

    function carregarFilmes() {
        $.ajax({
            url:'http://localhost:8080/filmes/tabela-inicio',
            method: 'GET',
            success: function (data) {
                $('#tabelaInicio tbody').empty();
                 $('#filmeSelecionado').empty();

                data.forEach( filme => {
                    let linha = $('<tr>')
                    .append($('<td>').text(filme.titulo))
                    .append($('<td>').text(filme.mediaNota || 'N/A'))
                    .append(
                        $('<td>').append(
                            $('<a>').text('Saiba Mais')
                            .attr('href','/filmes' + filme.id)
                            .attr('class','btn btn-primary')
                        )
                    );
                    $('#tabelaInicio tbody').append(linha);
                    $('#filmeSelecionado').append(
                    $('<option>')
                     .val(filme.id)
                     .text(filme.titulo)
                     );
                });
            },
            error: function() {
                alert('Não foi possível carregar as tarefas da API.');
            }
        });
    };

    function carregarFilmesComAnalises() {
        $.ajax({
            url:'http://localhost:8080/filmes/filmes-analises',
            method:'GET',
            success: function (data) {
                $('#tabelaFilmes tbody').empty();

                data.forEach(filme => {
                    let linha = $('<tr>')
                    .append($('<td>').text(filme.titulo))
                    .append($('<td>').text(filme.sinopse))
                    .append($('<td>').text(filme.genero))
                    .append($('<td>').text(filme.anoLancamento))

                    if(filme.analises && Array.isArray(filme.analises)  && filme.analises.length > 0){
                    let comentarios = filme.analises.map(analise => analise.comentario).join(", ");
                    let mediaNota = filme.mediaNota;
                    linha.append($('<td>').text(comentarios));
                    linha.append($('<td>').text(mediaNota));
                    }else{
                      linha.append($('<td>').text('Sem analises'));
                      linha.append($('<td>').text('N/A'));
                    }

                     let operacoes = $('<td>');
                     let btnDeletar = $('<button>')
                        .addClass('btn btn-danger btn-sm me-2')
                        .html('<i class="fas fa-trash"></i>"')
                        .click(() => deletarFilme(filme.id));

                     let btnAtualizar  = $('<button>')
                        .addClass('btn btn-warning btn-sm')
                        .html('<i class="fas fa-edit"></i>')
                        .click(() => atualizarFilme(filme.id));

                        operacoes.append(btnDeletar).append(btnAtualizar);

                     linha.append(operacoes);

                     $('#tabelaFilmes tbody').append(linha);
                });


            },
            error: function() {
               alert('Erro ao carregar os filmes com análises.');
            }
        });
    }

    function cadastrarFilme() {

    }

    $('#btn_salvar_analise').click(function () {
        let filmeId = $('#filmeSelecionado').val();
        let comentario = $('#comentario').val();
        let nota = $('#nota').val();

        if(!filmeId || nota === "0" || !comentario){
           alert('Preencha todos os campos corretamente.');
           return;
        }

        let analise = {
            filmeId: filmeId,
            comentario: comentario,
            nota: parseInt(nota)
        }

         $.ajax({
                url: 'http://localhost:8080/filmes/analises/analise',
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(analise),
                success: function () {
                    alert('Análise salva com sucesso!');
                    $('#comentario').val('');
                    $('#nota').val('0');
                     carregarFilmesComAnalises();
                },
                error: function () {
                    alert('Erro ao salvar a análise.');
                }
            });
    });


     carregarFilmes();
     carregarFilmesComAnalises();

});