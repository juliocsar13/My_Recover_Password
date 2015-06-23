package myaplicacion.my_recover_password.RecoverPassword;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import myaplicacion.my_recover_password.R;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by lenovo on 19/06/2015.
 */
public class RecoverPasswordActivity  extends Activity implements RecoverPasswordView,Dialog.OnClickListener{

    @InjectView(R.id.edtNewPassword)        EditText edtPassword;
    @InjectView(R.id.btnSendPassword)       Button btnSendPassword;
    RecoverPasswordPresenter presenter;

    private AlertDialog.Builder dialogConfirmPassword;
    private AlertDialog.Builder alertDialog;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoverpassword);
        /*
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.layout_logo_bar);*/

        presenter = new RecoverPasswordPresenterImpl(this);

        ButterKnife.inject(this);

        dialogConfirmPassword = new AlertDialog.Builder(this);
        progressDialog = new ProgressDialog(this);
        alertDialog = new AlertDialog.Builder(this);

    }

    @Override
    public Context getContext() {
        return RecoverPasswordActivity.this;
    }

    @Override
    public void showDialogSuccessSend() {
        Toast.makeText(this,"Se envio correctamente el email",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDialogFailedSend() {
        Toast.makeText(this, "Error al enviar el email", Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToCode(String email) {
    }

    @OnClick(R.id.btnSendPassword)
    public void showDialogConfirmEmail() {
        dialogConfirmPassword.setCancelable(false)
                .setTitle("Advertencia")
                .setMessage("¿Su email es el correcto " + edtPassword.getText().toString() + " ?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.validateEmail(edtPassword.getText().toString());

                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public void hideProgress() {

        progressDialog.hide();

    }

    @Override
    public void showProgress() {
        progressDialog.setIndeterminate(false);
       //se esta enviando y verificando el Email
        progressDialog.setMessage("Enviando el Email");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void showDialogInternetError() {
        alertDialog.setTitle(getString(R.string.dialog_conection_title))
                .setMessage(getString(R.string.dialog_conection_message))
                .setPositiveButton(getString(R.string.settings_services), this)
                .setNegativeButton(getString(R.string.cancel_services),null)
                .show();
    }

    @Override
    public void showDialogEmailError() {
        Toast.makeText(this,"Por favor ingrese un email, que se halla registrado",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDialogError() {
        Toast.makeText(this,"Hay un error enviando el email, por favor intentelo de nuevo",Toast.LENGTH_LONG).show();
    }

    @Override
    public void finished() {
        finish();
    }

    @Override
    public void showDialogEmptyemail() {
        Toast.makeText(this,"Por favor ingrese el email",Toast.LENGTH_LONG).show();
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {
        startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
    }
}
