package com.vilasha.shoppinglist.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ShoppingItem, Long> {
    List<ShoppingItem> findByUserUsername(String username);
}
