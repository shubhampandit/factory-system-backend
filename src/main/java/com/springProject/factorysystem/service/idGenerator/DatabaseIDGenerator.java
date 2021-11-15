package com.springProject.factorysystem.service.idGenerator;

import com.springProject.factorysystem.entity.OrderId;
import com.springProject.factorysystem.repository.OrderIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseIDGenerator implements IDGeneratorService{

    @Autowired
    private OrderIDRepository orderIDRepository;

    @Override
    public String generateID() {
        String orderIDInitial = "RSM-";
        String uniqueOrderID = null;
        List<OrderId> orderIdEntries = orderIDRepository.findAll();

        if(orderIdEntries.size() > 0){
            OrderId orderId = orderIdEntries.get(0);
            Long uniqueOrderInt = orderId.getLatestId();
            orderId.setLatestId(++uniqueOrderInt);
            uniqueOrderID = orderIDInitial + uniqueOrderInt;

            orderIDRepository.save(orderId);
        } else {
            Long uniqueOrderInt = 1L;
            uniqueOrderID = orderIDInitial + uniqueOrderInt;

            OrderId orderId = new OrderId(uniqueOrderInt);
            orderIDRepository.save(orderId);
        }
        return uniqueOrderID;
    }
}
