package ru.ayupov.task2;

import java.util.*;

public class Order implements Basket {
    HashMap<String, Integer> products = new HashMap<>();

    @Override
    public void addProduct(String product, int quantity) {
        products.putIfAbsent(product, quantity);
    }

    @Override
    public void removeProduct(String product) {
        if (products.containsKey(product)) {
            products.remove(product);
        }
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        products.computeIfPresent(product, (k, v) -> v + quantity);
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        if (!products.isEmpty()) {
            return new ArrayList<>(products.keySet());
        }
        return new ArrayList<>();
    }

    @Override
    public int getProductQuantity(String product) {
        if (products.containsValue(product)) {
            return products.get(product);
        } else {
            System.out.println("Указанного продукта нет в корзине!");
        }
        return 0;
    }

    public void printOrder() {
        if (!products.isEmpty()) {
            products.forEach((k, v) -> System.out.println(k + " " + v));
        } else {
            System.out.println("Корзина пуста!");
        }
        System.out.println();
    }
}
