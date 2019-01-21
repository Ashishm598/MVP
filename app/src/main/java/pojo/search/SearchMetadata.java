package pojo.search;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class SearchMetadata{

	@SerializedName("max_id_str")
	public abstract String maxIdStr();

	@SerializedName("next_results")
	public abstract String nextResults();

	@SerializedName("since_id_str")
	public abstract String sinceIdStr();

	@SerializedName("query")
	public abstract String query();

	@SerializedName("count")
	public abstract int count();

	@SerializedName("max_id")
	public abstract long maxId();

	@SerializedName("since_id")
	public abstract int sinceId();

	@SerializedName("completed_in")
	public abstract double completedIn();

	@SerializedName("refresh_url")
	public abstract String refreshUrl();

	public static TypeAdapter<SearchMetadata> typeAdapter(Gson gson) {
		return new AutoValue_SearchMetadata.GsonTypeAdapter(gson);
	}
}