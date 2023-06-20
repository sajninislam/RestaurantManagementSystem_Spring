package com.example.Api.repository;

import com.example.Api.model.BookOrder;
import com.example.Api.model.ProductInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookOrerDaw extends JpaRepository<BookOrder,Long> {
    @Query(value = "select * from book_order where user_name = :userName ", nativeQuery = true)
    List<BookOrder> findAllByUserName(@Param("userName") String userName);


    @Query(value = "select * from book_order where order_status = :orderStatus ", nativeQuery = true)
    List<BookOrder> findAllByOrderStatus(@Param("orderStatus") String orderStatus);



}
