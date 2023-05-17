package madhuri.com.uploadimgfromcamera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    private  final int CAMERA_REQ_CODE = 1;
    ImageView imageCamera;
    Button buttonCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageCamera = findViewById(R.id.Imagecamera);
        buttonCamera = findViewById(R.id.btnCamera);

        buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intemt chooser allow all camera choosen app
                Intent icamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(icamera,CAMERA_REQ_CODE);
            }
        });
    }
    //Back to the app with result

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == CAMERA_REQ_CODE){
                //For camera
                //Return object through static "data" key
                Bitmap img = (Bitmap)data.getExtras().get("data");
                imageCamera.setImageBitmap(img);

            }
        }
    }
}