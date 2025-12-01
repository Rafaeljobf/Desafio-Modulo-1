package com.rafael.desafio_modulo_1;

import com.rafael.desafio_modulo_1.entities.Order;
import com.rafael.desafio_modulo_1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioModulo1Application implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

	public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        SpringApplication.run(DesafioModulo1Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o código do pedido: ");
        int code = sc.nextInt();
        System.out.print("Digite o valor base do pedido: ");
        double basicPrice = sc.nextDouble();
        System.out.print("Digite o percentual de desconto: ");
        double discountPercentage = sc.nextDouble();

        Order order = new Order(code, basicPrice, discountPercentage);

        System.out.println("Pedido código: "+ order.getCode());
        System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));
    }
}
