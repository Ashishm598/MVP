package pojo.search;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class UserMentionsItem{

	@SerializedName("indices")
	public abstract List<Integer> indices();

	@SerializedName("screen_name")
	public abstract String screenName();

	@SerializedName("id_str")
	public abstract String idStr();

	@SerializedName("name")
	public abstract String name();

	@SerializedName("id")
	public abstract long id();

	public static TypeAdapter<UserMentionsItem> typeAdapter(Gson gson) {
		return new AutoValue_UserMentionsItem.GsonTypeAdapter(gson);
	}
}