//package com.bluelinelabs.logansquare.demo.parseinputstreamtask;
//
//import com.bluelinelabs.logansquare.demo.model.Response;
//import com.squareup.moshi.JsonReader;
//import com.squareup.moshi.Moshi;
//
//import java.io.InputStream;
//
//import okio.BufferedSource;
//
//public class MoshiInputStreamParser extends ParserInputStream {
//
//    private final Moshi moshi;
//
//    public MoshiInputStreamParser(ParseInputStreamListener parseInputStreamListener, InputStream inputStream, Moshi moshi) {
//        super(parseInputStreamListener, inputStream);
//        this.moshi = moshi;
//    }
//
//    @Override
//    protected int parse(InputStream inputStream) {
//        try {
//            BufferedSource bufferedSource = In
//            return moshi.adapter(Response.class).fromJson(JsonReader.of(bufferedSource)).users.size();
//        } catch (Exception e) {
//            return 0;
//        } finally {
//            System.gc();
//        }
//    }
//
//}
