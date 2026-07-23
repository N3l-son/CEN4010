package com.geektext.geektext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT AVG(r.ratingValue) FROM Rating r WHERE r.bookId = :bookId")
    Double findAverageRatingByBookId(@Param("bookId") Long bookId);

}