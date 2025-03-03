package org.example.SpringBootMVCProject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private List<Product>  products = new ArrayList<>();
    private ProdoctDao dao = new ProdoctDao();

    public void addProduct(Product p) {
        dao.save(p);
    }

    public List<Product> getAllProduct() {
        return dao.findAll();
    }

    public List<Product> getProductByName(String name) {
        return dao.findByName(name);
    }

    public List<Product> getProductByPlace(String place) {
        List<Product> prods = new ArrayList<>();
        for (Product p : products) {
            if (p.getPlace().equals(place))
                prods.add(p);
        }
        return prods;
    }

    public List<Product> getProductWithText(String text) {
//        String str = text.toLowerCase();
//        return products.stream()
//                .filter(p -> p.getName().toLowerCase().contains(str)
//                        || p.getPlace().toLowerCase().contains(str)
//                        || p.getType().toLowerCase().contains(str))
//                .collect(Collectors.toList());
        return dao.findByText(text);
    }

    public List<Product> getExpiredProduct() {
        LocalDate currentDate = LocalDate.now();
        return dao.findLessThanWarranty(currentDate.getYear());
    }
}
