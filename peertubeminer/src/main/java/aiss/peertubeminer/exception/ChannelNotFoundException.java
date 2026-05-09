package aiss.peertubeminer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ChannelNotFoundException extends Exception{
    public ChannelNotFoundException(String message) {
        super(message);
    }
}
