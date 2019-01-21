package pojo.search;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class Entities{

	@SerializedName("urls")
	public abstract List<UrlsItem> urls();

	@SerializedName("hashtags")
	public abstract List<HashtagsItem> hashtags();

	@SerializedName("user_mentions")
	public abstract List<UserMentionsItem> userMentions();

	@SerializedName("symbols")
	public abstract List<Object> symbols();

	public static TypeAdapter<Entities> typeAdapter(Gson gson) {
		return new AutoValue_Entities.GsonTypeAdapter(gson);
	}
}