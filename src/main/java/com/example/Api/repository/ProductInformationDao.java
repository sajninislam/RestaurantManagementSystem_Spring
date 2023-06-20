//package com.example.Api.repository;
//
//
//import com.example.Api.model.ProductInformation;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.Entity;
//import java.util.List;
//
//@Repository
//public interface ProductInformationDao extends JpaRepository<ProductInformation,Long> {
//
//    @Query(value = "select * from product_information where order_status = :orderStatus ", nativeQuery = true)
//    List<ProductInformation> findAllByCourierStatus(@Param("orderStatus") String orderStatus);
//
//    @Query(value = "select * from product_information where user_name = :userName ", nativeQuery = true)
//    List<ProductInformation> findAllByUserName(@Param("userName") String userName);
//
//}
