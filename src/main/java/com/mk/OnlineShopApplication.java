package com.mk;

import com.mk.repository.OrderRepository;
import com.mk.model.Product;
import com.mk.repository.CustomerRepository;
import com.mk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineShopApplication implements CommandLineRunner {

	@Autowired
    ProductRepository productRepository;

	@Autowired
    CustomerRepository customerRepository;

	@Autowired
    OrderRepository orderRepository;



    public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {

        Product apple = new Product();
        apple.setProductName("Apple");
        apple.setProductPrice(1.25);

        Product orange = new Product();
        orange.setProductName("Orange");
        orange.setProductPrice(4.95);

        productRepository.save(apple);
        productRepository.save(orange);

    }
/*
    @Override
    public void run(String... strings) throws Exception {

        Product mocha = new Product();
        mocha.setProductName("Mocha");
        mocha.setProductPrice(3.95);

        Product capuccinno = new Product();
        capuccinno.setProductName("Capuccinno");
        capuccinno.setProductPrice(4.95);

        productRepository.save(mocha);
        productRepository.save(capuccinno);

    }
*/

}
