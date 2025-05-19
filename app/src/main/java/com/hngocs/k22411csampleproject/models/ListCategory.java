package com.hngocs.k22411csampleproject.models;

import java.util.ArrayList;

public class ListCategory {
    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    private ArrayList<Category> categories;
    public ListCategory()
    {
        categories=new ArrayList<>();
    }
    public void generate_product_dataset()
    {
// c1: T-shirt
        Category c1 = new Category(100, "T-shirt", 100);

        Product p1 = new Product(11001, "T-shirt Basic White", 10, 395, 1001);
        Product p2 = new Product(21002, "T-shirt Graphic Black", 8, 450, 1002);
        Product p3 = new Product(31003, "T-shirt Oversized Blue", 5, 520, 1003);
        Product p4 = new Product(41004, "T-shirt Polo Style", 12, 610, 1004);
        Product p5 = new Product(51005, "T-shirt Crop Top", 15, 480, 1005);

        c1.addProduct(p1);
        c1.addProduct(p2);
        c1.addProduct(p3);
        c1.addProduct(p4);
        c1.addProduct(p5);

        categories.add(c1);

// c2: Jeans Skirt
        Category c2 = new Category(200, "Jeans Skirt", 200);

        Product p6 = new Product(62001, "High Waist Denim Skirt", 6, 540, 2001);
        Product p7 = new Product(72002, "Ripped Mini Skirt", 10, 490, 2002);
        Product p8 = new Product(82003, "Pencil Jeans Skirt", 8, 620, 2003);
        Product p9 = new Product(92004, "Buttoned A-line Skirt", 12, 580, 2004);
        Product p10 = new Product(102005, "Vintage Wash Skirt", 7, 560, 2005);

        c2.addProduct(p6);
        c2.addProduct(p7);
        c2.addProduct(p8);
        c2.addProduct(p9);
        c2.addProduct(p10);

        categories.add(c2);

// c3: Cap & Hat
        Category c3 = new Category(300, "Cap & Hat", 300);

        Product p11 = new Product(113001, "Baseball Cap", 20, 150, 3001);
        Product p12 = new Product(123002, "Bucket Hat", 15, 180, 3002);
        Product p13 = new Product(133003, "Fedora Hat", 6, 300, 3003);
        Product p14 = new Product(143004, "Beanie", 18, 130, 3004);
        Product p15 = new Product(153005, "Snapback Cap", 10, 190, 3005);

        c3.addProduct(p11);
        c3.addProduct(p12);
        c3.addProduct(p13);
        c3.addProduct(p14);
        c3.addProduct(p15);

        categories.add(c3);

// c4: Shoes
        Category c4 = new Category(400, "Shoes", 400);

        Product p16 = new Product(164001, "Running Shoes", 10, 850, 4001);
        Product p17 = new Product(174002, "Leather Boots", 5, 1200, 4002);
        Product p18 = new Product(184003, "Sandals", 20, 400, 4003);
        Product p19 = new Product(194004, "High Heels", 8, 980, 4004);
        Product p20 = new Product(204005, "Loafers", 12, 730, 4005);

        c4.addProduct(p16);
        c4.addProduct(p17);
        c4.addProduct(p18);
        c4.addProduct(p19);
        c4.addProduct(p20);

        categories.add(c4);

// c5: Jacket
        Category c5 = new Category(500, "Jacket", 500);

        Product p21 = new Product(215001, "Bomber Jacket", 6, 950, 5001);
        Product p22 = new Product(225002, "Denim Jacket", 9, 870, 5002);
        Product p23 = new Product(235003, "Leather Jacket", 4, 1450, 5003);
        Product p24 = new Product(245004, "Windbreaker", 11, 680, 5004);
        Product p25 = new Product(255005, "Parka Jacket", 7, 1050, 5005);

        c5.addProduct(p21);
        c5.addProduct(p22);
        c5.addProduct(p23);
        c5.addProduct(p24);
        c5.addProduct(p25);

        categories.add(c5);

// c6: Dress
        Category c6 = new Category(600, "Dress", 600);

        Product p26 = new Product(266001, "Floral Midi Dress", 8, 740, 6001);
        Product p27 = new Product(276002, "Bodycon Dress", 6, 670, 6002);
        Product p28 = new Product(286003, "A-line Dress", 10, 790, 6003);
        Product p29 = new Product(296004, "Maxi Dress", 4, 890, 6004);
        Product p30 = new Product(306005, "Lace Cocktail Dress", 3, 1350, 6005);

        c6.addProduct(p26);
        c6.addProduct(p27);
        c6.addProduct(p28);
        c6.addProduct(p29);
        c6.addProduct(p30);

        categories.add(c6);

// c7: Jewelry
        Category c7 = new Category(700, "Jewelry", 700);

        Product p31 = new Product(317001, "Gold Necklace", 5, 2500, 7001);
        Product p32 = new Product(327002, "Silver Earrings", 15, 350, 7002);
        Product p33 = new Product(337003, "Bracelet Set", 10, 600, 7003);
        Product p34 = new Product(347004, "Pearl Ring", 7, 1800, 7004);
        Product p35 = new Product(357005, "Diamond Pendant", 2, 5000, 7005);

        c7.addProduct(p31);
        c7.addProduct(p32);
        c7.addProduct(p33);
        c7.addProduct(p34);
        c7.addProduct(p35);

        categories.add(c7);

// c8: Kids
        Category c8 = new Category(800, "Kids", 800);

        Product p36 = new Product(368001, "Kids T-shirt", 12, 250, 8001);
        Product p37 = new Product(378002, "Kids Jeans", 8, 320, 8002);
        Product p38 = new Product(388003, "Kids Dress", 10, 420, 8003);
        Product p39 = new Product(398004, "Kids Jacket", 6, 550, 8004);
        Product p40 = new Product(408005, "Kids Sneakers", 9, 490, 8005);

        c8.addProduct(p36);
        c8.addProduct(p37);
        c8.addProduct(p38);
        c8.addProduct(p39);
        c8.addProduct(p40);

        categories.add(c8);

// c9: Bag
        Category c9 = new Category(900, "Bag", 900);

        Product p41 = new Product(419001, "Backpack", 8, 790, 9001);
        Product p42 = new Product(429002, "Handbag", 10, 980, 9002);
        Product p43 = new Product(439003, "Crossbody Bag", 7, 860, 9003);
        Product p44 = new Product(449004, "Tote Bag", 15, 640, 9004);
        Product p45 = new Product(459005, "Laptop Bag", 5, 1200, 9005);

        c9.addProduct(p41);
        c9.addProduct(p42);
        c9.addProduct(p43);
        c9.addProduct(p44);
        c9.addProduct(p45);

        categories.add(c9);

// c10: Watch
        Category c10 = new Category(1000, "Watch", 1000);

        Product p46 = new Product(4610001, "Digital Watch", 10, 1100, 10001);
        Product p47 = new Product(4710002, "Analog Watch", 8, 1250, 10002);
        Product p48 = new Product(4810003, "Smartwatch", 6, 3200, 10003);
        Product p49 = new Product(4910004, "Luxury Watch", 2, 7800, 10004);
        Product p50 = new Product(5010005, "Sport Watch", 12, 1450, 10005);

        c10.addProduct(p46);
        c10.addProduct(p47);
        c10.addProduct(p48);
        c10.addProduct(p49);
        c10.addProduct(p50);

        categories.add(c10);
    }
}
