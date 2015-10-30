package com.bluelinelabs.logansquare.demo.parseinputstreamtask;

import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.demo.model.Response;

import java.io.InputStream;

public class LoganSquareInputStreamParser extends ParserInputStream {

    public LoganSquareInputStreamParser(ParseInputStreamListener parseInputStreamListener, InputStream inputStream) {
        super(parseInputStreamListener, inputStream);
    }

    @Override
    protected int parse(InputStream inputStream) {
        try {
            Response response = LoganSquare.parse(inputStream, Response.class);
            return response.users.size();
        } catch (Exception e) {
            return 0;
        } finally {
            System.gc();
        }
    }

}
