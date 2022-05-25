package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;

@Repository
public class PgProductDao implements ProductDao{

	@Autowired
	private JdbcTemplate jdbcTemp;
	
	public List<Product> findAll(){
		return jdbcTemp.query("SELECT * FROM products ORDER BY product_id",
				new BeanPropertyRowMapper<Product>(Product.class));
	}
}
