package com.neilo.aithre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neilo.aithre.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{
}
