package curso.springboot.spring.controller;

import curso.springboot.spring.dao.IPessoaDao;
import curso.springboot.spring.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PessoaController {

    @Autowired
    private IPessoaDao pessoaDao;

    @RequestMapping(method = RequestMethod.GET, value = "/cadastro-pessoa")
    public String inicio() {
        return "cadastro/cadastro-pessoa";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/salvar-pessoa")
    public String salvarRegistro(Pessoa pessoa) {
        pessoaDao.save(pessoa);
        return "cadastro/cadastro-pessoa";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pessoas")
    public ModelAndView pessoas() {
        ModelAndView objView = new ModelAndView("cadastro/cadastro-pessoa");
        Iterable<Pessoa> pessoasIt = pessoaDao.findAll();
        objView.addObject("pessoas",pessoasIt);
        return objView;
    }
}
