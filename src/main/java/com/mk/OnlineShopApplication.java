package com.mk;

import com.mk.repository.OrderRepository;
import com.mk.model.Product;
import com.mk.repository.CustomerRepository;
import com.mk.repository.ProductRepository;

import com.mk.storage.StorageProperties;
import com.mk.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/*

BASED ON: https://shakeelosmani.wordpress.com/2017/02/13/step-by-step-spring-boot-hibernate-crud-web-application-tutorial/
*/


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
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
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            //storageService.deleteAll();
            storageService.init();
        };
    }

}
