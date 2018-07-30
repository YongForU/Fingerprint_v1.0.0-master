package figer.hsy.com.myfingertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import zwh.com.lib.FingerPrinterView;
import zwh.com.lib.Fingerprint;
import zwh.com.lib.FingerprintCallback;

public class MainActivity extends AppCompatActivity {

    private FingerPrinterView fingerPrinterView;
    private TextView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (TextView) findViewById(R.id.image);
        fingerPrinterView = (FingerPrinterView) findViewById(R.id.fpv);


        findViewById(R.id.btn_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fingerprint.FingerprintVail(MainActivity.this, fingerPrinterView, new FingerprintCallback() {
                    @Override
                    public void finish_msg(final String msg) {
                        Log.e("---",msg);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                image.setText(msg);
                            }
                        });
                    }
                });

            }
        });


    }
}
