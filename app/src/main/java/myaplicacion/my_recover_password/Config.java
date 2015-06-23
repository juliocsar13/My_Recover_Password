package myaplicacion.my_recover_password;

public interface Config {

    String url              = "http://llevameapp.evennode.com/api/v1";

    //URL para el registro del usuario
	String REGISTERUSER     = url + "/signUp-user";

    //URL para enviar un nueva peticion
    String REQUEST          = url + "/request/send";

    //URL para iniciar sesion
    String LOGIN            = url + "/login";

    //URL para cancelar un pedido en pleno servicio
    String CANCEL           = url + "/request/cancel";

    //URL para cancelar un peticion en pleno request
    String PRECANCEL        = url + "/request/precancel";

    //URL para verificar que un usuario no esta logeado en otro celular
    String CHECKLOGIN       = url + "/login/check";

    //Chequear si el request ha sido eliminado
    String CHECKREQUEST     = url + "/requests/check";

    //Obtener datos del usuario
    String GETDATAUSER      = url + "/users";

    //Obtener el codigo
    String GETCODE          = url + "/users/getCode";

    //Verificar el codigo obtenido
    String VERIFY           = url + "/users/verify";

    //Verificar si es que alguien a aceptado el pedido
    String CHECKACCEPT      = url + "/request/checkAccept";

    String VERSION          = url + "/version/check";

    String checkRequest     = url + "/request/check";

    String GETPASSWORD      = url + "/forgot";

    // Google Project Number
	String GOOGLE_PROJECT_ID       = "355409770365";
    String TYPE                    = "type";
    String DRIVER_NAME             = "name";
    String GCM_DRIVER              = "gcm_driver";
    String DRIVER_PHONE            = "phone";
    String DRIVER_AUTOPLATE        = "autoplate";
    String DRIVER_IMAGE            = "image";
    String DRIVER_IMAGE_ENTERPRISE = "image_enterprise";
    String DRIVER_LONGITUDE        = "longitude";
    String DRIVER_LATITUDE         = "latitude";
    String DRIVER_DNI              = "dni";
    String TAG_PREFERENCES         = "preferences_user";

    String TAG                     = "Register Activity";
    String PREF_TAG                = "UserPreferences";
    String APP_VERSION             = "appVersion";

    String ONCALL                  = "onCall";
    String ONSERVICE               = "onService";
    String ONREQUEST               = "onRequest";
    String ONLOGIN                 = "onLogin";
    String ONVERIFY                = "onVerify";
    String ONREGISTER              = "onRegister";
    String ONRADAR                 = "onRadar";
    String ONUSERDIALOG            = "onUserDialog";
    String ONCANCEL                = "onCancel";

    String GETIMAGE                = "getimage";

    String EMAIL                   = "email";
    String GETDATA                 = "getData";
    String GPS                     = "gps";

}
