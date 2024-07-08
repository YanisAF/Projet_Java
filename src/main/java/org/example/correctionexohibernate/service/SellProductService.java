package org.example.correctionexohibernate.service;

import java.util.List;

public class SellProductService {
    private final org.example.repository.SellProductRepository sellProductRepository;

    private final org.example.repository.SellRepository sellRepositoryl;

    private final org.example.repository.ProductRepository productRepository;

    public SellProductService() {
        this.sellProductRepository = new org.example.repository.SellProductRepository();
        this.sellRepositoryl = new org.example.repository.SellRepository();
        this.productRepository = new org.example.repository.ProductRepository();
    }

    public org.example.entity.SellProduct create(int idProduct, int idSell, int quantity){
        org.example.entity.Sell sell = sellRepositoryl.findById(idSell);
        org.example.entity.product.Product product = productRepository.findById(idProduct);

        if(sell != null && product != null){
            org.example.entity.SellProduct sellProduct = org.example.entity.SellProduct.builder().product(product).sell(sell).quantity(quantity).build();
            return sellProductRepository.create(sellProduct);
        }

        throw new org.example.utils.exception.NotFoundException();
    }

    public org.example.entity.Sell update(int id, int idProduct, int idSell, int quantity){

        org.example.entity.SellProduct sellProduct = sellProductRepository.findById(id);

        if (sellProduct != null){
            org.example.entity.Sell sell = sellRepositoryl.findById(idSell);
            org.example.entity.product.Product product = productRepository.findById(idProduct);
            if(sell != null && product != null){
                sellProduct.setSell(sell);
                sellProduct.setProduct(product);
                sellProduct.setQuantity(quantity);
                sellProductRepository.update(sellProduct);
            }
        }
        throw new org.example.utils.exception.NotFoundException();
    }

    public boolean delete (int id){
        org.example.entity.SellProduct sellProduct = sellProductRepository.findById(id);
        if(sellProduct != null){
            return sellProductRepository.delete(sellProduct);
        }
        return false;
    }

    public org.example.entity.SellProduct findById (int id){
        org.example.entity.SellProduct sellProduct = sellProductRepository.findById(id);
        if(sellProduct != null){
            return sellProduct;
        }
        throw new org.example.utils.exception.NotFoundException();
    }

    public List<org.example.entity.SellProduct> findAll (){
        return sellProductRepository.findAll();
    }
}
