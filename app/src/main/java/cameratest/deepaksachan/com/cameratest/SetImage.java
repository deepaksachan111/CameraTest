package cameratest.deepaksachan.com.cameratest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class SetImage extends AppCompatActivity {
  TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_image);

        tv = (TextView) findViewById(R.id.text_tv);

       // Bitmap bmp = (Bitmap)this.getIntent().getParcelableExtra("bmp");


          int i = getIntent().getIntExtra("pos", 0);
        Intent data=getIntent();

        String texts = data.getStringExtra("text");
        tv.setText(texts);

        String sbmp = data.getStringExtra("imgpath");

        Bitmap image = BitmapFactory.decodeFile(sbmp);
       // Bitmap image = Singlton.getInstance().getImage();

        ImageView imageView =(ImageView)findViewById(R.id.iv_set);
       /* ImageView imageView2 =(ImageView)findViewById(R.id.iv_set2);
        ImageView imageView3 =(ImageView)findViewById(R.id.iv_set3);
        ImageView imageView4 =(ImageView)findViewById(R.id.iv_set4);*/


     imageView.setImageBitmap(image);


        //BitmapDrawable background = new BitmapDrawable(bmp);
       // getWindow().setBackgroundDrawable(background);  //background image of the screen

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set_image, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
