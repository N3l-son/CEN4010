package com.geektext.geektext.shoppingcart;
import java.util.ArrayList;
import java.util.List;
import com.browsing.book.book.Book;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")

public class CartController {
    private List<CartItem> cartItems = new ArrayList<>();
    // Initialize empty list; specific Book construction removed to avoid constructor mismatch
    private List<Book> books = new ArrayList<>();

    
      
    

    @PostMapping
    public ResponseEntity<String> addToCart(@RequestBody CartItem cartItem) {
        if (cartItem.getUserId() <= 0 || cartItem.getBookId() <= 0) {
            return ResponseEntity.badRequest().body("Invalid user ID or book ID");
        }
        cartItems.add(cartItem);
        return new ResponseEntity<>("Product added to cart successfully", HttpStatus.CREATED);
    }
    @GetMapping("/{userID}/subtotal")
    public ResponseEntity<Double> getSubtotal(@PathVariable int userID) {
        double subtotal = 0.0;
        for (CartItem cartItem : cartItems) {
            if (cartItem.getUserId() == userID) {
                for (Book book : books) {
                    // compare book id with cart item's book id; adjust to Book#getId()
                    if (book.getId() == cartItem.getBookId()) {
                        subtotal += book.getPrice();
                    }
                }
            }
        }
        return ResponseEntity.ok(subtotal);
    }

    @DeleteMapping("/{userID}/{bookID}")
    public ResponseEntity<String> deleteBook(@PathVariable int userID, @PathVariable int bookID) {
        boolean removed = cartItems.removeIf(item ->
            item.getUserId() == userID && item.getBookId() == bookID);
        if (removed) {
            return ResponseEntity.ok("Item removed from cart");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        }
    }
}





