package com.productcatalog.model;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private int id;

        @Column(name="code")
        private String code;

        @Column(name="name")
        public String name;

        @Column(name="category")
        private String category;

        @Column(name="brand")
        private String brand;

        @Column(name="type")
        private String type;

        @Column(name="description")
        private String description;

        public Product() {
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getCode() {
                return code;
        }

        public void setCode(String code) {
                this.code = code;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public String getBrand() {
                return brand;
        }

        public void setBrand(String brand) {
                this.brand = brand;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        @Override
        public String toString() {
                return "Product{" +
                        "id=" + id +
                        ", code='" + code + '\'' +
                        ", name='" + name + '\'' +
                        ", category='" + category + '\'' +
                        ", brand='" + brand + '\'' +
                        ", type='" + type + '\'' +
                        ", description='" + description + '\'' +
                        '}';
        }

}
