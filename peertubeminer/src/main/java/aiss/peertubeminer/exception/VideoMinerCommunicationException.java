package aiss.peertubeminer.exception;

import org.springframework.http.HttpStatus;

public class VideoMinerCommunicationException extends Exception{
    private final HttpStatus status;

    public VideoMinerCommunicationException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
