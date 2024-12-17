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
                alert('Não foi possível carregar os filmes  da API.');
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
                        .html('<i class="fas fa-trash"></i>')
                        .click(() => deletarFilme(filme.id));

                     let btnAtualizar  = $('<button>')
                        .addClass('btn btn-warning btn-sm')
                        .html('<i class="fas fa-edit"></i>')
                        .data('id', filme.id)
                        .click(function (filme) {
                              const idFilme = $(this).data('id');
                               $.ajax({
                                        url: `http://localhost:8080/filmes/${idFilme}`,
                                        method: 'GET',
                                        success: function(filme) {

                                            $('#id').val(filme.id);
                                            $('#titulo').val(filme.titulo);
                                            $('#sinopse').val(filme.sinopse);
                                            $('#genero').val(filme.genero);
                                            $('#anoLancamento').val(filme.anoLancamento);

                                          $('form_atualizar_filme').data('id',filme.id);
                                          $('#modal_editar_filme').modal('show');
                                          $('#alert_message').hide();
                                        },
                                        error: function() {
                                        console.log("ID do filme extraído da URL:", idFilme);
                                            alert('Erro ao carregar os dados do filme.');
                                        }
                               });

                        });


                     operacoes.append(btnDeletar).append(btnAtualizar);

                     linha.append(operacoes);

                     $('#tabelaFilmes tbody').append(linha);
                });


            },
            error: function(xhr,status, error) {
               alert('Erro ao carregar os filmes com análises.');
               console.error("Erro ao carregar os dados do filme com ID:", idFilme);
               console.log('Erro na requisição: ', error);
               console.log('Status: ', status);
               console.log('Resposta do servidor: ', xhr.responseText);
            }
        });
    }

    function cadastrarFilme() {
        $('#form_cadastro_filme').submit(function(e) {
              e.preventDefault();

              let filme = {
                          titulo: $('#titulo').val(),
                          sinopse: $('#sinopse').val(),
                          genero: $('#genero').val(),
                          anoLancamento: $('#ano_Lancamento').val()
              };



              $.ajax({
                url: 'http://localhost:8080/filmes/adicionar',
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(filme),
                success: function(response) {
                    $('#mensagem').text('Filme criado com sucesso!').show();
                    $('#form_cadastro_filme')[0].reset();
                    carregarFilmesComAnalises();
                },
                error: function(xhr,status, error) {
                     console.log('Erro na requisição: ', error);
                     console.log('Status: ', status);
                     console.log('Resposta do servidor: ', xhr.responseText);
                }
              });

        });
    };

    function atualizarFilme(id) {

        let filme = {
                 id: $('#id').val(),
                 titulo: $('#titulo').val(),
                 sinopse: $('#sinopse').val(),
                 genero: $('#genero').val(),
                 anoLancamento: $('#ano_lancamento').val()
        };

        $.ajax({
                url: 'http://localhost:8080/filmes/atualizar/' + id,
                method: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(filme),
                success: function(response) {

                    $('#alert_message').show();
                    carregarFilmesComAnalises();
                    $('#model_editar_filme')[0].reset();

                },
                error: function(xhr,status, error) {
                    alert('Erro ao atualizar o filme.');
                    console.log('Erro na requisição: ', error);
                    console.log('Status: ', status);
                    console.log('Resposta do servidor: ', xhr.responseText);
                }
        });
    }





      $('#form_atualizar_filme').submit(function(e) {
              e.preventDefault();
              let filmeId = $('#id').val();
              console.log("ID do filme para atualizar:", filmeId);
              atualizarFilme(filmeId);
      });



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
     cadastrarFilme();


});