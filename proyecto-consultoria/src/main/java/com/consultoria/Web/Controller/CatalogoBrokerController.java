package com.consultoria.Web.Controller;

import com.consultoria.Entity.CatalogoBrokerEntity;
import com.consultoria.Service.ICatalogoBrokerService;
import com.consultoria.Web.Controller.dto.CatalogoBrokerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/broker")
public class CatalogoBrokerController {

    @Autowired
    private ICatalogoBrokerService catalogoBrokerService;
   //http://localhost:8080/api/broker
    @GetMapping("/findall")

    public ResponseEntity<?> findAll() {
        List<CatalogoBrokerDTO> catalogobrokerDTO = catalogoBrokerService.findAll()
                .stream()
                .map(catalogoBroker -> CatalogoBrokerDTO.builder()
                        .codigo(catalogoBroker.getCodigo())
                        .broker(catalogoBroker.getBroker())
                        .rfc(catalogoBroker.getRfc())
                        .build())
                .toList();
        return ResponseEntity.ok(catalogobrokerDTO);

    }

    @GetMapping("/find/{codigo}")
    public ResponseEntity<?> findById(@PathVariable Integer codigo) {
        Optional<CatalogoBrokerEntity> catalogoBrokerOptional = catalogoBrokerService.findById(codigo);
        if (catalogoBrokerOptional.isPresent()) {
            CatalogoBrokerEntity catalogobroker = catalogoBrokerOptional.get();

            CatalogoBrokerDTO catalogoBrokerDTO = CatalogoBrokerDTO.builder()
                    .codigo(catalogobroker.getCodigo())
                    .broker(catalogobroker.getBroker())
                    .rfc(catalogobroker.getRfc())
                    .build();
            return ResponseEntity.ok(catalogoBrokerDTO);

        }
        return ResponseEntity.notFound().build();


    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CatalogoBrokerDTO catalogoBrokerDTO) throws URISyntaxException {
        if (catalogoBrokerDTO.getBroker().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        catalogoBrokerService.save(CatalogoBrokerEntity.builder()
                .codigo(catalogoBrokerDTO.getCodigo())
                .broker(catalogoBrokerDTO.getBroker())
                .rfc(catalogoBrokerDTO.getRfc())
                .build());
        return ResponseEntity.created(new URI("/api/broker/save")).build();
    }
    @PutMapping("/update/{codigo}")
    public ResponseEntity<?> update(@PathVariable Integer codigo, @RequestBody CatalogoBrokerDTO catalogoBrokerDTO) {
        Optional<CatalogoBrokerEntity> catalogoBrokerEntity = catalogoBrokerService.findById(codigo);

        if (catalogoBrokerEntity.isPresent()) {
            CatalogoBrokerEntity catalogoBroker = catalogoBrokerEntity.get();
            catalogoBroker.setCodigo(catalogoBrokerDTO.getCodigo());
            catalogoBroker.setBroker(catalogoBrokerDTO.getBroker());
            catalogoBroker.setRfc(catalogoBrokerDTO.getRfc());
            catalogoBrokerService.save(catalogoBroker);
                return ResponseEntity.ok("BROKER UPDATED CORRECTLY");
        }
        return ResponseEntity.notFound().build();
    }


}