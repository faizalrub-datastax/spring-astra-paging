package com.example.springastrapaging;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;

import java.time.Instant;

@Table(value = "stores_tmz")
public class StoresTmz {
    @PrimaryKeyColumn(name = "tm_zone", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = Name.TEXT)
    private String tmZone;

    @PrimaryKeyColumn(name = "str_num", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = Name.TEXT)
    private String strNum;

    @Column("created_date")
    @CassandraType(type = Name.TIMESTAMP)
    private Instant createdDate;

    @Column("day_no")
    @CassandraType(type = Name.INT)
    private Integer dayNo;

    @Column("process_day")
    @CassandraType(type = Name.INT)
    private Integer processDay;

    @Column("updated_date")
    @CassandraType(type = Name.TIMESTAMP)
    private Instant updatedDate;
}

