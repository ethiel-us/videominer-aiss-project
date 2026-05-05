
package aiss.dailymotionminer.model.dailymotion;

import java.util.List;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "array"
})
@Generated("jsonschema2pojo")
public class TagSearch {

    @JsonProperty("array")
    private List<Tag> array;

    @JsonProperty("array")
    public List<Tag> getArray() {
        return array;
    }

    @JsonProperty("array")
    public void setArray(List<Tag> array) {
        this.array = array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TagSearch.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("array");
        sb.append('=');
        sb.append(((this.array == null)?"<null>":this.array));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
