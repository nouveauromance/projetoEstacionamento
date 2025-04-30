package br.gov.sp.cps.ProjetoSpringIoC.repository;

import br.gov.sp.cps.ProjetoSpringIoC.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
