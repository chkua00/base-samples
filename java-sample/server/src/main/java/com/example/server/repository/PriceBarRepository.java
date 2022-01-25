package com.example.server.repository;

import com.example.server.model.PriceBar;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceBarRepository extends JpaRepository<PriceBar, LocalDateTime> {

}
