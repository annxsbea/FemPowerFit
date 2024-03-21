package br.com.fiap.fpf.fempowerfit.Controller;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.fiap.fpf.fempowerfit.Model.Suplemento;
import br.com.fiap.fpf.fempowerfit.repository.SuplementoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/suplementos")
@Slf4j
public class SuplementoController {

    @Autowired
    private SuplementoRepository suplementoRepository;

    //Listar todos os Suplementos
    @GetMapping("/meusSuplementos")
    public List<Suplemento> listar() {

        return suplementoRepository.findAll();
    }
    //Listar um Suplemento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Suplemento> get(@PathVariable Long id) {
        log.info("Buscar por id: {}", id);

        return suplementoRepository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Cadastrar SUPLEMENTO
    @PostMapping
    @ResponseStatus(CREATED)
    public Suplemento create(@RequestBody Suplemento suplemento) {
        log.info("cadastrar suplemento: {}", suplemento);
        return suplementoRepository.save(suplemento);

    }

    //Atualizar SUPLEMENTO
    @PutMapping("{id}")
    public Suplemento update(@PathVariable Long id, @RequestBody Suplemento suplemento){
        log.info("atualizando suplemento id {} para {}", id, suplemento);

        verificarSeExisteSuplemento(id);

        suplemento.setId(id);
        return suplementoRepository.save(suplemento);

    }

    //delete suplemento
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando Suplento {}", id);

        verificarSeExisteSuplemento(id);
        suplementoRepository.deleteById(id);
    }

    private void verificarSeExisteSuplemento(Long id) {
        suplementoRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Suplemento não encontrada" )
                );
    }

}
