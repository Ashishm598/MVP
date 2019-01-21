package pojo.search;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class HashtagsItem{

	@SerializedName("indices")
	public abstract List<Integer> indices();

	@SerializedName("text")
	public abstract String text();

	public static TypeAdapter<HashtagsItem> typeAdapter(Gson gson) {
		return new AutoValue_HashtagsItem.GsonTypeAdapter(gson);
	}
}