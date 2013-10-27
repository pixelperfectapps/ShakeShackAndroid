package com.chapslife.shakeshackandroid.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chapslife.shakeshackandroid.MainActivity;
import com.chapslife.shakeshackandroid.R;
import com.chapslife.shakeshackandroid.utils.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lkchapman on 10/27/13.
 */
public class ShakeCameraFragment extends Fragment {

    private ImageView mShakeCamera;
    private Handler mHandler = new Handler();

    /**
     * Returns a new instance of this fragment
     */
    public static ShakeCameraFragment newInstance() {
        ShakeCameraFragment fragment = new ShakeCameraFragment();
        return fragment;
    }

    public ShakeCameraFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(1);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Indicate that this fragment would like to influence the set of actions in the action bar.
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        mShakeCamera = (ImageView) view.findViewById(R.id.shakeCamera);

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        mHandler.post(imageFetcher);
    }

    public void onPause(){
        super.onPause();
        mHandler.removeCallbacks(imageFetcher);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        protected Bitmap doInBackground(String... urls) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(Constants.CAMERA_URL);
                bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap result) {
            if(mShakeCamera.getDrawable() != null && ((BitmapDrawable)mShakeCamera.getDrawable()).getBitmap() != null){
                ((BitmapDrawable)mShakeCamera.getDrawable()).getBitmap().recycle();
            }
            mShakeCamera.setImageBitmap(result);
        }
    }

    /**
     * Gets the image from the server and sets it to the imageview. refreshes every 5 seconds
     */
    final Runnable imageFetcher = new Runnable(){
        public void run(){
            new DownloadImageTask().execute(Constants.CAMERA_URL);
            mHandler.postDelayed(this, Constants.IMAGE_REFRESH_TIME);
        }
    };

}
