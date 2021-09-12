package curso.springboot.spring.dao;

import curso.springboot.spring.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IPessoaDao extends CrudRepository<Pessoa, Long> {
}
