package com.geektext.geektext.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/create")
    public ResponseEntity<String> createWishlist(@RequestParam String name, @RequestParam Long userId) {
        try {
            wishlistService.createWishlist(name, userId);
            return new ResponseEntity<>("Wishlist created successfully.", HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestParam Long wishlistId, @RequestParam Long bookId) {
        /*wishlistService.addBookToWishlist(wishlistId, bookId);
        return new ResponseEntity<>("Book added to wishlist.", HttpStatus.OK);*/
        try {
            wishlistService.addBookToWishlist(wishlistId, bookId);
            return new ResponseEntity<>("Book added to wishlist successfully.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeBook(@RequestParam Long wishlistId, @RequestParam Long bookId) {
        wishlistService.removeBookFromWishlist(wishlistId, bookId);
        return new ResponseEntity<>("Book removed from wishlist.", HttpStatus.OK);
    }

    @GetMapping("/{wishlistId}/books")
    public ResponseEntity<List<Long>> listBooks(@PathVariable Long wishlistId) {
        List<Long> bookIds = wishlistService.getBooksInWishlist(wishlistId);
        return new ResponseEntity<>(bookIds, HttpStatus.OK);
    }

    @DeleteMapping("/{wishlistId}")
    public ResponseEntity<String> deleteWishlist(@PathVariable Long wishlistId) {
        wishlistService.deleteWishlist(wishlistId);
        return ResponseEntity.ok("Wishlist with ID " + wishlistId + " was successfully deleted.");
    }
}
