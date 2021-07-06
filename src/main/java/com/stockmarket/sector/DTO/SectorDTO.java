package com.stockmarket.sector.DTO;

import com.stockmarket.sector.DAO.Sector;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SectorDTO {
    private Long id;
    private String name;
    private String brief;
}
