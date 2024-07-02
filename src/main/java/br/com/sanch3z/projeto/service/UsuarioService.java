package br.com.sanch3z.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sanch3z.projeto.dto.UsuarioDTO;
import br.com.sanch3z.projeto.entity.UsuarioEntity;
import br.com.sanch3z.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	public List<UsuarioDTO> ListarTodos(){
		List<UsuarioEntity> Usuarios = UsuarioRepository.findAll();
		return Usuarios.stream().map(UsuarioDTO::new).toList();	
	}
	
	public void inserir(UsuarioDTO Usuario) {
		UsuarioEntity UsuarioEntity = new UsuarioEntity(Usuario);
		UsuarioRepository.save(UsuarioEntity);
	}
	
	public UsuarioDTO alterar(UsuarioDTO Usuario) {
		UsuarioEntity UsuarioEntity = new UsuarioEntity(Usuario);
		return new UsuarioDTO(UsuarioRepository.save(UsuarioEntity));
	}
	
	public void excluir(Long id) {
		UsuarioEntity Usuario = UsuarioRepository.findById(id).get();
		UsuarioRepository.delete(Usuario);
	}
	
	public UsuarioDTO buscarPorId(Long id) {
		return new UsuarioDTO(UsuarioRepository.findById(id).get());
	}
	
	
	
}
