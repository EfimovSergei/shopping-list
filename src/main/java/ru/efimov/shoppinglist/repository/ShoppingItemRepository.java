package ru.efimov.shoppinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.efimov.shoppinglist.entity.ShopItem;

import java.util.List;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShopItem,Long> {

    List<ShopItem> findByUserUsername(String username);
}
