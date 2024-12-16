$(document).ready(function () {

    function carregarFilmes() {
        $.ajax({
            url:'http://localhost:8080/filmes/filmes-inicio',
            method: 'GET',
            success: function (data) {
                $('#tabelaInicio tbody').empty();

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
                });
            },
            error: function() {
                alert('Não foi possível carregar as tarefas da API.');
            }
        });


    };
     carregarFilmes();
});