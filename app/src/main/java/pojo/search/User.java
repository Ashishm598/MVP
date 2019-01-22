package pojo.search;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class User{


	@SerializedName("friends_count")
	public abstract int friendsCount();


	@SerializedName("listed_count")
	public abstract int listedCount();

	@SerializedName("default_profile_image")
	public abstract boolean defaultProfileImage();

	@SerializedName("favourites_count")
	public abstract int favouritesCount();

	@SerializedName("description")
	public abstract String description();

	@SerializedName("created_at")
	public abstract String createdAt();

	@SerializedName("is_translator")
	public abstract boolean isTranslator();

//	@SerializedName("profile_background_image_url_https")
//	public abstract String profileBackgroundImageUrlHttps();

	@SerializedName("protected")
	public abstract boolean jsonMemberProtected();

	@SerializedName("screen_name")
	public abstract String screenName();

	@SerializedName("id_str")
	public abstract String idStr();

	@SerializedName("profile_link_color")
	public abstract String profileLinkColor();

	@SerializedName("is_translation_enabled")
	public abstract boolean isTranslationEnabled();
//
//	@SerializedName("translator_type")
//	public abstract String translatorType();

	@SerializedName("id")
	public abstract long id();

	@SerializedName("geo_enabled")
	public abstract boolean geoEnabled();

	@SerializedName("profile_background_color")
	public abstract String profileBackgroundColor();

	@SerializedName("lang")
	public abstract String lang();

	@SerializedName("has_extended_profile")
	public abstract boolean hasExtendedProfile();

	@SerializedName("profile_sidebar_border_color")
	public abstract String profileSidebarBorderColor();

	@SerializedName("profile_text_color")
	public abstract String profileTextColor();

	@SerializedName("verified")
	public abstract boolean verified();

	@SerializedName("profile_image_url_https")
	public abstract String profileImageUrl();

//	@SerializedName("time_zone")
//	public abstract String	 timeZone();

//	@SerializedName("url")
//	public abstract String url();

	@SerializedName("contributors_enabled")
	public abstract boolean contributorsEnabled();

	@SerializedName("profile_background_tile")
	public abstract boolean profileBackgroundTile();

	@SerializedName("entities")
	public abstract Entities entities();

	@SerializedName("statuses_count")
	public abstract int statusesCount();

	@SerializedName("followers_count")
	public abstract int followersCount();

	@SerializedName("profile_use_background_image")
	public abstract boolean profileUseBackgroundImage();

	@SerializedName("default_profile")
	public abstract boolean defaultProfile();

	@SerializedName("name")
	public abstract String name();

	@SerializedName("location")
	public abstract String location();

	@SerializedName("profile_sidebar_fill_color")
	public abstract String profileSidebarFillColor();

//	@SerializedName("notifications")
//	public abstract String notifications();

	public static TypeAdapter<User> typeAdapter(Gson gson) {
		return new AutoValue_User.GsonTypeAdapter(gson);
	}
}