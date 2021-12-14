package com.cuatroa.retodos;

import com.cuatroa.retodos.model.CleaningProduct;
import com.cuatroa.retodos.model.Order;
import com.cuatroa.retodos.model.User;
import com.cuatroa.retodos.repository.OrderRepository;
import com.cuatroa.retodos.repository.UserRepository;
import com.cuatroa.retodos.repository.crud.CleaningCrudProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.cuatroa.retodos.repository.crud.OrderCrudRepository;
import com.cuatroa.retodos.repository.crud.UserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class RetodosApplication implements CommandLineRunner {

    @Autowired
    private CleaningCrudProductRepository crudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private OrderCrudRepository orderCrudRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RetodosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        crudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();

//        crudRepository.saveAll(List.of(
//                new CleaningProduct("AP-903", "UNO A", "DESENGRASANTES", "MATERIAL 1", "BASICA", "Descripción... costo, calidad, precio, y economia", true, 80000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-006127.jpg"),
//                new CleaningProduct("AP-904", "MULTIVERSO", "LAVALOZA", "MATERIAL 2", "BASICA", "Descripción... excelente contra la mugre", true, 150000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-007.jpg")
//        ));
//
//        userCrudRepository.saveAll(List.of(
//                new User(1, "46669989", "BLODY MARRY", ft.parse("1996-11-15"), "11", "CR 34-45", "3174565625", "stellez@gmail.com", "Demo123.", "ZONA 2", "ASE"),
//                new User(2, "52369563", "JUANA DE ARCO", ft.parse("1987-05-15"), "05", "CR 34-45", "3265632", "jdarco@gmail.com", "Demo123.", "ZONA 2", "ASE")
//        ));
    }
}
