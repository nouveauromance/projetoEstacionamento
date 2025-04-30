package br.gov.sp.cps.ProjetoSpringIoC.service;

import br.gov.sp.cps.ProjetoSpringIoC.entity.Usuario;
import br.gov.sp.cps.ProjetoSpringIoC.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado...")
        );
    }

    @Transactional
    public Usuario editarSenha(Long id, String password) {
        Usuario user = buscarPorId(id);
        user.setPassword(password);
        return user;
    }

    @Transactional
    public void deletarPorId(Long id) {
        if(!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado...");
        }
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public void deletarTodos(){
        usuarioRepository.deleteAll();
    }
}
