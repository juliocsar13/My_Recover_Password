package myaplicacion.my_recover_password.Model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by angel on 16/05/15.
 */
public class TaxiDriver extends User {

    public static String TAG = "TaxiData";

    protected String autoplate="";
    protected String dni="";
    protected String company="";
    protected String car_brand="";
    protected String car_model="";
    protected String image="";
    protected String imageUrl="";
    protected String gcm_driver = "";

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private Context ctx;

    public TaxiDriver(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public TaxiDriver(String _name,String _phone,String _autoplate, String _image, String _gcm_driver,Context ctx){

        name = _name;
        phone = _phone;
        autoplate = _autoplate;
        image = _image;
        gcm_driver = _gcm_driver;
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public TaxiDriver(String _name,String _phone,String _autoplate,Context ctx){

        name = _name;
        phone = _phone;
        autoplate = _autoplate;
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public TaxiDriver(String _name,String _phone,String _autoplate,
                      String _dni,String _company,
                      String _car_brand,String _car_model,Context ctx){
        name = _name;
        phone = _phone;
        autoplate = _autoplate;
        dni = _dni;
        company = _company;
        car_brand = _car_brand;
        car_model = _car_model;
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void saveTaxiDriver()
    {
        editor.putString("gcm_driver",gcm_driver);
        editor.putString("name",name);
        editor.putString("email",email);
        editor.putString("phone",phone);
        editor.putString("autoplate",autoplate);
        editor.putString("dni",dni);
        editor.putString("company",company);
        editor.putString("car_brand",car_brand);
        editor.putString("car_model",car_model);
        editor.commit();

    }

    public void setImage(String image){
        editor.putString("image",image);
        editor.commit();
    }

    public void setImageUrl(String imageUrl){
        editor.putString("imageUrl",imageUrl);
        editor.commit();
    }

    public String getImageUrl(){
        return prefs.getString("imageUrl","");
    }

    public String getImage(){ return prefs.getString("image","");}

    public String getName(){ return prefs.getString("name","");}

    public void setName(String name){
        editor.putString("name",name);
        editor.commit();
    }

    public String getEmail(){
        return prefs.getString("email","");
    }

    public void setEmail(String email){
        editor.putString("email",email);
        editor.commit();
    }

    public String getPhone(){
        return prefs.getString("phone","");
    }

    public void setPhone(String phone){
        editor.putString("phone",phone);
        editor.commit();
    }

    public String getAutoplate() {
        return prefs.getString("autoplate","");
    }

    public void setAutoplate(String autoplate){
        editor.putString("autoplate",autoplate);
        editor.commit();
    }

    public String getDni() {
        return prefs.getString("dni","");
    }

    public void setDni(String Dni){
        editor.putString("dni",dni);
        editor.commit();
    }

    public String getCompany() {
        return prefs.getString("company","");
    }

    public void setCompany(String company){
        editor.putString("company",company);
        editor.commit();
    }

    public String getCar_brand() {
        return prefs.getString("car_brand","");
    }

    public void setCar_brand(String car_brand){
        editor.putString("car_brand",car_brand);
        editor.commit();
    }

    public String getCar_model() {
        return prefs.getString("car_model","");
    }

    public void setCar_model(String car_model){
        editor.putString("car_model",car_model);
        editor.commit();
    }

    public String getGCM(){return prefs.getString("gcm_driver","");}

    public void setGCM(String gcm){
        editor.putString("gcm_driver",gcm);
        editor.commit();
    }
}
