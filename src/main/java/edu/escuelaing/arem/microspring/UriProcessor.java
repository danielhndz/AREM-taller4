package edu.escuelaing.arem.microspring;

public interface UriProcessor {

    public void start(String component) throws Exception;

    public String invoke(String path);
}
