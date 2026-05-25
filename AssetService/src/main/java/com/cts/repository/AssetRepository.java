package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long>{

}
