package br.com.api.ApiPix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.ApiPix.entities.ChavePix;

@Repository
public interface ChavePixRepository extends JpaRepository<ChavePix, String> {

}
