package com.bluelinelabs.logansquare.demo.parseinputstreamtask;

import com.bluelinelabs.logansquare.demo.model.Response;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;

public class GsonInputStreamParser extends ParserInputStream {

  private final Gson gson;

  public GsonInputStreamParser(ParseInputStreamListener parseInputStreamListener, InputStream inputStream, Gson gson) {
    super(parseInputStreamListener, inputStream);
    this.gson = gson;
  }

  @Override
  protected int parse(InputStream inputStream) {
    try {
      JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
      Response response = gson.fromJson(reader, Response.class);
      return response.users.size();
    } catch (Exception e) {
      return 0;
    } finally {
      System.gc();
    }
  }

}
