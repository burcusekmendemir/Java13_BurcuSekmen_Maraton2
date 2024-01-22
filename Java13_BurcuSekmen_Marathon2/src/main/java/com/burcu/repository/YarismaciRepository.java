package com.burcu.repository;

import com.burcu.entity.Yarismaci;

public class YarismaciRepository extends RepositoryManager<Yarismaci,Long>{
    public YarismaciRepository() {
        super(new Yarismaci());
    }
}
