package com.geektext.geektext.profile;

import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    private final UserRepository userRepository;
    private final CreditCardRepository creditCardRepository;

    public CreditCardService(UserRepository userRepository, CreditCardRepository creditCardRepository) {
        this.userRepository = userRepository;
        this.creditCardRepository = creditCardRepository;
    }

    public void addCreditCard(String username, CreditCard creditCard) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (creditCard.getCardNumber() == null || creditCard.getCardNumber().isBlank()) {
            throw new IllegalArgumentException("Card number is required");
        }

        creditCard.setUser(user);
        creditCardRepository.save(creditCard);
    }
}
