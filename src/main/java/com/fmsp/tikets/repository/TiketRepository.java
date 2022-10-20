package com.fmsp.tikets.repository;

import com.fmsp.tikets.entity.TicketsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TiketRepository extends JpaRepository<TicketsEntity, Long>, JpaSpecificationExecutor<TicketsEntity> {
}
