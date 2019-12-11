package utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.twittersearch.ashish.twittersearch.R;

import org.threeten.bp.Clock;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneOffset;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import okio.ByteString;


public class Util {

    private Context mContext;
    private DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);


    public Util(Context context) {
        this.mContext = context;
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public static Random getRandom() {
        return new Random() {
            @Override
            public void nextBytes(byte[] bytes) {
                if (bytes.length != 32) throw new AssertionError();
                ByteString hex = ByteString.decodeBase64("kYjzVBB8Y0ZFabxSWbWovY3uYSQ2pTgmZeNu2VS4c+g");
                byte[] nonce = hex.toByteArray();
                System.arraycopy(nonce, 0, bytes, 0, nonce.length);
            }
        };
    }

    public static Clock getCurrentTimeStamp() {
        return Clock.fixed(Instant.ofEpochMilli(System.currentTimeMillis() / 1000), ZoneOffset.UTC);
    }


    public void displayNoInternetSnackBar(Context context, View rootView) {
        Snackbar.make(rootView, context.getString(R.string.no_internet_msg), Snackbar.LENGTH_LONG)
                .setAction(" ", null)
                .show();
    }


    public long getMinutesElapsedFromDate(String fromDate) {
        long fromDateTimeStamp = 0;
        try {
            fromDateTimeStamp = dateFormat.parse(fromDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (fromDateTimeStamp > 0) ? (getCurrentTimeStamp().millis() - fromDateTimeStamp / 1000) / 60 : 0;
    }


}
