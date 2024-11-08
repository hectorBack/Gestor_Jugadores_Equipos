package com.example.Basquet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Basquet.Entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Categoria findByEdadMinimaLessThanEqualAndEdadMaximaGreaterThanEqual(int edad, int edad2);

}
