package com.burcu.repository;

import com.burcu.entity.Yarisma;

public class YarismaRepository extends RepositoryManager<Yarisma,Long>{
    public YarismaRepository() {
        super(new Yarisma());
    }
}
