package com.stockmarket.sector.Controller;

import com.stockmarket.sector.DTO.AddSectorDTO;
import com.stockmarket.sector.DTO.SectorDTO;
import com.stockmarket.sector.Service.SectorService;
import com.stockmarket.sector.Service.SectorServiceImpl;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sector")
public class SectorController {

    private final SectorService sectorService;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addSector(@Valid @RequestBody AddSectorDTO addSectorDTO){
        return sectorService.addSector(addSectorDTO).getResponse();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getSectorById(@PathVariable("id") Long id){
        return sectorService.getSectorById(id).getResponse();
    }

    @GetMapping("/getCompaniesBySectorId/{sectorId}")
    public ResponseEntity<Object> getCompaniesBySector(@PathVariable("sectorId") Long id){
        return sectorService.getCompaniesBySectorId(id).getResponse();
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllSectors(){
        return sectorService.getAllSectors().getResponse();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage) //.map( fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.joining(" , ")));
    }
}
