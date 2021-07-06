package com.stockmarket.sector.Repository;

import com.stockmarket.sector.DAO.Sector;
import com.stockmarket.sector.DTO.SectorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {

    boolean existsByName(String name);

    @Query("select new com.stockmarket.sector.DTO.SectorDTO(s) from Sector s where s.id=?1")
    SectorDTO getById(Long id);

    @Query("select new com.stockmarket.sector.DTO.SectorDTO(s) from Sector s order by s.id")
    List<SectorDTO> getAll();
}
