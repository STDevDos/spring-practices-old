package com.froyo.initial;

import com.froyo.messages.AbstractResponse;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MapObjectRowResponse extends AbstractResponse {

    private List<Map<String, String>> objMapRowList;
    private List<String> headerList;

}
