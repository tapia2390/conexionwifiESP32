package com.wit.ui.perfil;

import android.util.Log;

import androidx.lifecycle.ViewModel;
import com.wit.data.retrofit.connection.ApiConecxion;
import com.wit.data.retrofit.user.ObjectResponseUser;
import com.wit.model.Callfun;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends ViewModel {
    private static Callfun listener;

    public void getDataUSer(String idUser) {
        try {
            final Call<ObjectResponseUser> obj = ApiConecxion.getApiService().getUser(idUser);
            obj.enqueue(new Callback<ObjectResponseUser>() {
                @Override
                public void onResponse(Call<ObjectResponseUser> call, Response<ObjectResponseUser> response) {
                    //
                    ObjectResponseUser bodyResponseUser = new ObjectResponseUser();
                    bodyResponseUser = response.body();

                    Log.v("bodyResponseUser", bodyResponseUser.getBody().toString());

                    listener.onSuccess(bodyResponseUser,"getuser");
                }

                @Override
                public void onFailure(Call<ObjectResponseUser> call, Throwable t) {
                   // listMutableLiveDataUser.postValue(null);
                    Log.v("Error", "");
                    listener.onError("getUserError");
                }
            });

        } catch (Exception exception) {
            Log.v("Error", exception.getMessage());
        }
    }

    public void setListener(Callfun listener) {
        this.listener = listener;
    }

}