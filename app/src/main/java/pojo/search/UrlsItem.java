package pojo.search;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class UrlsItem{

	@SerializedName("display_url")
	public abstract String displayUrl();

	@SerializedName("indices")
	public abstract List<Integer> indices();

	@SerializedName("expanded_url")
	public abstract String expandedUrl();

	@SerializedName("url")
	public abstract String url();

	public static TypeAdapter<UrlsItem> typeAdapter(Gson gson) {
		return new AutoValue_UrlsItem.GsonTypeAdapter(gson);
	}
}