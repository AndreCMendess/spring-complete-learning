package com.casa_cultural.casa_cultural.service;

import com.casa_cultural.casa_cultural.DTO.AnaliseDTO;
import com.casa_cultural.casa_cultural.DTO.FilmeComAnaliseDTO;
import com.casa_cultural.casa_cultural.DTO.FilmeDTO;
import com.casa_cultural.casa_cultural.DTO.FilmeMinDTO;
import com.casa_cultural.casa_cultural.model.Filme;
import com.casa_cultural.casa_cultural.repository.AnaliseRepository;
import com.casa_cultural.casa_cultural.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {
    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    AnaliseRepository analiseRepository;

    public FilmeDTO adicionandoFilme(FilmeDTO filmeDTO){

        Filme filme = new Filme();

        filme.setTitulo(filmeDTO.getTitulo());
        filme.setSinopse(filmeDTO.getSinopse());
        filme.setGenero(filmeDTO.getGenero());
        filme.setAnoLancamento(filmeDTO.getAnoLancamento());

        Filme filmeSalvo = filmeRepository.save(filme);

        return new FilmeDTO(filmeSalvo);
    }

    public FilmeDTO atualizarFilme(Integer filmeId , FilmeDTO filmeAtualizado){
        Filme filme = filmeRepository.findById(filmeId).orElse(null);
        filme.setTitulo(filmeAtualizado.getTitulo());
        filme.setSinopse(filmeAtualizado.getSinopse());
        filme.setGenero(filmeAtualizado.getGenero());
        filme.setAnoLancamento(filmeAtualizado.getAnoLancamento());
        filmeRepository.save(filme);
        return new FilmeDTO(filme);
    }

    public Filme getFilmePorId(Integer id){
        return filmeRepository.findById(id).orElse(null);
    }

    public List<Filme> getTodosFilmes(){
        return filmeRepository.findAll();
    }

    public boolean deletarFilme(Integer id) {
        if (filmeRepository.existsById(id)) {
            filmeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<FilmeMinDTO> getFilmesDTO(){
        return filmeRepository.findAll().
                stream().
                map(  filme -> new FilmeMinDTO(
                        filme.getId(),
                        filme.getTitulo(),
                        filme.calcularMedia()
                ))
                .collect(Collectors.toList());
    }

    public List<FilmeComAnaliseDTO> getFilmesComAnaliseDTO(){
        List<Filme> filmes = filmeRepository.findAll();
        return filmes.stream()
                .map(filme -> {
                    List<AnaliseDTO> analiseDTO = filme.getAnalises()
                            .stream()
                            .map(analise -> new AnaliseDTO(analise.getId(),analise.getComentario(), analise.getNota()))
                            .collect(Collectors.toList());

                    Double mediaNota = analiseDTO.stream()
                            .mapToDouble(AnaliseDTO::getNota)
                            .average()
                            .orElse(0.0);

                    return new FilmeComAnaliseDTO(
                            filme.getId(),
                            filme.getTitulo(),
                            filme.getSinopse(),
                            filme.getGenero(),
                            filme.getAnoLancamento(),
                            analiseDTO,
                            mediaNota

                    );
                }).collect(Collectors.toList());
    }

}
