package com.stockmarket.sector.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CompanyDTO {
    private Long id;
    private String name;
    private String ceo;
    private String boardOfDirectors;
    private Boolean listed;
    private String brief;
}
