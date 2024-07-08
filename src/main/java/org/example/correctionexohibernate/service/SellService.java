package org.example.correctionexohibernate.service;

import org.example.correctionexohibernate.entity.Customer;
import org.example.correctionexohibernate.entity.Sell;
import org.example.correctionexohibernate.entity.SellProduct;
import org.example.correctionexohibernate.repository.SellRepository;
import org.example.correctionexohibernate.utils.SellStatus;

import java.time.LocalDate;
import java.util.List;

public class SellService {
    private final SellRepository sellRepository;
    private final ProductService productService;

    public SellService() {
        this.sellRepository = new SellRepository();
        this.productService = new ProductService();
    }

    public Sell create(Customer customer){
                 Sell sell = Sell.builder()
                .customer(customer)
                .sellStatus(SellStatus.ONGOING)
                .sellDate(LocalDate.now()).build();

        return sellRepository.create(sell);
    }

    public org.example.entity.Sell update(int id, org.example.entity.Customer customer){

           Sell sell = sellRepository.findById(id);

        if (sell != null && sell.getSellStatus().equals(SellStatus.ONGOING) ){
            sell.setCustomer(customer);
            return sellRepository.update(sell);
        }
        throw new org.example.utils.exception.NotFoundException();
    }

    public boolean delete (int id){
        org.example.entity.Sell sell = sellRepository.findById(id);
        if(sell != null && sell.getSellStatus().equals(org.example.utils.SellStatus.ONGOING)){
            sell.setSellStatus(org.example.utils.SellStatus.CANCELED);
            sellRepository.update(sell);
            return true;
        }
        return false;
    }

    public org.example.entity.Sell findById (int id){
        org.example.entity.Sell sell = sellRepository.findById(id);
        if(sell != null){
            return sell;
        }
        throw new org.example.utils.exception.NotFoundException();
    }

    public List<org.example.entity.Sell> findAll (){
        return sellRepository.findAll();
    }

    public org.example.entity.Sell validateSell (int id){
        org.example.entity.Sell sell = sellRepository.findById(id);
        if(sell != null && sell.getSellStatus().equals(org.example.utils.SellStatus.ONGOING)){
            sell.setSellStatus(org.example.utils.SellStatus.FINALIZED);
            List<SellProduct> sellProducts = sell.getSellProducts();
            for (SellProduct sellProduct : sellProducts){
                productService.update(sellProduct.getProduct().getId(),sellProduct.getProduct().getStock() - sellProduct.getQuantity());
            }
            sellRepository.update(sell);
            return sell;
        }
        throw new org.example.utils.exception.NotFoundException();
    }

    public List<org.example.entity.Sell> getByDate (LocalDate dateStart, LocalDate dateStop){
        return sellRepository.findByDate(dateStart,dateStop);
    }
}
