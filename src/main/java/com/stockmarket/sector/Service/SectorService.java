package com.stockmarket.sector.Service;

import com.stockmarket.sector.DTO.AddSectorDTO;
import com.stockmarket.sector.DTO.SectorDTO;
import com.stockmarket.sector.Helper.ServiceResponse;

public interface SectorService {

    ServiceResponse addSector(AddSectorDTO addSectorDTO);

    ServiceResponse getSectorById(Long id);

    ServiceResponse getAllSectors();

    ServiceResponse getCompaniesBySectorId(Long id);
}
