package pojo.search;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Metadata{

	@SerializedName("result_type")
	public abstract String resultType();

	@SerializedName("iso_language_code")
	public abstract String isoLanguageCode();

	public static TypeAdapter<Metadata> typeAdapter(Gson gson) {
		return new AutoValue_Metadata.GsonTypeAdapter(gson);
	}
}