package myaplicacion.my_recover_password.RecoverPassword;

import org.json.JSONObject;

import myaplicacion.my_recover_password.Validation;

/**
 * Created by lenovo on 19/06/2015.
 */
public interface RecoverPasswordInteractor {

    public void sendEmail(JSONObject jsonObject, Validation validator, OnRecoverPasswordFinishedListener listener);

}
