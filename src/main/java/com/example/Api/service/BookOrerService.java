package com.example.Api.service;

import com.example.Api.enums.OrderStatus;
import com.example.Api.model.BookOrder;
import com.example.Api.repository.BookOrerDaw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BookOrerService {
    @Autowired
    BookOrerDaw bookdaw;
    public void saveOrder( List<BookOrder> bookOrder, String username, String customerName, String customerPhNu, String customerAddress, String PaymentMethod ){

        bookOrder.forEach(bookOrder1 -> {
            bookOrder1.setUserName(username);
            bookOrder1.setCustomerName(customerName);
            bookOrder1.setCustomerPhNu(customerPhNu);
            bookOrder1.setCustomerAddress(customerAddress);
            bookOrder1.setPaymentMethod(PaymentMethod);
            bookOrder1.setOrderStatus(OrderStatus.Pending);


        });
        bookdaw.saveAll(bookOrder);
    }



    public void updateOrder(BookOrder products){
        if(products.getId()!=null){
            bookdaw.findById(products.getId()).map(old ->{
//                old.setOrderStatus(products.getOrderStatus());
                old.setUserName(products.getUserName());
                old.setCustomerAddress(products.getCustomerAddress());
                old.setOrderStatus(products.getOrderStatus());
                old.setCreatedAt(products.getCreatedAt());
                return bookdaw.save(old);
            });

        }

    }








//        public List<BookOrder> getAllss(String orderStatus,String username){
//        if (username != null){
//            return bookdaw.findAllByUserName(username);
//        }
//            if (orderStatus == null) {
//                return bookdaw.findAll();
//            } else {
//                return bookdaw.findAllByOrderStatus(orderStatus);
//            }
//            return bookdaw.findAll();
//    }

    public BookOrder getSingle( Long id  ){
        return bookdaw.findById(id).get();
    }

//    public List<BookOrder> getSingleAll( @PathVariable("id") Long id ){
//        return bookOrderService.getAlls();
//    }
public List<BookOrder> getAlls(String orderStatus,String username){


    if (username != null){
        return bookdaw.findAllByUserName(username);
    }
    if (orderStatus == null) {
        return bookdaw.findAll();
    } else {
        return bookdaw.findAllByOrderStatus(orderStatus);

    }

//            return bookdaw.findAll();
    }









    //    public List<ProductInformation> getAlls(String orderStatus, String username){
//        if (username != null){
//            return productInformationDaw.findAllByUserName(username);
//        }
//        if (orderStatus == null) {
//            return productInformationDaw.findAll();
//        } else {
//            return productInformationDaw.findAllByCourierStatus(orderStatus);
//        }
//    }
}
