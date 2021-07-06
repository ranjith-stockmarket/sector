package com.stockmarket.sector.Service;

import com.stockmarket.sector.DAO.Sector;
import com.stockmarket.sector.DTO.AddSectorDTO;
import com.stockmarket.sector.DTO.CompaniesDTO;
import com.stockmarket.sector.DTO.SectorDTO;
import com.stockmarket.sector.Helper.ServiceResponse;
import com.stockmarket.sector.Repository.SectorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectorService{

    private final ModelMapper modelMapper;
    private final SectorRepository sectorRepository;
    private final ClientService clientService;

    public SectorService(ModelMapper modelMapper, SectorRepository sectorRepository, ClientService clientService) {
        this.modelMapper = modelMapper;
        this.sectorRepository = sectorRepository;
        this.clientService = clientService;
    }

    public ServiceResponse addSector(AddSectorDTO addSectorDTO){
        if(sectorRepository.existsByName(addSectorDTO.getName())){
            return new ServiceResponse(HttpStatus.BAD_REQUEST, "Sector already Exists");
        }
        Sector savedSector = sectorRepository.save(modelMapper.map(addSectorDTO, Sector.class));
        if(sectorRepository.existsById(savedSector.getId())){
            return new ServiceResponse(HttpStatus.CREATED, modelMapper.map(savedSector, SectorDTO.class));
        }
        return new ServiceResponse(HttpStatus.UNPROCESSABLE_ENTITY, "Please try again later!");
    }

    public ServiceResponse getSectorById(Long id){
        Optional<Sector> sector = sectorRepository.findById(id);
        if(sector.isPresent()) {
            return new ServiceResponse(HttpStatus.OK, modelMapper.map(sector.get(), SectorDTO.class));
        }
        return new ServiceResponse(HttpStatus.BAD_REQUEST, "Sector Id does not Exist");
    }

    public ServiceResponse getCompaniesBySectorId(Long id) {
        return new ServiceResponse(HttpStatus.OK, clientService.getCompanies(id));

    }

    public ServiceResponse getAllSectors(){
        return new ServiceResponse(HttpStatus.OK, sectorRepository.getAll());
    }
}
