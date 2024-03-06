package br.com.fempowerfit.FPF.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.fempowerfit.Model.Suplemento;

@RestController
@RequestMapping("/suplementos")
public class SuplementoController{

    Logger log = LoggerFactory.getLogger(getClass());

    List<Suplemento> repository = new ArrayList<>();

    @GetMapping("/MeusSuplementos")
    public List<Suplemento> listando(){
        return repository;
    }

    @GetMapping("{id}")
    public ResponseEntity<Suplemento> get(@PathVariable Long id){
        var suplementoOpcional = buscarSuplementoPorId(id);

        if (suplementoOpcional.isEmpty())
            return ResponseEntity.notFound().build();

        
        repository.remove(suplementoOpcional.get());

        return ResponseEntity.noContent().build();
    }

    @PostMapping("CadastrarSuplemento")
    public ResponseEntity cadastrandoSuplemento(@RequestBody Suplemento suplemento){
        repository.add(suplemento);

        return ResponseEntity.status(HttpStatus.CREATED).body(suplemento);
    }

    private Optional<Suplemento> buscarSuplementoPorId(Long id) {
        var suplementoOpcional = repository.stream().filter(suplemento -> suplemento.id().equals(id)).findFirst();
        
        return buscarSuplementoPorId(id);
    }
}