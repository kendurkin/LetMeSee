package imageFromUrl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.beefnky.R;

public class ContractActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contract_layout);
        
        // Loader image - will be shown before loading image
        int loader = R.drawable.ic_launcher;
        
        // Imageview to show
        ImageView image = (ImageView) findViewById(R.id.image);
        
        // Image url
        String image_url = "http://blog.wonderfulmachine.com/wp-content/uploads/2013/01/wmfh_redacted.jpg";
        
        // ImageLoader class instance
        ImageLoader imgLoader = new ImageLoader(getApplicationContext());
        
        // whenever you want to load an image from url
        // call DisplayImage function
        // url - image url to load
        // loader - loader image, will be displayed before getting image
        // image - ImageView 
        imgLoader.DisplayImage(image_url, loader, image);
    }
}