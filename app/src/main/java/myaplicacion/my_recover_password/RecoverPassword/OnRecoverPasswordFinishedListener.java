package myaplicacion.my_recover_password.RecoverPassword;

/**
 * Created by lenovo on 19/06/2015.
 */
public interface OnRecoverPasswordFinishedListener {
    public void onSuccessSend(String email);

    public void onFailedSend();

    public void onInternetError();

    public void onEmailError();

    public void onError();

    public void onEmptyEmailError();
}
