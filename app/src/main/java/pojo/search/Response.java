package pojo.search;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class Response{

	@SerializedName("statuses")
	public abstract List<StatusesItem> statuses();

	@SerializedName("search_metadata")
	public abstract SearchMetadata searchMetadata();

	public static TypeAdapter<Response> typeAdapter(Gson gson) {
		return new AutoValue_Response.GsonTypeAdapter(gson);
	}
}