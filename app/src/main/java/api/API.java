package api;

import io.reactivex.Observable;
import pojo.search.SearchResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    // Base URL
    String BASE_URL = "https://api.twitter.com/";

    // Search URL
    String SEARCH_URL = "/1.1/search/tweets.json";


    @GET(SEARCH_URL)
    Observable<SearchResponse> getTweetsByQuery(@Query("q") String query, @Query("result_type") String result_type);

}
