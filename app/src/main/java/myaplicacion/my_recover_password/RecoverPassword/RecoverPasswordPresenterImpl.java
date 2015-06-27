package myaplicacion.my_recover_password.RecoverPassword;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import myaplicacion.my_recover_password.Config;
import myaplicacion.my_recover_password.Model.User;
import myaplicacion.my_recover_password.Validation;

/**
 * Created by lenovo on 19/06/2015.
 */
public class RecoverPasswordPresenterImpl implements RecoverPasswordPresenter,OnRecoverPasswordFinishedListener{

    RecoverPasswordInteractor interactor;

    Validation validator;
    RecoverPasswordView recoverPasswordView;
    Context ctx;
    User user;
    Bundle extras;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    public RecoverPasswordPresenterImpl(RecoverPasswordView recoverPasswordView){
        this.recoverPasswordView = recoverPasswordView;
        interactor = new RecoverPasswordInteractorImpl();
        ctx = recoverPasswordView.getContext();
        validator = new Validation(ctx);
        extras = ((Activity)ctx).getIntent().getExtras();
        prefs = ctx.getSharedPreferences(Config.PREF_TAG,Context.MODE_PRIVATE);
        editor = prefs.edit();
    }


    @Override
    public void validateEmail(String email) {


        recoverPasswordView.showProgress();
        user = new User(ctx);

        if(extras!=null)
            email = extras.getString("email");
        else
            email = user.getEmail();

        Log.i("VP_email", email.toString());

        JSONObject param = new JSONObject();

        try{
            param.put("email",email);
        }catch (JSONException e){
            Log.e("VP_JSONException",e.toString());
        }

        interactor.sendEmail(param,validator,this);
    }

    @Override
    public void onSuccessSend(String email) {

      //  setOnVerify();

        user = new User(ctx);
        user.setEmail(email);

       // setOnRegister();


        recoverPasswordView.showDialogSuccessSend();
        recoverPasswordView.hideProgress();
        recoverPasswordView.navigateToCode(email);
        recoverPasswordView.finished();
    }

    @Override
    public void onFailedSend() {
        recoverPasswordView.showDialogFailedSend();
        recoverPasswordView.hideProgress();
    }

    @Override
    public void onInternetError() {
        recoverPasswordView.showDialogInternetError();

    }

    @Override
    public void onEmailError() {
        recoverPasswordView.showDialogEmailError();
        recoverPasswordView.hideProgress();

    }

    @Override
    public void onError() {
        recoverPasswordView.showDialogError();
        recoverPasswordView.hideProgress();

    }

    @Override
    public void onEmptyEmailError() {
        recoverPasswordView.showDialogEmptyemail();
        recoverPasswordView.hideProgress();

    }

}
