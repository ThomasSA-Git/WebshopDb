package com.example.webshopdat22v2.repository;

import com.example.webshopdat22v2.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ProductRepository {

  public List<Product> getAll() {
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webshop", "root", "T340593a");
          PreparedStatement psts = conn.prepareStatement("select * from product");
          ResultSet resultSet = psts.executeQuery();

      List<Product> productList = new LinkedList<>();
          while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int price = resultSet.getInt(3);
            productList.add(new Product(id, name, price));
          }
          return productList;
    }
    catch (SQLException e) {
      System.out.println("Connection not found");
      e.printStackTrace();
    }
    return null;
  }
}
