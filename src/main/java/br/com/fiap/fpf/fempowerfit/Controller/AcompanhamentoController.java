package br.com.fiap.fpf.fempowerfit.Controller;


import br.com.fiap.fpf.fempowerfit.Model.Acompanhamento;
import br.com.fiap.fpf.fempowerfit.repository.AcompanhamentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("acompanhamento")
public class AcompanhamentoController {

    @Autowired
    AcompanhamentoRepository repository;

    @PostMapping
    public Acompanhamento create(@RequestBody @Valid Acompanhamento acompanhamento){
        return repository.save(acompanhamento);
    }

}
