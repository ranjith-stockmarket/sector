package com.stockmarket.sector.Service;

import com.stockmarket.sector.DTO.CompaniesDTO;
import com.stockmarket.sector.DTO.CompanyDTO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Headers("Content-Type: application/json")
@FeignClient(name = "company", url = "http://localhost:8082/api/company")
public interface CompanyClientService {
    @GetMapping("/getBySector/{id}")
    CompaniesDTO getCompaniesBySectorId(@PathVariable("id") Long sectorId);
}
