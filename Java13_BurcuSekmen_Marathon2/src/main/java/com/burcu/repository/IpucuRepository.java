package com.burcu.repository;

import com.burcu.entity.Ipucu;

public class IpucuRepository extends RepositoryManager<Ipucu,Long>{
    public IpucuRepository() {
        super(new Ipucu());
    }
}
