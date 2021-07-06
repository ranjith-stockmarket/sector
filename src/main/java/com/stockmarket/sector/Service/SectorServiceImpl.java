package com.stockmarket.sector.Service;

import com.stockmarket.sector.DAO.Sector;
import com.stockmarket.sector.DTO.AddSectorDTO;
import com.stockmarket.sector.DTO.SectorDTO;
import com.stockmarket.sector.Helper.ServiceResponse;
import com.stockmarket.sector.Repository.SectorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class SectorServiceImpl implements SectorService {

    private final SectorRepository sectorRepository;
    private final CompanyClientService companyClientService;

    public SectorServiceImpl(SectorRepository sectorRepository, CompanyClientService companyClientService) {
        this.sectorRepository = sectorRepository;
        this.companyClientService = companyClientService;
    }

    @Override
    public ServiceResponse addSector(AddSectorDTO addSectorDTO){
        if(sectorRepository.existsByName(addSectorDTO.getName())){
            return new ServiceResponse(HttpStatus.BAD_REQUEST, "Sector already Exists");
        }
        Sector savedSector = sectorRepository.save(addSectorDTO.getSector());
        if(sectorRepository.existsById(savedSector.getId())){
            return new ServiceResponse(HttpStatus.CREATED, new SectorDTO(savedSector));
        }
        return new ServiceResponse(HttpStatus.UNPROCESSABLE_ENTITY, "Please try again later!");
    }

    @Override
    public ServiceResponse getSectorById(Long id){
        SectorDTO sectorDTO = sectorRepository.getById(id);
        if(sectorDTO==null){
            return new ServiceResponse(HttpStatus.BAD_REQUEST, "Sector Id does not Exist");
        }else{
            return new ServiceResponse(HttpStatus.OK, sectorDTO);
        }
    }

    @Override
    public ServiceResponse getCompaniesBySectorId(Long id) {
        return new ServiceResponse(HttpStatus.OK, companyClientService.getCompaniesBySectorId(id));
    }

    public ServiceResponse getAllSectors(){
        return new ServiceResponse(HttpStatus.OK, sectorRepository.getAll());
    }
}
