package com.anoxi.repo;

import com.anoxi.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School, Integer> {
}
