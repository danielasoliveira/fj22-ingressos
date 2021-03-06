package br.com.caelum.ingresso.rest;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.DetalheDoFilme;
import br.com.caelum.ingresso.model.Filme;

@Component
public class OmbdClient {

	public Optional<DetalheDoFilme> request(Filme filme)
	{
		
		RestTemplate client = new RestTemplate();
		String titulo = filme.getNome().replaceAll(" ", "+");
		
		String url = String.format("http://omdb-fj22.herokuapp.com/movie?title=%s", titulo);
		
		try{
		
			DetalheDoFilme detalheDoFilme = client.getForObject(url, DetalheDoFilme.class);
			return Optional.ofNullable(detalheDoFilme);
			
		}catch(RestClientException rc){
			return Optional.empty();
		}
		
		
	}
	
	
}
