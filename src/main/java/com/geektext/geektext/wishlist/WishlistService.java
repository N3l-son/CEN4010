package com.geektext.geektext.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;

    public Wishlist createWishlist(String name, Long userId) {
        List<Wishlist> existingLists = wishlistRepository.findByUserId(userId);
        if (existingLists.size() >= 3) {
            throw new IllegalStateException("Limit reached: Users can have at most 3 wishlists.");
        }
        Wishlist wishlist = new Wishlist(name, userId);
        return wishlistRepository.save(wishlist);
    }

    public void addBookToWishlist(Long wishlistId, Long bookId) {
        /*Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new IllegalArgumentException("Wishlist not found"));
        if (!wishlist.getBookIds().contains(bookId)) {
            wishlist.getBookIds().add(bookId);
            wishlistRepository.save(wishlist);
        }*/
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new IllegalArgumentException("Error: Wishlist with ID " + wishlistId + " does not exist."));
        if (wishlist.getBookIds().contains(bookId)) {
            throw new IllegalStateException("Error: Book ID " + bookId + " is already in this wishlist.");
        }
        wishlist.getBookIds().add(bookId);
        wishlistRepository.save(wishlist);
    }

    public void removeBookFromWishlist(Long wishlistId, Long bookId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new IllegalArgumentException("Wishlist not found"));
        wishlist.getBookIds().remove(bookId);
        wishlistRepository.save(wishlist);
    }

    public List<Long> getBooksInWishlist(Long wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new IllegalArgumentException("Wishlist not found"));
        return wishlist.getBookIds();
    }
    public void deleteWishlist(Long wishlistId) {
        if (!wishlistRepository.existsById(wishlistId)) {
            throw new IllegalArgumentException("Wishlist not found with ID: " + wishlistId);
        }
        wishlistRepository.deleteById(wishlistId);
    }
}
