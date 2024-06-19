package br.com.sanch3z.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sanch3z.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	
}
