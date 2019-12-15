package com.summer.community.dao;


import org.springframework.stereotype.Repository;

@Repository("aplphaDao")
public class AplphaDaoImpl implements AlphaDao{

    @Override
    public String select() {
        return "yeah";
    }
}
