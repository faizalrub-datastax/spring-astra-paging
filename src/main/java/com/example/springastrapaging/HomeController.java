package com.example.springastrapaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    @Autowired
    StoresByTimezone storesByTimezone;

    @GetMapping("/")
    public String home() {

        List<StoresTmz> storesTmzList = Collections.synchronizedList(new ArrayList<StoresTmz>());
        Slice<StoresTmz> storesTmzSlice = storesByTimezone.findAllByTmZone("EST", CassandraPageRequest.first(2000));
        storesTmzSlice.stream().collect(Collectors.toCollection(() -> storesTmzList ));
        while(storesTmzSlice.hasNext()) {
            storesTmzSlice = storesByTimezone.findAllByTmZone("EST",storesTmzSlice.nextPageable());
            storesTmzSlice.stream().collect(Collectors.toCollection(() -> storesTmzList));
        }
        /*
        Slice<StoresTmz> storesTmzSlice = storesByTimezone.findAllByTmZone("EST", CassandraPageRequest.of(0, 50000));
        List<StoresTmz> storesTmz = storesTmzSlice.getContent();
        storesTmz = storesTmz.stream().distinct().map(store -> {
            return store;
        }).collect(Collectors.toList());
        */
        return "Completed!"  ;

    }

}

