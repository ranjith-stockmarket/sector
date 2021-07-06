package com.stockmarket.sector.DTO;


import com.stockmarket.sector.DAO.Sector;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
@NoArgsConstructor
public class AddSectorDTO {
    @NotNull(message = "Sector name can't be null")
    private String name;
    private String brief;
}
