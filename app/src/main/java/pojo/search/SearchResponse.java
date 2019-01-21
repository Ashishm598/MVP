package pojo.search;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *
 *
 */

@AutoValue
public abstract class SearchResponse {

    @SerializedName("statuses")
    public abstract List<StatusesItem> statusesItems();

//    @SerializedName("search_metadata")
//    public abstract SearchMetadata metadata();

    public static TypeAdapter<SearchResponse> typeAdapter(Gson gson) {
        return new AutoValue_SearchResponse.GsonTypeAdapter(gson);
    }
}
