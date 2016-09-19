package cameratest.deepaksachan.com.cameratest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

public class Preview extends AppCompatActivity {
    EditText text ;
    Bitmap bitmap;
    int pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        ImageView image=(ImageView)findViewById(R.id.imageView);

        text =(EditText)findViewById(R.id.editText);
        Intent data=getIntent();

        File imgFile = new File(data.getStringExtra("path"));

        //Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;

        // Get target image size
      bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        int bitmapHeight = bitmap.getHeight();
        int bitmapWidth = bitmap.getWidth();

        // Scale the image down to fit perfectly into the screen
        // The value must be adjusted for phone/tables displays
        while (bitmapHeight > (screenHeight ) && bitmapWidth > (screenWidth)) {
            bitmapHeight = bitmapHeight / 2;
            bitmapWidth = bitmapWidth / 2;
        }

        // Create resized bitmap image
        BitmapDrawable resizedBitmap = new BitmapDrawable(getResources(),
                Bitmap.createScaledBitmap(bitmap, bitmapWidth, bitmapHeight,
                        false));


        image.setImageDrawable(resizedBitmap);
    }

    public void onCancelClick(View v){



    }

    public void onOkayClick(View v){
        pos++;

        String s = text.getText().toString();
        Intent intent = new Intent(this,SetImage.class);
        intent.putExtra("pos",pos);
        intent.putExtra("imgpath", getIntent().getStringExtra("path"));
        intent.putExtra("text",s);
       // Singlton.getInstance().setImage(bitmap);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preview, menu);
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
