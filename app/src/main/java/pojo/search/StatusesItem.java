package pojo.search;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class StatusesItem {

    @SerializedName("metadata")
    public abstract Metadata metadata();

    @SerializedName("created_at")
    public abstract String createdAt();

//	@SerializedName("in_reply_to_user_id_str")
//	public abstract Object inReplyToUserIdStr();

    @SerializedName("source")
    public abstract String source();

    @SerializedName("retweet_count")
    public abstract int retweetCount();

    @SerializedName("retweeted")
    public abstract boolean retweeted();

//	@SerializedName("geo")
//	public abstract Object geo();

//	@SerializedName("in_reply_to_screen_name")
//	public abstract Object inReplyToScreenName();

    @SerializedName("is_quote_status")
    public abstract boolean isQuoteStatus();

    @SerializedName("id_str")
    public abstract String idStr();

    @SerializedName("favorite_count")
    public abstract int favoriteCount();

    @SerializedName("id")
    public abstract long id();

    @SerializedName("text")
    public abstract String text();

    @SerializedName("lang")
    public abstract String lang();

    @SerializedName("favorited")
    public abstract boolean favorited();

    @SerializedName("possibly_sensitive")
    public abstract boolean possiblySensitive();

//	@SerializedName("coordinates")
//	public abstract Object coordinates();

    @SerializedName("truncated")
    public abstract boolean truncated();

    @SerializedName("entities")
    public abstract Entities entities();

    @SerializedName("user")
    public abstract User user();

    private long score;

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public static TypeAdapter<StatusesItem> typeAdapter(Gson gson) {
        return new AutoValue_StatusesItem.GsonTypeAdapter(gson);
    }

}