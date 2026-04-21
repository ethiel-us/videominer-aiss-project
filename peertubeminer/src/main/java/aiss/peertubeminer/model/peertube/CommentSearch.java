
package aiss.peertubeminer.model.peertube;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "total",
        "data",
        "totalNotDeletedComments"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentSearch {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("data")
    private List<Comment> data;
    @JsonProperty("totalNotDeletedComments")
    private Integer totalNotDeletedComments;

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("data")
    public List<Comment> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Comment> data) {
        this.data = data;
    }

    @JsonProperty("totalNotDeletedComments")
    public Integer getTotalNotDeletedComments() {
        return totalNotDeletedComments;
    }

    @JsonProperty("totalNotDeletedComments")
    public void setTotalNotDeletedComments(Integer totalNotDeletedComments) {
        this.totalNotDeletedComments = totalNotDeletedComments;
    }

    @Override
    public String toString() {
        return "CommentSearch{" +
                "total=" + total +
                ", data=" + data +
                ", totalNotDeletedComments=" + totalNotDeletedComments +
                '}';
    }

}
