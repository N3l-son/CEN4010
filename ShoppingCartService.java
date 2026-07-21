package com.geektext.geektext.shoppingcart;
import com.geektext.geektext.shoppingcart.CartItem;
import com.browsing.book.book.Book;
import com.browsing.book.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    @Autowired
    private CartRespository cartRespository;
    @Autowired
    private BookRepository bookRepository;

    public CartItem addBookToCart(Long userId, Long bookId) {
        CartItem cartItem = new CartItem(userId, bookId);
        return cartRespository.save(cartItem);
    }

    public List<CartItem> getCartItems(Long userId) {
        return cartRespository.findAll().stream()
                .filter(item -> item.getuserId().equals(userId))
                .toList();
                
    }

    public double calculateSubtotal(Long userId) {
        List<CartItem> cartItems = getCartItems(userId);
        double subtotal = 0.0;
        for (CartItem cartItem : cartItems) {
            Book book = bookRepository.findById(cartItem.getbookId()).orElse(null);
            if (book != null) {
                subtotal += book.getPrice();
            }
        }
        return subtotal;
    }

}
