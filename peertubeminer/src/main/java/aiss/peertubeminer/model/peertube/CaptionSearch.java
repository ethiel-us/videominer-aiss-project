
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
public class CaptionSearch {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("data")
    private List<Caption> data;

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("data")
    public List<Caption> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Caption> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CaptionSearch{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }

}
