package com.geektext.geektext.shoppingcart;
import com.geektext.geektext.shoppingcart.CartItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CartRespository implements JpaRepository<CartItem, Long> {


}
