package com.springProject.factorysystem.service;

import com.springProject.factorysystem.constant.OrderConstant;
import com.springProject.factorysystem.dto.GetOrderRequest;
import com.springProject.factorysystem.dto.GetOrdersRequest;
import com.springProject.factorysystem.dto.PostOrderRequest;
import com.springProject.factorysystem.dto.PostOrderResponse;
import com.springProject.factorysystem.entity.Orders;
import com.springProject.factorysystem.entity.Tasks;
import com.springProject.factorysystem.entity.referenceEntities.master.CompanyMaster;
import com.springProject.factorysystem.repository.OrderRepository;
import com.springProject.factorysystem.service.idGeneratorService.IDGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private IDGeneratorService idGeneratorService;

    @Autowired
    private CompanyMasterService companyMasterService;

    @Override
    public List<GetOrdersRequest> getOrders() {
        List<Orders> orders = orderRepository.findAll();
        List<GetOrdersRequest> requestList = new ArrayList<>();
        for (Orders order : orders) {
            CompanyMaster company = companyMasterService.getCompanyById(order.getCompanyId());
            GetOrdersRequest request = new GetOrdersRequest(order.getOrderId(), company.getName(), order.getAssignedTo(), order.getOrderStatus());
            requestList.add(request);
        }
        return requestList;
    }

    @Override
    public GetOrderRequest getOrder(String orderId) {
        Orders order = orderRepository.findByOrderId(orderId);
        CompanyMaster company = companyMasterService.getCompanyById(order.getCompanyId());
        return new GetOrderRequest(order.getOrderId(), company.getName(), company.getAddressDetails().getAddress(), company.getContactDetails().getContactPerson(), company.getContactDetails().getMobileNumber(), order.getAssignedTo(), order.getOrderStatus(), order.getProducts());
    }

    @Override
    public PostOrderResponse postOrder(PostOrderRequest postOrderRequest) {
        String uniqueOrderID = idGeneratorService.generateID();

        Orders order = createOrder(uniqueOrderID, postOrderRequest);

        Tasks task = new Tasks();
        task.setOrderId(uniqueOrderID);
        task.setAssignedTo(postOrderRequest.getAssignedTo());
        order.setTask(task);

        orderRepository.save(order);

        return new PostOrderResponse("Created", uniqueOrderID);
    }

    private Orders createOrder(String uniqueOrderID, PostOrderRequest postOrderRequest) {
        Orders order = new Orders();
        order.setOrderId(uniqueOrderID);
        order.setCompanyId(postOrderRequest.getCompanyId());
        order.setOrderStatus(OrderConstant.OrderStatus.ORDER_PLACED);
        if (null != postOrderRequest.getBrokerId()) {
            order.setBrokerId(postOrderRequest.getBrokerId());
        }
        order.setAssignedTo(postOrderRequest.getAssignedTo());
        order.setProducts(postOrderRequest.getProducts());

        return order;
    }
}
