package com.gunshippenguin.openflood;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Activity displaying information about the application.
 */
public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // Set up the first line of the info
        TextView versionTextView = (TextView) findViewById(R.id.infoVersionTextView);
        String versionText = getResources().getString(R.string.info_version);
        String appName = getResources().getString(R.string.app_name);

        PackageInfo pInfo;
        try {
            pInfo = getPackageManager().getPackageInfo(this.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            return;
        }

        versionText = String.format(versionText, pInfo.versionName);
        versionTextView.setText(appName + " " + versionText);

        // Set up the source link
        TextView sourceTextView = (TextView) findViewById(R.id.infoSourceTextView);
        sourceTextView.setMovementMethod(LinkMovementMethod.getInstance());

        // Set up the back button
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        return;
    }
}
