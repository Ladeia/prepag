package com.antonioladeia.prepag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.antonioladeia.prepag.models.Card;

public interface CardRepository extends JpaRepository<Card, Long>{

	  Card findByCardNumber(String cardNumber);
}
