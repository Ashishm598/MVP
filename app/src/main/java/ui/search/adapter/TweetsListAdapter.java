package ui.search.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.twittersearch.ashish.twittersearch.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import pojo.search.StatusesItem;

public class TweetsListAdapter extends RecyclerView.Adapter<TweetsListAdapter.TweetsListViewHolder> {

    private Context mContext;
    private List<StatusesItem> statusList;

    public TweetsListAdapter(Context mContext, List<StatusesItem> statuses) {
        this.mContext = mContext;
        this.statusList = statuses;
    }

    @Override
    public TweetsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new TweetsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TweetsListViewHolder holder, int position) {
        try {
            Glide.with(mContext).load(statusList.get(position).user().profileImageUrl()).apply(new RequestOptions().placeholder(R.drawable.default_profile_image)).into(holder.civUserProfilePic);
            holder.tvName.setText(statusList.get(position).user().name());
            holder.tvTwitterHandle.setText(statusList.get(position).user().screenName());
            holder.tvFavorites.setText(String.valueOf(statusList.get(position).favoriteCount()));
            holder.tvRetweets.setText(String.valueOf(statusList.get(position).retweetCount()));
            holder.tvTweet.setText(statusList.get(position).text());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return statusList.size();
    }

    public void setSearchedData(List<StatusesItem> statuses) {
        this.statusList = statuses;
        notifyDataSetChanged();
    }

    public List<StatusesItem> getCurrentListData() {
        return (statusList.size() > 0) ? statusList : null;
    }


    class TweetsListViewHolder extends RecyclerView.ViewHolder {
        CircleImageView civUserProfilePic;
        TextView tvName, tvTwitterHandle, tvTweet, tvFavorites, tvRetweets;

        TweetsListViewHolder(View itemView) {
            super(itemView);
            civUserProfilePic = itemView.findViewById(R.id.civ_userProfilePic);
            tvName = itemView.findViewById(R.id.tv_name);
            tvTwitterHandle = itemView.findViewById(R.id.tv_twitterHandle);
            tvTweet = itemView.findViewById(R.id.tv_tweet);
            tvFavorites = itemView.findViewById(R.id.tv_favorites);
            tvRetweets = itemView.findViewById(R.id.tv_retweets);

        }

    }
}