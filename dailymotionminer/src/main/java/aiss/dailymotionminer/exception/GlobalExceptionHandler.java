package aiss.dailymotionminer.exception;

import aiss.dailymotionminer.exception.ChannelNotFoundException;
import aiss.dailymotionminer.exception.VideoMinerCommunicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ChannelNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> handleChannelNotFoundException(ChannelNotFoundException ex) {
        Map<String, String> res = new LinkedHashMap<>();
        res.put("status", HttpStatus.NOT_FOUND.toString());
        res.put("error", ex.getMessage());
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VideoMinerCommunicationException.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> handleVideoMinerCommunicationException(VideoMinerCommunicationException ex) {
        Map<String, String> res = new LinkedHashMap<>();
        res.put("status", String.valueOf(ex.getStatus().value()));
        res.put("error", ex.getStatus().getReasonPhrase());
        res.put("message", ex.getMessage());
        return new ResponseEntity<>(res, ex.getStatus());
    }
}
