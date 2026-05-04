package aiss.peertubeminer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Peertube channel not found")
public class ChannelNotFoundException extends Exception{
}
