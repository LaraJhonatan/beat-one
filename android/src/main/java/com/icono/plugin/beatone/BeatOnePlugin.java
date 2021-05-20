package com.icono.plugin.beatone;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import android.hardware.Camera;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
@CapacitorPlugin(name = "BeatOne")
public class BeatOnePlugin extends Plugin {
    boolean isflash=false;
    Camera camara;
    Camera.Parameters parametros;
    boolean isoff=false;
    boolean isflash=false;
    Button btnone;
    private BeatOne implementation = new BeatOne();

    // @PluginMethod
    // public void echo(PluginCall call) {
    //     String value = call.getString("value");
       
    //     JSObject ret = new JSObject();
    //     ret.put("value1", implementation.echo(value));
    //     call.resolve(ret);
    // }

        @PluginMethod
        public void tienePermisos(PluginCall call) {
        
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 50);
            }
            else {

                if (getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
                camara = Camera.open();
                parametros = camara.getParameters();
                this.isflash = true;
                
                    }
            }

            JSObject ret = new JSObject();
         ret.put("value2", implementation.echo(this.isflash));
         call.resolve(ret)
        }



    
}
