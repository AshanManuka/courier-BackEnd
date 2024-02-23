package com.designCenter.designCenter.repository;

import com.designCenter.designCenter.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package,Long> {
}
