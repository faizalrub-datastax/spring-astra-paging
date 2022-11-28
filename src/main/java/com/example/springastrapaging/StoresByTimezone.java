package com.example.springastrapaging;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface StoresByTimezone extends CassandraRepository<StoresTmz, String> {
    Slice<StoresTmz> findAllByTmZone(String tmZone, Pageable pageable);
}
