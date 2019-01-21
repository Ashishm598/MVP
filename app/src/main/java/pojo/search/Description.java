package pojo.search;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class Description{

	@SerializedName("urls")
	public abstract List<Object> urls();

	public static TypeAdapter<Description> typeAdapter(Gson gson) {
		return new AutoValue_Description.GsonTypeAdapter(gson);
	}
}