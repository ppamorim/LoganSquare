package com.bluelinelabs.logansquare.demo.parseinputstreamtask;

import android.os.AsyncTask;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public abstract class ParserInputStream extends AsyncTask<Void, Void, ParseResultInputStream> {

    public interface ParseInputStreamListener {
        public void onComplete(ParserInputStream parserInputStream, ParseResultInputStream parseResultInputStream);
    }

    private final ParseInputStreamListener mParseListener;
    private final InputStream mInputStream;

    protected ParserInputStream(ParseInputStreamListener parseListener, InputStream inputStream) {
        mParseListener = parseListener;
        mInputStream = inputStream;
    }

    @Override
    protected ParseResultInputStream doInBackground(Void... params) {
        System.gc();
        long startTime = System.nanoTime();
        int objectCount = parse(mInputStream);
        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMicros(endTime - startTime);

        return new ParseResultInputStream(duration, objectCount);
    }

    @Override
    protected void onPostExecute(ParseResultInputStream parseResultInputStream) {
        mParseListener.onComplete(this, parseResultInputStream);
    }

    protected abstract int parse(InputStream inputStream);
}