package com.stockmarket.sector.Service;

import com.stockmarket.sector.DTO.CompaniesDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    private final RestTemplate restTemplate;
    private final String COMPANY_SERVICE = "http://company-service/api/company";
    private final String STOCK_PRICE_SERVICE = "http://stock-price-service/api/stock-price";

    public ClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public CompaniesDTO getCompanies(Long sectorId) {
        return restTemplate
                .getForObject(COMPANY_SERVICE+"/getBySector/"+sectorId, CompaniesDTO.class);
    }
}
