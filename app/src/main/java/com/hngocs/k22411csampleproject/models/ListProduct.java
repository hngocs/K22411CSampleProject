package com.hngocs.k22411csampleproject.models;

import com.hngocs.k22411csampleproject.R;

import java.util.ArrayList;

public class ListProduct {
    private ArrayList<Product> products;
    public ListProduct(){
        products=new ArrayList<>();
    }
    public void addProduct(Product p)
    {
        products.add(p);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    public void setProducts(ArrayList<Product> products){
        this.products=products;
    }

    public void generate_sample_products()
    {
        Product p1 = new Product(11001, "T-shirt Basic White", 10, 395, R.mipmap.p1);
        Product p2 = new Product(21002, "T-shirt Graphic Black", 8, 450, R.mipmap.p2);
        Product p3 = new Product(31003, "T-shirt Oversized Blue", 5, 520, R.mipmap.p3);
        Product p4 = new Product(41004, "T-shirt Polo Style", 12, 610, R.mipmap.p4);
        Product p5 = new Product(51005, "T-shirt Crop Top", 15, 480, R.mipmap.p5);

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);


    }
}
