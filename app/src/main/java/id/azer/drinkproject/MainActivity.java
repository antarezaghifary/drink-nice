package id.azer.drinkproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView1,imageView2,imageView3,imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Text
        textView = (TextView) findViewById(R.id.textView);
        String text = "Hi Greggy! What would \nyou like to drink";
        SpannableString ss = new SpannableString(text);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        ss.setSpan(boldSpan, 35, 40, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);

        //Img
        imageView1 = findViewById(R.id.image1);
        imageView2 = findViewById(R.id.image2);
        imageView3 = findViewById(R.id.image3);
        imageView4 = findViewById(R.id.image4);

        //
        if(isConnectingToInternet(MainActivity.this))
        {
            Toast.makeText(getApplicationContext(),"internet is available",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"internet is not available",Toast.LENGTH_LONG).show();
            openBottomSheetDialog();
        }
        //

        Glide.with(this)
                .load("https://i.imgur.com/yjsCW6a.jpg")
                .into(imageView1);

        Glide.with(this)
                .load("https://i.imgur.com/zGLyian.jpg")
                .into(imageView2);

        Glide.with(this)
                .load("https://i.imgur.com/rjfJqnt.jpg")
                .into(imageView3);

        Glide.with(this)
                .load("https://i.imgur.com/MQ06X7o.jpg")
                .into(imageView4);

    }

    public static boolean isConnectingToInternet(Context context)
    {
        ConnectivityManager connectivity =
                (ConnectivityManager) context.getSystemService(
                        Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            for (NetworkInfo networkInfo : info)
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
        }
        return false;
    }

    private void openBottomSheetDialog() {
        Bottom_notif_inet addBottomDialogFragment =
                Bottom_notif_inet.newInstance(this);
        addBottomDialogFragment.show(getSupportFragmentManager(),
                Bottom_notif_inet.TAG);
    }

    private void cekKoneksi(){
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
            Toast.makeText(getApplicationContext(), "konnek",
                    Toast.LENGTH_LONG).show();
        }
        else
            connected = false;
        Toast.makeText(getApplicationContext(), "tidak konnek konnek",
                Toast.LENGTH_LONG).show();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}