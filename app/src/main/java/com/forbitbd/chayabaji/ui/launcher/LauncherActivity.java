package com.forbitbd.chayabaji.ui.launcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.forbitbd.myplayer.models.OnlineStatus;
import com.forbitbd.chayabaji.DashboardActivity;
import com.forbitbd.chayabaji.DialogFragment;
import com.forbitbd.chayabaji.R;

public class LauncherActivity extends AppCompatActivity implements LauncherContract.View {

    private LauncherPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        mPresenter = new LauncherPresenter(this);
        mPresenter.getOnlineStatus();

        }

    @Override
    public void updateStatus(OnlineStatus onlineStatus) {
        if (onlineStatus.isIs_active()){
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
        }else{
            DialogFragment dialogFragment = new DialogFragment();
            dialogFragment.show(getSupportFragmentManager(),"jjkjjj");
            dialogFragment.setCancelable(false);
        }
    }
}
