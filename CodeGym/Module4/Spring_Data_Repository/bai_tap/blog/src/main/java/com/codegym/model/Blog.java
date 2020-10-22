package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private String content;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category blogCategory;

    public Category getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(Category blogCategory) {
        this.blogCategory = blogCategory;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
