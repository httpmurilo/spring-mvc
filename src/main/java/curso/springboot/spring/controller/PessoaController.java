package curso.springboot.spring.controller;

import curso.springboot.spring.dao.IPessoaDao;
import curso.springboot.spring.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class PessoaController {

    @Autowired
    private IPessoaDao pessoaDao;

    @RequestMapping(method = RequestMethod.GET, value = "/cadastro-pessoa")
    public ModelAndView inicio() {
        ModelAndView objView = new ModelAndView("cadastro/cadastro-pessoa");
        objView.addObject("pessoaobj", new Pessoa());
        return objView;
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/salvar-pessoa")
    public ModelAndView salvarRegistro(Pessoa pessoa) {
        pessoaDao.save(pessoa);
        ModelAndView objView = new ModelAndView("cadastro/cadastro-pessoa");
        Iterable<Pessoa> pessoasIt = pessoaDao.findAll();
        objView.addObject("pessoas",pessoasIt);
        objView.addObject("pessoaobj", new Pessoa());
        return objView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pessoas")
    public ModelAndView pessoas() {
        ModelAndView objView = new ModelAndView("cadastro/cadastro-pessoa");
        Iterable<Pessoa> pessoasIt = pessoaDao.findAll();
        objView.addObject("pessoas",pessoasIt);
        objView.addObject("pessoaobj", new Pessoa());
        return objView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editar-pessoa/{idpessoa}")
    public ModelAndView editarPessoa(@PathVariable("idpessoa") Long idpessoa){
        ModelAndView objView = new ModelAndView("cadastro/cadastro-pessoa");
        Optional<Pessoa> pessoa = pessoaDao.findById(idpessoa);
        objView.addObject("pessoaobj", pessoa.get());
        return objView;
    }
}
