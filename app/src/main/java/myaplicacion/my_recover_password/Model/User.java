package myaplicacion.my_recover_password.Model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by angel on 16/04/15.
 */
public class User {

    public static String TAG = "UserData";

    protected String name="";
    protected String lastname="";
    protected String email="";
    protected String phone="";
    protected String password="";
    protected boolean isable=false;



    protected boolean verified = false;
    protected String gcm_user="";

    protected SharedPreferences prefs;
    protected SharedPreferences.Editor editor;
    protected Context ctx;

    public User(){}

    public User(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public User(String _name,String _lastname,String _email,String _phone,boolean _isable,Context _ctx){
        ctx=_ctx;
        prefs = ctx.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        editor = prefs.edit();
        name = _name;
        lastname =_lastname;
        email = _email;
        phone = _phone;
        isable = _isable;
    }

    public User(String _name,String _lastname,String _email,String _phone,boolean _isable, String _gcm_user,Context _ctx){
        ctx=_ctx;
        prefs = ctx.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        editor = prefs.edit();
        name = _name;
        lastname =_lastname;
        email = _email;
        phone = _phone;
        isable = _isable;
        gcm_user = _gcm_user;
    }

    public void saveUser(){
        editor.putString("name",name);
        editor.putString("lastname",lastname);
        editor.putString("email",email);
        editor.putString("phone",phone);
        editor.putBoolean("isable",isable);
        editor.commit();
    }

    public String getName() {
        return prefs.getString("name","");
    }

    public void setName(String name) {
        editor.putString("name", name);
        editor.commit();
    }

    public String getLastname() {
        return prefs.getString("lastname","");
    }

    public void setLastname(String lastname) {
        editor.putString("lastname",lastname);
        editor.commit();

    }

    public String getEmail() {
        return prefs.getString("email","");
    }

    public void setEmail(String email) {
        editor.putString("email",email);
        editor.commit();
    }

    public String getPhone() {
        return prefs.getString("phone","");
    }

    public void setPhone(String phone) {
        editor.putString("phone",phone);
        editor.commit();
    }

    public boolean getIsable (){
        return prefs.getBoolean("isable", false);
    }

    public void setGCM(String gcm){
        editor.putString("gcm_user",gcm);
        editor.commit();
    }

    public String getGCM(){
        return prefs.getString("gcm_user", "");
    }

    public void setIsable(boolean active){
        editor.putBoolean("isable", active);
        editor.commit();
    }

    public boolean getVerified() {
        return prefs.getBoolean("verified",false);
    }

    public void setVerified(boolean verified) {
        editor.putBoolean("verified",verified);
        editor.commit();
    }

    public void clean(){
        editor.putString("name","");
        editor.putString("lastname","");
        editor.putString("email","");
        editor.putString("phone","");
        editor.putBoolean("isable",false);
        editor.putBoolean("verified",false);
        editor.putString("gcm_user","");
        editor.commit();
    }

}
