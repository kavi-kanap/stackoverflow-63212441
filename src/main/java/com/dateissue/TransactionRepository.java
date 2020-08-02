package com.dateissue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;



@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    @Query(value = "SELECT * FROM transactions WHERE " +
            "CAST(created_at AS date) " +
            "BETWEEN CAST(:fromDate AS date) AND CAST(:toDate AS date)", nativeQuery = true)
    List<Transaction> findByAccountIdWithCreationDateBetween(@Param("fromDate") Date fromDate,
                                                             @Param("toDate") Date toDate);


}
