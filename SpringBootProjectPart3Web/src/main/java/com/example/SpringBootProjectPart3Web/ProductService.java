package com.example.SpringBootProjectPart3Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao dao;

    public void addProduct(Product p) {
        dao.save(p);
    }

    public List<Product> getAllProduct() {
        return dao.findAll();
    }

    public List<Product> getProductByName(String name) {
        return dao.findByName(name);
    }

//    public List<Product> getProductByPlace(String place) {
//        List<Product> prods = new ArrayList<>();
//        for (Product p : products) {
//            if (p.getPlace().equals(place))
//                prods.add(p);
//        }
//        return prods;
//    }

//    public List<Product> getProductWithText(String text) {
////        String str = text.toLowerCase();
////        return products.stream()
////                .filter(p -> p.getName().toLowerCase().contains(str)
////                        || p.getPlace().toLowerCase().contains(str)
////                        || p.getType().toLowerCase().contains(str))
////                .collect(Collectors.toList());
//        return dao.findByText(text);
//    }
//
//    public List<Product> getExpiredProduct() {
//        LocalDate currentDate = LocalDate.now();
//        return dao.findLessThanWarranty(currentDate.getYear());
//    }
}
