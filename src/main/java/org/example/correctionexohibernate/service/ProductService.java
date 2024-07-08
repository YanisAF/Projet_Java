package org.example.correctionexohibernate.service;

import java.time.LocalDate;
import java.util.List;

public class ProductService {
    private final org.example.repository.ProductRepository productRepository;

    public ProductService() {
        this.productRepository = new org.example.repository.ProductRepository();
    }

    public org.example.entity.product.Product createProductCloth(String description, org.example.utils.Categories categories, String size, float price, int stock){
        org.example.entity.product.Product product = org.example.entity.product.ProductCloth.builder()
                .description(description)
                .price(price)
                .stock(stock)
                .size(size)
                .categories(categories)
                .build();

        return productRepository.create(product);
    }
    public org.example.entity.product.Product createProductFood(String description, float price, int stock, LocalDate dateExpiry){
        org.example.entity.product.Product product = org.example.entity.product.ProductFood.builder()
                .description(description)
                .price(price)
                .stock(stock)
                .dateExpiry(dateExpiry)
                .build();

        return productRepository.create(product);
    }

    public org.example.entity.product.Product createElectronic(String description, float price, int stock, int batteryDuration){
        org.example.entity.product.Product product = org.example.entity.product.ProductElectronic.builder()
                .description(description)
                .price(price)
                .stock(stock)
                .batteryDuration(batteryDuration)
                .build();

        return productRepository.create(product);
    }


    public org.example.entity.product.Product updateProductCloth(int id, String description, org.example.utils.Categories categories, String size, float price, int quantity){

        org.example.entity.product.Product product = productRepository.findById(id);

        if(product instanceof org.example.entity.product.ProductCloth productCloth){
            productCloth.setDescription(description);
            productCloth.setPrice(price);
            productCloth.setStock(quantity);
            productCloth.setCategories(categories);
            productCloth.setSize(size);

            return productRepository.update(product);
        }else {
            System.out.println("not a product cloth");
            return null;
        }
    }

    public org.example.entity.product.Product updateProductFood (int id, String description, float price, int quantity, LocalDate expiryDate){
        org.example.entity.product.Product product = productRepository.findById(id);

        if(product instanceof org.example.entity.product.ProductFood productFood){
            productFood.setDescription(description);
            productFood.setPrice(price);
            productFood.setStock(quantity);
            productFood.setDateExpiry(expiryDate);

            return productRepository.update(product);
        }else {
            System.out.println("not a product cloth");
            return null;
        }
    }

    public org.example.entity.product.Product updateProductElectronic (int id, String description, float price, int quantity, int batteryDuration){
        org.example.entity.product.Product product = productRepository.findById(id);

        if(product instanceof org.example.entity.product.ProductElectronic productElectronic){
            productElectronic.setDescription(description);
            productElectronic.setPrice(price);
            productElectronic.setStock(quantity);
            productElectronic.setBatteryDuration(batteryDuration);

            return productRepository.update(product);
        }else {
            System.out.println("not a product cloth");
            return null;
        }
    }

    public org.example.entity.product.Product update (int id, int stock){
        org.example.entity.product.Product product = productRepository.findById(id);
        product.setStock(stock);
        return productRepository.update(product);
    }

    public boolean delete (int id){
        org.example.entity.product.Product product = productRepository.findById(id);
        if(product != null){
            return productRepository.delete(product);
        }
        return false;
    }

    public org.example.entity.product.Product findById (int id){
        org.example.entity.product.Product product = productRepository.findById(id);
        if(product != null){
            return product;
        }
        throw new org.example.utils.exception.NotFoundException();
    }

    public List<org.example.entity.product.Product> findAll (){
        return productRepository.findAll();
    }
}
