package com.burcu.repository;

import com.burcu.entity.Unlu;

public class UnluRepository extends RepositoryManager<Unlu,Long>{
    public UnluRepository() {
        super(new Unlu());
    }
}
