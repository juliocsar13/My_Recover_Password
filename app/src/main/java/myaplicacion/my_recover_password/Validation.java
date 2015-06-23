package myaplicacion.my_recover_password;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by angel on 16/04/15.
 */
public class Validation {

    private Context ctx;

    public Validation(Context _ctx){
        ctx = _ctx;
    }

    public boolean isOnline()
    {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public boolean enabledGPS(){
        LocationManager manager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
        return manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

}
