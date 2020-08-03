package id.azer.drinkproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.ImageView;
import android.widget.TextView;

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
}