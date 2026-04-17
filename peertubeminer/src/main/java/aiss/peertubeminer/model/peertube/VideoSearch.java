
package aiss.peertubeminer.model.peertube;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total",
    "data"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoSearch {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("data")
    private List<Video> data;

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("data")
    public List<Video> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Video> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "VideoSearch{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }

}
