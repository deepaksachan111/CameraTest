package cameratest.deepaksachan.com.cameratest;

import android.graphics.Bitmap;

/**
 * Created by intex on 9/10/2016.
 */
public class Singlton {


        private Bitmap Image;
        private static Singlton instance;
        public static Singlton getInstance() {
            if (instance == null) {
                instance = new Singlton();
            }
            return instance;
        }

        public Bitmap getImage() {
            return this.Image;
        }

        public Bitmap setImage(Bitmap ImageIn) {
            this.Image = ImageIn;

            return Image;
        }

}
