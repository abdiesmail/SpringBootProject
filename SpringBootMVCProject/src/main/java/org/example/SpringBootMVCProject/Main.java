package org.example.SpringBootMVCProject;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

//        productService.addProduct(new Product("Hp Elitebook","Laptop","chair",2025));
//        productService.addProduct(new Product("Samsung Buds2Pro","Bluetooth earphones","chair",2022));
//        productService.addProduct(new Product("Pixel 7 Pro","Phone","bed",2025));
//        productService.addProduct(new Product("Dell Laptop","Laptop","Black bag",2023));

        //productService.getAllProduct().forEach(n -> System.out.println(n));
        //productService.getProductByName("Samsung Buds2Pro").forEach(n -> System.out.println(n));
        productService.getProductWithText("Phone").forEach(n -> System.out.println(n));
    }
}
