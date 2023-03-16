/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.truongthikimhoa.pojo;

import java.util.UUID;

/**
 *
 * @author admin
 */
public class Question {
    private String id;
    private String content;
    private int category_id;
    
    {
        id = UUID.randomUUID().toString();
    }

    public Question() {
    }

    public Question(String content, int category_id) {
        this.content = content;
        this.category_id = category_id;
    }

    public Question(String id, String content, int category_id) {
        this.id = id;
        this.content = content;
        this.category_id = category_id;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the category_id
     */
    public int getCategory_id() {
        return category_id;
    }

    /**
     * @param category_id the category_id to set
     */
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
