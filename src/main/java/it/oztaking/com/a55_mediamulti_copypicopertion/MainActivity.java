package it.oztaking.com.a55_mediamulti_copypicopertion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    //旋转的角度
    private float degree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
        final ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);

        //2.将tomcat.png转换为bitmap然后显示到iv_src
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.tomcat);
        iv_src.setImageBitmap(bitmap);

        //3.拷贝原图
        //创建模板
        final Bitmap copyBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        //创建画布
        final Canvas canvas = new Canvas(copyBitmap);
        //创建画笔
        final Paint paint = new Paint();
        //作画
        final Matrix matrix = new Matrix();
//        //图片缩小0.5；
//        matrix.setScale(0.5f,0.5f);
//        //图片位移
//        matrix.setTranslate(100,0);

//        //图片倒影效果
//        matrix.setScale(1.0f,-1.0f);
//        matrix.postTranslate(0,copyBitmap.getHeight());
        //镜面效果
        matrix.setScale(-1.0f, 1.0f);
        matrix.postTranslate(copyBitmap.getWidth(), 0);

        canvas.drawBitmap(bitmap, matrix, paint);
//        new Thread() {
//            @Override
//            public void run() {
//                for (;;){
//                    try {
//                        Thread.sleep(1000);
//                        degree+=10;
//                        matrix.setRotate(degree, copyBitmap.getWidth() / 2, copyBitmap.getHeight() / 2);
//                        canvas.drawBitmap(bitmap, matrix, paint);
//
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//
//                            }
//                        });
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//
//            }
//        }.start();


        //将画出的内容显示到ImageView中
        iv_copy.setImageBitmap(copyBitmap);

        for (int i = 0; i < 100; i++) {
            copyBitmap.setPixel(20 + i, 30, Color.BLACK);
        }

    }
}

