package com.forbitbd.chayabaji.ui.launcher;

import com.forbitbd.myplayer.models.OnlineStatus;
import com.forbitbd.chayabaji.api.ApiClient;
import com.forbitbd.chayabaji.api.ServiceGenerator;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LauncherPresenter implements LauncherContract.Presenter {

    private LauncherContract.View mview;

    public LauncherPresenter(LauncherContract.View mview) {
        this.mview = mview;
    }

    @Override
    public void getOnlineStatus() {
        ApiClient client = ServiceGenerator.createService(ApiClient.class);
        client.getOnlineStatus()
                .enqueue(new Callback<OnlineStatus>() {
                    @Override
                    public void onResponse(Call<OnlineStatus> call, Response<OnlineStatus> response) {
                        if (response.isSuccessful()){
                            mview.updateStatus(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<OnlineStatus> call, Throwable t) {

                    }
                });
    }
}
