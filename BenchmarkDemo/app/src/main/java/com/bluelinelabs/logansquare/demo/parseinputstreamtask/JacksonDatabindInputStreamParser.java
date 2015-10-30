package com.bluelinelabs.logansquare.demo.parseinputstreamtask;

import com.bluelinelabs.logansquare.demo.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JacksonDatabindInputStreamParser extends ParserInputStream {

    private final ObjectMapper objectMapper;

    public JacksonDatabindInputStreamParser(ParseInputStreamListener parseInputStreamListener, InputStream inputStream, ObjectMapper objectMapper) {
        super(parseInputStreamListener, inputStream);
        this.objectMapper = objectMapper;
    }

    @Override
    protected int parse(InputStream inputStream) {
        try {
            Response response = objectMapper.readValue(inputStream, Response.class);
            return response.users.size();
        } catch (Exception e) {
            return 0;
        } finally {
            System.gc();
        }
    }

}
