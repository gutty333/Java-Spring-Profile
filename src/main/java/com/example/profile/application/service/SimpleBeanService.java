package com.example.profile.application.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SimpleBeanService {

    String mockProxy;

    String realProxy;

    String currentBean;


    public String simpleResponse() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();
        ObjectNode child = objectMapper.createObjectNode();


        List<String> beanValueList = List.of(mockProxy, realProxy, currentBean);

        String result = beanValueList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining("<>"));

        child.put("content", result);
        rootNode.set("responseResult", child);

        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        } catch (Exception e) {
            return objectMapper.writeValueAsString("Bad Response processing");
        }
    }
}
