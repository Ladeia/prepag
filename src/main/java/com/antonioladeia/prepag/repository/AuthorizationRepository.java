package com.antonioladeia.prepag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.antonioladeia.prepag.models.Authorization;

public interface AuthorizationRepository extends JpaRepository<Authorization, Long>{

}
